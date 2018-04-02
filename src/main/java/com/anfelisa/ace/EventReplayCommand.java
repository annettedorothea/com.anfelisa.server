package com.anfelisa.ace;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.dropwizard.Application;
import io.dropwizard.cli.EnvironmentCommand;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Environment;
import net.sourceforge.argparse4j.inf.Namespace;

public class EventReplayCommand extends EnvironmentCommand<CustomAppConfiguration> {

	static final Logger LOG = LoggerFactory.getLogger(EventReplayCommand.class);

	private AceDao aceDao = new AceDao();

	protected EventReplayCommand(Application<CustomAppConfiguration> application) {
		super(application, "replay", "truncates views and replays events");
	}

	@Override
	protected void run(Environment environment, Namespace namespace, CustomAppConfiguration configuration)
			throws Exception {
		if (AceController.getAceExecutionMode() == AceExecutionMode.LIVE) {
			throw new RuntimeException("we won't truncate all views and replay events in a live environment");
		}
		if (AceController.getAceExecutionMode() == AceExecutionMode.REPLAY) {
			throw new RuntimeException("replay events in a replay environment doesn't make sense");
		}

		AceDao.setSchemaName(null);

		final DBIFactory factory = new DBIFactory();

		DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "data-source-name");

		DatabaseHandle databaseHandle = new DatabaseHandle(jdbi.open(), null);
		LOG.info("START EVENT REPLAY");
		try {
			databaseHandle.beginTransaction();

			Handle handle = databaseHandle.getHandle();

			AppUtils.truncateAllViews(handle);
			
			List<String> corrupted = new ArrayList<>();
			
			List<ITimelineItem> timeline = aceDao.selectTimeline(handle);
			
			E2E.timeline = timeline;

			int eventCount = 0;
			ITimelineItem nextAction = E2E.selectNextAction(null);
			while (nextAction != null) {
				if (!nextAction.getMethod().equalsIgnoreCase("GET")) {
					ITimelineItem nextEvent = E2E.selectEvent(nextAction.getUuid());
					if (nextEvent != null) {
						databaseHandle.commitTransaction();
						databaseHandle.beginTransaction();
						//LOG.info("PUBLISH EVENT " + nextEvent);
						Class<?> cl = Class.forName(nextEvent.getName());
						Constructor<?> con = cl.getConstructor(DatabaseHandle.class);
						IEvent event = (IEvent) con.newInstance(databaseHandle);
						try {
							event.initEventData(nextEvent.getData());
							event.notifyListeners();
							eventCount++;
							if (eventCount % 100 == 0) {
								LOG.info("published " + eventCount + " events");
							}
						} catch (Exception e) {
							LOG.info("failed to replay event " + nextAction.getUuid() + " - "+ event.getEventName());
							//LOG.info(nextEvent.getData());
							//LOG.info(e.getMessage());
							//LOG.info("===========================================================");
							corrupted.add(nextAction.getUuid());
							nextAction = E2E.selectNextAction(nextAction.getUuid());
							continue;
						}
					}
				}
				nextAction = E2E.selectNextAction(nextAction.getUuid());
			}

			databaseHandle.commitTransaction();

			handle.createStatement("SELECT setval('box_boxid_seq', (select max(boxid) + 1 from box), false)").execute();
			handle.createStatement("SELECT setval('card_cardid_seq', (select max(cardid) + 1 from card), false)").execute();
			handle.createStatement("SELECT setval('course_courseid_seq', (select max(courseid) + 1 from course), false)").execute();
			handle.createStatement("SELECT setval('lesson_lessonid_seq', (select max(lessonid) + 1 from lesson), false)").execute();
			handle.createStatement("SELECT setval('loginlog_loginlogid_seq', (select max(loginlogid) + 1 from loginlog), false)").execute();
			handle.createStatement("SELECT setval('result_resultid_seq', (select max(resultid) + 1 from result), false)").execute();
			handle.createStatement("SELECT setval('scheduledcard_scheduledcardid_seq', (select max(scheduledcardid) + 1 from scheduledcard), false)").execute();
			handle.createStatement("SELECT setval('scoredcard_scoredcardid_seq', (select max(scoredcardid) + 1 from scoredcard), false)").execute();
			handle.createStatement("SELECT setval('test_testid_seq', (select max(testid) + 1 from test), false)").execute();
			handle.createStatement("SELECT setval('timeline_id_seq', (select max(id) + 1 from timeline), false)").execute();
			handle.createStatement("SELECT setval('errortimeline_id_seq', (select max(id) + 1 from errortimeline), false)").execute();

			/*for (String uuid : corrupted) {
				aceDao.delete(handle, uuid);
			}*/
			
			databaseHandle.commitTransaction();

			LOG.info("EVENT REPLAY FINISHED: failed to replay " + corrupted.size() + " events");
			LOG.info("EVENT REPLAY FINISHED: successfully replayed " + eventCount + " events");
		} catch (Exception e) {
			databaseHandle.rollbackTransaction();
			LOG.info("EVENT REPLAY ABORTED " + e.getMessage());
			throw e;
		} finally {
			databaseHandle.close();
		}

	}

}

/********************************************************************************
 * generated by de.acegen 1.6.4
 ********************************************************************************/





package de.acegen;

import java.util.List;
import java.util.Scanner;

import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.dropwizard.Application;
import io.dropwizard.cli.EnvironmentCommand;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.setup.Environment;
import net.sourceforge.argparse4j.inf.Namespace;

public class EventReplayCommand extends EnvironmentCommand<CustomAppConfiguration> {

	static final Logger LOG = LoggerFactory.getLogger(EventReplayCommand.class);

	protected EventReplayCommand(Application<CustomAppConfiguration> application) {
		super(application, "replay", "truncates views and replays events");
	}

	@Override
	protected void run(Environment environment, Namespace namespace, CustomAppConfiguration configuration)
			throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.print("The database is going to be cleared before replaying events. Continue? Confirm with yes: ");
		String input = scanner.nextLine();
		scanner.close();
        if (!input.equals("yes")) {
        	System.out.print("Event replay aborted.");
        	return;
        }

		IDaoProvider daoProvider = DaoProvider.create();
		ViewProvider viewProvider = ViewProvider.create(daoProvider, configuration);

		final JdbiFactory factory = new JdbiFactory();
		Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(), "data-source-name");
		DatabaseHandle databaseHandle = new DatabaseHandle(jdbi, configuration);

		AppRegistration.registerConsumers(viewProvider);

		try {
			databaseHandle.beginTransaction();
			PersistenceHandle handle = databaseHandle.getHandle();
			daoProvider.truncateAllViews(handle);

			List<ITimelineItem> timeline = daoProvider.getAceDao().selectReplayTimeline(handle);
			LOG.info("START EVENT REPLAY: found {} events", timeline.size());

			int i = 0;
			for (ITimelineItem nextEvent : timeline) {
				EventReplayService.replayEvent(nextEvent.getName(), nextEvent.getData(), handle, viewProvider);
				i++;
				if (i%1000 == 0) {
					LOG.info("published " + i + " events");
				}
				LOG.info("published " + nextEvent.getUuid() + " - " + nextEvent.getName());
			}

			databaseHandle.commitTransaction();

			LOG.info("EVENT REPLAY FINISHED: successfully replayed " + i + " events");

		} catch (Exception e) {
			databaseHandle.rollbackTransaction();
			LOG.info("EVENT REPLAY ABORTED " + e.getMessage());
			throw e;
		} finally {
			databaseHandle.close();
		}

	}

}




/******* S.D.G. *******/




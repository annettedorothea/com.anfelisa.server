/********************************************************************************
 * generated by de.acegen 1.3.0
 ********************************************************************************/




package com.anfelisa.box.events;

import de.acegen.IDaoProvider;
import de.acegen.IEvent;
import de.acegen.ViewProvider;
import com.anfelisa.box.data.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.acegen.IDataContainer;
import de.acegen.CustomAppConfiguration;
import de.acegen.PersistenceHandle;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("all")
public class EventReplayService {
	
	private static ObjectMapper mapper = new ObjectMapper();
	private static final Logger LOG = LoggerFactory.getLogger(EventReplayService.class);

	static {
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public static void replayEvent(String eventClass, String json, PersistenceHandle handle, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		try {
			if (eventClass.equals("com.anfelisa.box.events.CreateBoxOkEvent")) {
				BoxCreationData data = mapper.readValue(json, BoxCreationData.class);
				data.migrateLegacyData(json);
				CreateBoxOkEvent event = new CreateBoxOkEvent(daoProvider, viewProvider, appConfiguration);
				event.notifyListeners(data, handle);
				event.notifyAfterCommitListeners(data, handle);
			}
			if (eventClass.equals("com.anfelisa.box.events.CreateReverseBoxOkEvent")) {
				BoxCreationData data = mapper.readValue(json, BoxCreationData.class);
				data.migrateLegacyData(json);
				CreateReverseBoxOkEvent event = new CreateReverseBoxOkEvent(daoProvider, viewProvider, appConfiguration);
				event.notifyListeners(data, handle);
				event.notifyAfterCommitListeners(data, handle);
			}
			if (eventClass.equals("com.anfelisa.box.events.ArchiveBoxOkEvent")) {
				BoxArchiveData data = mapper.readValue(json, BoxArchiveData.class);
				data.migrateLegacyData(json);
				ArchiveBoxOkEvent event = new ArchiveBoxOkEvent(daoProvider, viewProvider, appConfiguration);
				event.notifyListeners(data, handle);
				event.notifyAfterCommitListeners(data, handle);
			}
			if (eventClass.equals("com.anfelisa.box.events.UpdateBoxCanEditCategoryEvent")) {
				BoxUpdateData data = mapper.readValue(json, BoxUpdateData.class);
				data.migrateLegacyData(json);
				UpdateBoxCanEditCategoryEvent event = new UpdateBoxCanEditCategoryEvent(daoProvider, viewProvider, appConfiguration);
				event.notifyListeners(data, handle);
				event.notifyAfterCommitListeners(data, handle);
			}
			if (eventClass.equals("com.anfelisa.box.events.UpdateBoxOkEvent")) {
				BoxUpdateData data = mapper.readValue(json, BoxUpdateData.class);
				data.migrateLegacyData(json);
				UpdateBoxOkEvent event = new UpdateBoxOkEvent(daoProvider, viewProvider, appConfiguration);
				event.notifyListeners(data, handle);
				event.notifyAfterCommitListeners(data, handle);
			}
			if (eventClass.equals("com.anfelisa.box.events.ScheduleCardsOkEvent")) {
				ScheduledCardsData data = mapper.readValue(json, ScheduledCardsData.class);
				data.migrateLegacyData(json);
				ScheduleCardsOkEvent event = new ScheduleCardsOkEvent(daoProvider, viewProvider, appConfiguration);
				event.notifyListeners(data, handle);
				event.notifyAfterCommitListeners(data, handle);
			}
			if (eventClass.equals("com.anfelisa.box.events.SortCardsOutOkEvent")) {
				SortCardsOutData data = mapper.readValue(json, SortCardsOutData.class);
				data.migrateLegacyData(json);
				SortCardsOutOkEvent event = new SortCardsOutOkEvent(daoProvider, viewProvider, appConfiguration);
				event.notifyListeners(data, handle);
				event.notifyAfterCommitListeners(data, handle);
			}
			if (eventClass.equals("com.anfelisa.box.events.ScoreCardScoreEvent")) {
				ScoreCardData data = mapper.readValue(json, ScoreCardData.class);
				data.migrateLegacyData(json);
				ScoreCardScoreEvent event = new ScoreCardScoreEvent(daoProvider, viewProvider, appConfiguration);
				event.notifyListeners(data, handle);
				event.notifyAfterCommitListeners(data, handle);
			}
			if (eventClass.equals("com.anfelisa.box.events.ScoreCardReinforceEvent")) {
				ScoreCardData data = mapper.readValue(json, ScoreCardData.class);
				data.migrateLegacyData(json);
				ScoreCardReinforceEvent event = new ScoreCardReinforceEvent(daoProvider, viewProvider, appConfiguration);
				event.notifyListeners(data, handle);
				event.notifyAfterCommitListeners(data, handle);
			}
			if (eventClass.equals("com.anfelisa.box.events.ScoreReinforceCardKeepEvent")) {
				ScoreReinforceCardData data = mapper.readValue(json, ScoreReinforceCardData.class);
				data.migrateLegacyData(json);
				ScoreReinforceCardKeepEvent event = new ScoreReinforceCardKeepEvent(daoProvider, viewProvider, appConfiguration);
				event.notifyListeners(data, handle);
				event.notifyAfterCommitListeners(data, handle);
			}
			if (eventClass.equals("com.anfelisa.box.events.ScoreReinforceCardRemoveEvent")) {
				ScoreReinforceCardData data = mapper.readValue(json, ScoreReinforceCardData.class);
				data.migrateLegacyData(json);
				ScoreReinforceCardRemoveEvent event = new ScoreReinforceCardRemoveEvent(daoProvider, viewProvider, appConfiguration);
				event.notifyListeners(data, handle);
				event.notifyAfterCommitListeners(data, handle);
			}
			if (eventClass.equals("com.anfelisa.box.events.InitMyBoxesForDayOkEvent")) {
				InitMyBoxesDataData data = mapper.readValue(json, InitMyBoxesDataData.class);
				data.migrateLegacyData(json);
				InitMyBoxesForDayOkEvent event = new InitMyBoxesForDayOkEvent(daoProvider, viewProvider, appConfiguration);
				event.notifyListeners(data, handle);
				event.notifyAfterCommitListeners(data, handle);
			}
			if (eventClass.equals("com.anfelisa.box.events.DeleteBoxDeleteBoxEvent")) {
				DeleteBoxData data = mapper.readValue(json, DeleteBoxData.class);
				data.migrateLegacyData(json);
				DeleteBoxDeleteBoxEvent event = new DeleteBoxDeleteBoxEvent(daoProvider, viewProvider, appConfiguration);
				event.notifyListeners(data, handle);
				event.notifyAfterCommitListeners(data, handle);
			}
			if (eventClass.equals("com.anfelisa.box.events.DeleteBoxDeleteCategoryEvent")) {
				DeleteBoxData data = mapper.readValue(json, DeleteBoxData.class);
				data.migrateLegacyData(json);
				DeleteBoxDeleteCategoryEvent event = new DeleteBoxDeleteCategoryEvent(daoProvider, viewProvider, appConfiguration);
				event.notifyListeners(data, handle);
				event.notifyAfterCommitListeners(data, handle);
			}
		} catch (IOException e) {
			LOG.error("failed to replay event {} with data {}", eventClass, json, e);
		}
	}

}



/******* S.D.G. *******/




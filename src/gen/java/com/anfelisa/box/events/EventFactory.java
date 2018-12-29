package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.IEvent;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.data.*;
import com.anfelisa.ace.JodaObjectMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventFactory {
	
	private static JodaObjectMapper mapper = new JodaObjectMapper();
	private static final Logger LOG = LoggerFactory.getLogger(EventFactory.class);

	static {
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public static IEvent createEvent(String eventClass, String json, DatabaseHandle databaseHandle,
		IDaoProvider daoProvider, ViewProvider viewProvider) {
		try {
			if (eventClass.equals("com.anfelisa.box.events.CreateBoxOkEvent")) {
				BoxData data = mapper.readValue(json, BoxData.class);
				data.migrateLegacyData(json);
				CreateBoxOkEvent event = new CreateBoxOkEvent(data, databaseHandle, daoProvider, viewProvider);
				return event;
			}
			if (eventClass.equals("com.anfelisa.box.events.UpdateBoxOkEvent")) {
				BoxUpdateData data = mapper.readValue(json, BoxUpdateData.class);
				data.migrateLegacyData(json);
				UpdateBoxOkEvent event = new UpdateBoxOkEvent(data, databaseHandle, daoProvider, viewProvider);
				return event;
			}
			if (eventClass.equals("com.anfelisa.box.events.PostponeCardsOkEvent")) {
				PostponeCardsData data = mapper.readValue(json, PostponeCardsData.class);
				data.migrateLegacyData(json);
				PostponeCardsOkEvent event = new PostponeCardsOkEvent(data, databaseHandle, daoProvider, viewProvider);
				return event;
			}
			if (eventClass.equals("com.anfelisa.box.events.DeleteBoxOkEvent")) {
				DeleteBoxData data = mapper.readValue(json, DeleteBoxData.class);
				data.migrateLegacyData(json);
				DeleteBoxOkEvent event = new DeleteBoxOkEvent(data, databaseHandle, daoProvider, viewProvider);
				return event;
			}
			if (eventClass.equals("com.anfelisa.box.events.ScheduleNextCardOkEvent")) {
				ScheduleNextCardData data = mapper.readValue(json, ScheduleNextCardData.class);
				data.migrateLegacyData(json);
				ScheduleNextCardOkEvent event = new ScheduleNextCardOkEvent(data, databaseHandle, daoProvider, viewProvider);
				return event;
			}
			if (eventClass.equals("com.anfelisa.box.events.ScheduleCardsOkEvent")) {
				ScheduledCardsData data = mapper.readValue(json, ScheduledCardsData.class);
				data.migrateLegacyData(json);
				ScheduleCardsOkEvent event = new ScheduleCardsOkEvent(data, databaseHandle, daoProvider, viewProvider);
				return event;
			}
			if (eventClass.equals("com.anfelisa.box.events.ScoreCardScoreEvent")) {
				ScoreCardData data = mapper.readValue(json, ScoreCardData.class);
				data.migrateLegacyData(json);
				ScoreCardScoreEvent event = new ScoreCardScoreEvent(data, databaseHandle, daoProvider, viewProvider);
				return event;
			}
			if (eventClass.equals("com.anfelisa.box.events.ScoreCardScoreAndReinforceEvent")) {
				ScoreCardData data = mapper.readValue(json, ScoreCardData.class);
				data.migrateLegacyData(json);
				ScoreCardScoreAndReinforceEvent event = new ScoreCardScoreAndReinforceEvent(data, databaseHandle, daoProvider, viewProvider);
				return event;
			}
			if (eventClass.equals("com.anfelisa.box.events.ScoreReinforceCardRemoveEvent")) {
				ScoreReinforceCardData data = mapper.readValue(json, ScoreReinforceCardData.class);
				data.migrateLegacyData(json);
				ScoreReinforceCardRemoveEvent event = new ScoreReinforceCardRemoveEvent(data, databaseHandle, daoProvider, viewProvider);
				return event;
			}
			if (eventClass.equals("com.anfelisa.box.events.ScoreReinforceCardKeepEvent")) {
				ScoreReinforceCardData data = mapper.readValue(json, ScoreReinforceCardData.class);
				data.migrateLegacyData(json);
				ScoreReinforceCardKeepEvent event = new ScoreReinforceCardKeepEvent(data, databaseHandle, daoProvider, viewProvider);
				return event;
			}
		} catch (IOException e) {
			LOG.error("failed to create event {} with data {}", eventClass, json, e);
		}

		return null;
	}
}


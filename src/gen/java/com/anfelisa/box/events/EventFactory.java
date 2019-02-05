package com.anfelisa.box.events;

import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.IEvent;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.data.*;
import com.anfelisa.ace.JodaObjectMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.anfelisa.ace.IDataContainer;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventFactory {
	
	private static JodaObjectMapper mapper = new JodaObjectMapper();
	private static final Logger LOG = LoggerFactory.getLogger(EventFactory.class);

	static {
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public static IEvent createEvent(String eventClass, String json, IDaoProvider daoProvider, ViewProvider viewProvider) {
		try {
			if (eventClass.equals("com.anfelisa.box.events.CreateBoxOkEvent")) {
				BoxData data = mapper.readValue(json, BoxData.class);
				data.migrateLegacyData(json);
				CreateBoxOkEvent event = new CreateBoxOkEvent(data, daoProvider, viewProvider);
				return event;
			}
			if (eventClass.equals("com.anfelisa.box.events.UpdateBoxOkEvent")) {
				BoxUpdateData data = mapper.readValue(json, BoxUpdateData.class);
				data.migrateLegacyData(json);
				UpdateBoxOkEvent event = new UpdateBoxOkEvent(data, daoProvider, viewProvider);
				return event;
			}
			if (eventClass.equals("com.anfelisa.box.events.PostponeCardsOkEvent")) {
				PostponeCardsData data = mapper.readValue(json, PostponeCardsData.class);
				data.migrateLegacyData(json);
				PostponeCardsOkEvent event = new PostponeCardsOkEvent(data, daoProvider, viewProvider);
				return event;
			}
			if (eventClass.equals("com.anfelisa.box.events.DeleteBoxOkEvent")) {
				DeleteBoxData data = mapper.readValue(json, DeleteBoxData.class);
				data.migrateLegacyData(json);
				DeleteBoxOkEvent event = new DeleteBoxOkEvent(data, daoProvider, viewProvider);
				return event;
			}
			if (eventClass.equals("com.anfelisa.box.events.ScheduleNextCardOkEvent")) {
				ScheduleNextCardData data = mapper.readValue(json, ScheduleNextCardData.class);
				data.migrateLegacyData(json);
				ScheduleNextCardOkEvent event = new ScheduleNextCardOkEvent(data, daoProvider, viewProvider);
				return event;
			}
			if (eventClass.equals("com.anfelisa.box.events.ScheduleCardsOkEvent")) {
				ScheduledCardsData data = mapper.readValue(json, ScheduledCardsData.class);
				data.migrateLegacyData(json);
				ScheduleCardsOkEvent event = new ScheduleCardsOkEvent(data, daoProvider, viewProvider);
				return event;
			}
			if (eventClass.equals("com.anfelisa.box.events.ScoreCardScoreEvent")) {
				ScoreCardData data = mapper.readValue(json, ScoreCardData.class);
				data.migrateLegacyData(json);
				ScoreCardScoreEvent event = new ScoreCardScoreEvent(data, daoProvider, viewProvider);
				return event;
			}
			if (eventClass.equals("com.anfelisa.box.events.ScoreCardScoreAndReinforceEvent")) {
				ScoreCardData data = mapper.readValue(json, ScoreCardData.class);
				data.migrateLegacyData(json);
				ScoreCardScoreAndReinforceEvent event = new ScoreCardScoreAndReinforceEvent(data, daoProvider, viewProvider);
				return event;
			}
			if (eventClass.equals("com.anfelisa.box.events.ScoreReinforceCardRemoveEvent")) {
				ScoreReinforceCardData data = mapper.readValue(json, ScoreReinforceCardData.class);
				data.migrateLegacyData(json);
				ScoreReinforceCardRemoveEvent event = new ScoreReinforceCardRemoveEvent(data, daoProvider, viewProvider);
				return event;
			}
			if (eventClass.equals("com.anfelisa.box.events.ScoreReinforceCardKeepEvent")) {
				ScoreReinforceCardData data = mapper.readValue(json, ScoreReinforceCardData.class);
				data.migrateLegacyData(json);
				ScoreReinforceCardKeepEvent event = new ScoreReinforceCardKeepEvent(data, daoProvider, viewProvider);
				return event;
			}
		} catch (IOException e) {
			LOG.error("failed to create event {} with data {}", eventClass, json, e);
		}

		return null;
	}

	public static IEvent createEvent(String eventClass, IDataContainer data, IDaoProvider daoProvider, ViewProvider viewProvider) {


		if (eventClass.equals("com.anfelisa.box.events.CreateBoxOkEvent")) {
			return new CreateBoxOkEvent((BoxData)data, daoProvider, viewProvider);
		}

		if (eventClass.equals("com.anfelisa.box.events.UpdateBoxOkEvent")) {
			return new UpdateBoxOkEvent((BoxUpdateData)data, daoProvider, viewProvider);
		}

		if (eventClass.equals("com.anfelisa.box.events.PostponeCardsOkEvent")) {
			return new PostponeCardsOkEvent((PostponeCardsData)data, daoProvider, viewProvider);
		}

		if (eventClass.equals("com.anfelisa.box.events.DeleteBoxOkEvent")) {
			return new DeleteBoxOkEvent((DeleteBoxData)data, daoProvider, viewProvider);
		}



		if (eventClass.equals("com.anfelisa.box.events.ScheduleNextCardOkEvent")) {
			return new ScheduleNextCardOkEvent((ScheduleNextCardData)data, daoProvider, viewProvider);
		}

		if (eventClass.equals("com.anfelisa.box.events.ScheduleCardsOkEvent")) {
			return new ScheduleCardsOkEvent((ScheduledCardsData)data, daoProvider, viewProvider);
		}

		if (eventClass.equals("com.anfelisa.box.events.ScoreCardScoreEvent")) {
			return new ScoreCardScoreEvent((ScoreCardData)data, daoProvider, viewProvider);
		}
		if (eventClass.equals("com.anfelisa.box.events.ScoreCardScoreAndReinforceEvent")) {
			return new ScoreCardScoreAndReinforceEvent((ScoreCardData)data, daoProvider, viewProvider);
		}

		if (eventClass.equals("com.anfelisa.box.events.ScoreReinforceCardRemoveEvent")) {
			return new ScoreReinforceCardRemoveEvent((ScoreReinforceCardData)data, daoProvider, viewProvider);
		}
		if (eventClass.equals("com.anfelisa.box.events.ScoreReinforceCardKeepEvent")) {
			return new ScoreReinforceCardKeepEvent((ScoreReinforceCardData)data, daoProvider, viewProvider);
		}


		return null;
	}
}


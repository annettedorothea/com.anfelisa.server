/* 
 * Copyright (c) 2019, Annette Pohl, Koblenz, Germany
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.

 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */




package com.anfelisa.box.events;

import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.IEvent;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.data.*;
import com.anfelisa.ace.JodaObjectMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.anfelisa.ace.IDataContainer;
import com.anfelisa.ace.CustomAppConfiguration;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventFactory {
	
	private static JodaObjectMapper mapper = new JodaObjectMapper();
	private static final Logger LOG = LoggerFactory.getLogger(EventFactory.class);

	static {
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public static IEvent createEvent(String eventClass, String json, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		try {
			if (eventClass.equals("com.anfelisa.box.events.CreateBoxOkEvent")) {
				BoxCreationData data = mapper.readValue(json, BoxCreationData.class);
				data.migrateLegacyData(json);
				CreateBoxOkEvent event = new CreateBoxOkEvent(data, daoProvider, viewProvider, appConfiguration);
				return event;
			}
			if (eventClass.equals("com.anfelisa.box.events.UpdateBoxOkEvent")) {
				BoxUpdateData data = mapper.readValue(json, BoxUpdateData.class);
				data.migrateLegacyData(json);
				UpdateBoxOkEvent event = new UpdateBoxOkEvent(data, daoProvider, viewProvider, appConfiguration);
				return event;
			}
			if (eventClass.equals("com.anfelisa.box.events.InitMyBoxesForDayOkEvent")) {
				InitMyBoxesDataData data = mapper.readValue(json, InitMyBoxesDataData.class);
				data.migrateLegacyData(json);
				InitMyBoxesForDayOkEvent event = new InitMyBoxesForDayOkEvent(data, daoProvider, viewProvider, appConfiguration);
				return event;
			}
			if (eventClass.equals("com.anfelisa.box.events.DeleteBoxOkEvent")) {
				DeleteBoxData data = mapper.readValue(json, DeleteBoxData.class);
				data.migrateLegacyData(json);
				DeleteBoxOkEvent event = new DeleteBoxOkEvent(data, daoProvider, viewProvider, appConfiguration);
				return event;
			}
			if (eventClass.equals("com.anfelisa.box.events.ScheduleCardsOkEvent")) {
				ScheduledCardsData data = mapper.readValue(json, ScheduledCardsData.class);
				data.migrateLegacyData(json);
				ScheduleCardsOkEvent event = new ScheduleCardsOkEvent(data, daoProvider, viewProvider, appConfiguration);
				return event;
			}
			if (eventClass.equals("com.anfelisa.box.events.ScoreCardScoreEvent")) {
				ScoreCardData data = mapper.readValue(json, ScoreCardData.class);
				data.migrateLegacyData(json);
				ScoreCardScoreEvent event = new ScoreCardScoreEvent(data, daoProvider, viewProvider, appConfiguration);
				return event;
			}
			if (eventClass.equals("com.anfelisa.box.events.ScoreCardScoreAndReinforceEvent")) {
				ScoreCardData data = mapper.readValue(json, ScoreCardData.class);
				data.migrateLegacyData(json);
				ScoreCardScoreAndReinforceEvent event = new ScoreCardScoreAndReinforceEvent(data, daoProvider, viewProvider, appConfiguration);
				return event;
			}
			if (eventClass.equals("com.anfelisa.box.events.ScoreReinforceCardKeepEvent")) {
				ScoreReinforceCardData data = mapper.readValue(json, ScoreReinforceCardData.class);
				data.migrateLegacyData(json);
				ScoreReinforceCardKeepEvent event = new ScoreReinforceCardKeepEvent(data, daoProvider, viewProvider, appConfiguration);
				return event;
			}
			if (eventClass.equals("com.anfelisa.box.events.ScoreReinforceCardRemoveEvent")) {
				ScoreReinforceCardData data = mapper.readValue(json, ScoreReinforceCardData.class);
				data.migrateLegacyData(json);
				ScoreReinforceCardRemoveEvent event = new ScoreReinforceCardRemoveEvent(data, daoProvider, viewProvider, appConfiguration);
				return event;
			}
		} catch (IOException e) {
			LOG.error("failed to create event {} with data {}", eventClass, json, e);
		}

		return null;
	}

	public static IEvent createEvent(String eventClass, IDataContainer data, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		if (eventClass.equals("com.anfelisa.box.events.CreateBoxOkEvent")) {
			return new CreateBoxOkEvent((BoxCreationData)data, daoProvider, viewProvider, appConfiguration);
		}



		if (eventClass.equals("com.anfelisa.box.events.UpdateBoxOkEvent")) {
			return new UpdateBoxOkEvent((BoxUpdateData)data, daoProvider, viewProvider, appConfiguration);
		}

		if (eventClass.equals("com.anfelisa.box.events.InitMyBoxesForDayOkEvent")) {
			return new InitMyBoxesForDayOkEvent((InitMyBoxesDataData)data, daoProvider, viewProvider, appConfiguration);
		}

		if (eventClass.equals("com.anfelisa.box.events.DeleteBoxOkEvent")) {
			return new DeleteBoxOkEvent((DeleteBoxData)data, daoProvider, viewProvider, appConfiguration);
		}


		if (eventClass.equals("com.anfelisa.box.events.ScheduleCardsOkEvent")) {
			return new ScheduleCardsOkEvent((ScheduledCardsData)data, daoProvider, viewProvider, appConfiguration);
		}

		if (eventClass.equals("com.anfelisa.box.events.ScoreCardScoreEvent")) {
			return new ScoreCardScoreEvent((ScoreCardData)data, daoProvider, viewProvider, appConfiguration);
		}
		if (eventClass.equals("com.anfelisa.box.events.ScoreCardScoreAndReinforceEvent")) {
			return new ScoreCardScoreAndReinforceEvent((ScoreCardData)data, daoProvider, viewProvider, appConfiguration);
		}

		if (eventClass.equals("com.anfelisa.box.events.ScoreReinforceCardKeepEvent")) {
			return new ScoreReinforceCardKeepEvent((ScoreReinforceCardData)data, daoProvider, viewProvider, appConfiguration);
		}
		if (eventClass.equals("com.anfelisa.box.events.ScoreReinforceCardRemoveEvent")) {
			return new ScoreReinforceCardRemoveEvent((ScoreReinforceCardData)data, daoProvider, viewProvider, appConfiguration);
		}


		return null;
	}
}




/******* S.D.G. *******/




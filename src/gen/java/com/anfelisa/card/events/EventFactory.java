package com.anfelisa.card.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.IEvent;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.card.data.*;
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

	public static IEvent createEvent(String eventClass, String json, DatabaseHandle databaseHandle,
		IDaoProvider daoProvider, ViewProvider viewProvider) {
		try {
			if (eventClass.equals("com.anfelisa.card.events.CreateCardOkEvent")) {
				CardCreationData data = mapper.readValue(json, CardCreationData.class);
				data.migrateLegacyData(json);
				CreateCardOkEvent event = new CreateCardOkEvent(data, databaseHandle, daoProvider, viewProvider);
				return event;
			}
			if (eventClass.equals("com.anfelisa.card.events.UpdateCardOkEvent")) {
				CardUpdateData data = mapper.readValue(json, CardUpdateData.class);
				data.migrateLegacyData(json);
				UpdateCardOkEvent event = new UpdateCardOkEvent(data, databaseHandle, daoProvider, viewProvider);
				return event;
			}
			if (eventClass.equals("com.anfelisa.card.events.DeleteCardOkEvent")) {
				CardDeleteData data = mapper.readValue(json, CardDeleteData.class);
				data.migrateLegacyData(json);
				DeleteCardOkEvent event = new DeleteCardOkEvent(data, databaseHandle, daoProvider, viewProvider);
				return event;
			}
			if (eventClass.equals("com.anfelisa.card.events.MoveCardsOkEvent")) {
				CardIdListData data = mapper.readValue(json, CardIdListData.class);
				data.migrateLegacyData(json);
				MoveCardsOkEvent event = new MoveCardsOkEvent(data, databaseHandle, daoProvider, viewProvider);
				return event;
			}
		} catch (IOException e) {
			LOG.error("failed to create event {} with data {}", eventClass, json, e);
		}

		return null;
	}

	public static IEvent createEvent(String eventClass, IDataContainer data, DatabaseHandle databaseHandle,
		IDaoProvider daoProvider, ViewProvider viewProvider) {
		if (eventClass.equals("com.anfelisa.card.events.CreateCardOkEvent")) {
			return new CreateCardOkEvent((CardCreationData)data, databaseHandle, daoProvider, viewProvider);
		}
		if (eventClass.equals("com.anfelisa.card.events.UpdateCardOkEvent")) {
			return new UpdateCardOkEvent((CardUpdateData)data, databaseHandle, daoProvider, viewProvider);
		}
		if (eventClass.equals("com.anfelisa.card.events.DeleteCardOkEvent")) {
			return new DeleteCardOkEvent((CardDeleteData)data, databaseHandle, daoProvider, viewProvider);
		}
		if (eventClass.equals("com.anfelisa.card.events.MoveCardsOkEvent")) {
			return new MoveCardsOkEvent((CardIdListData)data, databaseHandle, daoProvider, viewProvider);
		}

		return null;
	}
}


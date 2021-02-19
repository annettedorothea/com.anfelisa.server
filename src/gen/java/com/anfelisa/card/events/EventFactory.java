/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.card.events;

import de.acegen.IDaoProvider;
import de.acegen.IEvent;
import de.acegen.ViewProvider;
import com.anfelisa.card.data.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.acegen.IDataContainer;
import de.acegen.CustomAppConfiguration;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("all")
public class EventFactory {
	
	private static ObjectMapper mapper = new ObjectMapper();
	private static final Logger LOG = LoggerFactory.getLogger(EventFactory.class);

	static {
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public static IEvent createEvent(String eventClass, String json, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		try {
			if (eventClass.equals("com.anfelisa.card.events.CreateCardOkEvent")) {
				CardCreationData data = mapper.readValue(json, CardCreationData.class);
				data.migrateLegacyData(json);
				CreateCardOkEvent event = new CreateCardOkEvent(data, daoProvider, viewProvider, appConfiguration);
				return event;
			}
			if (eventClass.equals("com.anfelisa.card.events.UpdateCardOkEvent")) {
				CardUpdateData data = mapper.readValue(json, CardUpdateData.class);
				data.migrateLegacyData(json);
				UpdateCardOkEvent event = new UpdateCardOkEvent(data, daoProvider, viewProvider, appConfiguration);
				return event;
			}
			if (eventClass.equals("com.anfelisa.card.events.UpdateCardPriorityOkEvent")) {
				CardUpdatePriorityData data = mapper.readValue(json, CardUpdatePriorityData.class);
				data.migrateLegacyData(json);
				UpdateCardPriorityOkEvent event = new UpdateCardPriorityOkEvent(data, daoProvider, viewProvider, appConfiguration);
				return event;
			}
			if (eventClass.equals("com.anfelisa.card.events.DeleteCardOkEvent")) {
				CardDeleteData data = mapper.readValue(json, CardDeleteData.class);
				data.migrateLegacyData(json);
				DeleteCardOkEvent event = new DeleteCardOkEvent(data, daoProvider, viewProvider, appConfiguration);
				return event;
			}
			if (eventClass.equals("com.anfelisa.card.events.MoveCardsOkEvent")) {
				MoveCardsData data = mapper.readValue(json, MoveCardsData.class);
				data.migrateLegacyData(json);
				MoveCardsOkEvent event = new MoveCardsOkEvent(data, daoProvider, viewProvider, appConfiguration);
				return event;
			}
			if (eventClass.equals("com.anfelisa.card.events.ChangeOrderOkEvent")) {
				ChangeCardOrderListData data = mapper.readValue(json, ChangeCardOrderListData.class);
				data.migrateLegacyData(json);
				ChangeOrderOkEvent event = new ChangeOrderOkEvent(data, daoProvider, viewProvider, appConfiguration);
				return event;
			}
		} catch (IOException e) {
			LOG.error("failed to create event {} with data {}", eventClass, json, e);
		}

		return null;
	}

	public static IEvent createEvent(String eventClass, IDataContainer data, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		if (eventClass.equals("com.anfelisa.card.events.CreateCardOkEvent")) {
			return new CreateCardOkEvent((CardCreationData)data, daoProvider, viewProvider, appConfiguration);
		}

		if (eventClass.equals("com.anfelisa.card.events.UpdateCardOkEvent")) {
			return new UpdateCardOkEvent((CardUpdateData)data, daoProvider, viewProvider, appConfiguration);
		}

		if (eventClass.equals("com.anfelisa.card.events.UpdateCardPriorityOkEvent")) {
			return new UpdateCardPriorityOkEvent((CardUpdatePriorityData)data, daoProvider, viewProvider, appConfiguration);
		}

		if (eventClass.equals("com.anfelisa.card.events.DeleteCardOkEvent")) {
			return new DeleteCardOkEvent((CardDeleteData)data, daoProvider, viewProvider, appConfiguration);
		}



		if (eventClass.equals("com.anfelisa.card.events.MoveCardsOkEvent")) {
			return new MoveCardsOkEvent((MoveCardsData)data, daoProvider, viewProvider, appConfiguration);
		}

		if (eventClass.equals("com.anfelisa.card.events.ChangeOrderOkEvent")) {
			return new ChangeOrderOkEvent((ChangeCardOrderListData)data, daoProvider, viewProvider, appConfiguration);
		}



		return null;
	}
}



/******* S.D.G. *******/




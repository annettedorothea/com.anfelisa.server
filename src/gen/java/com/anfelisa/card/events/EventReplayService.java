/********************************************************************************
 * generated by de.acegen 1.5.6
 ********************************************************************************/




package com.anfelisa.card.events;

import de.acegen.IEvent;
import de.acegen.Event;
import de.acegen.ViewProvider;
import com.anfelisa.card.data.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.acegen.IDataContainer;
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

	public static void replayEvent(String eventClass, String json, PersistenceHandle handle, ViewProvider viewProvider) {
		try {
			if (eventClass.equals("com.anfelisa.card.events.CreateCardOkEvent")) {
				CardCreationData data = mapper.readValue(json, CardCreationData.class);
				data.migrateLegacyData(json);
				Event event = new Event<CardCreationData>("com.anfelisa.card.events.CreateCardOkEvent", viewProvider);
				event.notifyListeners(data, handle);
				event.notifyAfterCommitListeners(data, handle);
			}
			if (eventClass.equals("com.anfelisa.card.events.UpdateCardOkEvent")) {
				CardUpdateData data = mapper.readValue(json, CardUpdateData.class);
				data.migrateLegacyData(json);
				Event event = new Event<CardUpdateData>("com.anfelisa.card.events.UpdateCardOkEvent", viewProvider);
				event.notifyListeners(data, handle);
				event.notifyAfterCommitListeners(data, handle);
			}
			if (eventClass.equals("com.anfelisa.card.events.UpdateCardPriorityOkEvent")) {
				CardUpdatePriorityData data = mapper.readValue(json, CardUpdatePriorityData.class);
				data.migrateLegacyData(json);
				Event event = new Event<CardUpdatePriorityData>("com.anfelisa.card.events.UpdateCardPriorityOkEvent", viewProvider);
				event.notifyListeners(data, handle);
				event.notifyAfterCommitListeners(data, handle);
			}
			if (eventClass.equals("com.anfelisa.card.events.DeleteCardOkEvent")) {
				CardDeleteData data = mapper.readValue(json, CardDeleteData.class);
				data.migrateLegacyData(json);
				Event event = new Event<CardDeleteData>("com.anfelisa.card.events.DeleteCardOkEvent", viewProvider);
				event.notifyListeners(data, handle);
				event.notifyAfterCommitListeners(data, handle);
			}
			if (eventClass.equals("com.anfelisa.card.events.MoveCardsOkEvent")) {
				MoveCardsData data = mapper.readValue(json, MoveCardsData.class);
				data.migrateLegacyData(json);
				Event event = new Event<MoveCardsData>("com.anfelisa.card.events.MoveCardsOkEvent", viewProvider);
				event.notifyListeners(data, handle);
				event.notifyAfterCommitListeners(data, handle);
			}
			if (eventClass.equals("com.anfelisa.card.events.ChangeOrderOkEvent")) {
				ChangeCardOrderListData data = mapper.readValue(json, ChangeCardOrderListData.class);
				data.migrateLegacyData(json);
				Event event = new Event<ChangeCardOrderListData>("com.anfelisa.card.events.ChangeOrderOkEvent", viewProvider);
				event.notifyListeners(data, handle);
				event.notifyAfterCommitListeners(data, handle);
			}
		} catch (IOException e) {
			LOG.error("failed to replay event {} with data {}", eventClass, json, e);
		}
	}

}



/******* S.D.G. *******/




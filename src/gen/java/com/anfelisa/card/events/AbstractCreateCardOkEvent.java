package com.anfelisa.card.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.card.data.CardCreationData;

public abstract class AbstractCreateCardOkEvent extends Event<CardCreationData> {

	public AbstractCreateCardOkEvent(CardCreationData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.card.events.CreateCardOkEvent", eventParam, databaseHandle);
	}
	
	public AbstractCreateCardOkEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.card.events.CreateCardOkEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, CardCreationData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.card.views.CardView.insert" };
	}
	
	

}

/*       S.D.G.       */

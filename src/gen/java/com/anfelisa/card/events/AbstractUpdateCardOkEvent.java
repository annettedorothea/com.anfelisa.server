package com.anfelisa.card.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.card.data.CardUpdateData;

public abstract class AbstractUpdateCardOkEvent extends Event<CardUpdateData> {

	public AbstractUpdateCardOkEvent(CardUpdateData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.card.events.UpdateCardOkEvent", eventParam, databaseHandle);
	}
	
	public AbstractUpdateCardOkEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.card.events.UpdateCardOkEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, CardUpdateData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.card.views.CardView.update" };
	}
	
	

}

/*       S.D.G.       */

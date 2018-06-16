package com.anfelisa.card.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.card.data.CardCreationData;

public abstract class AbstractCreateCardOkEvent extends Event<CardCreationData> {

	public AbstractCreateCardOkEvent(CardCreationData eventParam, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.card.events.CreateCardOkEvent", eventParam, databaseHandle, daoProvider, viewProvider);
	}
	
	public AbstractCreateCardOkEvent(DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.card.events.CreateCardOkEvent", null, databaseHandle, daoProvider, viewProvider);
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

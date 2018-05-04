package com.anfelisa.card.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.card.data.CardDeleteData;

public abstract class AbstractDeleteCardOkEvent extends Event<CardDeleteData> {

	public AbstractDeleteCardOkEvent(CardDeleteData eventParam, DatabaseHandle databaseHandle, DaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.card.events.DeleteCardOkEvent", eventParam, databaseHandle, daoProvider, viewProvider);
	}
	
	public AbstractDeleteCardOkEvent(DatabaseHandle databaseHandle, DaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.card.events.DeleteCardOkEvent", null, databaseHandle, daoProvider, viewProvider);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, CardDeleteData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.card.views.CardView.delete" };
	}
	
	

}

/*       S.D.G.       */

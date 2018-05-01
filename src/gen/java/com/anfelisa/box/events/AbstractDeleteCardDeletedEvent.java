package com.anfelisa.box.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import com.anfelisa.box.data.CardIdData;

public abstract class AbstractDeleteCardDeletedEvent extends Event<CardIdData> {

	public AbstractDeleteCardDeletedEvent(CardIdData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.DeleteCardDeletedEvent", eventParam, databaseHandle);
	}
	
	public AbstractDeleteCardDeletedEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.DeleteCardDeletedEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, CardIdData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.box.views.CardView.deleteCard" };
	}
	
	

}

/*       S.D.G.       */

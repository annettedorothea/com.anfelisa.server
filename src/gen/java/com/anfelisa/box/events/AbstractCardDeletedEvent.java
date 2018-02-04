package com.anfelisa.box.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.box.data.CardIdData;

public abstract class AbstractCardDeletedEvent extends Event<CardIdData> {

	public AbstractCardDeletedEvent(CardIdData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.CardDeletedEvent", eventParam, databaseHandle);
	}
	
	public AbstractCardDeletedEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.CardDeletedEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, CardIdData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	

}

/*       S.D.G.       */

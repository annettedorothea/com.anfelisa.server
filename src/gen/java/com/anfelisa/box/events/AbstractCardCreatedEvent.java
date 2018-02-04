package com.anfelisa.box.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.box.data.CardCreationData;

public abstract class AbstractCardCreatedEvent extends Event<CardCreationData> {

	public AbstractCardCreatedEvent(CardCreationData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.CardCreatedEvent", eventParam, databaseHandle);
	}
	
	public AbstractCardCreatedEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.CardCreatedEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, CardCreationData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	

}

/*       S.D.G.       */

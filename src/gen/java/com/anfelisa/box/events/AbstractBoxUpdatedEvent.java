package com.anfelisa.box.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.box.data.BoxCreationData;

public abstract class AbstractBoxUpdatedEvent extends Event<BoxCreationData> {

	public AbstractBoxUpdatedEvent(BoxCreationData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.BoxUpdatedEvent", eventParam, databaseHandle);
	}
	
	public AbstractBoxUpdatedEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.BoxUpdatedEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, BoxCreationData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	

}

/*       S.D.G.       */

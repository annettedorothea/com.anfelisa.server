package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.box.data.BoxCreationData;

public abstract class AbstractBoxCreatedEvent extends Event<BoxCreationData> {

	public AbstractBoxCreatedEvent(BoxCreationData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.BoxCreatedEvent", eventParam, databaseHandle);
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

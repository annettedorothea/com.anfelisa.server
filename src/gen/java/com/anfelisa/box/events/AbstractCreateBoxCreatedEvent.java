package com.anfelisa.box.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import com.anfelisa.box.data.BoxCreationData;

public abstract class AbstractCreateBoxCreatedEvent extends Event<BoxCreationData> {

	public AbstractCreateBoxCreatedEvent(BoxCreationData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.CreateBoxCreatedEvent", eventParam, databaseHandle);
	}
	
	public AbstractCreateBoxCreatedEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.CreateBoxCreatedEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, BoxCreationData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.box.views.BoxView.createBox" };
	}
	
	

}

/*       S.D.G.       */

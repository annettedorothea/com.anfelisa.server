package com.anfelisa.box.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.box.data.DeleteBoxData;

public abstract class AbstractDeleteBoxDeletedEvent extends Event<DeleteBoxData> {

	public AbstractDeleteBoxDeletedEvent(DeleteBoxData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.DeleteBoxDeletedEvent", eventParam, databaseHandle);
	}
	
	public AbstractDeleteBoxDeletedEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.DeleteBoxDeletedEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, DeleteBoxData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.box.views.BoxView.deleteBox" };
	}
	
	

}

/*       S.D.G.       */

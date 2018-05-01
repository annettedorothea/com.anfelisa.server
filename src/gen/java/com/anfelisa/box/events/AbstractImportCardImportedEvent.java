package com.anfelisa.box.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import com.anfelisa.box.data.CardCreationData;

public abstract class AbstractImportCardImportedEvent extends Event<CardCreationData> {

	public AbstractImportCardImportedEvent(CardCreationData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.ImportCardImportedEvent", eventParam, databaseHandle);
	}
	
	public AbstractImportCardImportedEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.ImportCardImportedEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, CardCreationData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.box.views.CardView.createCard" };
	}
	
	

}

/*       S.D.G.       */

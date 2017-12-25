package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.box.data.CardCreationData;

public abstract class AbstractCardImportedEvent extends Event<CardCreationData> {

	public AbstractCardImportedEvent(CardCreationData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.CardImportedEvent", eventParam, databaseHandle);
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

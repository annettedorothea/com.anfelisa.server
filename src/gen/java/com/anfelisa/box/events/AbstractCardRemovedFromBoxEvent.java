package com.anfelisa.box.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.box.data.RemoveCardFromBoxData;

public abstract class AbstractCardRemovedFromBoxEvent extends Event<RemoveCardFromBoxData> {

	public AbstractCardRemovedFromBoxEvent(RemoveCardFromBoxData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.CardRemovedFromBoxEvent", eventParam, databaseHandle);
	}
	
	public AbstractCardRemovedFromBoxEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.CardRemovedFromBoxEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, RemoveCardFromBoxData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	

}

/*       S.D.G.       */

package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.box.data.RemoveCardFromBoxData;

public abstract class AbstractCardRemovedFromBoxEvent extends Event<RemoveCardFromBoxData> {

	public AbstractCardRemovedFromBoxEvent(RemoveCardFromBoxData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.CardRemovedFromBoxEvent", eventParam, databaseHandle);
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

package com.anfelisa.box.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import com.anfelisa.box.data.RemoveCardFromBoxData;

public abstract class AbstractRemoveCardFromBoxDeletedEvent extends Event<RemoveCardFromBoxData> {

	public AbstractRemoveCardFromBoxDeletedEvent(RemoveCardFromBoxData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.RemoveCardFromBoxDeletedEvent", eventParam, databaseHandle);
	}
	
	public AbstractRemoveCardFromBoxDeletedEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.RemoveCardFromBoxDeletedEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, RemoveCardFromBoxData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.box.views.ScheduledCardView.removeFromBox" };
	}
	
	

}

/*       S.D.G.       */

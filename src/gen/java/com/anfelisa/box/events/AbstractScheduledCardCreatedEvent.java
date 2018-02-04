package com.anfelisa.box.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.box.data.ScheduledCardData;

public abstract class AbstractScheduledCardCreatedEvent extends Event<ScheduledCardData> {

	public AbstractScheduledCardCreatedEvent(ScheduledCardData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.ScheduledCardCreatedEvent", eventParam, databaseHandle);
	}
	
	public AbstractScheduledCardCreatedEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.ScheduledCardCreatedEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, ScheduledCardData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	

}

/*       S.D.G.       */

package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.box.data.ScheduledCardData;

public abstract class AbstractScheduledCardCreatedEvent extends Event<ScheduledCardData> {

	public AbstractScheduledCardCreatedEvent(ScheduledCardData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.ScheduledCardCreatedEvent", eventParam, databaseHandle);
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

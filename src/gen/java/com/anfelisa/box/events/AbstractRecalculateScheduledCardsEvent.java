package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.box.data.RecalculateScheduledCardsData;

public abstract class AbstractRecalculateScheduledCardsEvent extends Event<RecalculateScheduledCardsData> {

	public AbstractRecalculateScheduledCardsEvent(RecalculateScheduledCardsData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.RecalculateScheduledCardsEvent", eventParam, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, RecalculateScheduledCardsData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	

}

/*       S.D.G.       */

package com.anfelisa.box.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.box.data.RecalculateScheduledCardsData;

public abstract class AbstractRecalculateScheduledCardsOkEvent extends Event<RecalculateScheduledCardsData> {

	public AbstractRecalculateScheduledCardsOkEvent(RecalculateScheduledCardsData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.RecalculateScheduledCardsOkEvent", eventParam, databaseHandle);
	}
	
	public AbstractRecalculateScheduledCardsOkEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.RecalculateScheduledCardsOkEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, RecalculateScheduledCardsData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.box.views.ScheduledCardView.recalculateScheduledCards" };
	}
	
	

}

/*       S.D.G.       */
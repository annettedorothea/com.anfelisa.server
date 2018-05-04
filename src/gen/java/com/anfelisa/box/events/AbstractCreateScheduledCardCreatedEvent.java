package com.anfelisa.box.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.box.data.ScheduledCardData;

public abstract class AbstractCreateScheduledCardCreatedEvent extends Event<ScheduledCardData> {

	public AbstractCreateScheduledCardCreatedEvent(ScheduledCardData eventParam, DatabaseHandle databaseHandle, DaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.events.CreateScheduledCardCreatedEvent", eventParam, databaseHandle, daoProvider, viewProvider);
	}
	
	public AbstractCreateScheduledCardCreatedEvent(DatabaseHandle databaseHandle, DaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.events.CreateScheduledCardCreatedEvent", null, databaseHandle, daoProvider, viewProvider);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, ScheduledCardData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.box.views.ScheduledCardView.createScheduledCard" };
	}
	
	

}

/*       S.D.G.       */

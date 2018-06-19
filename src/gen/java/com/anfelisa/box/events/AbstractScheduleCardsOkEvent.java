package com.anfelisa.box.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.box.data.ScheduleCardsData;

public abstract class AbstractScheduleCardsOkEvent extends Event<ScheduleCardsData> {

	public AbstractScheduleCardsOkEvent(ScheduleCardsData eventParam, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.events.ScheduleCardsOkEvent", eventParam, databaseHandle, daoProvider, viewProvider);
	}
	
	public AbstractScheduleCardsOkEvent(DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.events.ScheduleCardsOkEvent", null, databaseHandle, daoProvider, viewProvider);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, ScheduleCardsData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.box.views.BoxView.scheduleCards" };
	}
	
	

}

/*       S.D.G.       */

package com.anfelisa.test.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.test.data.TestCreationData;

public abstract class AbstractUpdateTestUpdatedEvent extends Event<TestCreationData> {

	public AbstractUpdateTestUpdatedEvent(TestCreationData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.test.events.UpdateTestUpdatedEvent", eventParam, databaseHandle);
	}
	
	public AbstractUpdateTestUpdatedEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.test.events.UpdateTestUpdatedEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, TestCreationData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.test.views.TestView.updateTest" };
	}
	
	

}

/*       S.D.G.       */

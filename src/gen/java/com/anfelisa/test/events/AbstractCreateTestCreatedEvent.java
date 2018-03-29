package com.anfelisa.test.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.test.data.TestCreationData;

public abstract class AbstractCreateTestCreatedEvent extends Event<TestCreationData> {

	public AbstractCreateTestCreatedEvent(TestCreationData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.test.events.CreateTestCreatedEvent", eventParam, databaseHandle);
	}
	
	public AbstractCreateTestCreatedEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.test.events.CreateTestCreatedEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, TestCreationData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.test.views.TestView.createTest" };
	}
	
	

}

/*       S.D.G.       */

package com.anfelisa.test.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.test.data.TestCreationData;

public abstract class AbstractTestCreatedEvent extends Event<TestCreationData> {

	public AbstractTestCreatedEvent(TestCreationData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.test.events.TestCreatedEvent", eventParam, databaseHandle);
	}
	
	public AbstractTestCreatedEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.test.events.TestCreatedEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, TestCreationData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	

}

/*       S.D.G.       */

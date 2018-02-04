package com.anfelisa.test.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.test.data.TestCreationData;

public abstract class AbstractTestUpdatedEvent extends Event<TestCreationData> {

	public AbstractTestUpdatedEvent(TestCreationData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.test.events.TestUpdatedEvent", eventParam, databaseHandle);
	}
	
	public AbstractTestUpdatedEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.test.events.TestUpdatedEvent", null, databaseHandle);
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

package com.anfelisa.test.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.test.data.TestIdData;

public abstract class AbstractTestDeletedEvent extends Event<TestIdData> {

	public AbstractTestDeletedEvent(TestIdData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.test.events.TestDeletedEvent", eventParam, databaseHandle);
	}
	
	public AbstractTestDeletedEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.test.events.TestDeletedEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, TestIdData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	

}

/*       S.D.G.       */

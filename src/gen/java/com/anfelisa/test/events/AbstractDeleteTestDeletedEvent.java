package com.anfelisa.test.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.test.data.TestIdData;

public abstract class AbstractDeleteTestDeletedEvent extends Event<TestIdData> {

	public AbstractDeleteTestDeletedEvent(TestIdData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.test.events.DeleteTestDeletedEvent", eventParam, databaseHandle);
	}
	
	public AbstractDeleteTestDeletedEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.test.events.DeleteTestDeletedEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, TestIdData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.test.views.TestView.deleteTest" };
	}
	
	

}

/*       S.D.G.       */

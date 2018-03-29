package com.anfelisa.result.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.result.data.ResultCreationData;

public abstract class AbstractCreateResultCreatedEvent extends Event<ResultCreationData> {

	public AbstractCreateResultCreatedEvent(ResultCreationData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.result.events.CreateResultCreatedEvent", eventParam, databaseHandle);
	}
	
	public AbstractCreateResultCreatedEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.result.events.CreateResultCreatedEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, ResultCreationData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.result.views.ResultView.createResult" };
	}
	
	

}

/*       S.D.G.       */

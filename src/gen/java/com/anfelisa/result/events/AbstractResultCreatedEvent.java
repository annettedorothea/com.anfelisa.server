package com.anfelisa.result.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.result.data.ResultCreationData;

public abstract class AbstractResultCreatedEvent extends Event<ResultCreationData> {

	public AbstractResultCreatedEvent(ResultCreationData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.result.events.ResultCreatedEvent", eventParam, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, ResultCreationData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	

}

/*       S.D.G.       */

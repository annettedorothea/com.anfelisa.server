package com.anfelisa.result.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.result.data.ResultSaveData;

public abstract class AbstractResultSavedEvent extends Event<ResultSaveData> {

	public AbstractResultSavedEvent(ResultSaveData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.result.events.ResultSavedEvent", eventParam, databaseHandle);
	}
	
	public AbstractResultSavedEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.result.events.ResultSavedEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, ResultSaveData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	

}

/*       S.D.G.       */

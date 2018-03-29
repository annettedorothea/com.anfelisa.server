package com.anfelisa.result.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.result.data.ResultSaveData;

public abstract class AbstractSaveResultSavedEvent extends Event<ResultSaveData> {

	public AbstractSaveResultSavedEvent(ResultSaveData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.result.events.SaveResultSavedEvent", eventParam, databaseHandle);
	}
	
	public AbstractSaveResultSavedEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.result.events.SaveResultSavedEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, ResultSaveData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.result.views.ResultView.saveResult", "com.anfelisa.result.views.ResultView.fillBoxWithCards" };
	}
	
	

}

/*       S.D.G.       */

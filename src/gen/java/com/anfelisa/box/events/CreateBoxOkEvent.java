package com.anfelisa.box.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.box.data.BoxCreationData;

public class CreateBoxOkEvent extends Event<BoxCreationData> {

	public CreateBoxOkEvent(BoxCreationData eventData, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.events.CreateBoxOkEvent", eventData, databaseHandle, daoProvider, viewProvider);
	}
	
	public CreateBoxOkEvent(DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.events.CreateBoxOkEvent", null, databaseHandle, daoProvider, viewProvider);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, BoxCreationData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */
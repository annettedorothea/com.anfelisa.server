package com.anfelisa.box.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.box.data.BoxConfigData;

public abstract class AbstractBoxConfigSavedEvent extends Event<BoxConfigData> {

	public AbstractBoxConfigSavedEvent(BoxConfigData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.BoxConfigSavedEvent", eventParam, databaseHandle);
	}
	
	public AbstractBoxConfigSavedEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.BoxConfigSavedEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, BoxConfigData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	

}

/*       S.D.G.       */

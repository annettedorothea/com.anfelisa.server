package com.anfelisa.box.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.box.data.BoxConfigData;

public abstract class AbstractSaveBoxConfigSavedEvent extends Event<BoxConfigData> {

	public AbstractSaveBoxConfigSavedEvent(BoxConfigData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.SaveBoxConfigSavedEvent", eventParam, databaseHandle);
	}
	
	public AbstractSaveBoxConfigSavedEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.SaveBoxConfigSavedEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, BoxConfigData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.box.views.BoxToCourseView.saveBoxConfig" };
	}
	
	

}

/*       S.D.G.       */

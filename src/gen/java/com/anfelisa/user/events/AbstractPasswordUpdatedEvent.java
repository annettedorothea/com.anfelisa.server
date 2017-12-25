package com.anfelisa.user.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.user.data.PasswordUpdateData;

public abstract class AbstractPasswordUpdatedEvent extends Event<PasswordUpdateData> {

	public AbstractPasswordUpdatedEvent(PasswordUpdateData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.PasswordUpdatedEvent", eventParam, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, PasswordUpdateData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	

}

/*       S.D.G.       */

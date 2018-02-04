package com.anfelisa.user.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.user.data.UserUpdateData;

public abstract class AbstractUserUpdatedEvent extends Event<UserUpdateData> {

	public AbstractUserUpdatedEvent(UserUpdateData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.UserUpdatedEvent", eventParam, databaseHandle);
	}
	
	public AbstractUserUpdatedEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.UserUpdatedEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, UserUpdateData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	

}

/*       S.D.G.       */

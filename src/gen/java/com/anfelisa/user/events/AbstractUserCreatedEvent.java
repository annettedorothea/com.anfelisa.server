package com.anfelisa.user.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.user.data.UserCreationData;

public abstract class AbstractUserCreatedEvent extends Event<UserCreationData> {

	public AbstractUserCreatedEvent(UserCreationData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.UserCreatedEvent", eventParam, databaseHandle);
	}
	
	public AbstractUserCreatedEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.UserCreatedEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, UserCreationData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	

}

/*       S.D.G.       */

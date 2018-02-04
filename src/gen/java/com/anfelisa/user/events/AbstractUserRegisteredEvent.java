package com.anfelisa.user.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.user.data.UserRegistrationData;

public abstract class AbstractUserRegisteredEvent extends Event<UserRegistrationData> {

	public AbstractUserRegisteredEvent(UserRegistrationData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.UserRegisteredEvent", eventParam, databaseHandle);
	}
	
	public AbstractUserRegisteredEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.UserRegisteredEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, UserRegistrationData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	

}

/*       S.D.G.       */

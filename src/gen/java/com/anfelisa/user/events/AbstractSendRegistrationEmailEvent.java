package com.anfelisa.user.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.user.data.UserRegistrationData;

public abstract class AbstractSendRegistrationEmailEvent extends Event<UserRegistrationData> {

	public AbstractSendRegistrationEmailEvent(UserRegistrationData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.SendRegistrationEmailEvent", eventParam, databaseHandle);
	}
	
	public AbstractSendRegistrationEmailEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.SendRegistrationEmailEvent", null, databaseHandle);
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

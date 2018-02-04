package com.anfelisa.user.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.user.data.LoginData;

public abstract class AbstractUserLoggedInEvent extends Event<LoginData> {

	public AbstractUserLoggedInEvent(LoginData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.UserLoggedInEvent", eventParam, databaseHandle);
	}
	
	public AbstractUserLoggedInEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.UserLoggedInEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, LoginData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	

}

/*       S.D.G.       */

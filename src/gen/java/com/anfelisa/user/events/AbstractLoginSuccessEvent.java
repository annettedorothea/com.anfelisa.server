package com.anfelisa.user.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.user.data.LoginData;

public abstract class AbstractLoginSuccessEvent extends Event<LoginData> {

	public AbstractLoginSuccessEvent(LoginData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.LoginSuccessEvent", eventParam, databaseHandle);
	}
	
	public AbstractLoginSuccessEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.LoginSuccessEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, LoginData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.user.views.LoginLogView.userLoggedIn" };
	}
	
	

}

/*       S.D.G.       */

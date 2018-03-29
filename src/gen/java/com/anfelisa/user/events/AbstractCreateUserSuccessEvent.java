package com.anfelisa.user.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.user.data.UserCreationData;

public abstract class AbstractCreateUserSuccessEvent extends Event<UserCreationData> {

	public AbstractCreateUserSuccessEvent(UserCreationData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.CreateUserSuccessEvent", eventParam, databaseHandle);
	}
	
	public AbstractCreateUserSuccessEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.CreateUserSuccessEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, UserCreationData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.user.views.UserView.createUser" };
	}
	
	

}

/*       S.D.G.       */

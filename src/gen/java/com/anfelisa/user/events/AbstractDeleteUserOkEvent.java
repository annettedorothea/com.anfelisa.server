package com.anfelisa.user.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.user.data.UsernameData;

public abstract class AbstractDeleteUserOkEvent extends Event<UsernameData> {

	public AbstractDeleteUserOkEvent(UsernameData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.DeleteUserOkEvent", eventParam, databaseHandle);
	}
	
	public AbstractDeleteUserOkEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.DeleteUserOkEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, UsernameData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.user.views.UserView.deleteUser" };
	}
	
	

}

/*       S.D.G.       */

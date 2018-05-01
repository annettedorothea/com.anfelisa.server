package com.anfelisa.user.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import com.anfelisa.user.data.DeleteUserData;

public abstract class AbstractDeleteUserOkEvent extends Event<DeleteUserData> {

	public AbstractDeleteUserOkEvent(DeleteUserData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.DeleteUserOkEvent", eventParam, databaseHandle);
	}
	
	public AbstractDeleteUserOkEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.DeleteUserOkEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, DeleteUserData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.user.views.UserView.deleteUser" };
	}
	
	

}

/*       S.D.G.       */

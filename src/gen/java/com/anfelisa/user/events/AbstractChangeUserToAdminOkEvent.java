package com.anfelisa.user.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.user.data.ChangeUserRoleData;

public abstract class AbstractChangeUserToAdminOkEvent extends Event<ChangeUserRoleData> {

	public AbstractChangeUserToAdminOkEvent(ChangeUserRoleData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.ChangeUserToAdminOkEvent", eventParam, databaseHandle);
	}
	
	public AbstractChangeUserToAdminOkEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.ChangeUserToAdminOkEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, ChangeUserRoleData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.user.views.UserView.changeUserToAdmin" };
	}
	
	

}

/*       S.D.G.       */

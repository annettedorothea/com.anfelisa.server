package com.anfelisa.user.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.user.data.ChangeUserRoleData;

public abstract class AbstractChangeUserRoleOkEvent extends Event<ChangeUserRoleData> {

	public AbstractChangeUserRoleOkEvent(ChangeUserRoleData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.ChangeUserRoleOkEvent", eventParam, databaseHandle);
	}
	
	public AbstractChangeUserRoleOkEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.ChangeUserRoleOkEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, ChangeUserRoleData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.user.views.UserView.changeUserRole" };
	}
	
	

}

/*       S.D.G.       */

package com.anfelisa.user.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.user.data.ChangeUserRoleData;

public abstract class AbstractChangeUserToAuthorOkEvent extends Event<ChangeUserRoleData> {

	public AbstractChangeUserToAuthorOkEvent(ChangeUserRoleData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.ChangeUserToAuthorOkEvent", eventParam, databaseHandle);
	}
	
	public AbstractChangeUserToAuthorOkEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.ChangeUserToAuthorOkEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, ChangeUserRoleData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.user.views.UserView.changeUserToAuthor" };
	}
	
	

}

/*       S.D.G.       */

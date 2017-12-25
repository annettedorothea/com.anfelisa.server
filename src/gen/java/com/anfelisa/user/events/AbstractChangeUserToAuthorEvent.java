package com.anfelisa.user.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.user.data.ChangeUserRoleData;

public abstract class AbstractChangeUserToAuthorEvent extends Event<ChangeUserRoleData> {

	public AbstractChangeUserToAuthorEvent(ChangeUserRoleData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.ChangeUserToAuthorEvent", eventParam, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, ChangeUserRoleData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	

}

/*       S.D.G.       */

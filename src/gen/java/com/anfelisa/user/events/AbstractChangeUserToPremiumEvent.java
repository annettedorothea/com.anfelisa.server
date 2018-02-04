package com.anfelisa.user.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.user.data.ChangeUserRoleData;

public abstract class AbstractChangeUserToPremiumEvent extends Event<ChangeUserRoleData> {

	public AbstractChangeUserToPremiumEvent(ChangeUserRoleData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.ChangeUserToPremiumEvent", eventParam, databaseHandle);
	}
	
	public AbstractChangeUserToPremiumEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.ChangeUserToPremiumEvent", null, databaseHandle);
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

package com.anfelisa.user.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.user.data.ChangeUserRoleData;

public abstract class AbstractChangeUserToPremiumOkEvent extends Event<ChangeUserRoleData> {

	public AbstractChangeUserToPremiumOkEvent(ChangeUserRoleData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.ChangeUserToPremiumOkEvent", eventParam, databaseHandle);
	}
	
	public AbstractChangeUserToPremiumOkEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.ChangeUserToPremiumOkEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, ChangeUserRoleData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.user.views.UserView.changeUserToPremium" };
	}
	
	

}

/*       S.D.G.       */

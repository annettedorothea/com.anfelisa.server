package com.anfelisa.user.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import com.anfelisa.user.data.UserUpdateData;

public abstract class AbstractUpdateUserSuccessEvent extends Event<UserUpdateData> {

	public AbstractUpdateUserSuccessEvent(UserUpdateData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.UpdateUserSuccessEvent", eventParam, databaseHandle);
	}
	
	public AbstractUpdateUserSuccessEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.UpdateUserSuccessEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, UserUpdateData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.user.views.UserView.updateUser" };
	}
	
	

}

/*       S.D.G.       */

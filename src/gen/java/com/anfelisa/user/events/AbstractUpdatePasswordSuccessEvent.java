package com.anfelisa.user.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.user.data.PasswordUpdateData;

public abstract class AbstractUpdatePasswordSuccessEvent extends Event<PasswordUpdateData> {

	public AbstractUpdatePasswordSuccessEvent(PasswordUpdateData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.UpdatePasswordSuccessEvent", eventParam, databaseHandle);
	}
	
	public AbstractUpdatePasswordSuccessEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.UpdatePasswordSuccessEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, PasswordUpdateData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.user.views.UserView.updatePassword" };
	}
	
	

}

/*       S.D.G.       */

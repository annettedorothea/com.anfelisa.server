package com.anfelisa.user.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.user.data.ResetPasswordData;

public abstract class AbstractResetPasswordOkEvent extends Event<ResetPasswordData> {

	public AbstractResetPasswordOkEvent(ResetPasswordData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.ResetPasswordOkEvent", eventParam, databaseHandle);
	}
	
	public AbstractResetPasswordOkEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.ResetPasswordOkEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, ResetPasswordData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.user.views.UserView.resetPassword", "com.anfelisa.user.views.ResetPasswordView.delete" };
	}
	
	

}

/*       S.D.G.       */

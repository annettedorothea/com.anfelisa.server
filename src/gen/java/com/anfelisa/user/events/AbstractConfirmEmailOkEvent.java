package com.anfelisa.user.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.user.data.UsernameData;

public abstract class AbstractConfirmEmailOkEvent extends Event<UsernameData> {

	public AbstractConfirmEmailOkEvent(UsernameData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.ConfirmEmailOkEvent", eventParam, databaseHandle);
	}
	
	public AbstractConfirmEmailOkEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.ConfirmEmailOkEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, UsernameData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.user.views.UserView.confirmEmail" };
	}
	
	

}

/*       S.D.G.       */

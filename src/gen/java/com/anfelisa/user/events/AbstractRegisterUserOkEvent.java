package com.anfelisa.user.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import com.anfelisa.user.data.UserRegistrationData;

public abstract class AbstractRegisterUserOkEvent extends Event<UserRegistrationData> {

	public AbstractRegisterUserOkEvent(UserRegistrationData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.RegisterUserOkEvent", eventParam, databaseHandle);
	}
	
	public AbstractRegisterUserOkEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.RegisterUserOkEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, UserRegistrationData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.user.views.UserView.registerUser", "com.anfelisa.user.views.EmailConfirmationView.insert", "com.anfelisa.user.views.EmailView.sendRegistrationEmail" };
	}
	
	

}

/*       S.D.G.       */

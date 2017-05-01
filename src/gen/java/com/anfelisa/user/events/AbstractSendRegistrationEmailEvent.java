package com.anfelisa.user.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.user.data.UserRegistrationData;

public abstract class AbstractSendRegistrationEmailEvent extends Event<UserRegistrationData> {

	public AbstractSendRegistrationEmailEvent(UserRegistrationData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.SendRegistrationEmailEvent", eventParam, databaseHandle);
	}

}

/*       S.D.G.       */

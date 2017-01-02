package com.anfelisa.user.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.user.data.UserRegistrationData;

public abstract class AbstractUserRegisteredEvent extends Event<UserRegistrationData> {

	public AbstractUserRegisteredEvent(UserRegistrationData eventParam, DatabaseHandle databaseHandle) {
		super("UserRegisteredEvent", eventParam, databaseHandle);
	}

}

/*       S.D.G.       */

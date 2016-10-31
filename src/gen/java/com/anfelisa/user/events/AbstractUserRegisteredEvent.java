package com.anfelisa.user.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.user.data.RegistrationData;

public abstract class AbstractUserRegisteredEvent extends Event<RegistrationData> {

	public AbstractUserRegisteredEvent(RegistrationData eventParam, DatabaseHandle databaseHandle) {
		super("UserRegisteredEvent", eventParam, databaseHandle);
	}

}

/*       S.D.G.       */

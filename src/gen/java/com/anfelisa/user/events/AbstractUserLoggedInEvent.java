package com.anfelisa.user.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.user.data.LoginData;

public abstract class AbstractUserLoggedInEvent extends Event<LoginData> {

	public AbstractUserLoggedInEvent(LoginData eventParam, DatabaseHandle databaseHandle) {
		super("UserLoggedInEvent", eventParam, databaseHandle);
	}

}

/*       S.D.G.       */

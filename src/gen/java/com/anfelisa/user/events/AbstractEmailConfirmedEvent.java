package com.anfelisa.user.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.user.data.UsernameData;

public abstract class AbstractEmailConfirmedEvent extends Event<UsernameData> {

	public AbstractEmailConfirmedEvent(UsernameData eventParam, DatabaseHandle databaseHandle) {
		super("EmailConfirmedEvent", eventParam, databaseHandle);
	}

}

/*       S.D.G.       */

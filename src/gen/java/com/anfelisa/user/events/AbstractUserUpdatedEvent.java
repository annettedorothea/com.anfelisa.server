package com.anfelisa.user.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.user.data.UserUpdateData;

public abstract class AbstractUserUpdatedEvent extends Event<UserUpdateData> {

	public AbstractUserUpdatedEvent(UserUpdateData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.UserUpdatedEvent", eventParam, databaseHandle);
	}

}

/*       S.D.G.       */

package com.anfelisa.user.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.user.data.UserCreationData;

public abstract class AbstractUserCreatedEvent extends Event<UserCreationData> {

	public AbstractUserCreatedEvent(UserCreationData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.UserCreatedEvent", eventParam, databaseHandle);
	}

}

/*       S.D.G.       */

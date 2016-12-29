package com.anfelisa.user.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.user.data.PasswordUpdateData;

public abstract class AbstractPasswordUpdatedEvent extends Event<PasswordUpdateData> {

	public AbstractPasswordUpdatedEvent(PasswordUpdateData eventParam, DatabaseHandle databaseHandle) {
		super("PasswordUpdatedEvent", eventParam, databaseHandle);
	}

}

/*       S.D.G.       */

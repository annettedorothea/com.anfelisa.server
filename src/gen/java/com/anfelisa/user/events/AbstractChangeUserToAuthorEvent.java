package com.anfelisa.user.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.user.data.ChangeUserRoleData;

public abstract class AbstractChangeUserToAuthorEvent extends Event<ChangeUserRoleData> {

	public AbstractChangeUserToAuthorEvent(ChangeUserRoleData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.ChangeUserToAuthorEvent", eventParam, databaseHandle);
	}

}

/*       S.D.G.       */

package com.anfelisa.user.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.user.data.ChangeUserRoleData;

public abstract class AbstractChangeUserToAdminEvent extends Event<ChangeUserRoleData> {

	public AbstractChangeUserToAdminEvent(ChangeUserRoleData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.ChangeUserToAdminEvent", eventParam, databaseHandle);
	}

}

/*       S.D.G.       */

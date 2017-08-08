package com.anfelisa.user.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.user.data.ChangeUserRoleData;

public abstract class AbstractChangeUserToPremiumEvent extends Event<ChangeUserRoleData> {

	public AbstractChangeUserToPremiumEvent(ChangeUserRoleData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.ChangeUserToPremiumEvent", eventParam, databaseHandle);
	}

}

/*       S.D.G.       */

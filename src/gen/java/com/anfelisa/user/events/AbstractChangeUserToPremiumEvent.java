package com.anfelisa.user.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.user.data.ChangeUserToPremiumData;

public abstract class AbstractChangeUserToPremiumEvent extends Event<ChangeUserToPremiumData> {

	public AbstractChangeUserToPremiumEvent(ChangeUserToPremiumData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.ChangeUserToPremiumEvent", eventParam, databaseHandle);
	}

}

/*       S.D.G.       */

package com.anfelisa.category.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.category.data.RevokeUserData;

public class RevokeUserAccessOkEvent extends Event<RevokeUserData> {

	public RevokeUserAccessOkEvent(RevokeUserData eventData, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.category.events.RevokeUserAccessOkEvent", eventData, databaseHandle, daoProvider, viewProvider);
	}

}

/*       S.D.G.       */

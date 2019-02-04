package com.anfelisa.user.events;

import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.user.data.IChangeUserRoleData;

public class ChangeUserRoleOkEvent extends Event<IChangeUserRoleData> {

	public ChangeUserRoleOkEvent(IChangeUserRoleData eventData, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.user.events.ChangeUserRoleOkEvent", eventData, daoProvider, viewProvider);
	}

}

/*       S.D.G.       */

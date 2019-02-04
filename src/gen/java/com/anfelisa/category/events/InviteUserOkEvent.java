package com.anfelisa.category.events;

import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.category.data.IInviteUserData;

public class InviteUserOkEvent extends Event<IInviteUserData> {

	public InviteUserOkEvent(IInviteUserData eventData, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.category.events.InviteUserOkEvent", eventData, daoProvider, viewProvider);
	}

}

/*       S.D.G.       */

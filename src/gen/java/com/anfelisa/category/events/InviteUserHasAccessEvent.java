package com.anfelisa.category.events;

import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.category.data.IInviteUserData;

public class InviteUserHasAccessEvent extends Event<IInviteUserData> {

	public InviteUserHasAccessEvent(IInviteUserData eventData, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.category.events.InviteUserHasAccessEvent", eventData, daoProvider, viewProvider);
	}

}

/*       S.D.G.       */

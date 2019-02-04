package com.anfelisa.user.events;

import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.user.data.IDeleteUserData;

public class DeleteUserOkEvent extends Event<IDeleteUserData> {

	public DeleteUserOkEvent(IDeleteUserData eventData, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.user.events.DeleteUserOkEvent", eventData, daoProvider, viewProvider);
	}

}

/*       S.D.G.       */

package com.anfelisa.user.events;

import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.user.data.IConfirmEmailData;

public class ConfirmEmailOkEvent extends Event<IConfirmEmailData> {

	public ConfirmEmailOkEvent(IConfirmEmailData eventData, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.user.events.ConfirmEmailOkEvent", eventData, daoProvider, viewProvider);
	}

}

/*       S.D.G.       */

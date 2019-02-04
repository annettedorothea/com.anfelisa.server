package com.anfelisa.user.events;

import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.user.data.IConfirmEmailData;

public class ConfirmEmailAlreadyConfirmedEvent extends Event<IConfirmEmailData> {

	public ConfirmEmailAlreadyConfirmedEvent(IConfirmEmailData eventData, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.user.events.ConfirmEmailAlreadyConfirmedEvent", eventData, daoProvider, viewProvider);
	}

}

/*       S.D.G.       */

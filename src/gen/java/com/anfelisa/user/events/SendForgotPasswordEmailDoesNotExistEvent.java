package com.anfelisa.user.events;

import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.user.data.IForgotPasswordData;

public class SendForgotPasswordEmailDoesNotExistEvent extends Event<IForgotPasswordData> {

	public SendForgotPasswordEmailDoesNotExistEvent(IForgotPasswordData eventData, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.user.events.SendForgotPasswordEmailDoesNotExistEvent", eventData, daoProvider, viewProvider);
	}

}

/*       S.D.G.       */

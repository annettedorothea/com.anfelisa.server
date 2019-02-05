package com.anfelisa.user.events;

import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.user.data.IForgotPasswordData;

public class SendForgotPasswordEmailOkEvent extends Event<IForgotPasswordData> {

	public SendForgotPasswordEmailOkEvent(IForgotPasswordData eventData, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.user.events.SendForgotPasswordEmailOkEvent", eventData, daoProvider, viewProvider);
	}

}

/*       S.D.G.       */

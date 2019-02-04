package com.anfelisa.user.events;

import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.user.data.IForgotPasswordData;

public class ForgotPasswordDoesNotExistEvent extends Event<IForgotPasswordData> {

	public ForgotPasswordDoesNotExistEvent(IForgotPasswordData eventData, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.user.events.ForgotPasswordDoesNotExistEvent", eventData, daoProvider, viewProvider);
	}

}

/*       S.D.G.       */

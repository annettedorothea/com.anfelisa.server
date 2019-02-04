package com.anfelisa.user.events;

import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.user.data.IResetPasswordWithNewPasswordData;

public class ResetPasswordOkEvent extends Event<IResetPasswordWithNewPasswordData> {

	public ResetPasswordOkEvent(IResetPasswordWithNewPasswordData eventData, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.user.events.ResetPasswordOkEvent", eventData, daoProvider, viewProvider);
	}

}

/*       S.D.G.       */

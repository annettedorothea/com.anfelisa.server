package com.anfelisa.user.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.user.data.ResetPasswordWithNewPasswordData;

public class ResetPasswordOkEvent extends Event<ResetPasswordWithNewPasswordData> {

	public ResetPasswordOkEvent(ResetPasswordWithNewPasswordData eventData, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.user.events.ResetPasswordOkEvent", eventData, databaseHandle, daoProvider, viewProvider);
	}

}

/*       S.D.G.       */

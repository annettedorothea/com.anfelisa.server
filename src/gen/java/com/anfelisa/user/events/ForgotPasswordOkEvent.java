package com.anfelisa.user.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.user.data.ForgotPasswordData;

public class ForgotPasswordOkEvent extends Event<ForgotPasswordData> {

	public ForgotPasswordOkEvent(ForgotPasswordData eventData, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.user.events.ForgotPasswordOkEvent", eventData, databaseHandle, daoProvider, viewProvider);
	}

}

/*       S.D.G.       */

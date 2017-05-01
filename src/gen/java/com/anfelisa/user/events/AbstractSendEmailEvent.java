package com.anfelisa.user.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.user.data.ForgotPasswordData;

public abstract class AbstractSendEmailEvent extends Event<ForgotPasswordData> {

	public AbstractSendEmailEvent(ForgotPasswordData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.events.SendEmailEvent", eventParam, databaseHandle);
	}

}

/*       S.D.G.       */

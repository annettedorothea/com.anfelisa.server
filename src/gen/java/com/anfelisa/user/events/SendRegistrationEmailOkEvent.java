package com.anfelisa.user.events;

import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.user.data.IUserRegistrationData;

public class SendRegistrationEmailOkEvent extends Event<IUserRegistrationData> {

	public SendRegistrationEmailOkEvent(IUserRegistrationData eventData, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.user.events.SendRegistrationEmailOkEvent", eventData, daoProvider, viewProvider);
	}

}

/*       S.D.G.       */

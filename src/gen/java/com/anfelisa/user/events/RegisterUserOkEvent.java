package com.anfelisa.user.events;

import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.user.data.IUserRegistrationData;

public class RegisterUserOkEvent extends Event<IUserRegistrationData> {

	public RegisterUserOkEvent(IUserRegistrationData eventData, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.user.events.RegisterUserOkEvent", eventData, daoProvider, viewProvider);
	}

}

/*       S.D.G.       */

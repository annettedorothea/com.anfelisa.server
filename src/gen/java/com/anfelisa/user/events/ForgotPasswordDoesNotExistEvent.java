/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.user.events;

import de.acegen.Event;
import de.acegen.IDaoProvider;
import de.acegen.ViewProvider;
import de.acegen.CustomAppConfiguration;

import com.anfelisa.user.data.IForgotPasswordData;

public class ForgotPasswordDoesNotExistEvent extends Event<IForgotPasswordData> {

	public ForgotPasswordDoesNotExistEvent(IForgotPasswordData eventData, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super("com.anfelisa.user.events.ForgotPasswordDoesNotExistEvent", eventData, daoProvider, viewProvider, appConfiguration);
	}

}



/******* S.D.G. *******/




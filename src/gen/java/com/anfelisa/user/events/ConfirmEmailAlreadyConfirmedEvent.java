/********************************************************************************
 * generated by de.acegen 0.9.13
 ********************************************************************************/




package com.anfelisa.user.events;

import de.acegen.Event;
import de.acegen.IDaoProvider;
import de.acegen.ViewProvider;
import de.acegen.CustomAppConfiguration;

import com.anfelisa.user.data.IConfirmEmailData;

public class ConfirmEmailAlreadyConfirmedEvent extends Event<IConfirmEmailData> {

	public ConfirmEmailAlreadyConfirmedEvent(IConfirmEmailData eventData, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super("com.anfelisa.user.events.ConfirmEmailAlreadyConfirmedEvent", eventData, daoProvider, viewProvider, appConfiguration);
	}

}



/******* S.D.G. *******/




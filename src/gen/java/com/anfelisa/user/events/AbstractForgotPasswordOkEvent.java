package com.anfelisa.user.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.user.data.ForgotPasswordData;

public abstract class AbstractForgotPasswordOkEvent extends Event<ForgotPasswordData> {

	public AbstractForgotPasswordOkEvent(ForgotPasswordData eventParam, DatabaseHandle databaseHandle, DaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.user.events.ForgotPasswordOkEvent", eventParam, databaseHandle, daoProvider, viewProvider);
	}
	
	public AbstractForgotPasswordOkEvent(DatabaseHandle databaseHandle, DaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.user.events.ForgotPasswordOkEvent", null, databaseHandle, daoProvider, viewProvider);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, ForgotPasswordData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.user.views.ResetPasswordView.insert", "com.anfelisa.user.views.EmailView.sendForgotPasswordEmail" };
	}
	
	

}

/*       S.D.G.       */

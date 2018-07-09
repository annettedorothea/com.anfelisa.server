package com.anfelisa.user.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.user.data.EmailConfirmationData;

public abstract class AbstractConfirmEmailOkEvent extends Event<EmailConfirmationData> {

	public AbstractConfirmEmailOkEvent(EmailConfirmationData eventParam, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.user.events.ConfirmEmailOkEvent", eventParam, databaseHandle, daoProvider, viewProvider);
	}
	
	public AbstractConfirmEmailOkEvent(DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.user.events.ConfirmEmailOkEvent", null, databaseHandle, daoProvider, viewProvider);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, EmailConfirmationData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.user.views.UserView.confirmEmail", "com.anfelisa.user.views.EmailConfirmationView.delete" };
	}
	
	

}

/*       S.D.G.       */

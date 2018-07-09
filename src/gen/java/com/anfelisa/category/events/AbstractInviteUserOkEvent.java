package com.anfelisa.category.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.category.data.InviteUserData;

public abstract class AbstractInviteUserOkEvent extends Event<InviteUserData> {

	public AbstractInviteUserOkEvent(InviteUserData eventParam, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.category.events.InviteUserOkEvent", eventParam, databaseHandle, daoProvider, viewProvider);
	}
	
	public AbstractInviteUserOkEvent(DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.category.events.InviteUserOkEvent", null, databaseHandle, daoProvider, viewProvider);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, InviteUserData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.category.views.UserAccessToCategoryView.grantAccessInvitation" };
	}
	
	

}

/*       S.D.G.       */

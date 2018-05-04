package com.anfelisa.box.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.box.data.DeleteBoxData;

public abstract class AbstractDeleteBoxDeletedEvent extends Event<DeleteBoxData> {

	public AbstractDeleteBoxDeletedEvent(DeleteBoxData eventParam, DatabaseHandle databaseHandle, DaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.events.DeleteBoxDeletedEvent", eventParam, databaseHandle, daoProvider, viewProvider);
	}
	
	public AbstractDeleteBoxDeletedEvent(DatabaseHandle databaseHandle, DaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.events.DeleteBoxDeletedEvent", null, databaseHandle, daoProvider, viewProvider);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, DeleteBoxData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.box.views.BoxView.deleteBox" };
	}
	
	

}

/*       S.D.G.       */

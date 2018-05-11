package com.anfelisa.box.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.data.BoxCreationData;

public abstract class AbstractUpdateBoxUpdatedEvent extends Event<BoxCreationData> {

	public AbstractUpdateBoxUpdatedEvent(BoxCreationData eventParam, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.events.UpdateBoxUpdatedEvent", eventParam, databaseHandle, daoProvider, viewProvider);
	}
	
	public AbstractUpdateBoxUpdatedEvent(DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.events.UpdateBoxUpdatedEvent", null, databaseHandle, daoProvider, viewProvider);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, BoxCreationData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.box.views.BoxView.updateBox" };
	}
	
	

}

/*       S.D.G.       */

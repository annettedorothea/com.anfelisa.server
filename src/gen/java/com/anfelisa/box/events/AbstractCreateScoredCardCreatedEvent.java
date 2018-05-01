package com.anfelisa.box.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import com.anfelisa.box.data.ScoredCardData;

public abstract class AbstractCreateScoredCardCreatedEvent extends Event<ScoredCardData> {

	public AbstractCreateScoredCardCreatedEvent(ScoredCardData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.CreateScoredCardCreatedEvent", eventParam, databaseHandle);
	}
	
	public AbstractCreateScoredCardCreatedEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.CreateScoredCardCreatedEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, ScoredCardData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.box.views.ScoredCardView.createScoredCard" };
	}
	
	

}

/*       S.D.G.       */

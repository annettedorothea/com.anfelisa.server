package com.anfelisa.box.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.box.data.ScoredCardData;

public abstract class AbstractScoredCardCreatedEvent extends Event<ScoredCardData> {

	public AbstractScoredCardCreatedEvent(ScoredCardData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.ScoredCardCreatedEvent", eventParam, databaseHandle);
	}
	
	public AbstractScoredCardCreatedEvent(DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.ScoredCardCreatedEvent", null, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, ScoredCardData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	

}

/*       S.D.G.       */

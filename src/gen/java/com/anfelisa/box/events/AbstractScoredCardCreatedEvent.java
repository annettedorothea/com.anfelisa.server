package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.box.data.ScoredCardData;

public abstract class AbstractScoredCardCreatedEvent extends Event<ScoredCardData> {

	public AbstractScoredCardCreatedEvent(ScoredCardData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.ScoredCardCreatedEvent", eventParam, databaseHandle);
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

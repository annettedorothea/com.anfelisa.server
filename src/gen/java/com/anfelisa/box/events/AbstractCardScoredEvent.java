package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.box.data.ScoreCardData;

public abstract class AbstractCardScoredEvent extends Event<ScoreCardData> {

	public AbstractCardScoredEvent(ScoreCardData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.CardScoredEvent", eventParam, databaseHandle);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, ScoreCardData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	

}

/*       S.D.G.       */

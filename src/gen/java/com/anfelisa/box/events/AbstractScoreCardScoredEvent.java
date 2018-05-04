package com.anfelisa.box.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.box.data.ScoreCardData;

public abstract class AbstractScoreCardScoredEvent extends Event<ScoreCardData> {

	public AbstractScoreCardScoredEvent(ScoreCardData eventParam, DatabaseHandle databaseHandle, DaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.events.ScoreCardScoredEvent", eventParam, databaseHandle, daoProvider, viewProvider);
	}
	
	public AbstractScoreCardScoredEvent(DatabaseHandle databaseHandle, DaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.events.ScoreCardScoredEvent", null, databaseHandle, daoProvider, viewProvider);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, ScoreCardData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.box.views.ScoredCardView.score", "com.anfelisa.box.views.ScheduledCardView.score" };
	}
	
	

}

/*       S.D.G.       */

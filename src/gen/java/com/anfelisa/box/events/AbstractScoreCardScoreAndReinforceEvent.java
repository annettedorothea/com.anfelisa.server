package com.anfelisa.box.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.box.data.ScoreCardData;

public abstract class AbstractScoreCardScoreAndReinforceEvent extends Event<ScoreCardData> {

	public AbstractScoreCardScoreAndReinforceEvent(ScoreCardData eventParam, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.events.ScoreCardScoreAndReinforceEvent", eventParam, databaseHandle, daoProvider, viewProvider);
	}
	
	public AbstractScoreCardScoreAndReinforceEvent(DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.events.ScoreCardScoreAndReinforceEvent", null, databaseHandle, daoProvider, viewProvider);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, ScoreCardData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.box.views.ScheduledCardView.score", "com.anfelisa.box.views.ScheduledCardView.scheduleNext", "com.anfelisa.box.views.ReinforceCardView.add" };
	}
	
	

}

/*       S.D.G.       */

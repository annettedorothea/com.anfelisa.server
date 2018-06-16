package com.anfelisa.box.events;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.data.ScoreReinforceCardData;

public abstract class AbstractScoreReinforceCardRemoveEvent extends Event<ScoreReinforceCardData> {

	public AbstractScoreReinforceCardRemoveEvent(ScoreReinforceCardData eventParam, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.events.ScoreReinforceCardRemoveEvent", eventParam, databaseHandle, daoProvider, viewProvider);
	}
	
	public AbstractScoreReinforceCardRemoveEvent(DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.events.ScoreReinforceCardRemoveEvent", null, databaseHandle, daoProvider, viewProvider);
	}
	
	public void initEventData(String json) {
		try {
			this.eventData = mapper.readValue(json, ScoreReinforceCardData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
	
	protected String[] getNotifiedListeners() {
		return new String[] { "com.anfelisa.box.views.ReinforceCardView.remove" };
	}
	
	

}

/*       S.D.G.       */

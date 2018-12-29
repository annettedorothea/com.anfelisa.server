package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.box.data.ScoreReinforceCardData;

public class ScoreReinforceCardRemoveEvent extends Event<ScoreReinforceCardData> {

	public ScoreReinforceCardRemoveEvent(ScoreReinforceCardData eventData, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.events.ScoreReinforceCardRemoveEvent", eventData, databaseHandle, daoProvider, viewProvider);
	}

}

/*       S.D.G.       */

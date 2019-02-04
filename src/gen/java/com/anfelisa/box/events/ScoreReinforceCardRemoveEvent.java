package com.anfelisa.box.events;

import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.box.data.IScoreReinforceCardData;

public class ScoreReinforceCardRemoveEvent extends Event<IScoreReinforceCardData> {

	public ScoreReinforceCardRemoveEvent(IScoreReinforceCardData eventData, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.events.ScoreReinforceCardRemoveEvent", eventData, daoProvider, viewProvider);
	}

}

/*       S.D.G.       */

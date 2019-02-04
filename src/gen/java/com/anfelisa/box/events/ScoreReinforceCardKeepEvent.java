package com.anfelisa.box.events;

import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.box.data.IScoreReinforceCardData;

public class ScoreReinforceCardKeepEvent extends Event<IScoreReinforceCardData> {

	public ScoreReinforceCardKeepEvent(IScoreReinforceCardData eventData, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.events.ScoreReinforceCardKeepEvent", eventData, daoProvider, viewProvider);
	}

}

/*       S.D.G.       */

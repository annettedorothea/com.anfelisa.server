package com.anfelisa.box.events;

import com.anfelisa.ace.Event;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;

import com.anfelisa.box.data.IScoreCardData;

public class ScoreCardScoreEvent extends Event<IScoreCardData> {

	public ScoreCardScoreEvent(IScoreCardData eventData, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.events.ScoreCardScoreEvent", eventData, daoProvider, viewProvider);
	}

}

/*       S.D.G.       */

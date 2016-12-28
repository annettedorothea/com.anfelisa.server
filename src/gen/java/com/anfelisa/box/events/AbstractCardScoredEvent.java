package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.box.data.ScoreCardData;

public abstract class AbstractCardScoredEvent extends Event<ScoreCardData> {

	public AbstractCardScoredEvent(ScoreCardData eventParam, DatabaseHandle databaseHandle) {
		super("CardScoredEvent", eventParam, databaseHandle);
	}

}

/*       S.D.G.       */

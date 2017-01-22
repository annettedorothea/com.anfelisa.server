package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.box.data.ScoredCardData;

public abstract class AbstractScoredCardCreatedEvent extends Event<ScoredCardData> {

	public AbstractScoredCardCreatedEvent(ScoredCardData eventParam, DatabaseHandle databaseHandle) {
		super("ScoredCardCreatedEvent", eventParam, databaseHandle);
	}

}

/*       S.D.G.       */

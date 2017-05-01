package com.anfelisa.result.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.result.data.ResultCreationData;

public abstract class AbstractResultCreatedEvent extends Event<ResultCreationData> {

	public AbstractResultCreatedEvent(ResultCreationData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.result.events.ResultCreatedEvent", eventParam, databaseHandle);
	}

}

/*       S.D.G.       */

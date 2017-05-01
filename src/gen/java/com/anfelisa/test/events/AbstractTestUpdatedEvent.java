package com.anfelisa.test.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.test.data.TestCreationData;

public abstract class AbstractTestUpdatedEvent extends Event<TestCreationData> {

	public AbstractTestUpdatedEvent(TestCreationData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.test.events.TestUpdatedEvent", eventParam, databaseHandle);
	}

}

/*       S.D.G.       */

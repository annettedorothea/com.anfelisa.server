package com.anfelisa.test.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.test.data.TestCreationData;

public abstract class AbstractTestCreatedEvent extends Event<TestCreationData> {

	public AbstractTestCreatedEvent(TestCreationData eventParam, DatabaseHandle databaseHandle) {
		super("TestCreatedEvent", eventParam, databaseHandle);
	}

}

/*       S.D.G.       */

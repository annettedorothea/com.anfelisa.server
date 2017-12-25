package com.anfelisa.test.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.test.data.TestCreationData;

public class TestCreatedEvent extends AbstractTestCreatedEvent {

	static final Logger LOG = LoggerFactory.getLogger(TestCreatedEvent.class);

	public TestCreatedEvent(TestCreationData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public TestCreatedEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */

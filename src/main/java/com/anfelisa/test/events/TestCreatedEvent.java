package com.anfelisa.test.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.test.data.TestCreationData;

public class TestCreatedEvent extends AbstractTestCreatedEvent {

	static final Logger LOG = LoggerFactory.getLogger(TestCreatedEvent.class);

	public TestCreatedEvent(TestCreationData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		// prepare data for view
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */

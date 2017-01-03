package com.anfelisa.test.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.test.data.TestCreationData;

public class TestUpdatedEvent extends AbstractTestUpdatedEvent {

	static final Logger LOG = LoggerFactory.getLogger(TestUpdatedEvent.class);

	public TestUpdatedEvent(TestCreationData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		// prepare data for view
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */

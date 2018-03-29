package com.anfelisa.test.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.test.data.TestCreationData;

public class UpdateTestUpdatedEvent extends AbstractUpdateTestUpdatedEvent {

	static final Logger LOG = LoggerFactory.getLogger(UpdateTestUpdatedEvent.class);

	public UpdateTestUpdatedEvent(TestCreationData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public UpdateTestUpdatedEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */

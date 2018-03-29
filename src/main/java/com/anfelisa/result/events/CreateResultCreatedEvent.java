package com.anfelisa.result.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.result.data.ResultCreationData;

public class CreateResultCreatedEvent extends AbstractCreateResultCreatedEvent {

	static final Logger LOG = LoggerFactory.getLogger(CreateResultCreatedEvent.class);

	public CreateResultCreatedEvent(ResultCreationData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public CreateResultCreatedEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */

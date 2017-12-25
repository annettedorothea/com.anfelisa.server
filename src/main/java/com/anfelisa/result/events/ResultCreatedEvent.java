package com.anfelisa.result.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.result.data.ResultCreationData;

public class ResultCreatedEvent extends AbstractResultCreatedEvent {

	static final Logger LOG = LoggerFactory.getLogger(ResultCreatedEvent.class);

	public ResultCreatedEvent(ResultCreationData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public ResultCreatedEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */

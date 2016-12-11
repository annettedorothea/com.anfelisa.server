package com.anfelisa.result.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.result.data.ResultCreationData;

public class ResultCreatedEvent extends AbstractResultCreatedEvent {

	static final Logger LOG = LoggerFactory.getLogger(ResultCreatedEvent.class);

	public ResultCreatedEvent(ResultCreationData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		// prepare data for view
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */

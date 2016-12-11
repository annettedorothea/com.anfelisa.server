package com.anfelisa.result.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.result.data.ResultSaveData;

public class ResultSavedEvent extends AbstractResultSavedEvent {

	static final Logger LOG = LoggerFactory.getLogger(ResultSavedEvent.class);

	public ResultSavedEvent(ResultSaveData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		// prepare data for view
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */

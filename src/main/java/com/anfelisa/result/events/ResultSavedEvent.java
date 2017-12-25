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

	public ResultSavedEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */

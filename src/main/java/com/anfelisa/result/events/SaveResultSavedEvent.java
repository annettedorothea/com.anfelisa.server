package com.anfelisa.result.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.result.data.ResultSaveData;

public class SaveResultSavedEvent extends AbstractSaveResultSavedEvent {

	static final Logger LOG = LoggerFactory.getLogger(SaveResultSavedEvent.class);

	public SaveResultSavedEvent(ResultSaveData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public SaveResultSavedEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */

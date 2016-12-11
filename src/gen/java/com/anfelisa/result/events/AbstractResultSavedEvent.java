package com.anfelisa.result.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.result.data.ResultSaveData;

public abstract class AbstractResultSavedEvent extends Event<ResultSaveData> {

	public AbstractResultSavedEvent(ResultSaveData eventParam, DatabaseHandle databaseHandle) {
		super("ResultSavedEvent", eventParam, databaseHandle);
	}

}

/*       S.D.G.       */

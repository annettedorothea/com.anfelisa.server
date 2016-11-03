package com.anfelisa.setup.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.setup.data.SetupSchemaData;

public abstract class AbstractSetupSchemaEvent extends Event<SetupSchemaData> {

	public AbstractSetupSchemaEvent(SetupSchemaData eventParam, DatabaseHandle databaseHandle) {
		super("SetupSchemaEvent", eventParam, databaseHandle);
	}

}

/*       S.D.G.       */

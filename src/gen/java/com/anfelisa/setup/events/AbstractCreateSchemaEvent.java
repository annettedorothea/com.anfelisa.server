package com.anfelisa.setup.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.setup.data.SchemaCreationData;

public abstract class AbstractCreateSchemaEvent extends Event<SchemaCreationData> {

	public AbstractCreateSchemaEvent(SchemaCreationData eventParam, DatabaseHandle databaseHandle) {
		super("CreateSchemaEvent", eventParam, databaseHandle);
	}

}

/*       S.D.G.       */

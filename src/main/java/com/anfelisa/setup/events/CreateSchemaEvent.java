package com.anfelisa.setup.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.setup.data.SchemaCreationData;

public class CreateSchemaEvent extends AbstractCreateSchemaEvent {

	static final Logger LOG = LoggerFactory.getLogger(CreateSchemaEvent.class);

	public CreateSchemaEvent(SchemaCreationData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */

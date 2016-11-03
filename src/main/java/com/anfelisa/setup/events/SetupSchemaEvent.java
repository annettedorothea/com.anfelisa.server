package com.anfelisa.setup.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.setup.data.SetupSchemaData;

public class SetupSchemaEvent extends AbstractSetupSchemaEvent {

	static final Logger LOG = LoggerFactory.getLogger(SetupSchemaEvent.class);

	public SetupSchemaEvent(SetupSchemaData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		// prepare data for view
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */

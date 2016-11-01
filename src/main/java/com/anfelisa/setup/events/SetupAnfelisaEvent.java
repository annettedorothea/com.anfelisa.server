package com.anfelisa.setup.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.setup.data.SetupData;

public class SetupAnfelisaEvent extends AbstractSetupAnfelisaEvent {

	static final Logger LOG = LoggerFactory.getLogger(SetupAnfelisaEvent.class);

	public SetupAnfelisaEvent(SetupData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		// prepare data for view
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */

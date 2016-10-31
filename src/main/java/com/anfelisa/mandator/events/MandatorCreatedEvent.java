package com.anfelisa.mandator.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.mandator.data.MandatorCreationData;

public class MandatorCreatedEvent extends AbstractMandatorCreatedEvent {

	static final Logger LOG = LoggerFactory.getLogger(MandatorCreatedEvent.class);

	public MandatorCreatedEvent(MandatorCreationData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		// prepare data for view
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */

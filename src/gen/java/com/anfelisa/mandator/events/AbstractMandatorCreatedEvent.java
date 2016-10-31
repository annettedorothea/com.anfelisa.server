package com.anfelisa.mandator.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.mandator.data.MandatorCreationData;

public abstract class AbstractMandatorCreatedEvent extends Event<MandatorCreationData> {

	public AbstractMandatorCreatedEvent(MandatorCreationData eventParam, DatabaseHandle databaseHandle) {
		super("MandatorCreatedEvent", eventParam, databaseHandle);
	}

}

/*       S.D.G.       */

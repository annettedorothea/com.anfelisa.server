package com.anfelisa.setup.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.setup.data.SetupData;

public abstract class AbstractSetupAnfelisaEvent extends Event<SetupData> {

	public AbstractSetupAnfelisaEvent(SetupData eventParam, DatabaseHandle databaseHandle) {
		super("SetupAnfelisaEvent", eventParam, databaseHandle);
	}

}

/*       S.D.G.       */

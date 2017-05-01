package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.box.data.BoxConfigData;

public abstract class AbstractBoxConfigSavedEvent extends Event<BoxConfigData> {

	public AbstractBoxConfigSavedEvent(BoxConfigData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.BoxConfigSavedEvent", eventParam, databaseHandle);
	}

}

/*       S.D.G.       */

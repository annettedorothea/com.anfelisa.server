package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.box.data.BoxCreationData;

public abstract class AbstractBoxUpdatedEvent extends Event<BoxCreationData> {

	public AbstractBoxUpdatedEvent(BoxCreationData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.BoxUpdatedEvent", eventParam, databaseHandle);
	}

}

/*       S.D.G.       */

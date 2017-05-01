package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.box.data.BoxCreationData;

public abstract class AbstractBoxCreatedEvent extends Event<BoxCreationData> {

	public AbstractBoxCreatedEvent(BoxCreationData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.BoxCreatedEvent", eventParam, databaseHandle);
	}

}

/*       S.D.G.       */

package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.box.data.DeleteBoxData;

public abstract class AbstractBoxDeletedEvent extends Event<DeleteBoxData> {

	public AbstractBoxDeletedEvent(DeleteBoxData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.BoxDeletedEvent", eventParam, databaseHandle);
	}

}

/*       S.D.G.       */

package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.box.data.CardCreationData;

public abstract class AbstractCardImportedEvent extends Event<CardCreationData> {

	public AbstractCardImportedEvent(CardCreationData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.CardImportedEvent", eventParam, databaseHandle);
	}

}

/*       S.D.G.       */

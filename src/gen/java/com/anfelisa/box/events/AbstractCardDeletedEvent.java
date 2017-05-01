package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.box.data.CardIdData;

public abstract class AbstractCardDeletedEvent extends Event<CardIdData> {

	public AbstractCardDeletedEvent(CardIdData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.CardDeletedEvent", eventParam, databaseHandle);
	}

}

/*       S.D.G.       */

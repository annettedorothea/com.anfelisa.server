package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.box.data.CardCreationData;

public abstract class AbstractCardCreatedEvent extends Event<CardCreationData> {

	public AbstractCardCreatedEvent(CardCreationData eventParam, DatabaseHandle databaseHandle) {
		super("CardCreatedEvent", eventParam, databaseHandle);
	}

}

/*       S.D.G.       */

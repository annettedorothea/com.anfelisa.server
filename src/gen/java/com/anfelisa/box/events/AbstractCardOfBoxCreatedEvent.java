package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.box.data.CardOfBoxCreationData;

public abstract class AbstractCardOfBoxCreatedEvent extends Event<CardOfBoxCreationData> {

	public AbstractCardOfBoxCreatedEvent(CardOfBoxCreationData eventParam, DatabaseHandle databaseHandle) {
		super("CardOfBoxCreatedEvent", eventParam, databaseHandle);
	}

}

/*       S.D.G.       */

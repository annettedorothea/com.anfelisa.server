package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.box.data.ScheduledCardData;

public abstract class AbstractCardOfBoxCreatedEvent extends Event<ScheduledCardData> {

	public AbstractCardOfBoxCreatedEvent(ScheduledCardData eventParam, DatabaseHandle databaseHandle) {
		super("CardOfBoxCreatedEvent", eventParam, databaseHandle);
	}

}

/*       S.D.G.       */

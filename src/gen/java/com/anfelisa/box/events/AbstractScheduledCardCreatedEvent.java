package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.box.data.ScheduledCardData;

public abstract class AbstractScheduledCardCreatedEvent extends Event<ScheduledCardData> {

	public AbstractScheduledCardCreatedEvent(ScheduledCardData eventParam, DatabaseHandle databaseHandle) {
		super("ScheduledCardCreatedEvent", eventParam, databaseHandle);
	}

}

/*       S.D.G.       */

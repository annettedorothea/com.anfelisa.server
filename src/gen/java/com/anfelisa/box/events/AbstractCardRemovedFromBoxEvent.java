package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.box.data.ScheduledCardIdData;

public abstract class AbstractCardRemovedFromBoxEvent extends Event<ScheduledCardIdData> {

	public AbstractCardRemovedFromBoxEvent(ScheduledCardIdData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.CardRemovedFromBoxEvent", eventParam, databaseHandle);
	}

}

/*       S.D.G.       */

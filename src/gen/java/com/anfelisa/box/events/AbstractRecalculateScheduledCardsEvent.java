package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.box.data.RecalculateScheduledCardsData;

public abstract class AbstractRecalculateScheduledCardsEvent extends Event<RecalculateScheduledCardsData> {

	public AbstractRecalculateScheduledCardsEvent(RecalculateScheduledCardsData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.RecalculateScheduledCardsEvent", eventParam, databaseHandle);
	}

}

/*       S.D.G.       */

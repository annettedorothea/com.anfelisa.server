package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.box.data.RemoveCardFromBoxData;

public abstract class AbstractCardRemovedFromBoxEvent extends Event<RemoveCardFromBoxData> {

	public AbstractCardRemovedFromBoxEvent(RemoveCardFromBoxData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.CardRemovedFromBoxEvent", eventParam, databaseHandle);
	}

}

/*       S.D.G.       */

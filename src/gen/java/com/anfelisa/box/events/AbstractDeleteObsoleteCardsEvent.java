package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.box.data.ContentHashesOfCreatedCardsData;

public abstract class AbstractDeleteObsoleteCardsEvent extends Event<ContentHashesOfCreatedCardsData> {

	public AbstractDeleteObsoleteCardsEvent(ContentHashesOfCreatedCardsData eventParam, DatabaseHandle databaseHandle) {
		super("DeleteObsoleteCardsEvent", eventParam, databaseHandle);
	}

}

/*       S.D.G.       */

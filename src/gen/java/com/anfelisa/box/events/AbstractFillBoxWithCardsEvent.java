package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.box.data.FillBoxData;

public abstract class AbstractFillBoxWithCardsEvent extends Event<FillBoxData> {

	public AbstractFillBoxWithCardsEvent(FillBoxData eventParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.events.FillBoxWithCardsEvent", eventParam, databaseHandle);
	}

}

/*       S.D.G.       */

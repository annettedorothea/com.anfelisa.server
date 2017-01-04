package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Event;

import com.anfelisa.box.data.BoxIdListData;

public abstract class AbstractFillBoxWithCardsEvent extends Event<BoxIdListData> {

	public AbstractFillBoxWithCardsEvent(BoxIdListData eventParam, DatabaseHandle databaseHandle) {
		super("FillBoxWithCardsEvent", eventParam, databaseHandle);
	}

}

/*       S.D.G.       */

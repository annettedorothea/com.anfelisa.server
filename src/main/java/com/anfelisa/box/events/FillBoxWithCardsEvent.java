package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.data.BoxIdListData;

public class FillBoxWithCardsEvent extends AbstractFillBoxWithCardsEvent {

	static final Logger LOG = LoggerFactory.getLogger(FillBoxWithCardsEvent.class);

	public FillBoxWithCardsEvent(BoxIdListData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		// prepare data for view
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */

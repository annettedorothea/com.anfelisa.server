package com.anfelisa.box.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.box.data.FillBoxData;

public class FillBoxWithCardsEvent extends AbstractFillBoxWithCardsEvent {

	static final Logger LOG = LoggerFactory.getLogger(FillBoxWithCardsEvent.class);

	public FillBoxWithCardsEvent(FillBoxData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		// prepare data for view
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */

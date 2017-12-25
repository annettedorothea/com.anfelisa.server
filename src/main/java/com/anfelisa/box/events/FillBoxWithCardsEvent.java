package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.data.FillBoxData;

public class FillBoxWithCardsEvent extends AbstractFillBoxWithCardsEvent {

	static final Logger LOG = LoggerFactory.getLogger(FillBoxWithCardsEvent.class);

	public FillBoxWithCardsEvent(FillBoxData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public FillBoxWithCardsEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */

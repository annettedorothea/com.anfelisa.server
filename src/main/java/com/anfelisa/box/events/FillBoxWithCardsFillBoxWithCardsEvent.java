package com.anfelisa.box.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.box.data.FillBoxData;

public class FillBoxWithCardsFillBoxWithCardsEvent extends AbstractFillBoxWithCardsFillBoxWithCardsEvent {

	static final Logger LOG = LoggerFactory.getLogger(FillBoxWithCardsFillBoxWithCardsEvent.class);

	public FillBoxWithCardsFillBoxWithCardsEvent(FillBoxData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public FillBoxWithCardsFillBoxWithCardsEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */

package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.data.RecalculateScheduledCardsData;

public class RecalculateScheduledCardsOkEvent extends AbstractRecalculateScheduledCardsOkEvent {

	static final Logger LOG = LoggerFactory.getLogger(RecalculateScheduledCardsOkEvent.class);

	public RecalculateScheduledCardsOkEvent(RecalculateScheduledCardsData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public RecalculateScheduledCardsOkEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */

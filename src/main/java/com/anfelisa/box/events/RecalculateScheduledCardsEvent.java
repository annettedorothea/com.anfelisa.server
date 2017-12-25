package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.data.RecalculateScheduledCardsData;

public class RecalculateScheduledCardsEvent extends AbstractRecalculateScheduledCardsEvent {

	static final Logger LOG = LoggerFactory.getLogger(RecalculateScheduledCardsEvent.class);

	public RecalculateScheduledCardsEvent(RecalculateScheduledCardsData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public RecalculateScheduledCardsEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */

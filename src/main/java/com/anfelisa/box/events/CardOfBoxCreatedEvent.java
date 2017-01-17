package com.anfelisa.box.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.box.data.ScheduledCardData;

public class CardOfBoxCreatedEvent extends AbstractCardOfBoxCreatedEvent {

	static final Logger LOG = LoggerFactory.getLogger(CardOfBoxCreatedEvent.class);

	public CardOfBoxCreatedEvent(ScheduledCardData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		// prepare data for view
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */

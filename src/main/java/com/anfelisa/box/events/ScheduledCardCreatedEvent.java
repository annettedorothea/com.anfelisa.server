package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.data.ScheduledCardData;

public class ScheduledCardCreatedEvent extends AbstractScheduledCardCreatedEvent {

	static final Logger LOG = LoggerFactory.getLogger(ScheduledCardCreatedEvent.class);

	public ScheduledCardCreatedEvent(ScheduledCardData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */

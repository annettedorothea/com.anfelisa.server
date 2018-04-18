package com.anfelisa.box.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.box.data.ScheduledCardData;

public class CreateScheduledCardCreatedEvent extends AbstractCreateScheduledCardCreatedEvent {

	static final Logger LOG = LoggerFactory.getLogger(CreateScheduledCardCreatedEvent.class);

	public CreateScheduledCardCreatedEvent(ScheduledCardData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public CreateScheduledCardCreatedEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */

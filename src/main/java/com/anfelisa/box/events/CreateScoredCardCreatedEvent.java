package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.data.ScoredCardData;

public class CreateScoredCardCreatedEvent extends AbstractCreateScoredCardCreatedEvent {

	static final Logger LOG = LoggerFactory.getLogger(CreateScoredCardCreatedEvent.class);

	public CreateScoredCardCreatedEvent(ScoredCardData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public CreateScoredCardCreatedEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */

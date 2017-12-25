package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.data.ScoredCardData;

public class ScoredCardCreatedEvent extends AbstractScoredCardCreatedEvent {

	static final Logger LOG = LoggerFactory.getLogger(ScoredCardCreatedEvent.class);

	public ScoredCardCreatedEvent(ScoredCardData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public ScoredCardCreatedEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */

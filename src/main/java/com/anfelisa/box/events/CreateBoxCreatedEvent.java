package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.data.BoxCreationData;

public class CreateBoxCreatedEvent extends AbstractCreateBoxCreatedEvent {

	static final Logger LOG = LoggerFactory.getLogger(CreateBoxCreatedEvent.class);

	public CreateBoxCreatedEvent(BoxCreationData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public CreateBoxCreatedEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */
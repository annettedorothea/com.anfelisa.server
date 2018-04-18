package com.anfelisa.box.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.box.data.BoxCreationData;

public class UpdateBoxUpdatedEvent extends AbstractUpdateBoxUpdatedEvent {

	static final Logger LOG = LoggerFactory.getLogger(UpdateBoxUpdatedEvent.class);

	public UpdateBoxUpdatedEvent(BoxCreationData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public UpdateBoxUpdatedEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */

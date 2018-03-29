package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.data.RemoveCardFromBoxData;

public class RemoveCardFromBoxDeletedEvent extends AbstractRemoveCardFromBoxDeletedEvent {

	static final Logger LOG = LoggerFactory.getLogger(RemoveCardFromBoxDeletedEvent.class);

	public RemoveCardFromBoxDeletedEvent(RemoveCardFromBoxData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public RemoveCardFromBoxDeletedEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */

package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.data.DeleteBoxData;

public class DeleteBoxDeletedEvent extends AbstractDeleteBoxDeletedEvent {

	static final Logger LOG = LoggerFactory.getLogger(DeleteBoxDeletedEvent.class);

	public DeleteBoxDeletedEvent(DeleteBoxData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public DeleteBoxDeletedEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */

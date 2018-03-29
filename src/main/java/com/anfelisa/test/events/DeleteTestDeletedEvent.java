package com.anfelisa.test.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.test.data.TestIdData;

public class DeleteTestDeletedEvent extends AbstractDeleteTestDeletedEvent {

	static final Logger LOG = LoggerFactory.getLogger(DeleteTestDeletedEvent.class);

	public DeleteTestDeletedEvent(TestIdData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public DeleteTestDeletedEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */

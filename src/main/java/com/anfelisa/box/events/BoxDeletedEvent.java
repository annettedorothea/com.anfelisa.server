package com.anfelisa.box.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.data.DeleteBoxData;

public class BoxDeletedEvent extends AbstractBoxDeletedEvent {

	static final Logger LOG = LoggerFactory.getLogger(BoxDeletedEvent.class);

	public BoxDeletedEvent(DeleteBoxData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public BoxDeletedEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */

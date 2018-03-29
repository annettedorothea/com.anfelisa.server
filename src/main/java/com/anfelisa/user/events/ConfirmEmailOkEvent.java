package com.anfelisa.user.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.user.data.UsernameData;

public class ConfirmEmailOkEvent extends AbstractConfirmEmailOkEvent {

	static final Logger LOG = LoggerFactory.getLogger(ConfirmEmailOkEvent.class);

	public ConfirmEmailOkEvent(UsernameData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public ConfirmEmailOkEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */

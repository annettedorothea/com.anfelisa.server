package com.anfelisa.user.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.user.data.DeleteUserData;

public class DeleteUserOkEvent extends AbstractDeleteUserOkEvent {

	static final Logger LOG = LoggerFactory.getLogger(DeleteUserOkEvent.class);

	public DeleteUserOkEvent(DeleteUserData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public DeleteUserOkEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */

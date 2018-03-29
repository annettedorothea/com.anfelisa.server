package com.anfelisa.user.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.user.data.UserUpdateData;

public class UpdateUserSuccessEvent extends AbstractUpdateUserSuccessEvent {

	static final Logger LOG = LoggerFactory.getLogger(UpdateUserSuccessEvent.class);

	public UpdateUserSuccessEvent(UserUpdateData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public UpdateUserSuccessEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */

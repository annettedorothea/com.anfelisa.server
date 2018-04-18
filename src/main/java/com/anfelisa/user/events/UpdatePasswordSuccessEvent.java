package com.anfelisa.user.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.user.data.PasswordUpdateData;

public class UpdatePasswordSuccessEvent extends AbstractUpdatePasswordSuccessEvent {

	static final Logger LOG = LoggerFactory.getLogger(UpdatePasswordSuccessEvent.class);

	public UpdatePasswordSuccessEvent(PasswordUpdateData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public UpdatePasswordSuccessEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */

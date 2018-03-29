package com.anfelisa.user.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.user.data.UserCreationData;

public class CreateUserSuccessEvent extends AbstractCreateUserSuccessEvent {

	static final Logger LOG = LoggerFactory.getLogger(CreateUserSuccessEvent.class);

	public CreateUserSuccessEvent(UserCreationData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public CreateUserSuccessEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */

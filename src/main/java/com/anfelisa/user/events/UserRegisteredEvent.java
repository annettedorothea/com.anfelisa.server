package com.anfelisa.user.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.user.data.UserRegistrationData;

public class UserRegisteredEvent extends AbstractUserRegisteredEvent {

	static final Logger LOG = LoggerFactory.getLogger(UserRegisteredEvent.class);

	public UserRegisteredEvent(UserRegistrationData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public UserRegisteredEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */

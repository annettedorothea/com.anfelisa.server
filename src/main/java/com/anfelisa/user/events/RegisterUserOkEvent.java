package com.anfelisa.user.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.user.data.UserRegistrationData;

public class RegisterUserOkEvent extends AbstractRegisterUserOkEvent {

	static final Logger LOG = LoggerFactory.getLogger(RegisterUserOkEvent.class);

	public RegisterUserOkEvent(UserRegistrationData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public RegisterUserOkEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */

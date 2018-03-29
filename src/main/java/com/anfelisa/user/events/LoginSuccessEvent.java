package com.anfelisa.user.events;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.user.data.LoginData;

public class LoginSuccessEvent extends AbstractLoginSuccessEvent {

	static final Logger LOG = LoggerFactory.getLogger(LoginSuccessEvent.class);

	public LoginSuccessEvent(LoginData eventParam, DatabaseHandle databaseHandle) {
		super(eventParam, databaseHandle);
	}

	public LoginSuccessEvent(DatabaseHandle databaseHandle) {
		this(null, databaseHandle);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */

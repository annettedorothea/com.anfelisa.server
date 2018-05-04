package com.anfelisa.user.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.user.data.UserRegistrationData;

public class RegisterUserOkEvent extends AbstractRegisterUserOkEvent {

	static final Logger LOG = LoggerFactory.getLogger(RegisterUserOkEvent.class);

	public RegisterUserOkEvent(UserRegistrationData eventParam, DatabaseHandle databaseHandle, DaoProvider daoProvider, ViewProvider viewProvider) {
		super(eventParam, databaseHandle, daoProvider, viewProvider);
	}

	public RegisterUserOkEvent(DatabaseHandle databaseHandle, DaoProvider daoProvider, ViewProvider viewProvider) {
		this(null, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void prepareDataForView() {
		this.eventData = this.eventParam;
	}

}

/*       S.D.G.       */

package com.anfelisa.user.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.user.data.UserRegistrationData;

public class RegisterUserAction extends AbstractRegisterUserAction {

	static final Logger LOG = LoggerFactory.getLogger(RegisterUserAction.class);

	public RegisterUserAction(UserRegistrationData actionParam, DatabaseHandle databaseHandle) {
		super(actionParam, databaseHandle);
	}

	@Override
	protected void captureActionParam() {
		// capture all stuff that we need to replay this action (e.g. system time)
	}

	@Override
	protected void applyAction() {
		// init actionData
		this.actionData = this.actionParam;
	}

}

/*       S.D.G.       */

package com.anfelisa.user.actions;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.user.data.LoginData;

public class LoginAction extends AbstractLoginAction {

	static final Logger LOG = LoggerFactory.getLogger(LoginAction.class);

	public LoginAction(LoginData actionParam, DatabaseHandle databaseHandle) {
		super(actionParam, databaseHandle);
	}

	@Override
	protected void captureActionParam() {
	}

	@Override
	protected void applyAction() {
		this.actionData = this.actionParam;
		this.actionData.setDate(new DateTime(System.currentTimeMillis()));
	}

}

/* S.D.G. */

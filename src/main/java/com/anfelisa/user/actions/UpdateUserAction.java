package com.anfelisa.user.actions;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.user.data.UserUpdateData;

public class UpdateUserAction extends AbstractUpdateUserAction {

	static final Logger LOG = LoggerFactory.getLogger(UpdateUserAction.class);

	public UpdateUserAction(UserUpdateData actionParam, DatabaseHandle databaseHandle) {
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

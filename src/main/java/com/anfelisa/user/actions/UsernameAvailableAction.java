package com.anfelisa.user.actions;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.user.data.UsernameAvailableData;
import com.anfelisa.user.models.UserDao;

public class UsernameAvailableAction extends AbstractUsernameAvailableAction {

	static final Logger LOG = LoggerFactory.getLogger(UsernameAvailableAction.class);

	public UsernameAvailableAction(UsernameAvailableData actionParam, DatabaseHandle databaseHandle) {
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
		if (UserDao.selectByUsername(this.getDatabaseHandle().getHandle(), this.actionData.getUsername(), this.actionData.getSchema()) == null) {
			this.actionData.setAvailable(true);
		} else {
			this.actionData.setAvailable(false);
		}
	}

}

/*       S.D.G.       */

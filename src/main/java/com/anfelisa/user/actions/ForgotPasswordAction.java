package com.anfelisa.user.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.user.data.ForgotPasswordData;
import com.anfelisa.user.models.IUserModel;
import com.anfelisa.user.models.UserDao;

public class ForgotPasswordAction extends AbstractForgotPasswordAction {

	static final Logger LOG = LoggerFactory.getLogger(ForgotPasswordAction.class);

	public ForgotPasswordAction(ForgotPasswordData actionParam, DatabaseHandle databaseHandle) {
		super(actionParam, databaseHandle);
	}

	@Override
	protected void captureActionParam() {
		// capture all stuff that we need to replay this action (e.g. system time)
	}

	@Override
	protected void applyAction() {
		this.actionData = this.actionParam;
		IUserModel user = UserDao.selectByUsername(this.getDatabaseHandle().getHandle(), this.actionData.getUsername(), this.actionData.getSchema());
		if (user != null) {
			this.actionData.setEmail(user.getEmail());
			this.actionData.setName(user.getName());
			this.actionData.setPrename(user.getPrename());
			this.actionData.setPassword(user.getPassword());
		}
	}

}

/*       S.D.G.       */

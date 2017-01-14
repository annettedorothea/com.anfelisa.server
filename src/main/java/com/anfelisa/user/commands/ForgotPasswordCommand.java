package com.anfelisa.user.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.user.data.ForgotPasswordData;
import com.anfelisa.user.models.IUserModel;
import com.anfelisa.user.models.UserDao;

public class ForgotPasswordCommand extends AbstractForgotPasswordCommand {

	static final Logger LOG = LoggerFactory.getLogger(ForgotPasswordCommand.class);

	public ForgotPasswordCommand(ForgotPasswordData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		IUserModel user = UserDao.selectByUsername(this.getDatabaseHandle().getHandle(), this.commandData.getUsername(),
				this.commandData.getSchema());
		if (user != null) {
			this.commandData.setEmail(user.getEmail());
			this.commandData.setName(user.getName());
			this.commandData.setPrename(user.getPrename());
			this.commandData.setPassword(user.getPassword());
			this.outcome = ok;
		} else {
			this.outcome = userNotFound;
		}
	}

}

/* S.D.G. */

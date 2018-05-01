package com.anfelisa.user.commands;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.user.data.ForgotPasswordData;
import com.anfelisa.user.models.IUserModel;
import com.anfelisa.user.models.UserDao;

public class ForgotPasswordCommand extends AbstractForgotPasswordCommand {

	static final Logger LOG = LoggerFactory.getLogger(ForgotPasswordCommand.class);

	private UserDao userDao = new UserDao();

	public ForgotPasswordCommand(ForgotPasswordData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		IUserModel user = userDao.selectByUsername(this.getDatabaseHandle().getHandle(),
				this.commandData.getUsername());
		if (user != null) {
			this.commandData.setToken(UUID.randomUUID().toString());
			this.commandData.setEmail(user.getEmail());
			this.commandData.setUserId(user.getUserId());
			this.commandData.setOutcome(ok);
		} else {
			this.commandData.setOutcome(doesNotExist);
		}
	}

}

/* S.D.G. */

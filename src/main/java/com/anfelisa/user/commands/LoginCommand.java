package com.anfelisa.user.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.user.data.LoginData;
import com.anfelisa.user.models.UserDao;

public class LoginCommand extends AbstractLoginCommand {

	static final Logger LOG = LoggerFactory.getLogger(LoginCommand.class);

	private UserDao userDao = new UserDao();

	public LoginCommand(LoginData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		if (userDao.selectByUsername(getHandle(), commandData.getUsername()) == null) {
			throwBadRequest(commandData.getUsername() + " does not exist");
		}
		this.commandData.setOutcome(success);
		this.commandData.setLoginLogId(this.commandData.getUuid());
	}

}

/* S.D.G. */

package com.anfelisa.user.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.user.data.UserRegistrationData;
import com.anfelisa.user.models.IUserModel;
import com.anfelisa.user.models.UserDao;

public class RegisterUserCommand extends AbstractRegisterUserCommand {

	static final Logger LOG = LoggerFactory.getLogger(RegisterUserCommand.class);

	private UserDao userDao = new UserDao();

	public RegisterUserCommand(UserRegistrationData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		IUserModel user = userDao.selectByUsername(this.getHandle(), commandData.getUsername());
		if (user != null) {
			throwBadRequest();
		}
		this.commandData.setRole(AuthUser.STUDENT);
		this.commandData.setEmailConfirmed(false);
		this.commandData.setOutcome(ok);
	}

}

/* S.D.G. */

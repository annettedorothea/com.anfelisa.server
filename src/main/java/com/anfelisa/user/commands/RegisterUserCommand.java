package com.anfelisa.user.commands;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.user.data.UserRegistrationData;
import com.anfelisa.user.models.IUserModel;
import com.anfelisa.user.models.UserDao;

public class RegisterUserCommand extends AbstractRegisterUserCommand {

	static final Logger LOG = LoggerFactory.getLogger(RegisterUserCommand.class);

	private UserDao userDao = new UserDao();

	public RegisterUserCommand(UserRegistrationData commandParam, DatabaseHandle databaseHandle, DaoProvider daoProvider, ViewProvider viewProvider) {
		super(commandParam, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void executeCommand() {
		IUserModel user = userDao.selectByUsername(this.getHandle(), commandData.getUsername());
		if (user != null) {
			throwBadRequest();
		}
		if ("Admin".equals(this.commandData.getUsername())) {
			this.commandData.setRole(AuthUser.ADMIN);
		} else {
			this.commandData.setRole(AuthUser.STUDENT);
		}
		this.commandData.setUserId(this.commandData.getUuid());
		this.commandData.setEmailConfirmed(false);
		this.commandData.setToken(UUID.randomUUID().toString());
		this.commandData.setOutcome(ok);
	}

}

/* S.D.G. */

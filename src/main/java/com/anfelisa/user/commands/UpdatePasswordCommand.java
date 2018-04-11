package com.anfelisa.user.commands;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.auth.AuthUser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.user.data.PasswordUpdateData;
import com.anfelisa.user.models.UserDao;

public class UpdatePasswordCommand extends AbstractUpdatePasswordCommand {

	static final Logger LOG = LoggerFactory.getLogger(UpdatePasswordCommand.class);

	private UserDao userDao = new UserDao();

	public UpdatePasswordCommand(PasswordUpdateData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		if (!AuthUser.ADMIN.equals(commandData.getCredentialsRole()) && !commandData.getCredentialsUsername().equals(commandData.getEditedUsername())) {
			throwUnauthorized();
		}
		if (userDao.selectByUsername(getHandle(), commandData.getEditedUsername()) == null) {
			throwBadRequest(commandData.getEditedUsername() + " does not exist");
		}
		this.commandData.setOutcome(success);
	}

}

/*       S.D.G.       */

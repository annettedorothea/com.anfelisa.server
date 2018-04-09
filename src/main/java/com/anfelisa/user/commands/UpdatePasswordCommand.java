package com.anfelisa.user.commands;

import com.anfelisa.ace.DatabaseHandle;

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
		if (userDao.selectByUsername(getHandle(), commandData.getUsername()) == null) {
			throwBadRequest(commandData.getUsername() + " does not exist");
		}
		this.commandData.setOutcome(success);
	}

}

/*       S.D.G.       */

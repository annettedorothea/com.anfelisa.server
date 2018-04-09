package com.anfelisa.user.commands;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.user.data.UsernameData;
import com.anfelisa.user.models.UserDao;

public class DeleteUserCommand extends AbstractDeleteUserCommand {

	static final Logger LOG = LoggerFactory.getLogger(DeleteUserCommand.class);

	private UserDao userDao = new UserDao();
	
	public DeleteUserCommand(UsernameData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	public DeleteUserCommand(DatabaseHandle databaseHandle) {
		super(null, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		if (userDao.selectByUsername(getHandle(), commandData.getUsername()) == null) {
			throwBadRequest(commandData.getUsername() + " does not exist");
		}
		this.commandData.setOutcome(ok);
	}

}

/*       S.D.G.       */

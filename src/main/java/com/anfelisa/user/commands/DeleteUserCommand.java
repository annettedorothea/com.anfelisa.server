package com.anfelisa.user.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.user.data.DeleteUserData;
import com.anfelisa.user.models.UserDao;

public class DeleteUserCommand extends AbstractDeleteUserCommand {

	static final Logger LOG = LoggerFactory.getLogger(DeleteUserCommand.class);

	private UserDao userDao = new UserDao();
	
	public DeleteUserCommand(DeleteUserData commandParam, DatabaseHandle databaseHandle, DaoProvider daoProvider) {
		super(commandParam, databaseHandle, daoProvider);
	}

	@Override
	protected void executeCommand() {
		if (!AuthUser.ADMIN.equals(commandData.getCredentialsRole()) && !commandData.getCredentialsUsername().equals(commandData.getDeletedUsername())) {
			throwUnauthorized();
		}
		if (userDao.selectByUsername(getHandle(), commandData.getDeletedUsername()) == null) {
			throwBadRequest(commandData.getDeletedUsername() + " does not exist");
		}
		this.commandData.setOutcome(ok);
	}

}

/*       S.D.G.       */

package com.anfelisa.user.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.user.data.DeleteUserData;
import com.anfelisa.user.models.IUserModel;

public class DeleteUserCommand extends AbstractDeleteUserCommand {

	static final Logger LOG = LoggerFactory.getLogger(DeleteUserCommand.class);

	public DeleteUserCommand(DeleteUserData commandParam, DatabaseHandle databaseHandle, IDaoProvider daoProvider,
			ViewProvider viewProvider) {
		super(commandParam, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void executeCommand() {
		if (!AuthUser.ADMIN.equals(commandData.getRole())
				&& !commandData.getUsername().equals(commandData.getUsernameToBeDeleted())) {
			throwUnauthorized();
		}
		IUserModel userToBeDeleted = daoProvider.getUserDao().selectByUsername(getHandle(), commandData.getUsernameToBeDeleted());
		if (userToBeDeleted == null) {
			throwBadRequest("userDoesNotExist");
		}
		if (AuthUser.ADMIN.equals(userToBeDeleted.getRole())) {
			if (daoProvider.getCustomUserDao().selectAdminCount(getHandle()) == 1) {
				throwBadRequest("lastAdminMustNotBeDeleted");
			}
		}
		this.commandData.setOutcome(ok);
	}

}

/* S.D.G. */

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
		if (!AuthUser.ADMIN.equals(commandData.getAuthRole())
				&& !commandData.getAuthUsername().equals(commandData.getDeletedUsername())) {
			throwUnauthorized();
		}
		IUserModel userToBeDeleted = daoProvider.getUserDao().selectByUsername(getHandle(), commandData.getDeletedUsername());
		if (userToBeDeleted == null) {
			throwBadRequest(commandData.getDeletedUsername() + " does not exist");
		}
		if (AuthUser.ADMIN.equals(userToBeDeleted.getRole())) {
			if (daoProvider.getCustomUserDao().selectAdminCount(getHandle()) == 1) {
				throwBadRequest("last admin must not be deleted");
			}
		}
		this.commandData.setOutcome(ok);
	}

}

/* S.D.G. */

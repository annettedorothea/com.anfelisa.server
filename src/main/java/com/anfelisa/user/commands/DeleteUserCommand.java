package com.anfelisa.user.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.auth.Roles;
import com.anfelisa.user.data.IDeleteUserData;
import com.anfelisa.user.models.IUserModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class DeleteUserCommand extends AbstractDeleteUserCommand {

	static final Logger LOG = LoggerFactory.getLogger(DeleteUserCommand.class);

	public DeleteUserCommand(IDeleteUserData actionData, IDaoProvider daoProvider,
			ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super(actionData, daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected void executeCommand(PersistenceHandle readonlyHandle) {
		if (!Roles.ADMIN.equals(commandData.getRole())
				&& !commandData.getUsername().equals(commandData.getUsernameToBeDeleted())) {
			throwUnauthorized();
		}
		IUserModel userToBeDeleted = daoProvider.getUserDao().selectByUsername(readonlyHandle,
				commandData.getUsernameToBeDeleted());
		if (userToBeDeleted == null) {
			throwBadRequest("userDoesNotExist");
		}
		if (Roles.ADMIN.equals(userToBeDeleted.getRole())) {
			if (daoProvider.getUserDao().selectAdminCount(readonlyHandle) == 1) {
				throwBadRequest("lastAdminMustNotBeDeleted");
			}
		}
		this.commandData.setOutcome(ok);
	}

}

/* S.D.G. */

package com.anfelisa.user.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.user.data.ChangeUserRoleData;

public class ChangeUserRoleCommand extends AbstractChangeUserRoleCommand {

	static final Logger LOG = LoggerFactory.getLogger(ChangeUserRoleCommand.class);

	public ChangeUserRoleCommand(ChangeUserRoleData commandParam, DatabaseHandle databaseHandle,
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(commandParam, databaseHandle, daoProvider, viewProvider);
	}

	public ChangeUserRoleCommand(DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(null, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void executeCommand() {
		if (!AuthUser.ADMIN.equals(this.commandData.getRole())
				&& !AuthUser.STUDENT.equals(this.commandData.getRole())) {
			throwBadRequest(commandData.getRole() + " is not valid role");
		}
		if (!AuthUser.ADMIN.equals(this.commandData.getAuthRole())) {
			throwUnauthorized();
		}
		if (daoProvider.getUserDao().selectByUserId(getHandle(), commandData.getUserId()) == null) {
			throwBadRequest("User does not exist.");
		}
		this.commandData.setOutcome(ok);
	}

}

/* S.D.G. */

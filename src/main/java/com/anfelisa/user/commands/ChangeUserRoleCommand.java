package com.anfelisa.user.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.auth.Roles;
import com.anfelisa.user.data.IChangeUserRoleData;

public class ChangeUserRoleCommand extends AbstractChangeUserRoleCommand {

	static final Logger LOG = LoggerFactory.getLogger(ChangeUserRoleCommand.class);

	public ChangeUserRoleCommand(IChangeUserRoleData actionData, DatabaseHandle databaseHandle,
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(actionData, databaseHandle, daoProvider, viewProvider);
	}

	public ChangeUserRoleCommand(DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(null, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void executeCommand() {
		if (!Roles.ADMIN.equals(this.commandData.getRole())) {
			throwUnauthorized();
		}
		if (daoProvider.getUserDao().selectByUserId(getHandle(), commandData.getUserId()) == null) {
			throwBadRequest("userDoesNotExist");
		}
		this.commandData.setOutcome(ok);
	}

}

/* S.D.G. */

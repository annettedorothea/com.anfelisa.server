package com.anfelisa.user.commands;

import org.jdbi.v3.core.Handle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.auth.Roles;
import com.anfelisa.user.data.IChangeUserRoleData;

public class ChangeUserRoleCommand extends AbstractChangeUserRoleCommand {

	static final Logger LOG = LoggerFactory.getLogger(ChangeUserRoleCommand.class);

	public ChangeUserRoleCommand(IChangeUserRoleData actionData, 
			IDaoProvider daoProvider, ViewProvider viewProvider,
			CustomAppConfiguration appConfiguration) {
		super(actionData, daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected void executeCommand(Handle readonlyHandle) {
		if (!Roles.ADMIN.equals(this.commandData.getRole())) {
			throwUnauthorized();
		}
		if (daoProvider.getUserDao().selectByUserId(readonlyHandle,  commandData.getUserId()) == null) {
			throwBadRequest("userDoesNotExist");
		}
		this.commandData.setOutcome(ok);
	}

}

/* S.D.G. */

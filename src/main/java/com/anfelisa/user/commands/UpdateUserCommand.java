package com.anfelisa.user.commands;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.user.data.UserUpdateData;

public class UpdateUserCommand extends AbstractUpdateUserCommand {

	static final Logger LOG = LoggerFactory.getLogger(UpdateUserCommand.class);

	public UpdateUserCommand(UserUpdateData commandParam, DatabaseHandle databaseHandle, DaoProvider daoProvider,
			ViewProvider viewProvider) {
		super(commandParam, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void executeCommand() {
		if (commandData.getCredentialsRole().equals(AuthUser.STUDENT)
				&& !commandData.getEditedUsername().equals(commandData.getCredentialsUsername())) {
			throw new WebApplicationException(Response.Status.UNAUTHORIZED);
		}
		if (daoProvider.userDao.selectByUsername(getHandle(), commandData.getEditedUsername()) == null) {
			throwBadRequest(commandData.getEditedUsername() + " does not exist");
		}
		if ("Admin".equals(commandData.getEditedUsername()) && !AuthUser.ADMIN.equals(commandData.getRole())) {
			throwBadRequest("do not remove ADMIN role from default Admin");
		}
		this.commandData.setOutcome(success);
	}

}

/* S.D.G. */

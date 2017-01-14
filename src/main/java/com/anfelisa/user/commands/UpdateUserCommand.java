package com.anfelisa.user.commands;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.auth.AuthUser;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.user.data.UserUpdateData;

public class UpdateUserCommand extends AbstractUpdateUserCommand {

	static final Logger LOG = LoggerFactory.getLogger(UpdateUserCommand.class);

	public UpdateUserCommand(UserUpdateData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		if (commandData.getCredentialsRole().equals(AuthUser.STUDENT)
				&& !commandData.getUsername().equals(commandData.getCredentialsUsername())) {
			throw new WebApplicationException(Response.Status.UNAUTHORIZED);
		}
		this.outcome = success;
	}

}

/* S.D.G. */

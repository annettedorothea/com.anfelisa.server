package com.anfelisa.user.commands;

import java.util.UUID;

import org.jdbi.v3.core.Handle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.auth.Roles;
import com.anfelisa.user.data.IUserRegistrationData;
import com.anfelisa.user.models.IUserModel;

public class RegisterUserCommand extends AbstractRegisterUserCommand {

	static final Logger LOG = LoggerFactory.getLogger(RegisterUserCommand.class);

	public RegisterUserCommand(IUserRegistrationData actionData, 
			IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super(actionData, daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected void executeCommand(Handle readonlyHandle) {
		IUserModel user = daoProvider.getUserDao().selectByUsername(readonlyHandle, commandData.getUsername());
		if (user != null) {
			throwBadRequest("usernameAlreadyTaken");
		}
		if ("Admin".equals(this.commandData.getUsername())) {
			this.commandData.setRole(Roles.ADMIN);
		} else {
			this.commandData.setRole(Roles.STUDENT);
		}
		this.commandData.setUserId(this.commandData.getUuid());
		this.commandData.setEmailConfirmed(false);
		this.commandData.setToken(UUID.randomUUID().toString());
		this.commandData.setOutcome(ok);
	}

}

/* S.D.G. */

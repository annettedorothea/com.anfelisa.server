package com.anfelisa.user.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.auth.Roles;
import com.anfelisa.user.data.IUserRegistrationData;
import com.anfelisa.user.models.IUserModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class RegisterUserCommand extends AbstractRegisterUserCommand {

	static final Logger LOG = LoggerFactory.getLogger(RegisterUserCommand.class);

	public RegisterUserCommand(IUserRegistrationData actionData, 
			IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super(actionData, daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected void executeCommand(PersistenceHandle readonlyHandle) {
		IUserModel user = daoProvider.getUserDao().selectByUsername(readonlyHandle, commandData.getUsername());
		if (user != null) {
			throwIllegalArgumentException("usernameAlreadyTaken");
		}
		if ("Admin".equals(this.commandData.getUsername())) {
			this.commandData.setRole(Roles.ADMIN);
		} else {
			this.commandData.setRole(Roles.STUDENT);
		}
		this.commandData.setUserId(this.commandData.getUuid());
		this.commandData.setEmailConfirmed(false);
		this.addOkOutcome();
	}

}

/* S.D.G. */

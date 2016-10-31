package com.anfelisa.user.actions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.user.data.RegistrationData;

import com.anfelisa.user.commands.RegisterUserCommand;

public abstract class AbstractRegisterUserAction extends Action<RegistrationData> {

	public AbstractRegisterUserAction(RegistrationData actionParam, DatabaseHandle databaseHandle) {
		super("RegisterUserAction", HttpMethod.POST, actionParam, databaseHandle);
	}

	@Override
	public ICommand getCommand() {
		return new RegisterUserCommand(this.actionData, databaseHandle);
	}
}

/*       S.D.G.       */

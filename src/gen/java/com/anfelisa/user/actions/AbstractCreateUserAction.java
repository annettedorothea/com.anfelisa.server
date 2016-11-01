package com.anfelisa.user.actions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.user.data.UserCreationData;

import com.anfelisa.user.commands.CreateUserCommand;

public abstract class AbstractCreateUserAction extends Action<UserCreationData> {

	public AbstractCreateUserAction(UserCreationData actionParam, DatabaseHandle databaseHandle) {
		super("CreateUserAction", HttpMethod.POST, actionParam, databaseHandle);
	}

	@Override
	public ICommand getCommand() {
		return new CreateUserCommand(this.actionData, databaseHandle);
	}
}

/*       S.D.G.       */

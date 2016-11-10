package com.anfelisa.user.actions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.user.data.LoginData;

import com.anfelisa.user.commands.LoginCommand;

public abstract class AbstractLoginAction extends Action<LoginData> {

	public AbstractLoginAction(LoginData actionParam, DatabaseHandle databaseHandle) {
		super("LoginAction", HttpMethod.POST, actionParam, databaseHandle);
	}

	@Override
	public ICommand getCommand() {
		return new LoginCommand(this.actionData, databaseHandle);
	}
}

/*       S.D.G.       */

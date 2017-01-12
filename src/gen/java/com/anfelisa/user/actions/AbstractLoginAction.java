package com.anfelisa.user.actions;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.user.data.LoginData;

import com.anfelisa.user.commands.LoginCommand;

public abstract class AbstractLoginAction extends Action<LoginData> {

	public AbstractLoginAction(DBI jdbi) {
		super("LoginAction", HttpMethod.POST, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return new LoginCommand(this.actionData, databaseHandle);
	}
}

/*       S.D.G.       */

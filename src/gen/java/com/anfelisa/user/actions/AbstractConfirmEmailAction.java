package com.anfelisa.user.actions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.user.data.UsernameData;

import com.anfelisa.user.commands.ConfirmEmailCommand;

public abstract class AbstractConfirmEmailAction extends Action<UsernameData> {

	public AbstractConfirmEmailAction(UsernameData actionParam, DatabaseHandle databaseHandle) {
		super("ConfirmEmailAction", HttpMethod.PUT, actionParam, databaseHandle);
	}

	@Override
	public ICommand getCommand() {
		return new ConfirmEmailCommand(this.actionData, databaseHandle);
	}
}

/*       S.D.G.       */

package com.anfelisa.user.actions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.user.data.PasswordUpdateData;

import com.anfelisa.user.commands.UpdatePasswordCommand;

public abstract class AbstractUpdatePasswordAction extends Action<PasswordUpdateData> {

	public AbstractUpdatePasswordAction(PasswordUpdateData actionParam, DatabaseHandle databaseHandle) {
		super("UpdatePasswordAction", HttpMethod.PUT, actionParam, databaseHandle);
	}

	@Override
	public ICommand getCommand() {
		return new UpdatePasswordCommand(this.actionData, databaseHandle);
	}
}

/*       S.D.G.       */

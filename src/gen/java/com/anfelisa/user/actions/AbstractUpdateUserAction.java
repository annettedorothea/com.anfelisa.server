package com.anfelisa.user.actions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.user.data.UserUpdateData;

import com.anfelisa.user.commands.UpdateUserCommand;

public abstract class AbstractUpdateUserAction extends Action<UserUpdateData> {

	public AbstractUpdateUserAction(UserUpdateData actionParam, DatabaseHandle databaseHandle) {
		super("UpdateUserAction", HttpMethod.PUT, actionParam, databaseHandle);
	}

	@Override
	public ICommand getCommand() {
		return new UpdateUserCommand(this.actionData, databaseHandle);
	}
}

/*       S.D.G.       */

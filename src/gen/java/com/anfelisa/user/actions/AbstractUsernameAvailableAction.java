package com.anfelisa.user.actions;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.user.data.UsernameAvailableData;


public abstract class AbstractUsernameAvailableAction extends Action<UsernameAvailableData> {

	public AbstractUsernameAvailableAction(UsernameAvailableData actionParam, DatabaseHandle databaseHandle) {
		super("UsernameAvailableAction", HttpMethod.GET, actionParam, databaseHandle);
	}

	@Override
	public ICommand getCommand() {
		return null;
	}
}

/*       S.D.G.       */

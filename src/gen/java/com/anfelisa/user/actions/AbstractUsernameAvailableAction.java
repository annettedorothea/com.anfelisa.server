package com.anfelisa.user.actions;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.user.data.UsernameAvailableData;


public abstract class AbstractUsernameAvailableAction extends Action<UsernameAvailableData> {

	public AbstractUsernameAvailableAction(DBI jdbi) {
		super("UsernameAvailableAction", HttpMethod.GET, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return null;
	}
}

/*       S.D.G.       */

package com.anfelisa.user.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.DaoProvider;

import com.anfelisa.user.data.UserUpdateData;

public abstract class AbstractUpdateUserCommand extends Command<UserUpdateData> {

	protected static final String success = "success";

	public AbstractUpdateUserCommand(UserUpdateData commandParam, DatabaseHandle databaseHandle, DaoProvider daoProvider) {
		super("com.anfelisa.user.commands.UpdateUserCommand", commandParam, databaseHandle, daoProvider);
	}

	public AbstractUpdateUserCommand(DatabaseHandle databaseHandle, DaoProvider daoProvider) {
		super("com.anfelisa.user.commands.UpdateUserCommand", null, databaseHandle, daoProvider);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case success:
			new com.anfelisa.user.events.UpdateUserSuccessEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
	public void initCommandData(String json) {
		try {
			this.commandData = mapper.readValue(json, UserUpdateData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */

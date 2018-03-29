package com.anfelisa.result.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.result.data.MyResultData;

public abstract class AbstractLoadResultCommand extends Command<MyResultData> {


	public AbstractLoadResultCommand(MyResultData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.result.commands.LoadResultCommand", commandParam, databaseHandle);
	}

	public AbstractLoadResultCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.result.commands.LoadResultCommand", null, databaseHandle);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
	public void initCommandData(String json) {
		try {
			this.commandData = mapper.readValue(json, MyResultData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */

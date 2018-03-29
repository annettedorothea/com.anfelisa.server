package com.anfelisa.test.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.test.data.MyTestData;

public abstract class AbstractLoadPrivateTestCommand extends Command<MyTestData> {


	public AbstractLoadPrivateTestCommand(MyTestData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.test.commands.LoadPrivateTestCommand", commandParam, databaseHandle);
	}

	public AbstractLoadPrivateTestCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.test.commands.LoadPrivateTestCommand", null, databaseHandle);
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
			this.commandData = mapper.readValue(json, MyTestData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */

package com.anfelisa.test.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.test.data.TestCreationData;

public abstract class AbstractGetTestCommand extends Command<TestCreationData> {


	public AbstractGetTestCommand(TestCreationData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.test.commands.GetTestCommand", commandParam, databaseHandle);
	}

	public AbstractGetTestCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.test.commands.GetTestCommand", null, databaseHandle);
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
			this.commandData = mapper.readValue(json, TestCreationData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */

package com.anfelisa.test.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.test.data.TestData;

public abstract class AbstractLoadPublicTestCommand extends Command<TestData> {


	public AbstractLoadPublicTestCommand(TestData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.test.commands.LoadPublicTestCommand", commandParam, databaseHandle);
	}

	public AbstractLoadPublicTestCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.test.commands.LoadPublicTestCommand", null, databaseHandle);
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
			this.commandData = mapper.readValue(json, TestData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */

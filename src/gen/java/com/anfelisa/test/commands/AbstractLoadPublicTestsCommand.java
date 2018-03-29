package com.anfelisa.test.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.test.data.TestListData;

public abstract class AbstractLoadPublicTestsCommand extends Command<TestListData> {


	public AbstractLoadPublicTestsCommand(TestListData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.test.commands.LoadPublicTestsCommand", commandParam, databaseHandle);
	}

	public AbstractLoadPublicTestsCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.test.commands.LoadPublicTestsCommand", null, databaseHandle);
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
			this.commandData = mapper.readValue(json, TestListData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */

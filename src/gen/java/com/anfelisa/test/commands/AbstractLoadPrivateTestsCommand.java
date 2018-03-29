package com.anfelisa.test.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.test.data.MyTestListData;

public abstract class AbstractLoadPrivateTestsCommand extends Command<MyTestListData> {


	public AbstractLoadPrivateTestsCommand(MyTestListData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.test.commands.LoadPrivateTestsCommand", commandParam, databaseHandle);
	}

	public AbstractLoadPrivateTestsCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.test.commands.LoadPrivateTestsCommand", null, databaseHandle);
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
			this.commandData = mapper.readValue(json, MyTestListData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */

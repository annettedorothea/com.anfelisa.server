package com.anfelisa.test.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.test.data.SimpleTestListData;

public abstract class AbstractGetAllTestsCommand extends Command<SimpleTestListData> {


	public AbstractGetAllTestsCommand(SimpleTestListData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.test.commands.GetAllTestsCommand", commandParam, databaseHandle);
	}

	public AbstractGetAllTestsCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.test.commands.GetAllTestsCommand", null, databaseHandle);
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
			this.commandData = mapper.readValue(json, SimpleTestListData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */

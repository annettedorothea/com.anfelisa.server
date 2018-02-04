package com.anfelisa.result.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.result.data.ResultSaveData;

public abstract class AbstractSaveResultCommand extends Command<ResultSaveData> {

	protected static final String saved = "saved";

	public AbstractSaveResultCommand(ResultSaveData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.result.commands.SaveResultCommand", commandParam, databaseHandle);
	}

	public AbstractSaveResultCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.result.commands.SaveResultCommand", null, databaseHandle);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case saved:
			new com.anfelisa.result.events.ResultSavedEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
	public void initCommandData(String json) {
		try {
			this.commandData = mapper.readValue(json, ResultSaveData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */

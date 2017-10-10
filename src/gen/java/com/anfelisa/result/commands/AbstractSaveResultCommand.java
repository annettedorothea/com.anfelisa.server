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

	@Override
	protected void publishEvents() {
		switch (this.outcome) {
		case saved:
			new com.anfelisa.result.events.ResultSavedEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + outcome);
		}
	}

}

/*       S.D.G.       */

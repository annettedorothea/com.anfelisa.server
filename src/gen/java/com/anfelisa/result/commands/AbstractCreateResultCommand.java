package com.anfelisa.result.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.result.data.ResultCreationData;

public abstract class AbstractCreateResultCommand extends Command<ResultCreationData> {

	protected static final String created = "created";

	public AbstractCreateResultCommand(ResultCreationData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.result.commands.CreateResultCommand", commandParam, databaseHandle);
	}

	public AbstractCreateResultCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.result.commands.CreateResultCommand", null, databaseHandle);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case created:
			new com.anfelisa.result.events.CreateResultCreatedEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
	public void initCommandData(String json) {
		try {
			this.commandData = mapper.readValue(json, ResultCreationData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */

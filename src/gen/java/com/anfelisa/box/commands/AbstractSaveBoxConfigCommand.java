package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.box.data.BoxConfigData;

public abstract class AbstractSaveBoxConfigCommand extends Command<BoxConfigData> {

	protected static final String saved = "saved";

	public AbstractSaveBoxConfigCommand(BoxConfigData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.commands.SaveBoxConfigCommand", commandParam, databaseHandle);
	}

	public AbstractSaveBoxConfigCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.commands.SaveBoxConfigCommand", null, databaseHandle);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case saved:
			new com.anfelisa.box.events.BoxConfigSavedEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
	public void initCommandData(String json) {
		try {
			this.commandData = mapper.readValue(json, BoxConfigData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */

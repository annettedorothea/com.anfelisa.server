package com.anfelisa.box.commands;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.data.BoxConfigData;

public class SaveBoxConfigCommand extends AbstractSaveBoxConfigCommand {

	static final Logger LOG = LoggerFactory.getLogger(SaveBoxConfigCommand.class);

	public SaveBoxConfigCommand(BoxConfigData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		this.outcome = saved;
	}

}

/*       S.D.G.       */

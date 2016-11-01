package com.anfelisa.setup.commands;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.setup.data.SetupData;

public class SetupAnfelisaCommand extends AbstractSetupAnfelisaCommand {

	static final Logger LOG = LoggerFactory.getLogger(SetupAnfelisaCommand.class);

	public SetupAnfelisaCommand(SetupData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		this.commandData = this.commandParam;
		this.outcome = setup;
	}

}

/*       S.D.G.       */

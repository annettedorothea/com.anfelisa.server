package com.anfelisa.setup.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.setup.data.SetupSchemaData;

public class SetupSchemaCommand extends AbstractSetupSchemaCommand {

	static final Logger LOG = LoggerFactory.getLogger(SetupSchemaCommand.class);

	public SetupSchemaCommand(SetupSchemaData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		this.commandData = this.commandParam;
		this.outcome = setup;
	}

}

/*       S.D.G.       */

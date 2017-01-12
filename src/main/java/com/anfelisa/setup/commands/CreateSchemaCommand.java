package com.anfelisa.setup.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.setup.data.SchemaCreationData;

public class CreateSchemaCommand extends AbstractCreateSchemaCommand {

	static final Logger LOG = LoggerFactory.getLogger(CreateSchemaCommand.class);

	public CreateSchemaCommand(SchemaCreationData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		this.outcome = setup;
	}

}

/*       S.D.G.       */

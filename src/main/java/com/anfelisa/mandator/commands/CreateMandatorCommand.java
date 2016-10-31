package com.anfelisa.mandator.commands;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.mandator.data.MandatorCreationData;

public class CreateMandatorCommand extends AbstractCreateMandatorCommand {

	static final Logger LOG = LoggerFactory.getLogger(CreateMandatorCommand.class);

	public CreateMandatorCommand(MandatorCreationData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		// execute command and set outcome
	}

}

/*       S.D.G.       */

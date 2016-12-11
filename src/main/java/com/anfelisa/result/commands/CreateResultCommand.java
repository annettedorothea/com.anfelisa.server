package com.anfelisa.result.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.result.data.ResultCreationData;

public class CreateResultCommand extends AbstractCreateResultCommand {

	static final Logger LOG = LoggerFactory.getLogger(CreateResultCommand.class);

	public CreateResultCommand(ResultCreationData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		// execute command and set outcome
		this.commandData = this.commandParam;
		this.outcome = created;
	}

}

/*       S.D.G.       */

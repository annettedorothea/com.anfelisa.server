package com.anfelisa.result.commands;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.result.data.ResultSaveData;

public class SaveResultCommand extends AbstractSaveResultCommand {

	static final Logger LOG = LoggerFactory.getLogger(SaveResultCommand.class);

	public SaveResultCommand(ResultSaveData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		// execute command and set outcome
		this.commandData = this.commandParam;
		this.outcome = saved;
	}

}

/*       S.D.G.       */

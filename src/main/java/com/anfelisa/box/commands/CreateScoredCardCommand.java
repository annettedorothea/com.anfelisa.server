package com.anfelisa.box.commands;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.data.ScoredCardData;

public class CreateScoredCardCommand extends AbstractCreateScoredCardCommand {

	static final Logger LOG = LoggerFactory.getLogger(CreateScoredCardCommand.class);

	public CreateScoredCardCommand(ScoredCardData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		this.commandData.setScoredCardId(this.commandData.getUuid());
		this.commandData.setOutcome(created);
	}

}

/*       S.D.G.       */

package com.anfelisa.box.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.box.data.ScoredCardData;

public class CreateScoredCardCommand extends AbstractCreateScoredCardCommand {

	static final Logger LOG = LoggerFactory.getLogger(CreateScoredCardCommand.class);

	public CreateScoredCardCommand(ScoredCardData commandParam, DatabaseHandle databaseHandle, DaoProvider daoProvider) {
		super(commandParam, databaseHandle, daoProvider);
	}

	@Override
	protected void executeCommand() {
		this.commandData.setScoredCardId(this.commandData.getUuid());
		this.commandData.setOutcome(created);
	}

}

/*       S.D.G.       */

package com.anfelisa.box.commands;

import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.data.CardCreationData;

public class CreateCardCommand extends AbstractCreateCardCommand {

	static final Logger LOG = LoggerFactory.getLogger(CreateCardCommand.class);

	public CreateCardCommand(CardCreationData commandParam, DatabaseHandle databaseHandle, DaoProvider daoProvider) {
		super(commandParam, databaseHandle, daoProvider);
	}

	@Override
	protected void executeCommand() {
	}

}

/*       S.D.G.       */

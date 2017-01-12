package com.anfelisa.box.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.box.data.CardOfBoxCreationData;

public class CreateCardOfBoxCommand extends AbstractCreateCardOfBoxCommand {

	static final Logger LOG = LoggerFactory.getLogger(CreateCardOfBoxCommand.class);

	public CreateCardOfBoxCommand(CardOfBoxCreationData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		this.outcome = created;
	}

}

/*       S.D.G.       */

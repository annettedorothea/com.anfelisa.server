package com.anfelisa.test.commands;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.test.data.CardContentHashListData;

public class GetCardsOfTestCommand extends AbstractGetCardsOfTestCommand {

	static final Logger LOG = LoggerFactory.getLogger(GetCardsOfTestCommand.class);

	public GetCardsOfTestCommand(CardContentHashListData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	public GetCardsOfTestCommand(DatabaseHandle databaseHandle) {
		super(null, databaseHandle);
	}

	@Override
	protected void executeCommand() {
	}

}

/*       S.D.G.       */

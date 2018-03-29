package com.anfelisa.box.commands;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.data.CardData;

public class LoadNextCardCommand extends AbstractLoadNextCardCommand {

	static final Logger LOG = LoggerFactory.getLogger(LoadNextCardCommand.class);

	public LoadNextCardCommand(CardData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	public LoadNextCardCommand(DatabaseHandle databaseHandle) {
		super(null, databaseHandle);
	}

	@Override
	protected void executeCommand() {
	}

}

/*       S.D.G.       */

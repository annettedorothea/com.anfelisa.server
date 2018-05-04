package com.anfelisa.box.commands;

import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.data.CardIdData;

public class DeleteCardCommand extends AbstractDeleteCardCommand {

	static final Logger LOG = LoggerFactory.getLogger(DeleteCardCommand.class);

	public DeleteCardCommand(CardIdData commandParam, DatabaseHandle databaseHandle, DaoProvider daoProvider) {
		super(commandParam, databaseHandle, daoProvider);
	}

	@Override
	protected void executeCommand() {
	}

}

/*       S.D.G.       */

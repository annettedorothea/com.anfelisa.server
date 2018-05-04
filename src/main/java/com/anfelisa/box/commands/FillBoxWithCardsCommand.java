package com.anfelisa.box.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.box.data.FillBoxData;

public class FillBoxWithCardsCommand extends AbstractFillBoxWithCardsCommand {

	static final Logger LOG = LoggerFactory.getLogger(FillBoxWithCardsCommand.class);

	public FillBoxWithCardsCommand(FillBoxData commandParam, DatabaseHandle databaseHandle, DaoProvider daoProvider) {
		super(commandParam, databaseHandle, daoProvider);
	}

	@Override
	protected void executeCommand() {
		this.commandData.setOutcome(fillBoxWithCards);
	}

}

/*       S.D.G.       */

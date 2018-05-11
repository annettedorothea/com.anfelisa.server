package com.anfelisa.box.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.data.FillBoxData;

public class FillBoxWithCardsCommand extends AbstractFillBoxWithCardsCommand {

	static final Logger LOG = LoggerFactory.getLogger(FillBoxWithCardsCommand.class);

	public FillBoxWithCardsCommand(FillBoxData commandParam, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(commandParam, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void executeCommand() {
		this.commandData.setOutcome(fillBoxWithCards);
	}

}

/*       S.D.G.       */

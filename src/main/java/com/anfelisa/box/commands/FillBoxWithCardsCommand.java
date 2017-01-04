package com.anfelisa.box.commands;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.data.BoxIdListData;

public class FillBoxWithCardsCommand extends AbstractFillBoxWithCardsCommand {

	static final Logger LOG = LoggerFactory.getLogger(FillBoxWithCardsCommand.class);

	public FillBoxWithCardsCommand(BoxIdListData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		// execute command and set outcome
		this.commandData = this.commandParam;
		this.outcome = fillBoxWithCards;
	}

}

/*       S.D.G.       */

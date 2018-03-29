package com.anfelisa.box.commands;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.data.ReinforceCardListData;

public class LoadReinforceCardListCommand extends AbstractLoadReinforceCardListCommand {

	static final Logger LOG = LoggerFactory.getLogger(LoadReinforceCardListCommand.class);

	public LoadReinforceCardListCommand(ReinforceCardListData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	public LoadReinforceCardListCommand(DatabaseHandle databaseHandle) {
		super(null, databaseHandle);
	}

	@Override
	protected void executeCommand() {
	}

}

/*       S.D.G.       */

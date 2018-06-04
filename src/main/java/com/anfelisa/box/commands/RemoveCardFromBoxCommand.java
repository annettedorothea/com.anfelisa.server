package com.anfelisa.box.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.data.RemoveCardFromBoxData;

public class RemoveCardFromBoxCommand extends AbstractRemoveCardFromBoxCommand {

	static final Logger LOG = LoggerFactory.getLogger(RemoveCardFromBoxCommand.class);

	public RemoveCardFromBoxCommand(RemoveCardFromBoxData commandData, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(commandData, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void executeCommand() {
		this.commandData.setOutcome(deleted);
	}

}

/*       S.D.G.       */

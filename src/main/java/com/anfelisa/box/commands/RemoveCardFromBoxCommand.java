package com.anfelisa.box.commands;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.data.ScheduledCardIdData;

public class RemoveCardFromBoxCommand extends AbstractRemoveCardFromBoxCommand {

	static final Logger LOG = LoggerFactory.getLogger(RemoveCardFromBoxCommand.class);

	public RemoveCardFromBoxCommand(ScheduledCardIdData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		this.outcome = deleted;
	}

}

/*       S.D.G.       */

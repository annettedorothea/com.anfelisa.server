package com.anfelisa.box.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.box.data.ScheduledCardData;

public class CreateScheduledCardCommand extends AbstractCreateScheduledCardCommand {

	static final Logger LOG = LoggerFactory.getLogger(CreateScheduledCardCommand.class);

	public CreateScheduledCardCommand(ScheduledCardData commandParam, DatabaseHandle databaseHandle, DaoProvider daoProvider) {
		super(commandParam, databaseHandle, daoProvider);
	}

	@Override
	protected void executeCommand() {
		this.commandData.setScheduledCardId(this.commandData.getUuid());
		this.commandData.setOutcome(created);
	}

}

/*       S.D.G.       */

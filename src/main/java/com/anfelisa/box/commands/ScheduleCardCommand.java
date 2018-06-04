package com.anfelisa.box.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.data.ScheduleCardData;

public class ScheduleCardCommand extends AbstractScheduleCardCommand {

	static final Logger LOG = LoggerFactory.getLogger(ScheduleCardCommand.class);

	public ScheduleCardCommand(ScheduleCardData commandData, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(commandData, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void executeCommand() {
	}

}

/*       S.D.G.       */

package com.anfelisa.course.commands;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.course.data.StatisticsData;

public class LoadStatisticsCommand extends AbstractLoadStatisticsCommand {

	static final Logger LOG = LoggerFactory.getLogger(LoadStatisticsCommand.class);

	public LoadStatisticsCommand(StatisticsData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	public LoadStatisticsCommand(DatabaseHandle databaseHandle) {
		super(null, databaseHandle);
	}

	@Override
	protected void executeCommand() {
	}

}

/*       S.D.G.       */

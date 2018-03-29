package com.anfelisa.course.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.course.data.StatisticsData;

public abstract class AbstractLoadStatisticsCommand extends Command<StatisticsData> {


	public AbstractLoadStatisticsCommand(StatisticsData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.course.commands.LoadStatisticsCommand", commandParam, databaseHandle);
	}

	public AbstractLoadStatisticsCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.course.commands.LoadStatisticsCommand", null, databaseHandle);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
	public void initCommandData(String json) {
		try {
			this.commandData = mapper.readValue(json, StatisticsData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */

package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.box.data.BoxOfCourseListData;

public abstract class AbstractLoadBoxOfCourseListCommand extends Command<BoxOfCourseListData> {


	public AbstractLoadBoxOfCourseListCommand(BoxOfCourseListData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.commands.LoadBoxOfCourseListCommand", commandParam, databaseHandle);
	}

	public AbstractLoadBoxOfCourseListCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.commands.LoadBoxOfCourseListCommand", null, databaseHandle);
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
			this.commandData = mapper.readValue(json, BoxOfCourseListData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */

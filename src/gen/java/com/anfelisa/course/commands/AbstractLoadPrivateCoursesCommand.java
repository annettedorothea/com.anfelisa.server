package com.anfelisa.course.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.course.data.MyCourseListData;

public abstract class AbstractLoadPrivateCoursesCommand extends Command<MyCourseListData> {


	public AbstractLoadPrivateCoursesCommand(MyCourseListData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.course.commands.LoadPrivateCoursesCommand", commandParam, databaseHandle);
	}

	public AbstractLoadPrivateCoursesCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.course.commands.LoadPrivateCoursesCommand", null, databaseHandle);
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
			this.commandData = mapper.readValue(json, MyCourseListData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */

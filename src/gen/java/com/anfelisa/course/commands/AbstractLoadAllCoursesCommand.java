package com.anfelisa.course.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.course.data.CourseListData;

public abstract class AbstractLoadAllCoursesCommand extends Command<CourseListData> {


	public AbstractLoadAllCoursesCommand(CourseListData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.course.commands.LoadAllCoursesCommand", commandParam, databaseHandle);
	}

	public AbstractLoadAllCoursesCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.course.commands.LoadAllCoursesCommand", null, databaseHandle);
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
			this.commandData = mapper.readValue(json, CourseListData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */

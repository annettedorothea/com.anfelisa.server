package com.anfelisa.course.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.course.data.CourseData;

public abstract class AbstractGetCourseCommand extends Command<CourseData> {


	public AbstractGetCourseCommand(CourseData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.course.commands.GetCourseCommand", commandParam, databaseHandle);
	}

	public AbstractGetCourseCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.course.commands.GetCourseCommand", null, databaseHandle);
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
			this.commandData = mapper.readValue(json, CourseData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */

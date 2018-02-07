package com.anfelisa.course.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.course.data.CourseIdData;

public abstract class AbstractDeleteCourseCommand extends Command<CourseIdData> {

	protected static final String deleted = "deleted";

	public AbstractDeleteCourseCommand(CourseIdData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.course.commands.DeleteCourseCommand", commandParam, databaseHandle);
	}

	public AbstractDeleteCourseCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.course.commands.DeleteCourseCommand", null, databaseHandle);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case deleted:
			new com.anfelisa.course.events.CourseDeletedEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
	public void initCommandData(String json) {
		try {
			this.commandData = mapper.readValue(json, CourseIdData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */

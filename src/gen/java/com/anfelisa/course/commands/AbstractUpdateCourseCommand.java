package com.anfelisa.course.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.course.data.CourseData;

public abstract class AbstractUpdateCourseCommand extends Command<CourseData> {

	protected static final String updated = "updated";

	public AbstractUpdateCourseCommand(CourseData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.course.commands.UpdateCourseCommand", commandParam, databaseHandle);
	}

	@Override
	protected void publishEvents() {
		switch (this.outcome) {
		case updated:
			new com.anfelisa.course.events.CourseUpdatedEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + outcome);
		}
	}

}

/*       S.D.G.       */

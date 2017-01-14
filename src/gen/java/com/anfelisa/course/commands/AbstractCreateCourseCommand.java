package com.anfelisa.course.commands;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.course.data.CourseCreationData;

public abstract class AbstractCreateCourseCommand extends Command<CourseCreationData> {

	protected static final String created = "created";

	public AbstractCreateCourseCommand(CourseCreationData commandParam, DatabaseHandle databaseHandle) {
		super("CreateCourseCommand", commandParam, databaseHandle);
	}

	@Override
	protected void publishEvents() {
		switch (this.outcome) {
		case created:
			new com.anfelisa.course.events.CourseCreatedEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + outcome);
		}
	}
	
	protected void throwUnauthorized() {
		throw new WebApplicationException(Response.Status.UNAUTHORIZED);
	}
}

/*       S.D.G.       */

package com.anfelisa.user.commands;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.user.data.RemoveCourseData;

public abstract class AbstractRemoveCourseCommand extends Command<RemoveCourseData> {

	protected static final String success = "success";

	public AbstractRemoveCourseCommand(RemoveCourseData commandParam, DatabaseHandle databaseHandle) {
		super("RemoveCourseCommand", commandParam, databaseHandle);
	}

	@Override
	protected void publishEvents() {
		switch (this.outcome) {
		case success:
			new com.anfelisa.user.events.CourseRemovedEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + outcome);
		}
	}
	
	protected void throwUnauthorized() {
		throw new WebApplicationException(Response.Status.UNAUTHORIZED);
	}

	protected void throwBadRequest() {
		throw new WebApplicationException(Response.Status.BAD_REQUEST);
	}

}

/*       S.D.G.       */

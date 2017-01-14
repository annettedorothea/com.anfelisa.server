package com.anfelisa.user.commands;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.user.data.AddCoursesData;

public abstract class AbstractAddCoursesCommand extends Command<AddCoursesData> {

	protected static final String success = "success";

	public AbstractAddCoursesCommand(AddCoursesData commandParam, DatabaseHandle databaseHandle) {
		super("AddCoursesCommand", commandParam, databaseHandle);
	}

	@Override
	protected void publishEvents() {
		switch (this.outcome) {
		case success:
			new com.anfelisa.user.events.CoursesAddedEvent(this.commandData, databaseHandle).publish();
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

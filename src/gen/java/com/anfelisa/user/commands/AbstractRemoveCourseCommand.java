package com.anfelisa.user.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.user.data.RemoveCourseData;

public abstract class AbstractRemoveCourseCommand extends Command<RemoveCourseData> {

	protected static final String success = "success";

	public AbstractRemoveCourseCommand(RemoveCourseData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.commands.RemoveCourseCommand", commandParam, databaseHandle);
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

}

/*       S.D.G.       */

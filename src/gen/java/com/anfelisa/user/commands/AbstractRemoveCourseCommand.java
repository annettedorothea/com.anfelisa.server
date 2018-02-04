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

	public AbstractRemoveCourseCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.user.commands.RemoveCourseCommand", null, databaseHandle);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case success:
			new com.anfelisa.user.events.CourseRemovedEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
	public void initCommandData(String json) {
		try {
			this.commandData = mapper.readValue(json, RemoveCourseData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */

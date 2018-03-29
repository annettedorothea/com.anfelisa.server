package com.anfelisa.course.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.course.data.CourseCreationData;

public abstract class AbstractCreateCourseCommand extends Command<CourseCreationData> {

	protected static final String created = "created";

	public AbstractCreateCourseCommand(CourseCreationData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.course.commands.CreateCourseCommand", commandParam, databaseHandle);
	}

	public AbstractCreateCourseCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.course.commands.CreateCourseCommand", null, databaseHandle);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case created:
			new com.anfelisa.course.events.CreateCourseCreatedEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
	public void initCommandData(String json) {
		try {
			this.commandData = mapper.readValue(json, CourseCreationData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */

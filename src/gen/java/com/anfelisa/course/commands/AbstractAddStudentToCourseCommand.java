package com.anfelisa.course.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.course.data.StudentToCourseAdditionData;

public abstract class AbstractAddStudentToCourseCommand extends Command<StudentToCourseAdditionData> {

	protected static final String added = "added";

	public AbstractAddStudentToCourseCommand(StudentToCourseAdditionData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.course.commands.AddStudentToCourseCommand", commandParam, databaseHandle);
	}

	public AbstractAddStudentToCourseCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.course.commands.AddStudentToCourseCommand", null, databaseHandle);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case added:
			new com.anfelisa.course.events.AddStudentToCourseAddedEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
	public void initCommandData(String json) {
		try {
			this.commandData = mapper.readValue(json, StudentToCourseAdditionData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */

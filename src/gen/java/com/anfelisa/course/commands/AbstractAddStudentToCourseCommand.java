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

	@Override
	protected void publishEvents() {
		switch (this.outcome) {
		case added:
			new com.anfelisa.course.events.StudentAddedToCourseEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + outcome);
		}
	}

}

/*       S.D.G.       */

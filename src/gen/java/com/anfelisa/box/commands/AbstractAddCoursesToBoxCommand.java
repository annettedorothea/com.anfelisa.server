package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.box.data.BoxOfCourseListData;

public abstract class AbstractAddCoursesToBoxCommand extends Command<BoxOfCourseListData> {

	protected static final String created = "created";

	public AbstractAddCoursesToBoxCommand(BoxOfCourseListData commandParam, DatabaseHandle databaseHandle) {
		super("AddCoursesToBoxCommand", commandParam, databaseHandle);
	}

	@Override
	protected void publishEvents() {
		switch (this.outcome) {
		case created:
			new com.anfelisa.box.events.CoursesAddedToBoxEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + outcome);
		}
	}
}

/*       S.D.G.       */

package com.anfelisa.box.commands;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.box.data.BoxToCourseAdditionData;

public abstract class AbstractAddCourseToBoxCommand extends Command<BoxToCourseAdditionData> {

	protected static final String added = "added";

	public AbstractAddCourseToBoxCommand(BoxToCourseAdditionData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.box.commands.AddCourseToBoxCommand", commandParam, databaseHandle);
	}

	@Override
	protected void publishEvents() {
		switch (this.outcome) {
		case added:
			new com.anfelisa.box.events.CourseAddedToBoxEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + outcome);
		}
	}

}

/*       S.D.G.       */

package com.anfelisa.lesson.commands;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.lesson.data.LessonData;

public abstract class AbstractUpdateLessonCommand extends Command<LessonData> {

	protected static final String updated = "updated";

	public AbstractUpdateLessonCommand(LessonData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.lesson.commands.UpdateLessonCommand", commandParam, databaseHandle);
	}

	@Override
	protected void publishEvents() {
		switch (this.outcome) {
		case updated:
			new com.anfelisa.lesson.events.LessonUpdatedEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + outcome);
		}
	}

}

/*       S.D.G.       */

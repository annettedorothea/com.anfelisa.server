package com.anfelisa.lesson.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.DatabaseService;

import com.anfelisa.lesson.data.LessonCreationData;

public abstract class AbstractCreateLessonCommand extends Command<LessonCreationData> {

	protected static final String created = "created";

	public AbstractCreateLessonCommand(LessonCreationData commandParam, DatabaseHandle databaseHandle) {
		super("CreateLessonCommand", commandParam, databaseHandle);
	}

	@Override
	protected void publishEvents() {
		switch (this.outcome) {
		case created:
			new com.anfelisa.lesson.events.LessonCreatedEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + outcome);
		}
	}
}

/*       S.D.G.       */

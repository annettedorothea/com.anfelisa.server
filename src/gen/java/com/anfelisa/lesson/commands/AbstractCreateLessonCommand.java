package com.anfelisa.lesson.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.lesson.data.LessonCreationData;

public abstract class AbstractCreateLessonCommand extends Command<LessonCreationData> {

	protected static final String created = "created";

	public AbstractCreateLessonCommand(LessonCreationData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.lesson.commands.CreateLessonCommand", commandParam, databaseHandle);
	}

	public AbstractCreateLessonCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.lesson.commands.CreateLessonCommand", null, databaseHandle);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case created:
			new com.anfelisa.lesson.events.LessonCreatedEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
	public void initCommandData(String json) {
		try {
			this.commandData = mapper.readValue(json, LessonCreationData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */

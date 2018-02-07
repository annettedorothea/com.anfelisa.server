package com.anfelisa.lesson.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.lesson.data.LessonIdData;

public abstract class AbstractDeleteLessonCommand extends Command<LessonIdData> {

	protected static final String deleted = "deleted";

	public AbstractDeleteLessonCommand(LessonIdData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.lesson.commands.DeleteLessonCommand", commandParam, databaseHandle);
	}

	public AbstractDeleteLessonCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.lesson.commands.DeleteLessonCommand", null, databaseHandle);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case deleted:
			new com.anfelisa.lesson.events.LessonDeletedEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
	public void initCommandData(String json) {
		try {
			this.commandData = mapper.readValue(json, LessonIdData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */

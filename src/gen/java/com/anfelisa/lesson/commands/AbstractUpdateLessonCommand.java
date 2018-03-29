package com.anfelisa.lesson.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.lesson.data.LessonData;

public abstract class AbstractUpdateLessonCommand extends Command<LessonData> {

	protected static final String updated = "updated";

	public AbstractUpdateLessonCommand(LessonData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.lesson.commands.UpdateLessonCommand", commandParam, databaseHandle);
	}

	public AbstractUpdateLessonCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.lesson.commands.UpdateLessonCommand", null, databaseHandle);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
		case updated:
			new com.anfelisa.lesson.events.UpdateLessonUpdatedEvent(this.commandData, databaseHandle).publish();
			break;
		default:
			throw new WebApplicationException("unhandled outcome " + this.commandData.getOutcome());
		}
	}
	
	public void initCommandData(String json) {
		try {
			this.commandData = mapper.readValue(json, LessonData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */

package com.anfelisa.lesson.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.lesson.data.LessonData;

public abstract class AbstractGetLessonCommand extends Command<LessonData> {


	public AbstractGetLessonCommand(LessonData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.lesson.commands.GetLessonCommand", commandParam, databaseHandle);
	}

	public AbstractGetLessonCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.lesson.commands.GetLessonCommand", null, databaseHandle);
	}

	@Override
	public void publishEvents() {
		switch (this.commandData.getOutcome()) {
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

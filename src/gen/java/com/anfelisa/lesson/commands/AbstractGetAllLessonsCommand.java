package com.anfelisa.lesson.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.lesson.data.SimpleLessonListData;

public abstract class AbstractGetAllLessonsCommand extends Command<SimpleLessonListData> {


	public AbstractGetAllLessonsCommand(SimpleLessonListData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.lesson.commands.GetAllLessonsCommand", commandParam, databaseHandle);
	}

	public AbstractGetAllLessonsCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.lesson.commands.GetAllLessonsCommand", null, databaseHandle);
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
			this.commandData = mapper.readValue(json, SimpleLessonListData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */

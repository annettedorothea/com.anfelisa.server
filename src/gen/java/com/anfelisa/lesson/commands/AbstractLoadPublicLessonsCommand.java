package com.anfelisa.lesson.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.lesson.data.LessonListData;

public abstract class AbstractLoadPublicLessonsCommand extends Command<LessonListData> {


	public AbstractLoadPublicLessonsCommand(LessonListData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.lesson.commands.LoadPublicLessonsCommand", commandParam, databaseHandle);
	}

	public AbstractLoadPublicLessonsCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.lesson.commands.LoadPublicLessonsCommand", null, databaseHandle);
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
			this.commandData = mapper.readValue(json, LessonListData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */

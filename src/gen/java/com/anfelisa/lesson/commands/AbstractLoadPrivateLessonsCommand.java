package com.anfelisa.lesson.commands;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Command;
import com.anfelisa.ace.DatabaseHandle;

import com.anfelisa.lesson.data.MyLessonListData;

public abstract class AbstractLoadPrivateLessonsCommand extends Command<MyLessonListData> {


	public AbstractLoadPrivateLessonsCommand(MyLessonListData commandParam, DatabaseHandle databaseHandle) {
		super("com.anfelisa.lesson.commands.LoadPrivateLessonsCommand", commandParam, databaseHandle);
	}

	public AbstractLoadPrivateLessonsCommand(DatabaseHandle databaseHandle) {
		super("com.anfelisa.lesson.commands.LoadPrivateLessonsCommand", null, databaseHandle);
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
			this.commandData = mapper.readValue(json, MyLessonListData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */

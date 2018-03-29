package com.anfelisa.lesson.commands;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.lesson.data.SimpleLessonListData;

public class GetAllLessonsCommand extends AbstractGetAllLessonsCommand {

	static final Logger LOG = LoggerFactory.getLogger(GetAllLessonsCommand.class);

	public GetAllLessonsCommand(SimpleLessonListData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	public GetAllLessonsCommand(DatabaseHandle databaseHandle) {
		super(null, databaseHandle);
	}

	@Override
	protected void executeCommand() {
	}

}

/*       S.D.G.       */

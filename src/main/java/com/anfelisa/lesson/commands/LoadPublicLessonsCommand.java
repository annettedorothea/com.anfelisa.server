package com.anfelisa.lesson.commands;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.lesson.data.LessonListData;

public class LoadPublicLessonsCommand extends AbstractLoadPublicLessonsCommand {

	static final Logger LOG = LoggerFactory.getLogger(LoadPublicLessonsCommand.class);

	public LoadPublicLessonsCommand(LessonListData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	public LoadPublicLessonsCommand(DatabaseHandle databaseHandle) {
		super(null, databaseHandle);
	}

	@Override
	protected void executeCommand() {
	}

}

/*       S.D.G.       */

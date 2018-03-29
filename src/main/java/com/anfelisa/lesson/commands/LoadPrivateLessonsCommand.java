package com.anfelisa.lesson.commands;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.lesson.data.MyLessonListData;

public class LoadPrivateLessonsCommand extends AbstractLoadPrivateLessonsCommand {

	static final Logger LOG = LoggerFactory.getLogger(LoadPrivateLessonsCommand.class);

	public LoadPrivateLessonsCommand(MyLessonListData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	public LoadPrivateLessonsCommand(DatabaseHandle databaseHandle) {
		super(null, databaseHandle);
	}

	@Override
	protected void executeCommand() {
	}

}

/*       S.D.G.       */

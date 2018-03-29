package com.anfelisa.course.commands;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.course.data.CourseListData;

public class LoadAllCoursesCommand extends AbstractLoadAllCoursesCommand {

	static final Logger LOG = LoggerFactory.getLogger(LoadAllCoursesCommand.class);

	public LoadAllCoursesCommand(CourseListData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	public LoadAllCoursesCommand(DatabaseHandle databaseHandle) {
		super(null, databaseHandle);
	}

	@Override
	protected void executeCommand() {
	}

}

/*       S.D.G.       */

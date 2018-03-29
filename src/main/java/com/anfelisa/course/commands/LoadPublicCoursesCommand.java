package com.anfelisa.course.commands;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.course.data.CourseListData;

public class LoadPublicCoursesCommand extends AbstractLoadPublicCoursesCommand {

	static final Logger LOG = LoggerFactory.getLogger(LoadPublicCoursesCommand.class);

	public LoadPublicCoursesCommand(CourseListData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	public LoadPublicCoursesCommand(DatabaseHandle databaseHandle) {
		super(null, databaseHandle);
	}

	@Override
	protected void executeCommand() {
	}

}

/*       S.D.G.       */

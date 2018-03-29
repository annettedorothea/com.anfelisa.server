package com.anfelisa.course.commands;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.course.data.MyCourseListData;

public class LoadPrivateCoursesCommand extends AbstractLoadPrivateCoursesCommand {

	static final Logger LOG = LoggerFactory.getLogger(LoadPrivateCoursesCommand.class);

	public LoadPrivateCoursesCommand(MyCourseListData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	public LoadPrivateCoursesCommand(DatabaseHandle databaseHandle) {
		super(null, databaseHandle);
	}

	@Override
	protected void executeCommand() {
	}

}

/*       S.D.G.       */

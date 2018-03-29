package com.anfelisa.user.commands;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.user.data.CourseSelectionData;

public class GetCourseSelectionCommand extends AbstractGetCourseSelectionCommand {

	static final Logger LOG = LoggerFactory.getLogger(GetCourseSelectionCommand.class);

	public GetCourseSelectionCommand(CourseSelectionData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	public GetCourseSelectionCommand(DatabaseHandle databaseHandle) {
		super(null, databaseHandle);
	}

	@Override
	protected void executeCommand() {
	}

}

/*       S.D.G.       */

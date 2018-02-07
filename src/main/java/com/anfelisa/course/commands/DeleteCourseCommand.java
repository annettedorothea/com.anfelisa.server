package com.anfelisa.course.commands;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.course.data.CourseIdData;

public class DeleteCourseCommand extends AbstractDeleteCourseCommand {

	static final Logger LOG = LoggerFactory.getLogger(DeleteCourseCommand.class);

	public DeleteCourseCommand(CourseIdData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	public DeleteCourseCommand(DatabaseHandle databaseHandle) {
		super(null, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		this.commandData.setOutcome(deleted);
	}

}

/*       S.D.G.       */

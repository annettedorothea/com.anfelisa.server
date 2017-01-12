package com.anfelisa.course.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.course.data.CourseCreationData;

public class CreateCourseCommand extends AbstractCreateCourseCommand {

	static final Logger LOG = LoggerFactory.getLogger(CreateCourseCommand.class);

	public CreateCourseCommand(CourseCreationData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		this.outcome = created;
	}

}

/*       S.D.G.       */

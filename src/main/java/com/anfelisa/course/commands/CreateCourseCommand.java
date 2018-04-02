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
		this.commandData.setOutcome(created);
		if (this.commandData.getCourseId() == null) {
			this.commandData.setCourseId(this.commandData.getUuid());
		}
	}

}

/*       S.D.G.       */

package com.anfelisa.course.commands;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.course.data.StudentToCourseAdditionData;

public class AddStudentToCourseCommand extends AbstractAddStudentToCourseCommand {

	static final Logger LOG = LoggerFactory.getLogger(AddStudentToCourseCommand.class);

	public AddStudentToCourseCommand(StudentToCourseAdditionData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		// execute command and set outcome
		this.commandData = this.commandParam;
		this.outcome = added;
	}

}

/*       S.D.G.       */

package com.anfelisa.lesson.commands;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.lesson.data.LessonData;

public class UpdateLessonCommand extends AbstractUpdateLessonCommand {

	static final Logger LOG = LoggerFactory.getLogger(UpdateLessonCommand.class);

	public UpdateLessonCommand(LessonData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		// execute command and set outcome
		this.commandData = this.commandParam;
		this.outcome = updated;
	}

}

/*       S.D.G.       */

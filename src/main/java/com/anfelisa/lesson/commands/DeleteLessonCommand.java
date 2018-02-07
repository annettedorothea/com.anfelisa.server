package com.anfelisa.lesson.commands;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.lesson.data.LessonIdData;

public class DeleteLessonCommand extends AbstractDeleteLessonCommand {

	static final Logger LOG = LoggerFactory.getLogger(DeleteLessonCommand.class);

	public DeleteLessonCommand(LessonIdData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	public DeleteLessonCommand(DatabaseHandle databaseHandle) {
		super(null, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		this.commandData.setOutcome(deleted);
	}

}

/*       S.D.G.       */

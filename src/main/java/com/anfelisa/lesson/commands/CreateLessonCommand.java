package com.anfelisa.lesson.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.lesson.data.LessonCreationData;

public class CreateLessonCommand extends AbstractCreateLessonCommand {

	static final Logger LOG = LoggerFactory.getLogger(CreateLessonCommand.class);

	public CreateLessonCommand(LessonCreationData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		this.outcome = created;
	}

}

/*       S.D.G.       */

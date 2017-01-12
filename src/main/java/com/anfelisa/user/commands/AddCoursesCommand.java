package com.anfelisa.user.commands;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.user.data.AddCoursesData;

public class AddCoursesCommand extends AbstractAddCoursesCommand {

	static final Logger LOG = LoggerFactory.getLogger(AddCoursesCommand.class);

	public AddCoursesCommand(AddCoursesData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		this.outcome = success;
	}

}

/*       S.D.G.       */

package com.anfelisa.user.commands;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.user.data.RemoveCourseData;

public class RemoveCourseCommand extends AbstractRemoveCourseCommand {

	static final Logger LOG = LoggerFactory.getLogger(RemoveCourseCommand.class);

	public RemoveCourseCommand(RemoveCourseData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		this.outcome = success;
	}

}

/*       S.D.G.       */

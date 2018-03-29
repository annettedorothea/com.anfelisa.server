package com.anfelisa.box.commands;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.data.BoxOfCourseListData;

public class LoadBoxOfCourseListCommand extends AbstractLoadBoxOfCourseListCommand {

	static final Logger LOG = LoggerFactory.getLogger(LoadBoxOfCourseListCommand.class);

	public LoadBoxOfCourseListCommand(BoxOfCourseListData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	public LoadBoxOfCourseListCommand(DatabaseHandle databaseHandle) {
		super(null, databaseHandle);
	}

	@Override
	protected void executeCommand() {
	}

}

/*       S.D.G.       */

package com.anfelisa.box.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.box.data.BoxToCourseAdditionData;

public class AddCourseToBoxCommand extends AbstractAddCourseToBoxCommand {

	static final Logger LOG = LoggerFactory.getLogger(AddCourseToBoxCommand.class);

	public AddCourseToBoxCommand(BoxToCourseAdditionData commandParam, DatabaseHandle databaseHandle) {
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

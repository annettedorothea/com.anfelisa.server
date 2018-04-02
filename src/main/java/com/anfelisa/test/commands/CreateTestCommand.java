package com.anfelisa.test.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.test.data.TestCreationData;

public class CreateTestCommand extends AbstractCreateTestCommand {

	static final Logger LOG = LoggerFactory.getLogger(CreateTestCommand.class);

	public CreateTestCommand(TestCreationData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		this.commandData.setOutcome(created);
		if (this.commandData.getTestId() == null) {
			this.commandData.setTestId(this.commandData.getUuid());
		}
	}

}

/*       S.D.G.       */

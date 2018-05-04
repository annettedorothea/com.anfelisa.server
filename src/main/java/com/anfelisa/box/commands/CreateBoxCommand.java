package com.anfelisa.box.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.box.data.BoxCreationData;

public class CreateBoxCommand extends AbstractCreateBoxCommand {

	static final Logger LOG = LoggerFactory.getLogger(CreateBoxCommand.class);

	public CreateBoxCommand(BoxCreationData commandParam, DatabaseHandle databaseHandle, DaoProvider daoProvider, ViewProvider viewProvider) {
		super(commandParam, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void executeCommand() {
		if (commandData.getCredentialsRole().equals(AuthUser.STUDENT) && !commandData.getUsername().equals(commandData.getCredentialsUsername())) {
			throwUnauthorized();
		}
		this.commandData.setBoxId(this.commandData.getUuid());
		this.commandData.setOutcome(created);
	}

}

/*       S.D.G.       */

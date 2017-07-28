package com.anfelisa.user.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.user.data.ChangeUserToPremiumData;

public class ChangeUserToPremiumCommand extends AbstractChangeUserToPremiumCommand {

	static final Logger LOG = LoggerFactory.getLogger(ChangeUserToPremiumCommand.class);

	public ChangeUserToPremiumCommand(ChangeUserToPremiumData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		if (!commandData.getCredentialsUsername().equals("Annette")) {
			throwUnauthorized();
		}
		this.outcome = ok;
	}

}

/*       S.D.G.       */

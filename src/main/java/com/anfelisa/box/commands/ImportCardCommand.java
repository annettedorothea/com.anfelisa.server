package com.anfelisa.box.commands;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.data.CardCreationData;

public class ImportCardCommand extends AbstractImportCardCommand {

	static final Logger LOG = LoggerFactory.getLogger(ImportCardCommand.class);

	public ImportCardCommand(CardCreationData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		if (this.commandData.getCardId() == null) {
			this.outcome = imported;
		} else {
			this.outcome = alreadyExists;
			this.commandData.setCardId(null);
		}
	}

}

/*       S.D.G.       */

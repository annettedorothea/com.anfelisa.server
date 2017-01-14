package com.anfelisa.box.commands;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.data.CardCreationData;
import com.anfelisa.box.models.CustomCardDao;
import com.anfelisa.box.models.ICardModel;

public class ImportCardCommand extends AbstractImportCardCommand {

	static final Logger LOG = LoggerFactory.getLogger(ImportCardCommand.class);

	public ImportCardCommand(CardCreationData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		ICardModel existingCard = CustomCardDao.selectByTestIdAndContentHash(this.getHandle(), this.commandData.getSchema(),
				this.commandData.getTestId(), this.commandData.getContentHash());
		if (existingCard != null) {
			this.commandData.setCardId(existingCard.getCardId());
			this.outcome = imported;
		} else {
			this.commandData.setCardId(null);
			this.outcome = alreadyExists;
		}
	}

}

/*       S.D.G.       */

package com.anfelisa.box.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.box.data.CardCreationData;
import com.anfelisa.box.models.CustomCardDao;
import com.anfelisa.box.models.ICardModel;

public class ImportCardCommand extends AbstractImportCardCommand {

	static final Logger LOG = LoggerFactory.getLogger(ImportCardCommand.class);

	private CustomCardDao customCardDao = new CustomCardDao();

	public ImportCardCommand(CardCreationData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		ICardModel existingCard = customCardDao.selectByTestIdAndContentHash(this.getHandle(),
				this.commandData.getTestId(), this.commandData.getContentHash());
		if (existingCard != null) {
			this.commandData.setCardId(existingCard.getCardId());
			this.commandData.setOutcome(alreadyExists);
		} else {
			this.commandData.setCardId(null);
			this.commandData.setOutcome(imported);
		}
	}

}

/* S.D.G. */

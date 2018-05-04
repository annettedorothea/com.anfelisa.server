package com.anfelisa.box.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.data.CardCreationData;

public class ImportCardCommand extends AbstractImportCardCommand {

	static final Logger LOG = LoggerFactory.getLogger(ImportCardCommand.class);

	//private CustomCardDao customCardDao = new CustomCardDao();

	public ImportCardCommand(CardCreationData commandParam, DatabaseHandle databaseHandle, DaoProvider daoProvider, ViewProvider viewProvider) {
		super(commandParam, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void executeCommand() {
		/*ICardModel existingCard = customCardDao.selectByTestIdAndContentHash(this.getHandle(),
				this.commandData.getTestId(), this.commandData.getContentHash());
		if (existingCard != null) {
			this.commandData.setCardId(existingCard.getCardId());
			this.commandData.setOutcome(alreadyExists);
		} else {
			this.commandData.setCardId(this.commandData.getUuid());
			this.commandData.setOutcome(imported);
		}*/
	}

}

/* S.D.G. */

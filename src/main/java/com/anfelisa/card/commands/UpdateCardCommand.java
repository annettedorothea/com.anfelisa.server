package com.anfelisa.card.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.card.data.CardUpdateData;

public class UpdateCardCommand extends AbstractUpdateCardCommand {

	static final Logger LOG = LoggerFactory.getLogger(UpdateCardCommand.class);

	public UpdateCardCommand(CardUpdateData commandParam, DatabaseHandle databaseHandle, DaoProvider daoProvider,
			ViewProvider viewProvider) {
		super(commandParam, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void executeCommand() {
		if (daoProvider.cardDao.selectByCardId(getHandle(), commandData.getCardId()) == null) {
			throwBadRequest("card does not exist");
		}
		if (commandData.getCardIndex() == null) {
			commandData.setCardIndex(0);
		}
		this.commandData.setOutcome(ok);
	}

}

/* S.D.G. */

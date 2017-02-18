package com.anfelisa.box.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.box.data.CardIdData;
import com.anfelisa.box.models.CustomCardDao;
import com.anfelisa.box.models.ICardModel;

public class DeleteCardCommand extends AbstractDeleteCardCommand {

	static final Logger LOG = LoggerFactory.getLogger(DeleteCardCommand.class);

	private CustomCardDao customCardDao = new CustomCardDao();

	public DeleteCardCommand(CardIdData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		ICardModel card = customCardDao.selectByTestIdAndContentHash(this.getDatabaseHandle().getHandle(),
				this.commandData.getTestId(), this.commandData.getContentHash());
		this.commandData.setCardId(card.getCardId());
		this.outcome = deleted;
	}

}

/* S.D.G. */

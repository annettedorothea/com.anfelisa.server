package com.anfelisa.result.commands;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.box.models.CardOfBoxModel;
import com.anfelisa.box.models.CustomBoxDao;
import com.anfelisa.box.models.CustomCardDao;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.models.ICardModel;
import com.anfelisa.box.models.ICardOfBoxModel;
import com.anfelisa.result.data.ResultSaveData;

public class SaveResultCommand extends AbstractSaveResultCommand {

	static final Logger LOG = LoggerFactory.getLogger(SaveResultCommand.class);

	public SaveResultCommand(ResultSaveData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		if (!commandData.getUsername().equals(commandData.getCredentialsUsername())) {
			throwUnauthorized();
		}
		this.commandData.setCardsToBeAdded(new ArrayList<>());
		List<IBoxModel> boxes = CustomBoxDao.selectBoxesWhereCardMightBeAddedAfterEdit(
				this.getDatabaseHandle().getHandle(), this.commandData.getSchema(), this.commandData.getTestId(),
				this.commandData.getUsername());
		for (IBoxModel box : boxes) {
			List<ICardModel> allCards;
			allCards = CustomCardDao.selectCardsToBeAddedAfterEdit(this.getDatabaseHandle().getHandle(),
					this.commandData.getSchema(), this.commandData.getTestId(), box.getBoxId());
			for (ICardModel card : allCards) {
				ICardOfBoxModel cardOfBox = new CardOfBoxModel(null, card.getCardId(), 0F, 0, 0, 0,
						this.commandData.getDate(), box.getBoxId(), null, this.commandData.getDate(), 0);
				this.commandData.getCardsToBeAdded().add(cardOfBox);
			}
		}
		this.outcome = saved;
	}

}

/* S.D.G. */

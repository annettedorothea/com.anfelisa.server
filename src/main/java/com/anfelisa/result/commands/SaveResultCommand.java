package com.anfelisa.result.commands;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.box.models.CustomBoxDao;
import com.anfelisa.box.models.CustomCardDao;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.models.ICardModel;
import com.anfelisa.box.models.IScheduledCardModel;
import com.anfelisa.box.models.ScheduledCardModel;
import com.anfelisa.result.data.ResultSaveData;

public class SaveResultCommand extends AbstractSaveResultCommand {

	static final Logger LOG = LoggerFactory.getLogger(SaveResultCommand.class);

	private CustomBoxDao customBoxDao = new CustomBoxDao();

	private CustomCardDao customCardDao = new CustomCardDao();

	public SaveResultCommand(ResultSaveData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		if (!commandData.getUsername().equals(commandData.getCredentialsUsername())) {
			throwUnauthorized();
		}
		this.commandData.setCardsToBeAdded(new ArrayList<>());
		List<IBoxModel> boxes = customBoxDao.selectBoxesWhereCardMightBeAddedAfterEdit(
				this.getDatabaseHandle().getHandle(), this.commandData.getSchema(), this.commandData.getTestId(),
				this.commandData.getUsername());
		for (IBoxModel box : boxes) {
			List<ICardModel> allCards;
			allCards = customCardDao.selectCardsToBeAddedAfterEdit(this.getDatabaseHandle().getHandle(),
					this.commandData.getSchema(), this.commandData.getTestId(), box.getBoxId());
			for (ICardModel card : allCards) {
				IScheduledCardModel scheduledCard = new ScheduledCardModel(null, card.getCardId(), 2.5F, 0, 0, 0,
						this.commandData.getDate().plusDays(1), box.getBoxId(), null, this.commandData.getDate(), false);
				this.commandData.getCardsToBeAdded().add(scheduledCard);
			}
		}
		this.outcome = saved;
	}

}

/* S.D.G. */

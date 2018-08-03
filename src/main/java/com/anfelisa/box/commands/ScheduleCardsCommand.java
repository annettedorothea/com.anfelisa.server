package com.anfelisa.box.commands;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.data.ScheduleCardsData;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.models.IScheduledCardModel;
import com.anfelisa.box.models.ScheduledCardModel;
import com.anfelisa.card.models.ICardModel;

public class ScheduleCardsCommand extends AbstractScheduleCardsCommand {

	static final Logger LOG = LoggerFactory.getLogger(ScheduleCardsCommand.class);

	public ScheduleCardsCommand(ScheduleCardsData commandData, DatabaseHandle databaseHandle, IDaoProvider daoProvider,
			ViewProvider viewProvider) {
		super(commandData, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void executeCommand() {
		if (this.commandData.getCardIds() == null || this.commandData.getCardIds().size() == 0) {
			this.commandData.setOutcome(nullOrEmpty);
		} else {
			String firstCardId = this.commandData.getCardIds().get(0);
			ICardModel firstCard = daoProvider.getCardDao().selectByCardId(getHandle(), firstCardId);
			if (firstCard == null) {
				throwBadRequest("cardDoesNotExist");
			}
			IBoxModel box = daoProvider.getCustomBoxDao().selectByCategoryIdAndUserId(getHandle(),
					firstCard.getRootCategoryId(), commandData.getUserId());
			if (box == null) {
				throwBadRequest("boxDoesNotExist");
			}
			List<IScheduledCardModel> allCards = daoProvider.getCustomScheduledCardDao().selectAllCardsOfBox(getHandle(), box.getBoxId());
			this.commandData.setExistingScheduledCardIds(new ArrayList<String>()); 
			this.commandData.setNewScheduledCards(new ArrayList<IScheduledCardModel>()); 
			this.commandData.setScheduledDate(commandData.getSystemTime());
			for (String cardId : this.commandData.getCardIds()) {
				IScheduledCardModel scheduledCardModel = findByCardId(allCards, cardId);
				if (scheduledCardModel != null) {
					this.commandData.getExistingScheduledCardIds().add(scheduledCardModel.getScheduledCardId());
				} else {
					String uuid = commandData.getUuid();
					String shorterUuid = uuid.substring(0, uuid.length() - 8);
					uuid = shorterUuid + cardId.substring(0, 8); 
					ScheduledCardModel newScheduledCard = new ScheduledCardModel(uuid, cardId, box.getBoxId(), commandData.getSystemTime(), 2.5F, 1, 1, 0, commandData.getSystemTime(), null, null, null);
					this.commandData.getNewScheduledCards().add(newScheduledCard);
				}
			}
			this.commandData.setOutcome(ok);
		}
	}
	
	private IScheduledCardModel findByCardId(List<IScheduledCardModel> allCards, String cardId) {
		for (IScheduledCardModel scheduledCardModel : allCards) {
			if (scheduledCardModel.getCardId().equals(cardId)) {
				return scheduledCardModel;
			}
		}
		return null;
	}

}

/* S.D.G. */

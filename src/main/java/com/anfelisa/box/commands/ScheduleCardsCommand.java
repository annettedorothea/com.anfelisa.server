package com.anfelisa.box.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.data.ScheduledCardsData;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.models.IScheduledCardModel;
import com.anfelisa.box.models.ScheduledCardModel;
import com.anfelisa.card.models.ICardModel;

public class ScheduleCardsCommand extends AbstractScheduleCardsCommand {

	static final Logger LOG = LoggerFactory.getLogger(ScheduleCardsCommand.class);

	public ScheduleCardsCommand(ScheduledCardsData commandData, DatabaseHandle databaseHandle, IDaoProvider daoProvider,
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
			IBoxModel box = daoProvider.getBoxDao().selectByCategoryIdAndUserId(getHandle(),
					firstCard.getRootCategoryId(), commandData.getUserId());
			if (box == null) {
				throwBadRequest("boxDoesNotExist");
			}
			List<IScheduledCardModel> allCards = daoProvider.getScheduledCardDao().selectAllCardsOfBox(getHandle(), box.getBoxId());
			this.commandData.setExistingScheduledCardIds(new ArrayList<String>()); 
			this.commandData.setNewScheduledCards(new ArrayList<IScheduledCardModel>());
			DateTime scheduledDateTime = firstCardByDateTime(allCards);
			this.commandData.setScheduledDate(scheduledDateTime);
			for (String cardId : this.commandData.getCardIds()) {
				IScheduledCardModel scheduledCardModel = findByCardId(allCards, cardId);
				if (scheduledCardModel != null) {
					this.commandData.getExistingScheduledCardIds().add(scheduledCardModel.getScheduledCardId());
				} else {
					String uuid = UUID.randomUUID().toString();
					ScheduledCardModel newScheduledCard = new ScheduledCardModel(uuid, cardId, box.getBoxId(), commandData.getSystemTime(), 2.5F, 1, 1, 0, scheduledDateTime, null, null, null);
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
	
	private DateTime firstCardByDateTime(List<IScheduledCardModel> allCards) {
		DateTime dateTime = commandData.getSystemTime();
		for (IScheduledCardModel scheduledCardModel : allCards) {
			if (scheduledCardModel.getScheduledDate().isBefore(dateTime)) {
				dateTime = scheduledCardModel.getScheduledDate();
			}
		}
		return dateTime.minusMinutes(1);
	}

}

/* S.D.G. */

package com.anfelisa.box.commands;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.data.IScheduledCardsData;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.models.IScheduledCardModel;
import com.anfelisa.box.models.ScheduledCardModel;
import com.anfelisa.card.models.ICardModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class ScheduleCardsCommand extends AbstractScheduleCardsCommand {

	static final Logger LOG = LoggerFactory.getLogger(ScheduleCardsCommand.class);

	public ScheduleCardsCommand(IScheduledCardsData actionData, IDaoProvider daoProvider,
			ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super(actionData, daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected void executeCommand(PersistenceHandle readonlyHandle) {
		if (this.commandData.getCardIds() == null || this.commandData.getCardIds().size() == 0) {
			this.commandData.setOutcome(nullOrEmpty);
		} else {
			String firstCardId = this.commandData.getCardIds().get(0);
			ICardModel firstCard = daoProvider.getCardDao().selectByCardId(readonlyHandle,  firstCardId);
			if (firstCard == null) {
				throwBadRequest("cardDoesNotExist");
			}
			IBoxModel box = daoProvider.getBoxDao().selectByCategoryIdAndUserId(readonlyHandle, 
					firstCard.getRootCategoryId(), commandData.getUserId());
			if (box == null) {
				throwBadRequest("boxDoesNotExist");
			}
			List<IScheduledCardModel> allCards = daoProvider.getScheduledCardDao().selectAllCardsOfBox(readonlyHandle, 
					box.getBoxId());
			this.commandData.setExistingScheduledCardIds(new ArrayList<String>());
			this.commandData.setNewScheduledCards(new ArrayList<IScheduledCardModel>());
			DateTime scheduledDateTime = firstCardByDateTime(allCards);
			this.commandData.setScheduledDate(scheduledDateTime);
			for (String cardId : this.commandData.getCardIds()) {
				IScheduledCardModel scheduledCardModel = findByCardId(allCards, cardId);
				if (scheduledCardModel != null) {
					this.commandData.getExistingScheduledCardIds().add(scheduledCardModel.getScheduledCardId());
				} else {
					String uuid = combineUuids(cardId, commandData.getUuid());
					ScheduledCardModel newScheduledCard = new ScheduledCardModel(uuid, cardId, box.getBoxId(),
							commandData.getSystemTime(), 2.5F, 1, 1, 0, scheduledDateTime, null, null, null);
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

	private String combineUuids(String uuid1, String uuid2) {
		return (uuid1.length() >= 23 ? uuid1.substring(0, 23) : uuid1) + "-"
				+ (uuid2.length() >= 8 ? uuid2.substring(0, 8) : uuid2);
	}

}

/* S.D.G. */

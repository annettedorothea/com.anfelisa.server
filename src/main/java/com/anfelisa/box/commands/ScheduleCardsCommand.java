package com.anfelisa.box.commands;

import java.util.ArrayList;

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
			this.commandData.setExistingScheduledCardIds(new ArrayList<String>());
			this.commandData.setNewScheduledCards(new ArrayList<IScheduledCardModel>());
			this.commandData.setScheduledDate(this.commandData.getSystemTime());
			for (String cardId : this.commandData.getCardIds()) {
				ICardModel card = daoProvider.getCardDao().selectByCardId(readonlyHandle, cardId);
				if (card == null) {
					throwBadRequest("card does not exist");
				}
				IBoxModel box = daoProvider.getBoxDao().selectByCategoryIdAndUserId(readonlyHandle,
						card.getRootCategoryId(), commandData.getUserId());
				if (box == null) {
					throwUnauthorized();
				}
				IScheduledCardModel scheduledCard = daoProvider.getScheduledCardDao()
						.selectUnscoredByCardIdAndBoxId(readonlyHandle, cardId, box.getBoxId());
				ScheduledCardModel newScheduledCard;
				if (scheduledCard == null) {
					IScheduledCardModel lastScoredScheduledCard = daoProvider.getScheduledCardDao()
							.selectLastScoredByCardIdAndBoxId(readonlyHandle, cardId, box.getBoxId());
					if (lastScoredScheduledCard != null) {
						newScheduledCard = new ScheduledCardModel(
								combineUuids(cardId, commandData.getUuid()), cardId, box.getBoxId(),
								commandData.getSystemTime(), 2.5F, 1, 1, lastScoredScheduledCard.getCount() + 1,
								this.commandData.getSystemTime(), lastScoredScheduledCard.getQuality(), null,
								null);
					} else {
						newScheduledCard = new ScheduledCardModel(
								combineUuids(cardId, commandData.getUuid()), cardId, box.getBoxId(),
								commandData.getSystemTime(), 2.5F, 1, 1, 0, this.commandData.getSystemTime(), null,
								null, null);
					}
					this.commandData.getNewScheduledCards().add(newScheduledCard);
				} else {
					this.commandData.getExistingScheduledCardIds().add(scheduledCard.getScheduledCardId());
				}
			}
			this.commandData.setOutcome(ok);
		}
	}

	private String combineUuids(String uuid1, String uuid2) {
		return (uuid1.length() >= 12 ? uuid1.substring(0, 12) : uuid1) + "-"
				+ (uuid2.length() >= 12 ? uuid2.substring(0, 12) : uuid2);
	}

}

/* S.D.G. */

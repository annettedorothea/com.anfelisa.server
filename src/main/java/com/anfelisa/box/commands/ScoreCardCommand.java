package com.anfelisa.box.commands;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.data.IScoreCardData;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.models.IReinforceCardModel;
import com.anfelisa.box.models.IScheduledCardModel;

import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;
import de.acegen.ViewProvider;

public class ScoreCardCommand extends AbstractScoreCardCommand {

	static final Logger LOG = LoggerFactory.getLogger(ScoreCardCommand.class);

	public ScoreCardCommand(IScoreCardData actionData, IDaoProvider daoProvider,
			ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super(actionData, daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected void executeCommand(PersistenceHandle readonlyHandle) {
		IScheduledCardModel scheduledCard = this.daoProvider.getScheduledCardDao().selectByScheduledCardId(readonlyHandle, 
				commandData.getScoredCardScheduledCardId());
		if (scheduledCard == null) {
			throwBadRequest("card does not exist");
		}
		IBoxModel box = daoProvider.getBoxDao().selectByBoxId(readonlyHandle,  scheduledCard.getBoxId());
		if (!commandData.getUserId().equals(box.getUserId())) {
			throwUnauthorized();
		}

		Float ef = scheduledCard.getEf();
		Integer interval = scheduledCard.getInterval();
		Integer count = scheduledCard.getCount() + 1;
		Integer n = scheduledCard.getN() + 1;
		Float newFactor = ef;
		Integer quality = commandData.getScoredCardQuality();

		if (quality < 3) {
			n = 1;
		} else {
			Float qFactor = (float) (5 - quality);
			newFactor = (ef + (0.1F - qFactor * (0.08F + qFactor * 0.02F)));
			if (newFactor < 1.3) {
				newFactor = 1.3F;
			}
		}

		IReinforceCardModel reinforceCard = daoProvider.getReinforceCardDao().selectByScheduledCardId(readonlyHandle, 
				scheduledCard.getScheduledCardId());
		if (quality <= 3 && reinforceCard == null) {
			this.commandData.setOutcome(scoreAndReinforce);
		} else {
			this.commandData.setOutcome(score);
		}
		Integer newInterval = 1;
		if (n == 2) {
			newInterval = 6;
		} else if (n > 2) {
			newInterval = Math.round(interval * newFactor);
		}
		if (box.getMaxInterval() != null && newInterval > box.getMaxInterval()) {
			newInterval = box.getMaxInterval();
		}
		DateTime newTime = this.commandData.getSystemTime().plusDays(newInterval);
		if (box.getMaxCardsPerDay() != null) {
			if (scheduledCard.getScheduledDate().isAfter(commandData.getSystemTime())) {
				newTime = scheduledCard.getScheduledDate().plusDays(newInterval);
			} else {
				newTime = commandData.getSystemTime().plusDays(newInterval);
			}
			Integer cardCount = daoProvider.getScheduledCardDao().selectCardCountOfDay(readonlyHandle,  box.getBoxId(),
					newTime.withTimeAtStartOfDay(), newTime.plusDays(1).withTimeAtStartOfDay());
			while (cardCount >= box.getMaxCardsPerDay()) {
				newInterval += 1;
				if (scheduledCard.getScheduledDate().isAfter(commandData.getSystemTime())) {
					newTime = scheduledCard.getScheduledDate().plusDays(newInterval);
				} else {
					newTime = commandData.getSystemTime().plusDays(newInterval);
				}
				cardCount = daoProvider.getScheduledCardDao().selectCardCountOfDay(readonlyHandle,  box.getBoxId(),
						newTime.withTimeAtStartOfDay(), newTime.plusDays(1).withTimeAtStartOfDay());
			}
		}
		this.commandData.setNextScheduledCardScheduledCardId(commandData.getUuid());
		this.commandData.setNextScheduledCardEf(newFactor);
		this.commandData.setNextScheduledCardInterval(newInterval);
		this.commandData.setNextScheduledCardCount(count);
		this.commandData.setNextScheduledCardN(n);
		this.commandData.setNextScheduledCardScheduledDate(newTime);
		this.commandData.setNextScheduledCardLastQuality(quality);
		this.commandData.setNextScheduledCardCreatedDate(this.commandData.getSystemTime());

		this.commandData.setCardId(scheduledCard.getCardId());
		this.commandData.setBoxId(scheduledCard.getBoxId());

		this.commandData.setScoredCardScoredDate(this.commandData.getSystemTime());

		this.commandData.setReinforceCardId(this.commandData.getUuid());
		this.commandData.setReinforceCardCreatedDate(this.commandData.getSystemTime());

	}

}

/* S.D.G. */

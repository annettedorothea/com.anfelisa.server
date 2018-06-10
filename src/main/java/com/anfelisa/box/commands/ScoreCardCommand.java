package com.anfelisa.box.commands;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.data.ScoreCardData;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.models.IScheduledCardModel;

public class ScoreCardCommand extends AbstractScoreCardCommand {

	static final Logger LOG = LoggerFactory.getLogger(ScoreCardCommand.class);

	public ScoreCardCommand(ScoreCardData commandData, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(commandData, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void executeCommand() {
		IScheduledCardModel scheduledCard = this.daoProvider.getScheduledCardDao().selectByScheduledCardId(getHandle(), commandData.getScoredCardScheduledCardId());
		if (scheduledCard == null) {
			throwBadRequest("scheduled card not found");
		}
		IBoxModel box = daoProvider.getBoxDao().selectByBoxId(getHandle(), scheduledCard.getBoxId());
		if (box == null) {
			throwBadRequest("Something went wrong.....");
		}
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
			this.commandData.setOutcome(scoreAndReinforce);
		} else {
			Float qFactor = (float) (5 - quality);
			newFactor = (ef + (0.1F - qFactor * (0.08F + qFactor * 0.02F)));
			if (newFactor < 1.3) {
				newFactor = 1.3F;
			}
			this.commandData.setOutcome(score);
		}
		Integer newInterval = 1;
		if (n == 2) {
			newInterval = 6;
		} else if (n > 2) {
			newInterval = Math.round(interval * newFactor);
		}
		DateTime next = this.commandData.getSystemTime().plusDays(newInterval);

		this.commandData.setNextScheduledCardScheduledCardId(commandData.getUuid());
		this.commandData.setNextScheduledCardEf(newFactor);
		this.commandData.setNextScheduledCardInterval(newInterval);
		this.commandData.setNextScheduledCardCount(count);
		this.commandData.setNextScheduledCardN(n);
		this.commandData.setNextScheduledCardScheduledDate(next);
		this.commandData.setNextScheduledCardLastQuality(quality);
		this.commandData.setNextScheduledCardCreatedDate(this.commandData.getSystemTime());
		
		this.commandData.setCardId(scheduledCard.getCardId());
		this.commandData.setBoxId(scheduledCard.getBoxId());
		
		this.commandData.setScoredCardScoredDate(this.commandData.getSystemTime());

	}

}

/*       S.D.G.       */

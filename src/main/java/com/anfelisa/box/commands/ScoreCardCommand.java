package com.anfelisa.box.commands;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.box.data.ScoreCardData;
import com.anfelisa.box.models.CardDao;
import com.anfelisa.box.models.CustomBoxDao;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.models.ICardModel;
import com.anfelisa.box.models.IScheduledCardModel;
import com.anfelisa.box.models.ScheduledCardDao;

public class ScoreCardCommand extends AbstractScoreCardCommand {

	static final Logger LOG = LoggerFactory.getLogger(ScoreCardCommand.class);

	private CardDao cardDao = new CardDao();

	private ScheduledCardDao scheduledCardDao = new ScheduledCardDao();

	private CustomBoxDao customBoxDao = new CustomBoxDao();

	public ScoreCardCommand(ScoreCardData commandData, DatabaseHandle databaseHandle, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(commandData, databaseHandle, daoProvider, viewProvider);
	}

	@Override
	protected void executeCommand() {
		try {
			IBoxModel box = customBoxDao.selectByScheduledCardId(getHandle(), commandData.getScheduledCardId());
			/*if (!box.getUsername().equals(commandData.getCredentialsUsername())) {
				throwUnauthorized();
			}*/

			IScheduledCardModel scheduledCard = scheduledCardDao.selectByScheduledCardId(
					this.getDatabaseHandle().getHandle(), this.commandData.getScheduledCardId());
			this.commandData.setBoxId(scheduledCard.getBoxId());
			this.commandData.setCardId(scheduledCard.getCardId());

			this.commandData.setScheduledDateOfScored(scheduledCard.getScheduledDate());

			ICardModel card = cardDao.selectByCardId(this.getDatabaseHandle().getHandle(),
					this.commandData.getCardId());

			Float ef = scheduledCard.getEf() == 0F ? 2.5F : scheduledCard.getEf();
			Integer interval = scheduledCard.getInterval() == 0 ? 1 : scheduledCard.getInterval();
			Integer count = scheduledCard.getCount() + 1;
			Integer maxPoints = card.getMaxPoints();
			Integer n = scheduledCard.getN() + 1;
			Float newFactor = ef;
			Integer quality = commandData.getSubmittedQuality();

			if (quality < 3) {
				n = 1;
			} else {
				Float qFactor = (float) (5 - quality);
				newFactor = (ef + (0.1F - qFactor * (0.08F + qFactor * 0.02F)));
				if (newFactor < 1.3) {
					newFactor = 1.3F;
				}
			}
			Integer newInterval = 1;
			if (n == 2) {
				newInterval = 6;
			} else if (n > 2) {
				newInterval = Math.round(interval * newFactor);
			}
			DateTime next = this.commandData.getSystemTime().plusDays(newInterval);
			Integer points = 0;
			if (quality > 2) {
				points = maxPoints;
			} else if (quality == 2) {
				points = (maxPoints / 2);
			}

			this.commandData.setEf(newFactor);
			this.commandData.setInterval(newInterval);
			this.commandData.setCount(count);
			this.commandData.setN(n);
			this.commandData.setScheduledDate(next);
			this.commandData.setTimestamp(this.commandData.getSystemTime());
			this.commandData.setQuality(quality);
			this.commandData.setLastQuality(quality);
			this.commandData.setPoints(points);
			this.commandData.setRemoved(false);
			this.commandData.setScoredCardId(this.commandData.getUuid());

			this.commandData.setOutcome(scored);
		} catch (Exception e) {
			this.throwInternalServerError(e);
		}

	}

}

/* S.D.G. */

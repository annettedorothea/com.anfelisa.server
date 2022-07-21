/********************************************************************************
 * generated by de.acegen 1.2.1
 ********************************************************************************/

package com.anfelisa.box.commands;

import java.time.LocalDateTime;

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

	public ScoreCardCommand(IDaoProvider daoProvider, ViewProvider viewProvider,
			CustomAppConfiguration appConfiguration) {
		super(daoProvider, viewProvider, appConfiguration);
	}

	@Override
	protected IScoreCardData executeCommand(IScoreCardData data, PersistenceHandle readonlyHandle) {
		IScheduledCardModel scheduledCard = this.daoProvider.getScheduledCardDao().selectByScheduledCardId(
				readonlyHandle,
				data.getScheduledCardId());
		if (scheduledCard == null) {
			throwIllegalArgumentException("cardDoesNotExist");
		}
		IBoxModel box = daoProvider.getBoxDao().selectByBoxId(readonlyHandle, scheduledCard.getBoxId());
		if (!data.getUserId().equals(box.getUserId())) {
			throwSecurityException();
		}

		Float ef = scheduledCard.getEf();
		Integer interval = scheduledCard.getInterval();
		Integer count = scheduledCard.getCount() + 1;
		Integer n = scheduledCard.getN();
		Integer quality = data.getScoredCardQuality();

		if (quality >= 3) {
			if (n == 0) {
				interval = 1;
			} else if (n == 1) {
				interval = 6;
			} else {
				interval = Math.round(interval * ef);
			}
			n++;
		} else {
			n = 0;
			interval = 1;
		}
		Integer calculatedInterval = interval;

		Float qFactor = (float) (5 - quality);
		ef = (ef + (0.1F - qFactor * (0.08F + qFactor * 0.02F)));
		if (ef < 1.3) {
			ef = 1.3F;
		}

		if (box.getMaxInterval() != null && interval > box.getMaxInterval()) {
			interval = box.getMaxInterval();
		}
		LocalDateTime newTime = data.getSystemTime().plusDays(interval);
		if (box.getMaxCardsPerDay() != null) {
			Integer cardCount = daoProvider.getScheduledCardDao().selectCardCountOfDay(readonlyHandle, box.getBoxId(),
					stripTime(newTime), stripTime(newTime.plusDays(1)));
			while (cardCount >= box.getMaxCardsPerDay()) {
				interval += 1;
				newTime = data.getSystemTime().plusDays(interval);
				cardCount = daoProvider.getScheduledCardDao().selectCardCountOfDay(readonlyHandle, box.getBoxId(),
						stripTime(newTime), stripTime(newTime.plusDays(1)));
			}
		}
		data.setNextScheduledCardScheduledCardId(data.getUuid());
		data.setNextScheduledCardEf(ef);
		data.setNextScheduledCardInterval(interval);
		data.setNextScheduledCardCount(count);
		data.setNextScheduledCardN(n);
		data.setNextScheduledCardScheduledDate(newTime);
		data.setNextScheduledCardLastQuality(quality);
		data.setNextScheduledCardCreatedDate(data.getSystemTime());

		data.setCardId(scheduledCard.getCardId());
		data.setBoxId(scheduledCard.getBoxId());

		data.setScoredCardScoredDate(data.getSystemTime());

		this.addScoreOutcome(data);
		IReinforceCardModel reinforceCard = daoProvider.getReinforceCardDao().selectByScheduledCardId(readonlyHandle,
				scheduledCard.getScheduledCardId());
		if (quality <= 3 && reinforceCard == null) {
			this.addReinforceOutcome(data);
			data.setReinforceCardId(data.getUuid());
			data.setReinforceCardCreatedDate(data.getSystemTime());
		}
		
		data.setIntervalDifference(interval - calculatedInterval); 
		data.setMaxCardsPerDay(box.getMaxCardsPerDay());
		data.setMaxInterval(box.getMaxInterval());

		return data;
	}

	private LocalDateTime stripTime(LocalDateTime value) {
		return value.withHour(0).withMinute(0).withSecond(0).withNano(0);
	}

}

/******* S.D.G. *******/

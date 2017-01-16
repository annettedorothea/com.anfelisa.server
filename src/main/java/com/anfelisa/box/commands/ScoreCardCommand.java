package com.anfelisa.box.commands;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.box.data.ScoreCardData;
import com.anfelisa.box.models.CardDao;
import com.anfelisa.box.models.CardOfBoxDao;
import com.anfelisa.box.models.CustomBoxDao;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.models.ICardModel;
import com.anfelisa.box.models.ICardOfBoxModel;

public class ScoreCardCommand extends AbstractScoreCardCommand {

	static final Logger LOG = LoggerFactory.getLogger(ScoreCardCommand.class);

	private CardDao cardDao = new CardDao();

	private CardOfBoxDao cardOfBoxDao = new CardOfBoxDao();

	private CustomBoxDao customBoxDao = new CustomBoxDao();

	public ScoreCardCommand(ScoreCardData commandData, DatabaseHandle databaseHandle) {
		super(commandData, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		IBoxModel box = customBoxDao.selectByCardOfBoxId(getHandle(), commandData.getSchema(),
				commandData.getCardOfBoxId());
		if (!box.getUsername().equals(commandData.getCredentialsUsername())) {
			throwUnauthorized();
		}

		ICardOfBoxModel cardOfBox = cardOfBoxDao.selectByCardOfBoxId(this.getDatabaseHandle().getHandle(),
				this.commandData.getCardOfBoxId(), this.commandData.getSchema());
		this.commandData.setBoxId(cardOfBox.getBoxId());
		this.commandData.setCardId(cardOfBox.getCardId());
		this.commandData.setCount(cardOfBox.getCount());
		this.commandData.setInterval(cardOfBox.getInterval());
		this.commandData.setN(cardOfBox.getN());
		this.commandData.setPoints(cardOfBox.getPoints());
		this.commandData.setQuality(cardOfBox.getQuality());
		this.commandData.setDate(cardOfBox.getDate());
		this.commandData.setEf(cardOfBox.getEf());
		this.commandData.setTimestamp(cardOfBox.getTimestamp());

		ICardModel card = cardDao.selectByCardId(this.getDatabaseHandle().getHandle(), this.commandData.getCardId(),
				this.commandData.getSchema());
		this.commandData.setMaxPoints(card.getMaxPoints());

		Float ef = this.commandData.getEf() == 0F ? 1F : this.commandData.getEf();
		Integer interval = this.commandData.getInterval() == 0 ? 1 : this.commandData.getInterval();
		Integer count = this.commandData.getCount() + 1;
		Integer maxPoints = this.commandData.getMaxPoints();
		Integer n = this.commandData.getN() + 1;
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
		DateTime next = this.commandData.getNow().plusDays(newInterval);
		Integer points = 0;
		if (quality > 2) {
			points = maxPoints;
		} else if (quality == 2) {
			points = (maxPoints / 2);
		}

		this.commandData.setCardOfBoxId(null);
		this.commandData.setEf(newFactor);
		this.commandData.setInterval(newInterval);
		this.commandData.setCount(count);
		this.commandData.setN(n);
		this.commandData.setDate(next);
		this.commandData.setTimestamp(this.commandData.getNow());
		this.commandData.setQuality(quality);
		this.commandData.setPoints(points);

		this.outcome = scored;
	}

}

/* S.D.G. */

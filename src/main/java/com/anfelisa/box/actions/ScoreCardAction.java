package com.anfelisa.box.actions;

import com.anfelisa.ace.DatabaseHandle;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.box.data.ScoreCardData;
import com.anfelisa.box.models.CardDao;
import com.anfelisa.box.models.CardOfBoxDao;
import com.anfelisa.box.models.ICardModel;
import com.anfelisa.box.models.ICardOfBoxModel;

public class ScoreCardAction extends AbstractScoreCardAction {

	static final Logger LOG = LoggerFactory.getLogger(ScoreCardAction.class);

	public ScoreCardAction(ScoreCardData actionParam, DatabaseHandle databaseHandle) {
		super(actionParam, databaseHandle);
	}

	@Override
	protected void captureActionParam() {
		this.actionParam.setNow(new DateTime());
	}

	@Override
	protected void applyAction() {
		this.actionData = this.actionParam;

		ICardOfBoxModel cardOfBox = CardOfBoxDao.selectByCardOfBoxId(this.getDatabaseHandle().getHandle(),
				this.actionParam.getCardOfBoxId(), this.actionParam.getSchema());
		this.actionData.setBoxId(cardOfBox.getBoxId());
		this.actionData.setCardId(cardOfBox.getCardId());
		this.actionData.setCount(cardOfBox.getCount());
		this.actionData.setInterval(cardOfBox.getInterval());
		this.actionData.setN(cardOfBox.getN());
		this.actionData.setPoints(cardOfBox.getPoints());
		this.actionData.setQuality(cardOfBox.getQuality());
		this.actionData.setDate(cardOfBox.getDate());
		this.actionData.setEf(cardOfBox.getEf());
		this.actionData.setTimestamp(cardOfBox.getTimestamp());

		ICardModel card = CardDao.selectByCardId(this.getDatabaseHandle().getHandle(), this.actionData.getCardId(),
				this.actionParam.getSchema());
		this.actionData.setMaxPoints(card.getMaxPoints());
	}

}

/* S.D.G. */

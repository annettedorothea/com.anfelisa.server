package com.anfelisa.box.actions;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.box.data.CardData;
import com.anfelisa.box.models.CustomBoxDao;
import com.anfelisa.box.models.ICardInfoModel;

public class LoadNextCardAction extends AbstractLoadNextCardAction {

	static final Logger LOG = LoggerFactory.getLogger(LoadNextCardAction.class);

	public LoadNextCardAction(CardData actionParam, DatabaseHandle databaseHandle) {
		super(actionParam, databaseHandle);
	}

	@Override
	protected void captureActionParam() {
	}

	@Override
	protected void applyAction() {
		this.actionData = this.actionParam;
		List<ICardInfoModel> nextCards = CustomBoxDao.selectNextCardsByBoxId(this.getDatabaseHandle().getHandle(),
				this.actionParam.getSchema(), this.actionParam.getBoxId());
		ICardInfoModel nextCard = null;
		ICardInfoModel nextNewCard = null;
		int count = 0;
		int cardsForToday = 0;
		int cardsForTomorrow = 0;
		int newCards = 0;
		int quality0Count = 0;
		int quality1Count = 0;
		int quality2Count = 0;
		int quality3Count = 0;
		int quality4Count = 0;
		int quality5Count = 0;
		this.actionData.setCount(0);
		for (ICardInfoModel cardInfoModel : nextCards) {
			DateTime next = cardInfoModel.getNext();
			DateTime last = cardInfoModel.getLast();
			if (nextCard == null && next != null && new LocalDate().plusDays(1).isAfter(next.toLocalDate())) {
				nextCard = cardInfoModel;
			} else if (nextNewCard == null && last == null) {
				nextNewCard = cardInfoModel;
			}
			count++;
			Integer quality = cardInfoModel.getQuality();
			if (last == null) {
				newCards++;
			}
			if (quality != null) {
				switch (quality) {
				case 0:
					quality0Count++;
					break;
				case 1:
					quality1Count++;
					break;
				case 2:
					quality2Count++;
					break;
				case 3:
					quality3Count++;
					break;
				case 4:
					quality4Count++;
					break;
				case 5:
					quality5Count++;
					break;
				}
			}
			if (next != null && new LocalDate().plusDays(1).isAfter(next.toLocalDate())) {
				cardsForToday++;
			} else if (next != null && new LocalDate().plusDays(1).equals(next.toLocalDate())) {
				cardsForTomorrow++;
			}
		}
		
		if (nextCard != null) {
			this.actionData.setBoxName(nextCard.getBoxName());
			this.actionData.setCardId(nextCard.getCardId());
			this.actionData.setContent(nextCard.getContent());
			this.actionData.setCount(nextCard.getCount());
			this.actionData.setNext(nextCard.getNext());
		} else if (nextNewCard != null) {
			this.actionData.setBoxName(nextNewCard.getBoxName());
			this.actionData.setCardId(nextNewCard.getCardId());
			this.actionData.setContent(nextNewCard.getContent());
			this.actionData.setCount(nextNewCard.getCount());
			this.actionData.setNext(nextNewCard.getNext());
		}
		
		this.actionData.setCount(count);
		this.actionData.setCardsForToday(cardsForToday);
		this.actionData.setCardsForTomorrow(cardsForTomorrow);
		this.actionData.setNewCards(newCards);

		int numberOfCardsWithQuality = quality0Count + quality1Count + quality2Count + quality3Count + quality4Count
				+ quality5Count;
		float factor = 100 / numberOfCardsWithQuality;
		this.actionData.setZero((int) Math.floor((factor * quality0Count)));
		this.actionData.setOne((int) Math.floor((factor * quality1Count)));
		this.actionData.setTwo((int) Math.floor((factor * quality2Count)));
		this.actionData.setThree((int) Math.floor((factor * quality3Count)));
		this.actionData.setFour((int) Math.floor((factor * quality4Count)));
		this.actionData.setFive(100 - this.actionData.getZero() - this.actionData.getOne() - this.actionData.getTwo()
				- this.actionData.getThree() - this.actionData.getFour());
		
	}

}

/* S.D.G. */

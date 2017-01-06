package com.anfelisa.box.actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.WebApplicationException;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.box.data.CardData;
import com.anfelisa.box.models.BoxDao;
import com.anfelisa.box.models.CustomBoxDao;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.models.ICardInfoModel;
import com.anfelisa.box.models.ILineModel;
import com.anfelisa.box.models.LineModel;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoadNextCardAction extends AbstractLoadNextCardAction {

	static final Logger LOG = LoggerFactory.getLogger(LoadNextCardAction.class);

	public LoadNextCardAction(CardData actionParam, DatabaseHandle databaseHandle) {
		super(actionParam, databaseHandle);
	}

	@Override
	protected void captureActionParam() {
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void applyAction() {
		this.actionData = this.actionParam;
		List<ICardInfoModel> nextCards = CustomBoxDao.selectNextCardsByBoxId(this.getDatabaseHandle().getHandle(),
				this.actionParam.getSchema(), this.actionParam.getBoxId());
		ICardInfoModel nextCard = null;
		int count = 0;
		int cardsForToday = 0;
		int cardsForTomorrow = 0;
		int quality0Count = 0;
		int quality1Count = 0;
		int quality2Count = 0;
		int quality3Count = 0;
		int quality4Count = 0;
		int quality5Count = 0;
		int noQualityCount = 0;
		for (ICardInfoModel cardInfoModel : nextCards) {
			DateTime next = cardInfoModel.getNext();
			if (nextCard == null && next != null && new LocalDate().plusDays(1).isAfter(next.toLocalDate())) {
				nextCard = cardInfoModel;
			}
			count++;
			Integer quality = cardInfoModel.getQuality();
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
			} else {
				noQualityCount++;
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
			this.actionData.setCardOfBoxId(nextCard.getCardOfBoxId());
			this.actionData.setContent(nextCard.getContent());
			this.actionData.setCount(nextCard.getCount());
			this.actionData.setNext(nextCard.getNext());
			this.actionData.setLast(nextCard.getLast());
			this.actionData.setQuality(nextCard.getQuality());

			ObjectMapper mapper = new ObjectMapper();
			try {
				Map<Object, Object> cardContentModel = mapper.readValue(this.actionData.getContent(), Map.class);
				this.actionData.setComplex((Boolean) cardContentModel.get("complex"));
				this.actionData.setGiven((String) cardContentModel.get("given"));
				List<Map<Object, Object>> lineList = (List<Map<Object, Object>>) cardContentModel.get("lines");
				List<ILineModel> lines = new ArrayList<ILineModel>();
				if (lineList != null) {
					for (Map<Object, Object> line : lineList) {
						List<Map<Object, Object>> wordList = (List<Map<Object, Object>>) line.get("line");
						List<String> words = new ArrayList<String>();
						for (Map<Object, Object> wordMap : wordList) {
							String word = (String) wordMap.get("word");
							words.add(word);
						}
						lines.add(new LineModel(words));
					}
				}
				this.actionData.setLines(lines);
				this.actionData.setLarge((Boolean) cardContentModel.get("large"));
				this.actionData.setWanted((String) cardContentModel.get("wanted"));
				this.actionData.setHeader((String) cardContentModel.get("header"));
			} catch (IOException e) {
				e.printStackTrace();
				throw new WebApplicationException("cannot parse " + this.actionData.getContent() + ".");
			}
		} else {
			IBoxModel box = BoxDao.selectByBoxId(this.getDatabaseHandle().getHandle(),this.actionParam.getBoxId(),
				this.actionParam.getSchema());
			this.actionData.setBoxName(box.getName());
		}

		this.actionData.setCards(count);
		this.actionData.setCardsForToday(cardsForToday);
		this.actionData.setCardsForTomorrow(cardsForTomorrow);

		int numberOfCardsWithQuality = quality0Count + quality1Count + quality2Count + quality3Count + quality4Count
				+ quality5Count + noQualityCount;
		if (numberOfCardsWithQuality > 0) {
			this.actionData.setZero((int) Math.floor((100 * quality0Count / numberOfCardsWithQuality)));
			this.actionData.setOne((int) Math.floor((100 * quality1Count / numberOfCardsWithQuality)));
			this.actionData.setTwo((int) Math.floor((100 * quality2Count / numberOfCardsWithQuality)));
			this.actionData.setThree((int) Math.floor((100 * quality3Count / numberOfCardsWithQuality)));
			this.actionData.setFour((int) Math.floor((100 * quality4Count / numberOfCardsWithQuality)));
			this.actionData.setFive((int) Math.floor((100 * quality5Count / numberOfCardsWithQuality)));
			this.actionData.setNoQuality(100 - this.actionData.getZero() - this.actionData.getOne() - this.actionData.getTwo()
					- this.actionData.getThree() - this.actionData.getFour() - this.actionData.getFive());
		}

	}

}

/* S.D.G. */

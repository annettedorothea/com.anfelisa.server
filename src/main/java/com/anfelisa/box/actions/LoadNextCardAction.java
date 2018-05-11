package com.anfelisa.box.actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.security.PermitAll;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.AppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.box.data.CardData;
import com.anfelisa.box.models.BoxDao;
import com.anfelisa.box.models.CustomScheduledCardDao;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.models.ILineModel;
import com.anfelisa.box.models.IScheduledCardModel;
import com.anfelisa.box.models.LineModel;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.dropwizard.auth.Auth;

@Path("/boxes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoadNextCardAction extends AbstractLoadNextCardAction {

	static final Logger LOG = LoggerFactory.getLogger(LoadNextCardAction.class);

	private BoxDao boxDao = new BoxDao();

	private CustomScheduledCardDao scheduledCardDao = new CustomScheduledCardDao();

	//private CardDao cardDao = new CardDao();

	public LoadNextCardAction(DBI jdbi, AppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(jdbi, appConfiguration, daoProvider, viewProvider);
	}

	@GET
	@Timed
	@Path("/next")
	@PermitAll
	public Response get(@Auth AuthUser user, @NotNull @QueryParam("uuid") String uuid,
			@NotNull @QueryParam("boxId") String boxId) throws JsonProcessingException {
		actionData = new CardData(uuid).withBoxId(boxId).withCredentialsRole(user.getRole())
				.withCredentialsUsername(user.getUsername());
		return this.apply();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void loadDataForGetRequest() {
		try {

			IBoxModel box = boxDao.selectByBoxId(this.getHandle(), this.actionData.getBoxId());
			if (!box.getUsername().equals(actionData.getCredentialsUsername())) {
				throwUnauthorized();
			}
			List<IScheduledCardModel> allCards = scheduledCardDao.selectAllCards(this.getDatabaseHandle().getHandle(),
					this.actionData.getBoxId());
			int quality0Count = 0;
			int quality1Count = 0;
			int quality2Count = 0;
			int quality3Count = 0;
			int quality4Count = 0;
			int quality5Count = 0;
			int noQualityCount = 0;
			for (IScheduledCardModel cardInfoModel : allCards) {
				Integer quality = cardInfoModel.getLastQuality();
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
			}

			List<IScheduledCardModel> todaysCards = scheduledCardDao
					.selectTodaysCards(this.getDatabaseHandle().getHandle(), this.actionData.getBoxId(), this.actionData.getSystemTime());
			if (todaysCards.size() > 0) {
				IScheduledCardModel nextCard = todaysCards.get(0);
				this.actionData.setBoxName(box.getName());
				this.actionData.setCardId(nextCard.getCardId());
				this.actionData.setCardOfBoxId(nextCard.getScheduledCardId());
				//ICardModel card = cardDao.selectByCardId(this.getHandle(), nextCard.getCardId());
				//this.actionData.setContent(card.getContent());
				this.actionData.setCount(nextCard.getCount());
				this.actionData.setNext(nextCard.getScheduledDate());
				this.actionData.setLast(nextCard.getTimestamp());
				this.actionData.setQuality(nextCard.getLastQuality());

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
				this.actionData.setBoxName(box.getName());
			}

			this.actionData.setCards(allCards.size());
			this.actionData.setCardsForToday(todaysCards.size());
			List<IScheduledCardModel> tomorrowsCards = scheduledCardDao
					.selectTomorrowsCards(this.getDatabaseHandle().getHandle(), this.actionData.getBoxId(), this.actionData.getSystemTime());
			this.actionData.setCardsForTomorrow(tomorrowsCards.size());
			List<IScheduledCardModel> cardsToBeReinforced = scheduledCardDao
					.selectReinforceCards(this.getDatabaseHandle().getHandle(), this.actionData.getBoxId(), this.actionData.getSystemTime());
			this.actionData.setCardsToBeReinforced(cardsToBeReinforced.size());

			int numberOfCardsWithQuality = quality0Count + quality1Count + quality2Count + quality3Count + quality4Count
					+ quality5Count + noQualityCount;
			if (numberOfCardsWithQuality > 0) {
				this.actionData.setZero((int) Math.floor((100 * quality0Count / numberOfCardsWithQuality)));
				this.actionData.setOne((int) Math.floor((100 * quality1Count / numberOfCardsWithQuality)));
				this.actionData.setTwo((int) Math.floor((100 * quality2Count / numberOfCardsWithQuality)));
				this.actionData.setThree((int) Math.floor((100 * quality3Count / numberOfCardsWithQuality)));
				this.actionData.setFour((int) Math.floor((100 * quality4Count / numberOfCardsWithQuality)));
				this.actionData.setFive((int) Math.floor((100 * quality5Count / numberOfCardsWithQuality)));
				this.actionData.setNoQuality(
						100 - this.actionData.getZero() - this.actionData.getOne() - this.actionData.getTwo()
								- this.actionData.getThree() - this.actionData.getFour() - this.actionData.getFive());
			}

			IScheduledCardModel firstScheduledCard = this.scheduledCardDao.selectFirstScheduledCard(getHandle(),
					actionData.getBoxId());
			if (firstScheduledCard != null) {
				LocalDate date = firstScheduledCard.getScheduledDate().toLocalDate();
				LocalDate now = new DateTime().toLocalDate();
				if (date.isBefore(now)) {
					this.actionData.setDaysBehind(Days.daysBetween(date, now).getDays());
				}
			}
		} catch (Exception e) {
			this.throwInternalServerError(e);
		}
	}
}

/* S.D.G. */

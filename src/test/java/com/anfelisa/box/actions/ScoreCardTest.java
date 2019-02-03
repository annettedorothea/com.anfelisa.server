package com.anfelisa.box.actions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.anfelisa.ace.ITimelineItem;
import com.anfelisa.auth.Roles;
import com.anfelisa.box.data.BoxData;
import com.anfelisa.box.data.IBoxData;
import com.anfelisa.box.data.IScheduleNextCardData;
import com.anfelisa.box.data.ScheduleNextCardData;
import com.anfelisa.box.models.IScheduledCardModel;
import com.anfelisa.box.models.ScheduledCardModel;
import com.anfelisa.card.data.CardCreationData;
import com.anfelisa.card.data.ICardCreationData;
import com.anfelisa.category.data.CategoryCreationData;
import com.anfelisa.category.data.ICategoryCreationData;
import com.anfelisa.test.BaseTest;
import com.anfelisa.user.models.IUserModel;
import com.anfelisa.user.models.UserModel;
import com.fasterxml.jackson.core.JsonProcessingException;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.converters.Nullable;

@RunWith(JUnitParamsRunner.class)
public class ScoreCardTest extends BaseTest {

	@Test
	@Parameters({ 
		"null, 0, 2.5, 1, 1", 
		"null, 1, 2.5, 1, 1", 
		"null, 2, 2.5, 1, 1", 
		"null, 3, 2.36, 2, 6",
		"null, 4, 2.5, 2, 6", 
		"null, 5, 2.6, 2, 6", 
		"4, 0, 2.5, 1, 1", 
		"4, 1, 2.5, 1, 1", 
		"4, 2, 2.5, 1, 1",
		"4, 3, 2.36, 2, 4", 
		"4, 4, 2.5, 2, 4", 
		"4, 5, 2.6, 2, 4" 
	})
	public void returnsOK(@Nullable Integer maxInterval, int scoredCardQuality, float expectedEf, int expectedN,
			int expectedInterval) throws JsonProcessingException {
		IUserModel user = createTestUser();
		ICategoryCreationData category = createTestCategory(user);
		ICardCreationData card = createCard(category, 1);
		IBoxData box = createBox(user, category, maxInterval, null);
		IScheduleNextCardData scheduleNextCardData = createScheduleNextCard(user, box, card,
				new DateTime(2019, 1, 23, 15, 0, 0));

		List<ITimelineItem> timeline = registerUserTimeline(user);
		timeline.add(com.anfelisa.category.TestUtils.createCreateCategoryRootEventTimelineItem(category));
		timeline.add(com.anfelisa.card.TestUtils.createCreateCardOkEventTimelineItem(card));
		timeline.add(com.anfelisa.box.TestUtils.createCreateBoxOkEventTimelineItem(box));
		timeline.add(com.anfelisa.box.TestUtils.createScheduleNextCardOkEventTimelineItem(scheduleNextCardData));
		prepare(timeline, DROPWIZARD.getLocalPort());

		DateTime systemTime = new DateTime(2019, 1, 23, 15, 0, 0);
		setSystemTime(systemTime, DROPWIZARD.getLocalPort());

		String uuid = randomUUID();
		Response response = com.anfelisa.box.ActionCalls.callScoreCard(uuid, scheduleNextCardData.getScheduledCardId(),
				box.getBoxId(), scoredCardQuality, DROPWIZARD.getLocalPort(), getAuthenticationHeader(user));

		assertThat(response.getStatus(), is(Response.Status.OK.getStatusCode()));

		IScheduledCardModel updatedScheduleCard = daoProvider.getScheduledCardDao().selectByScheduledCardId(handle,
				scheduleNextCardData.getScheduledCardId());
		ScheduledCardModel expectedUpdatedScheduleCard = new ScheduledCardModel();
		expectedUpdatedScheduleCard.setBoxId(box.getBoxId());
		expectedUpdatedScheduleCard.setCardId(card.getCardId());
		expectedUpdatedScheduleCard.setCount(0);
		expectedUpdatedScheduleCard.setCreatedDate(scheduleNextCardData.getCreatedDate());
		expectedUpdatedScheduleCard.setEf(2.5F);
		expectedUpdatedScheduleCard.setInterval(1);
		expectedUpdatedScheduleCard.setLastQuality(null);
		expectedUpdatedScheduleCard.setN(1);
		expectedUpdatedScheduleCard.setQuality(scoredCardQuality);
		expectedUpdatedScheduleCard.setScheduledCardId(updatedScheduleCard.getScheduledCardId());
		expectedUpdatedScheduleCard.setScheduledDate(systemTime);
		expectedUpdatedScheduleCard.setScoredDate(systemTime);
		
		List<String> differingAttributs = expectedUpdatedScheduleCard.equalsPrimitiveTypes(updatedScheduleCard);
		assertThat(differingAttributs, is(new ArrayList<String>()));

		IScheduledCardModel insertedScheduleCard = daoProvider.getScheduledCardDao().selectByScheduledCardId(handle,
				uuid);
		ScheduledCardModel expectedInsertedScheduleCard = new ScheduledCardModel();
		expectedInsertedScheduleCard.setBoxId(box.getBoxId());
		expectedInsertedScheduleCard.setCardId(card.getCardId());
		expectedInsertedScheduleCard.setCount(1);
		expectedInsertedScheduleCard.setCreatedDate(systemTime);
		expectedInsertedScheduleCard.setEf(expectedEf);
		expectedInsertedScheduleCard.setInterval(expectedInterval);
		expectedInsertedScheduleCard.setLastQuality(scoredCardQuality);
		expectedInsertedScheduleCard.setN(expectedN);
		expectedInsertedScheduleCard.setQuality(null);
		expectedInsertedScheduleCard.setScheduledCardId(uuid);
		expectedInsertedScheduleCard.setScheduledDate(systemTime.plusDays(expectedInterval));// changes
		expectedInsertedScheduleCard.setScoredDate(null);

		differingAttributs = expectedInsertedScheduleCard.equalsPrimitiveTypes(insertedScheduleCard);
		assertThat(differingAttributs, is(new ArrayList<String>()));
	}

	@Test
	@Parameters({ 
		"null, null, 4, 6, 6", 
		"3, null, 4, 3, 3", 
		"null, 4, 4, 6, 7", 
		"3, 4, 4, 3, 4"
	})
	public void maxCardsPerDay(@Nullable Integer maxInterval, @Nullable Integer maxCardsPerDay, int cardCount,
			int createCardsInDays, int expectedInterval) throws JsonProcessingException {
		DateTime systemTime = new DateTime(2019, 1, 23, 15, 0, 0);

		IUserModel user = createTestUser();
		ICategoryCreationData category = createTestCategory(user);
		ICardCreationData card = createCard(category, 1);
		IBoxData box = createBox(user, category, maxInterval, maxCardsPerDay);
		IScheduleNextCardData scheduleNextCardData = createScheduleNextCard(user, box, card,
				new DateTime(2019, 1, 23, 15, 0, 0));

		List<ITimelineItem> timeline = registerUserTimeline(user);
		timeline.add(com.anfelisa.category.TestUtils.createCreateCategoryRootEventTimelineItem(category));
		timeline.add(com.anfelisa.card.TestUtils.createCreateCardOkEventTimelineItem(card));
		timeline.add(com.anfelisa.box.TestUtils.createCreateBoxOkEventTimelineItem(box));
		timeline.add(com.anfelisa.box.TestUtils.createScheduleNextCardOkEventTimelineItem(scheduleNextCardData));
		for (int i = 0; i < cardCount; i++) {
			timeline.add(com.anfelisa.box.TestUtils.createScheduleNextCardOkEventTimelineItem(
					createScheduleNextCard(user, box, card, systemTime.plusDays(createCardsInDays))));
		}
		prepare(timeline, DROPWIZARD.getLocalPort());

		setSystemTime(systemTime, DROPWIZARD.getLocalPort());

		String uuid = randomUUID();
		Response response = com.anfelisa.box.ActionCalls.callScoreCard(uuid, scheduleNextCardData.getScheduledCardId(),
				box.getBoxId(), 5, DROPWIZARD.getLocalPort(), getAuthenticationHeader(user));

		assertThat(response.getStatus(), is(Response.Status.OK.getStatusCode()));

		IScheduledCardModel insertedScheduleCard = daoProvider.getScheduledCardDao().selectByScheduledCardId(handle,
				uuid);

		assertThat(insertedScheduleCard.getInterval(), is(expectedInterval));
	}

	private IUserModel createTestUser() {
		return new UserModel(randomUUID(), "test-user", "password", "info@anfelisa.de", Roles.STUDENT, false);
	}

	private ICategoryCreationData createTestCategory(IUserModel user) {
		ICategoryCreationData category = new CategoryCreationData(randomUUID());
		category.setCategoryId(category.getUuid());
		category.setCategoryIndex(0);
		category.setCategoryName("cat");
		category.setParentCategoryId(category.getCategoryId());
		category.setCategoryAuthor("author");
		category.setUserId(user.getUserId());
		return category;
	}

	private ICardCreationData createCard(ICategoryCreationData category, int index) {
		ICardCreationData card = new CardCreationData(randomUUID());
		card.setCardId(card.getUuid());
		card.setCardIndex(index);
		card.setCategoryId(category.getCategoryId());
		card.setRootCategoryId(category.getCategoryId());
		card.setCardAuthor("author");
		return card;
	}

	private IBoxData createBox(IUserModel user, ICategoryCreationData category, Integer maxInterval,
			Integer maxCardsPerDay) {
		IBoxData box = new BoxData(randomUUID());
		box.setBoxId(box.getUuid());
		box.setCategoryId(category.getCategoryId());
		box.setUserId(user.getUserId());
		box.setMaxInterval(maxInterval);
		box.setMaxCardsPerDay(maxCardsPerDay);
		return box;
	}

	private IScheduleNextCardData createScheduleNextCard(IUserModel user, IBoxData box, ICardCreationData card,
			DateTime scheduledDate) {
		IScheduleNextCardData scheduleNextCardData = new ScheduleNextCardData(randomUUID());
		scheduleNextCardData.setBoxId(box.getBoxId());
		scheduleNextCardData.setUserId(user.getUserId());
		scheduleNextCardData.setCardId(card.getCardId());
		scheduleNextCardData.setCount(0);
		scheduleNextCardData.setCreatedDate(new DateTime(2019, 1, 23, 14, 0, 0));
		scheduleNextCardData.setEf(2.5F);
		scheduleNextCardData.setInterval(1);
		scheduleNextCardData.setLastQuality(null);
		scheduleNextCardData.setN(1);
		scheduleNextCardData.setScheduledDate(scheduledDate);
		scheduleNextCardData.setScheduledCardId(scheduleNextCardData.getUuid());
		return scheduleNextCardData;
	}

}

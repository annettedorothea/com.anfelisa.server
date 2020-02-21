/* 
 * Copyright (c) 2019, Annette Pohl, Koblenz, Germany
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.

 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */

package com.anfelisa.box.scenarios;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.Test;

import com.anfelisa.ace.BaseScenario;
import com.anfelisa.ace.ITimelineItem;
import com.anfelisa.box.ActionCalls;

@SuppressWarnings("unused")
public class InitMyBoxesForDayRemoveOutdatedReinforceCardsScenarioW extends BaseScenario {

	private void given() throws Exception {
		List<ITimelineItem> timeline = new ArrayList<>();

		com.anfelisa.user.data.UserRegistrationData userRegistration0 = new com.anfelisa.user.data.UserRegistrationData(
				randomUUID());
		userRegistration0.setEmail("Annette@anfelisa.de");
		userRegistration0.setLanguage("de");
		userRegistration0.setPassword("2e3817293fc275dbee74bd71ce6eb056");
		userRegistration0.setToken("token");
		userRegistration0.setUsername("Annette");
		userRegistration0.setUserId("userid");
		userRegistration0.setRole("STUDENT");
		timeline.add(com.anfelisa.user.TestUtils.createRegisterUserOkEventTimelineItem(userRegistration0));

		com.anfelisa.user.data.ConfirmEmailData confirmEmail1 = new com.anfelisa.user.data.ConfirmEmailData(
				randomUUID());
		confirmEmail1.setToken("token");
		confirmEmail1.setUsername("Annette");
		confirmEmail1.setUserId("userid");
		timeline.add(com.anfelisa.user.TestUtils.createConfirmEmailOkEventTimelineItem(confirmEmail1));

		com.anfelisa.category.data.CategoryCreationData categoryCreation2 = new com.anfelisa.category.data.CategoryCreationData(
				randomUUID());
		categoryCreation2.setCategoryAuthor("Annette");
		categoryCreation2.setCategoryId("catid");
		categoryCreation2.setCategoryIndex(1);
		categoryCreation2.setCategoryName("root");
		categoryCreation2.setRootCategoryId("catid");
		categoryCreation2.setUserId("userid");
		categoryCreation2.setUsername("Annette");
		//timeline.add(com.anfelisa.category.TestUtils.createCreateCategoryRootEventTimelineItem(categoryCreation2));

		com.anfelisa.card.data.CardCreationData cardCreation3 = new com.anfelisa.card.data.CardCreationData(randomUUID());
		cardCreation3.setCardAuthor("test");
		cardCreation3.setCardId("cardid");
		cardCreation3.setCardIndex(1);
		cardCreation3.setCategoryId("catid");
		cardCreation3.setGiven("given");
		cardCreation3.setRootCategoryId("catid");
		cardCreation3.setUserId("userid");
		cardCreation3.setUsername("test");
		cardCreation3.setWanted("wanted");
		timeline.add(com.anfelisa.card.TestUtils.createCreateCardOkEventTimelineItem(cardCreation3));
		
		com.anfelisa.box.data.ScheduledCardsData scheduledCards5 = new com.anfelisa.box.data.ScheduledCardsData(randomUUID());
		List<com.anfelisa.box.models.IScheduledCardModel> scheduledCards5NewScheduledCards = new ArrayList<com.anfelisa.box.models.IScheduledCardModel>();
		com.anfelisa.box.models.IScheduledCardModel scheduledCards5NewScheduledCards0 = new com.anfelisa.box.models.ScheduledCardModel();
		scheduledCards5NewScheduledCards0.setCardId("cardid");
		scheduledCards5NewScheduledCards0.setScheduledCardId("scid");
		scheduledCards5NewScheduledCards0.setBoxId("boxid");
		scheduledCards5NewScheduledCards0.setCreatedDate(DateTime.parse("12.02.2020 14:00:00", DateTimeFormat.forPattern("dd.MM.yyyy HH:mm:ss")));
		scheduledCards5NewScheduledCards0.setScheduledDate(DateTime.parse("12.02.2020 14:00:00", DateTimeFormat.forPattern("dd.MM.yyyy HH:mm:ss")));
		scheduledCards5NewScheduledCards0.setBoxId("boxid");
		scheduledCards5NewScheduledCards.add(scheduledCards5NewScheduledCards0);
		scheduledCards5.setNewScheduledCards(scheduledCards5NewScheduledCards);
		scheduledCards5NewScheduledCards0.setEf(1F);
		scheduledCards5NewScheduledCards0.setN(1);
		scheduledCards5NewScheduledCards0.setCount(1);
		scheduledCards5.setExistingScheduledCardIds(new ArrayList<String>());
		timeline.add(com.anfelisa.box.TestUtils.createScheduleCardsOkEventTimelineItem(scheduledCards5));

		prepare(timeline, DROPWIZARD.getLocalPort());
	}

	private Response when() throws Exception {
		return ActionCalls.callScoreCard(randomUUID(), "scid", "boxid", 4, DROPWIZARD.getLocalPort(), authorization("Annette", "2e3817293fc275dbee74bd71ce6eb056"));
	}

	private void then(Response response) throws Exception {
		//assertThat(response.getStatus(), is(200));

	}

	@Test
	public void initMyBoxesForDayRemoveOutdatedReinforceCards() throws Exception {
		given();

		Response response = when();

		then(response);
	}

}

/******* S.D.G. *******/

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




package com.anfelisa.box.getboxes.scenarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.Response;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;

import org.junit.Test;

import de.acegen.BaseScenario;
import de.acegen.ITimelineItem;
import de.acegen.NotReplayableDataProvider;

@SuppressWarnings("unused")
public abstract class AbstractGetBoxesScenario extends BaseScenario {

	private void given() throws Exception {
		NotReplayableDataProvider.put("token", this.templateStringValue("TOKEN", null));
		com.anfelisa.user.data.UserRegistrationData registerUser0 = new com.anfelisa.user.data.UserRegistrationData("uuid");
		registerUser0.setEmail(this.templateStringValue("annette.pohl@anfelisa.de", 0));
		registerUser0.setLanguage(this.templateStringValue("de", 0));
		registerUser0.setPassword(this.templateStringValue("password", 0));
		registerUser0.setUsername(this.templateStringValue("Annette", 0));
		registerUser0.setToken(this.templateStringValue("TOKEN", 0));
		
		
		com.anfelisa.user.ActionCalls.callRegisterUser(registerUser0, DROPWIZARD.getLocalPort());
		

		com.anfelisa.box.data.BoxCreationData createBox1 = new com.anfelisa.box.data.BoxCreationData("boxId");
		createBox1.setCategoryName(this.templateStringValue("cat", 1));
		createBox1.setDictionaryLookup(new Boolean("false"));
		createBox1.setMaxCardsPerDay(1);
		
		
		com.anfelisa.box.ActionCalls.callCreateBox(createBox1, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		com.anfelisa.category.data.CategoryCreationData createCategory2 = new com.anfelisa.category.data.CategoryCreationData("cat1");
		createCategory2.setCategoryName(this.templateStringValue("level 1 #1", 2));
		createCategory2.setParentCategoryId(this.templateStringValue("boxId", 2));
		
		
		com.anfelisa.category.ActionCalls.callCreateCategory(createCategory2, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		com.anfelisa.card.data.CardCreationData createCard3 = new com.anfelisa.card.data.CardCreationData("c1");
		createCard3.setCategoryId(this.templateStringValue("cat1", 3));
		createCard3.setGiven(this.templateStringValue("given", 3));
		createCard3.setImage(this.templateStringValue("image", 3));
		createCard3.setWanted(this.templateStringValue("wanted", 3));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard3, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		com.anfelisa.card.data.CardCreationData createCard4 = new com.anfelisa.card.data.CardCreationData("c2");
		createCard4.setCategoryId(this.templateStringValue("cat1", 4));
		createCard4.setGiven(this.templateStringValue("given2", 4));
		createCard4.setImage(this.templateStringValue("image2", 4));
		createCard4.setWanted(this.templateStringValue("wanted2", 4));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard4, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		com.anfelisa.card.data.CardCreationData createCard5 = new com.anfelisa.card.data.CardCreationData("c3");
		createCard5.setCategoryId(this.templateStringValue("cat1", 5));
		createCard5.setGiven(this.templateStringValue("3given", 5));
		createCard5.setWanted(this.templateStringValue("3wanted", 5));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard5, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		com.anfelisa.card.data.CardCreationData createCard6 = new com.anfelisa.card.data.CardCreationData("c4");
		createCard6.setCategoryId(this.templateStringValue("cat1", 6));
		createCard6.setGiven(this.templateStringValue("4given4", 6));
		createCard6.setWanted(this.templateStringValue("4wanted4", 6));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard6, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		com.anfelisa.card.data.CardCreationData createCard7 = new com.anfelisa.card.data.CardCreationData("c5");
		createCard7.setCategoryId(this.templateStringValue("cat1", 7));
		createCard7.setGiven(this.templateStringValue("different", 7));
		createCard7.setWanted(this.templateStringValue("different", 7));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard7, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		NotReplayableDataProvider.setSystemTime(DateTime.parse("20200416 10:30", DateTimeFormat.forPattern("yyyyMMdd HH:mm")).withZone(DateTimeZone.UTC));
		com.anfelisa.box.data.ScheduledCardsData scheduleCards8 = new com.anfelisa.box.data.ScheduledCardsData("sc1");
		
			List<String> scheduleCards8CardIds = new ArrayList<String>();
			scheduleCards8CardIds.add("c1");
		
			scheduleCards8CardIds.add("c3");
		
			scheduleCards8CardIds.add("c4");
		
			
		scheduleCards8.setCardIds(scheduleCards8CardIds);
		
		
		com.anfelisa.box.ActionCalls.callScheduleCards(scheduleCards8, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		NotReplayableDataProvider.setSystemTime(DateTime.parse("20200418 16:30", DateTimeFormat.forPattern("yyyyMMdd HH:mm")).withZone(DateTimeZone.UTC));
		com.anfelisa.box.data.ScoreCardData scoreCard9 = new com.anfelisa.box.data.ScoreCardData("score0");
		scoreCard9.setBoxId(this.templateStringValue("boxId", 9));
		scoreCard9.setScoredCardQuality(0);
		scoreCard9.setScoredCardScheduledCardId(this.templateStringValue("c1-sc1", 9));
		
		
		com.anfelisa.box.ActionCalls.callScoreCard(scoreCard9, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		NotReplayableDataProvider.setSystemTime(DateTime.parse("20200416 10:30", DateTimeFormat.forPattern("yyyyMMdd HH:mm")).withZone(DateTimeZone.UTC));
		com.anfelisa.box.data.ScheduledCardsData scheduleCards10 = new com.anfelisa.box.data.ScheduledCardsData("sc1");
		
			List<String> scheduleCards10CardIds = new ArrayList<String>();
			scheduleCards10CardIds.add("c1");
		
			scheduleCards10CardIds.add("c3");
		
			scheduleCards10CardIds.add("c4");
		
			
		scheduleCards10.setCardIds(scheduleCards10CardIds);
		
		
		com.anfelisa.box.ActionCalls.callScheduleCards(scheduleCards10, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		NotReplayableDataProvider.setSystemTime(DateTime.parse("20200418 16:30", DateTimeFormat.forPattern("yyyyMMdd HH:mm")).withZone(DateTimeZone.UTC));
		com.anfelisa.box.data.ScoreCardData scoreCard11 = new com.anfelisa.box.data.ScoreCardData("score1");
		scoreCard11.setBoxId(this.templateStringValue("boxId", 11));
		scoreCard11.setScoredCardQuality(1);
		scoreCard11.setScoredCardScheduledCardId(this.templateStringValue("c3-sc1", 11));
		
		
		com.anfelisa.box.ActionCalls.callScoreCard(scoreCard11, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		NotReplayableDataProvider.setSystemTime(DateTime.parse("20200416 10:30", DateTimeFormat.forPattern("yyyyMMdd HH:mm")).withZone(DateTimeZone.UTC));
		com.anfelisa.box.data.ScheduledCardsData scheduleCards12 = new com.anfelisa.box.data.ScheduledCardsData("sc1");
		
			List<String> scheduleCards12CardIds = new ArrayList<String>();
			scheduleCards12CardIds.add("c1");
		
			scheduleCards12CardIds.add("c3");
		
			scheduleCards12CardIds.add("c4");
		
			
		scheduleCards12.setCardIds(scheduleCards12CardIds);
		
		
		com.anfelisa.box.ActionCalls.callScheduleCards(scheduleCards12, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		NotReplayableDataProvider.setSystemTime(DateTime.parse("20200418 16:30", DateTimeFormat.forPattern("yyyyMMdd HH:mm")).withZone(DateTimeZone.UTC));
		com.anfelisa.box.data.ScoreCardData scoreCard13 = new com.anfelisa.box.data.ScoreCardData("score5");
		scoreCard13.setBoxId(this.templateStringValue("boxId", 13));
		scoreCard13.setScoredCardQuality(5);
		scoreCard13.setScoredCardScheduledCardId(this.templateStringValue("c4-sc1", 13));
		
		
		com.anfelisa.box.ActionCalls.callScoreCard(scoreCard13, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

	}
	
	private Response when() throws Exception {
		com.anfelisa.box.data.BoxListData getBoxes0 = new com.anfelisa.box.data.BoxListData(randomUUID());
		getBoxes0.setToday(DateTime.parse("20200420 18:30", DateTimeFormat.forPattern("yyyyMMdd HH:mm")).withZone(DateTimeZone.UTC));
		
		
		return 
		com.anfelisa.box.ActionCalls.callGetBoxes(getBoxes0, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
	}
	
	private com.anfelisa.box.data.GetBoxesResponse then(Response response) throws Exception {
		assertThat(response.getStatus(), 200);
		
		com.anfelisa.box.data.GetBoxesResponse actual = null;
		try {
			actual = response.readEntity(com.anfelisa.box.data.GetBoxesResponse.class);
		} catch (Exception x) {
		}
		com.anfelisa.box.data.BoxListData expectedData = new com.anfelisa.box.data.BoxListData(randomUUID());
		
			List<com.anfelisa.box.models.IBoxViewModel> expectedDataBoxList = new ArrayList<com.anfelisa.box.models.IBoxViewModel>();
			com.anfelisa.box.models.IBoxViewModel item1 = new com.anfelisa.box.models.BoxViewModel();
			item1.setAllTodaysCards(3);
			item1.setBoxId(this.templateStringValue("boxId", null));
			item1.setCategoryId(this.templateStringValue("cat1", null));
			item1.setCategoryName(this.templateStringValue("", null));
			item1.setOpenTodaysCards(3);
			item1.setQuality0Count(1);
			item1.setQuality1Count(1);
			item1.setQuality2Count(0);
			item1.setQuality3Count(0);
			item1.setQuality4Count(0);
			item1.setQuality5Count(1);
			expectedDataBoxList.add(item1);
		
			
		expectedData.setBoxList(expectedDataBoxList);
		
		
		com.anfelisa.box.data.GetBoxesResponse expected = new com.anfelisa.box.data.GetBoxesResponse(expectedData);


		assertThat(actual, expected);
			
			return actual;
				}
				
				@Test
				public void getBoxes() throws Exception {
					given();
					
					Response response = when();
			
					com.anfelisa.box.data.GetBoxesResponse actualResponse = then(response);
					
					verifications(actualResponse);
			}
			
			protected abstract void verifications(com.anfelisa.box.data.GetBoxesResponse response);
			
			}
			
			
			
			
			/******* S.D.G. *******/
			
			
			

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




package com.anfelisa.box.scorecard.scenarios;

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
public abstract class AbstractScoreCard33Scenario extends BaseScenario {

	private void given() throws Exception {
		NotReplayableDataProvider.put("token", this.templateStringValue("TOKEN", null));
		com.anfelisa.user.data.UserRegistrationTestData registerUser0 = new com.anfelisa.user.data.UserRegistrationTestData("uuid");
		registerUser0.setEmail(this.templateStringValue("annette.pohl@anfelisa.de", 0));
		registerUser0.setLanguage(this.templateStringValue("de", 0));
		registerUser0.setPassword(this.templateStringValue("password", 0));
		registerUser0.setUsername(this.templateStringValue("Annette", 0));
		registerUser0.setToken(this.templateStringValue("TOKEN", 0));
		
		
		com.anfelisa.user.ActionCalls.callRegisterUser(registerUser0, DROPWIZARD.getLocalPort());
		

		com.anfelisa.box.data.BoxCreationTestData createBox1 = new com.anfelisa.box.data.BoxCreationTestData("boxId");
		createBox1.setCategoryName(this.templateStringValue("cat", 1));
		createBox1.setDictionaryLookup(new Boolean("false"));
		createBox1.setMaxCardsPerDay(1);
		
		
		com.anfelisa.box.ActionCalls.callCreateBox(createBox1, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		com.anfelisa.category.data.CategoryCreationTestData createCategory2 = new com.anfelisa.category.data.CategoryCreationTestData("cat1");
		createCategory2.setCategoryName(this.templateStringValue("level 1 #1", 2));
		createCategory2.setParentCategoryId(this.templateStringValue("boxId", 2));
		
		
		com.anfelisa.category.ActionCalls.callCreateCategory(createCategory2, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		com.anfelisa.card.data.CardCreationTestData createCard3 = new com.anfelisa.card.data.CardCreationTestData("c1");
		createCard3.setCategoryId(this.templateStringValue("cat1", 3));
		createCard3.setGiven(this.templateStringValue("given", 3));
		createCard3.setImage(this.templateStringValue("image", 3));
		createCard3.setWanted(this.templateStringValue("wanted", 3));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard3, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		com.anfelisa.card.data.CardCreationTestData createCard4 = new com.anfelisa.card.data.CardCreationTestData("c2");
		createCard4.setCategoryId(this.templateStringValue("cat1", 4));
		createCard4.setGiven(this.templateStringValue("given2", 4));
		createCard4.setImage(this.templateStringValue("image2", 4));
		createCard4.setWanted(this.templateStringValue("wanted2", 4));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard4, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		com.anfelisa.card.data.CardCreationTestData createCard5 = new com.anfelisa.card.data.CardCreationTestData("c3");
		createCard5.setCategoryId(this.templateStringValue("cat1", 5));
		createCard5.setGiven(this.templateStringValue("3given", 5));
		createCard5.setWanted(this.templateStringValue("3wanted", 5));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard5, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		com.anfelisa.card.data.CardCreationTestData createCard6 = new com.anfelisa.card.data.CardCreationTestData("c4");
		createCard6.setCategoryId(this.templateStringValue("cat1", 6));
		createCard6.setGiven(this.templateStringValue("4given4", 6));
		createCard6.setWanted(this.templateStringValue("4wanted4", 6));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard6, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		com.anfelisa.card.data.CardCreationTestData createCard7 = new com.anfelisa.card.data.CardCreationTestData("c5");
		createCard7.setCategoryId(this.templateStringValue("cat1", 7));
		createCard7.setGiven(this.templateStringValue("different", 7));
		createCard7.setWanted(this.templateStringValue("different", 7));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard7, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		NotReplayableDataProvider.setSystemTime(DateTime.parse("20200416 10:30", DateTimeFormat.forPattern("yyyyMMdd HH:mm")).withZone(DateTimeZone.UTC));
		com.anfelisa.box.data.ScheduledCardsTestData scheduleCards8 = new com.anfelisa.box.data.ScheduledCardsTestData("sc1");
		
			List<String> scheduleCards8CardIds = new ArrayList<String>();
			scheduleCards8CardIds.add("c1");
		
			scheduleCards8CardIds.add("c3");
		
			scheduleCards8CardIds.add("c4");
		
			
		scheduleCards8.setCardIds(scheduleCards8CardIds);
		
		
		com.anfelisa.box.ActionCalls.callScheduleCards(scheduleCards8, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		NotReplayableDataProvider.setSystemTime(DateTime.parse("20200418 16:30", DateTimeFormat.forPattern("yyyyMMdd HH:mm")).withZone(DateTimeZone.UTC));
		com.anfelisa.box.data.ScoreCardTestData scoreCard9 = new com.anfelisa.box.data.ScoreCardTestData("score3");
		scoreCard9.setBoxId(this.templateStringValue("boxId", 9));
		scoreCard9.setScoredCardQuality(3);
		scoreCard9.setScoredCardScheduledCardId(this.templateStringValue("c1-sc1", 9));
		
		
		com.anfelisa.box.ActionCalls.callScoreCard(scoreCard9, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		com.anfelisa.box.data.BoxCreationTestData createBox10 = new com.anfelisa.box.data.BoxCreationTestData("boxId");
		createBox10.setCategoryName(this.templateStringValue("cat", 10));
		createBox10.setDictionaryLookup(new Boolean("false"));
		createBox10.setMaxCardsPerDay(1);
		
		
		com.anfelisa.box.ActionCalls.callCreateBox(createBox10, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		com.anfelisa.box.data.BoxUpdateTestData updateBox11 = new com.anfelisa.box.data.BoxUpdateTestData(randomUUID());
		updateBox11.setBoxId(this.templateStringValue("boxId", 11));
		updateBox11.setCategoryId(this.templateStringValue("boxId", 11));
		updateBox11.setCategoryName(this.templateStringValue("changed", 11));
		updateBox11.setDictionaryLookup(new Boolean("false"));
		updateBox11.setMaxCardsPerDay(11);
		updateBox11.setMaxInterval(90);
		
		
		com.anfelisa.box.ActionCalls.callUpdateBox(updateBox11, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		NotReplayableDataProvider.setSystemTime(DateTime.parse("20200425 16:30", DateTimeFormat.forPattern("yyyyMMdd HH:mm")).withZone(DateTimeZone.UTC));
		com.anfelisa.box.data.ScoreCardTestData scoreCard12 = new com.anfelisa.box.data.ScoreCardTestData("score31");
		scoreCard12.setBoxId(this.templateStringValue("boxId", 12));
		scoreCard12.setScoredCardQuality(3);
		scoreCard12.setScoredCardScheduledCardId(this.templateStringValue("score3", 12));
		
		
		com.anfelisa.box.ActionCalls.callScoreCard(scoreCard12, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		NotReplayableDataProvider.setSystemTime(DateTime.parse("20200515 16:30", DateTimeFormat.forPattern("yyyyMMdd HH:mm")).withZone(DateTimeZone.UTC));
		com.anfelisa.box.data.ScoreCardTestData scoreCard13 = new com.anfelisa.box.data.ScoreCardTestData("score32");
		scoreCard13.setBoxId(this.templateStringValue("boxId", 13));
		scoreCard13.setScoredCardQuality(3);
		scoreCard13.setScoredCardScheduledCardId(this.templateStringValue("score31", 13));
		
		
		com.anfelisa.box.ActionCalls.callScoreCard(scoreCard13, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

	}
	
	private Response when() throws Exception {
		NotReplayableDataProvider.setSystemTime(DateTime.parse("20200615 16:30", DateTimeFormat.forPattern("yyyyMMdd HH:mm")).withZone(DateTimeZone.UTC));
		com.anfelisa.box.data.ScoreCardTestData scoreCard0 = new com.anfelisa.box.data.ScoreCardTestData("score33");
		scoreCard0.setBoxId(this.templateStringValue("boxId", 0));
		scoreCard0.setScoredCardQuality(4);
		scoreCard0.setScoredCardScheduledCardId(this.templateStringValue("score32", 0));
		
		
		return 
		com.anfelisa.box.ActionCalls.callScoreCard(scoreCard0, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
	}
	
	private void then(Response response) throws Exception {
		assertThat(response.getStatus(), 200);
		
			
				}
				
				@Test
				public void scoreCard33() throws Exception {
					given();
					
					Response response = when();
			
					then(response);
					
					verifications();
			}
			
			protected abstract void verifications();
			
			}
			
			
			
			
			/******* S.D.G. *******/
			
			
			

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




package com.anfelisa.box.loadnextcard.scenarios;

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
public abstract class AbstractLoadNextCardSecondReinforceScoredScenario extends BaseScenario {

	private void given() throws Exception {
		Response response;
		NotReplayableDataProvider.put("token", objectMapper.readValue("\"TOKEN\"",
				 String.class));
		response = 
		com.anfelisa.user.ActionCalls.callRegisterUser(objectMapper.readValue("{" +
			"\"uuid\" : \"uuid\"," + 
				"\"email\" : \"annette.pohl@anfelisa.de\"," + 
				"\"language\" : \"de\"," + 
				"\"password\" : \"password\"," + 
				"\"username\" : \"Annette\"} ",
		com.anfelisa.user.data.UserRegistrationData.class)
		
		, DROPWIZARD.getLocalPort());
		
		if (response.getStatus() >= 400) {
			String message = "GIVEN RegisterUser fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		

		response = 
		com.anfelisa.box.ActionCalls.callCreateBox(objectMapper.readValue("{" +
			"\"uuid\" : \"boxId\"," + 
				"\"categoryName\" : \"cat\"," + 
				"\"dictionaryLookup\" : false," + 
				"\"maxCardsPerDay\" : 10} ",
		com.anfelisa.box.data.BoxCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() >= 400) {
			String message = "GIVEN CreateBox fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		

		response = 
		com.anfelisa.category.ActionCalls.callCreateCategory(objectMapper.readValue("{" +
			"\"uuid\" : \"cat1\"," + 
				"\"categoryName\" : \"level 1 #1\"," + 
				"\"parentCategoryId\" : \"boxId\"} ",
		com.anfelisa.category.data.CategoryCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() >= 400) {
			String message = "GIVEN CreateCategory fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		

		response = 
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"c1\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"given\"," + 
				"\"image\" : \"image\"," + 
				"\"wanted\" : \"wanted\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() >= 400) {
			String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		

		response = 
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"c2\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"given2\"," + 
				"\"image\" : \"image2\"," + 
				"\"wanted\" : \"wanted2\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() >= 400) {
			String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		

		response = 
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"c3\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"3given\"," + 
				"\"wanted\" : \"3wanted\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() >= 400) {
			String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		

		response = 
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"c4\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"4given4\"," + 
				"\"wanted\" : \"4wanted4\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() >= 400) {
			String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		

		response = 
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"c5\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"different\"," + 
				"\"wanted\" : \"different\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() >= 400) {
			String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		

		NotReplayableDataProvider.setSystemTime(DateTime.parse("20200418 10:30", DateTimeFormat.forPattern("yyyyMMdd HH:mm")).withZone(DateTimeZone.UTC));
		response = 
		com.anfelisa.box.ActionCalls.callScheduleCards(objectMapper.readValue("{" +
			"\"uuid\" : \"sc1\"," + 
				"\"cardIds\" : [ \"c1\"," + 
				"\"c3\"," + 
				"\"c4\"]} ",
		com.anfelisa.box.data.ScheduledCardsData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() >= 400) {
			String message = "GIVEN ScheduleCards fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		

		NotReplayableDataProvider.setSystemTime(DateTime.parse("20200418 16:30", DateTimeFormat.forPattern("yyyyMMdd HH:mm")).withZone(DateTimeZone.UTC));
		response = 
		com.anfelisa.box.ActionCalls.callScoreCard(objectMapper.readValue("{" +
			"\"uuid\" : \"score0\"," + 
				"\"boxId\" : \"boxId\"," + 
				"\"scoredCardQuality\" : 0," + 
				"\"scoredCardScheduledCardId\" : \"c1-sc1\"} ",
		com.anfelisa.box.data.ScoreCardData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() >= 400) {
			String message = "GIVEN ScoreCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		

		NotReplayableDataProvider.setSystemTime(DateTime.parse("20200418 16:30", DateTimeFormat.forPattern("yyyyMMdd HH:mm")).withZone(DateTimeZone.UTC));
		response = 
		com.anfelisa.box.ActionCalls.callScoreCard(objectMapper.readValue("{" +
			"\"uuid\" : \"score1\"," + 
				"\"boxId\" : \"boxId\"," + 
				"\"scoredCardQuality\" : 1," + 
				"\"scoredCardScheduledCardId\" : \"c3-sc1\"} ",
		com.anfelisa.box.data.ScoreCardData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() >= 400) {
			String message = "GIVEN ScoreCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		

		NotReplayableDataProvider.setSystemTime(DateTime.parse("20200418 16:30", DateTimeFormat.forPattern("yyyyMMdd HH:mm")).withZone(DateTimeZone.UTC));
		response = 
		com.anfelisa.box.ActionCalls.callScoreCard(objectMapper.readValue("{" +
			"\"uuid\" : \"score5\"," + 
				"\"boxId\" : \"boxId\"," + 
				"\"scoredCardQuality\" : 5," + 
				"\"scoredCardScheduledCardId\" : \"c4-sc1\"} ",
		com.anfelisa.box.data.ScoreCardData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() >= 400) {
			String message = "GIVEN ScoreCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		

		NotReplayableDataProvider.setSystemTime(DateTime.parse("20200418 16:40", DateTimeFormat.forPattern("yyyyMMdd HH:mm")).withZone(DateTimeZone.UTC));
		response = 
		com.anfelisa.box.ActionCalls.callScoreReinforceCard(objectMapper.readValue("{" +
			"\"uuid\" : \"1\"," + 
				"\"scoredCardQuality\" : 0," + 
				"\"reinforceCardId\" : \"score0\"} ",
		com.anfelisa.box.data.ScoreReinforceCardData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() >= 400) {
			String message = "GIVEN ScoreReinforceCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		

		NotReplayableDataProvider.setSystemTime(DateTime.parse("20200418 16:40", DateTimeFormat.forPattern("yyyyMMdd HH:mm")).withZone(DateTimeZone.UTC));
		response = 
		com.anfelisa.box.ActionCalls.callScoreReinforceCard(objectMapper.readValue("{" +
			"\"uuid\" : \"1\"," + 
				"\"scoredCardQuality\" : 5," + 
				"\"reinforceCardId\" : \"score1\"} ",
		com.anfelisa.box.data.ScoreReinforceCardData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() >= 400) {
			String message = "GIVEN ScoreReinforceCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		

	}
	
	private Response when() throws Exception {
		
		return 
		com.anfelisa.box.ActionCalls.callLoadNextCard(objectMapper.readValue("{" +
			"\"uuid\" : \"" + this.randomUUID() + "\"," + 
				"\"boxId\" : \"boxId\"," + 
				"\"todayAtMidnightInUTC\" : \"2020-04-18T00:00:00.000Z\"} ",
		com.anfelisa.box.data.NextCardData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
	}
	
	private com.anfelisa.box.data.LoadNextCardResponse then(Response response) throws Exception {
		if (response.getStatus() == 500) {
			String message = response.readEntity(String.class);
			assertFail(message);
		}
		assertThat(response.getStatus(), 200);
		
		com.anfelisa.box.data.LoadNextCardResponse actual = null;
		try {
			actual = response.readEntity(com.anfelisa.box.data.LoadNextCardResponse.class);
		} catch (Exception x) {
		}
		com.anfelisa.box.data.NextCardData expectedData = objectMapper.readValue("{" +
			"\"uuid\" : \"" + this.randomUUID() + "\"," + 
				"\"allTodaysCards\" : 3," + 
				"\"cardId\" : \"c1\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"count\" : 0," + 
				"\"given\" : \"given\"," + 
				"\"image\" : \"image\"," + 
				"\"lastQuality\" : 0," + 
				"\"openTodaysCards\" : 1," + 
				"\"reinforceCardId\" : \"score0\"," + 
				"\"rootCategoryId\" : \"boxId\"," + 
				"\"scheduledDate\" : \"2020-04-18T08:30:00.000Z\"," + 
				"\"scoredDate\" : \"2020-04-18T14:30:00.000Z\"," + 
				"\"wanted\" : \"wanted\"} ",
		com.anfelisa.box.data.NextCardData.class)
		
		;
		
		com.anfelisa.box.data.LoadNextCardResponse expected = new com.anfelisa.box.data.LoadNextCardResponse(expectedData);


		assertThat(actual, expected);
			
			return actual;
				}
				
				@Test
				public void loadNextCardSecondReinforceScored() throws Exception {
					given();
					
					Response response = when();
			
					com.anfelisa.box.data.LoadNextCardResponse actualResponse = then(response);
					
					verifications(actualResponse);
				}
				
				protected abstract void verifications(com.anfelisa.box.data.LoadNextCardResponse response);
				
				@Override
				protected String scenarioName() {
					return "LoadNextCardSecondReinforceScored";
				}
			
			}
			
			
			
			/******* S.D.G. *******/
			
			
			

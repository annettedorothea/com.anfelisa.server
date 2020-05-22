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




package com.anfelisa.box.sortcardsout.scenarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.Response;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.acegen.BaseScenario;
import de.acegen.ITimelineItem;
import de.acegen.NotReplayableDataProvider;

@SuppressWarnings("unused")
public abstract class AbstractSortCardsOutTwiceScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractSortCardsOutTwiceScenario.class);
	
	private void given() throws Exception {
		Response response;
		String uuid;
		if (prerequisite("RegisterUser")) {
			uuid = "uuid-${testId}".replace("${testId}", this.getTestId());
			this.callNotReplayableDataProviderPutValue(uuid, "token", 
						objectMapper.readValue("\"TOKEN-" + this.getTestId() + "\"",  String.class));
			com.anfelisa.user.data.UserRegistrationData data_1 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"email\" : \"annette.pohl@anfelisa.de\"," + 
					"\"language\" : \"de\"," + 
					"\"password\" : \"password\"," + 
					"\"username\" : \"Annette-" + this.getTestId() + "\"} ",
			com.anfelisa.user.data.UserRegistrationData.class);
			response = 
			this.httpPost(
				"/users/register", 
				data_1,
				null
			);
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN RegisterUser fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: RegisterUser fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: RegisterUser success");
		} else {
			LOG.info("GIVEN: prerequisite for RegisterUser not met");
		}
		

		if (prerequisite("CreateBoxMinimal")) {
			uuid = "boxId-${testId}".replace("${testId}", this.getTestId());
			com.anfelisa.box.data.BoxCreationData data_2 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryName\" : \"cat\"," + 
					"\"dictionaryLookup\" : false," + 
					"\"maxCardsPerDay\" : 10} ",
			com.anfelisa.box.data.BoxCreationData.class);
			response = 
			this.httpPost(
				"/box/create", 
				data_2,
				authorization("Annette-${testId}", "password")
			);
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateBoxMinimal fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateBoxMinimal fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateBoxMinimal success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateBoxMinimal not met");
		}
		

		if (prerequisite("CreateCategory")) {
			uuid = "cat1-${testId}".replace("${testId}", this.getTestId());
			com.anfelisa.category.data.CategoryCreationData data_3 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryName\" : \"level 1 #1\"," + 
					"\"parentCategoryId\" : \"boxId-" + this.getTestId() + "\"} ",
			com.anfelisa.category.data.CategoryCreationData.class);
			response = 
			this.httpPost(
				"/category/create", 
				data_3,
				authorization("Annette-${testId}", "password")
			);
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateCategory fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateCategory fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateCategory success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateCategory not met");
		}
		

		if (prerequisite("CreateCard")) {
			uuid = "c1-${testId}".replace("${testId}", this.getTestId());
			com.anfelisa.card.data.CardCreationData data_4 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"given\"," + 
					"\"image\" : \"image\"," + 
					"\"wanted\" : \"wanted\"} ",
			com.anfelisa.card.data.CardCreationData.class);
			response = 
			this.httpPost(
				"/card/create", 
				data_4,
				authorization("Annette-${testId}", "password")
			);
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateCard fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateCard success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateCard not met");
		}
		

		if (prerequisite("CreateSecondCard")) {
			uuid = "c2-${testId}".replace("${testId}", this.getTestId());
			com.anfelisa.card.data.CardCreationData data_5 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"given2\"," + 
					"\"image\" : \"image2\"," + 
					"\"wanted\" : \"wanted2\"} ",
			com.anfelisa.card.data.CardCreationData.class);
			response = 
			this.httpPost(
				"/card/create", 
				data_5,
				authorization("Annette-${testId}", "password")
			);
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateSecondCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateSecondCard fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateSecondCard success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateSecondCard not met");
		}
		

		if (prerequisite("CreateThirdCard")) {
			uuid = "c3-${testId}".replace("${testId}", this.getTestId());
			com.anfelisa.card.data.CardCreationData data_6 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"3given\"," + 
					"\"wanted\" : \"3wanted\"} ",
			com.anfelisa.card.data.CardCreationData.class);
			response = 
			this.httpPost(
				"/card/create", 
				data_6,
				authorization("Annette-${testId}", "password")
			);
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateThirdCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateThirdCard fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateThirdCard success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateThirdCard not met");
		}
		

		if (prerequisite("CreateFourthCard")) {
			uuid = "c4-${testId}".replace("${testId}", this.getTestId());
			com.anfelisa.card.data.CardCreationData data_7 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"4given4\"," + 
					"\"wanted\" : \"4wanted4\"} ",
			com.anfelisa.card.data.CardCreationData.class);
			response = 
			this.httpPost(
				"/card/create", 
				data_7,
				authorization("Annette-${testId}", "password")
			);
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateFourthCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateFourthCard fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateFourthCard success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateFourthCard not met");
		}
		

		if (prerequisite("CreateFifthCard")) {
			uuid = "c5-${testId}".replace("${testId}", this.getTestId());
			com.anfelisa.card.data.CardCreationData data_8 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"different\"," + 
					"\"wanted\" : \"different\"} ",
			com.anfelisa.card.data.CardCreationData.class);
			response = 
			this.httpPost(
				"/card/create", 
				data_8,
				authorization("Annette-${testId}", "password")
			);
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateFifthCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateFifthCard fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateFifthCard success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateFifthCard not met");
		}
		

		if (prerequisite("ScheduleCards")) {
			uuid = "sc1-${testId}".replace("${testId}", this.getTestId());
			this.callNotReplayableDataProviderPutSystemTime(uuid, DateTime.parse("20200418 10:30", DateTimeFormat.forPattern("yyyyMMdd HH:mm")).withZone(DateTimeZone.UTC));
			com.anfelisa.box.data.ScheduledCardsData data_9 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"cardIds\" : [ \"c1-" + this.getTestId() + "\"," + 
					"\"c3-" + this.getTestId() + "\"," + 
					"\"c4-" + this.getTestId() + "\"]} ",
			com.anfelisa.box.data.ScheduledCardsData.class);
			response = 
			this.httpPost(
				"/cards/schedule", 
				data_9,
				authorization("Annette-${testId}", "password")
			);
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN ScheduleCards fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: ScheduleCards fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: ScheduleCards success");
		} else {
			LOG.info("GIVEN: prerequisite for ScheduleCards not met");
		}
		

		if (prerequisite("SortCardsOut")) {
			uuid = this.randomUUID();
			com.anfelisa.box.data.SortCardsOutData data_10 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"cardIds\" : [ \"c1-" + this.getTestId() + "\"," + 
					"\"c4-" + this.getTestId() + "\"]} ",
			com.anfelisa.box.data.SortCardsOutData.class);
			response = 
			this.httpPost(
				"/cards/sort-out", 
				data_10,
				authorization("Annette-${testId}", "password")
			);
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN SortCardsOut fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: SortCardsOut fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: SortCardsOut success");
		} else {
			LOG.info("GIVEN: prerequisite for SortCardsOut not met");
		}
		

	}
	
	private Response when() throws Exception {
		String uuid = this.randomUUID();
		com.anfelisa.box.data.SortCardsOutData data_0 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
				"\"cardIds\" : [ \"c1-" + this.getTestId() + "\"," + 
				"\"c4-" + this.getTestId() + "\"]} ",
		com.anfelisa.box.data.SortCardsOutData.class);
		
		return 
		this.httpPost(
			"/cards/sort-out", 
			data_0,
			authorization("Annette-${testId}", "password")
		);
		
	}
	
	private void then(Response response) throws Exception {
		if (response.getStatus() == 500) {
			String message = response.readEntity(String.class);
			assertFail(message);
		}
		if (response.getStatus() != 200) {
			String message = response.readEntity(String.class);
			assertFail(message);
		}
		
			
				}
				
				@Override
				public void runTest() throws Exception {
					given();
						
					if (prerequisite("SortCardsOutTwice")) {
						Response response = when();
		
						LOG.info("WHEN: SortCardsOut");
				
						then(response);
						
						verifications();
					} else {
						LOG.info("WHEN: prerequisite for SortCardsOutTwice not met");
					}
				}
				
				protected abstract void verifications();
				
				@Override
				protected String scenarioName() {
					return "SortCardsOutTwice";
				}
			
			}
			
			
			
			/******* S.D.G. *******/
			
			
			

/* 
 * Copyright (c) 2020, Annette Pohl, Koblenz, Germany
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
 *
 * generated with de.acegen 0.9.8
 *
 */




package com.anfelisa.box.deletebox.scenarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import javax.ws.rs.core.Response;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.acegen.BaseScenario;
import de.acegen.ITimelineItem;
import de.acegen.NotReplayableDataProvider;

@SuppressWarnings("unused")
public abstract class AbstractDeleteBoxCascadesAllScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractDeleteBoxCascadesAllScenario.class);
	
	private Map<String, Object> extractedValues = new HashMap<String, Object>();
	
	private void given() throws Exception {
		Response response;
		String uuid;
		long timeBeforeRequest;
		long timeAfterRequest;
		if (prerequisite("RegisterUserAdmin")) {
			uuid = "uuid-admin";
			this.callNotReplayableDataProviderPutValue(uuid, "token", 
						objectMapper.readValue("\"ADMIN-TOKEN\"",  String.class));
			com.anfelisa.user.data.UserRegistrationData data_1 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"email\" : \"annette.pohl@anfelisa.de\"," + 
					"\"language\" : \"de\"," + 
					"\"password\" : \"admin-password\"," + 
					"\"username\" : \"Admin\"} ",
			com.anfelisa.user.data.UserRegistrationData.class);
			timeBeforeRequest = System.currentTimeMillis();
			response = 
			this.httpPost(
				"/users/register", 
				data_1,
				null
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response.getStatus() >= 400) {
				String message = "GIVEN RegisterUserAdmin fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: RegisterUserAdmin fails due to {} in {} ms", message, (timeAfterRequest-timeBeforeRequest));
				addToMetrics("RegisterUser", (timeAfterRequest-timeBeforeRequest));
				assertFail(message);
			}
			LOG.info("GIVEN: RegisterUserAdmin success in {} ms", (timeAfterRequest-timeBeforeRequest));
			addToMetrics("RegisterUser", (timeAfterRequest-timeBeforeRequest));
		} else {
			LOG.info("GIVEN: prerequisite for RegisterUserAdmin not met");
		}
		

		if (prerequisite("CreateBoxMinimalAsAdmin")) {
			uuid = "adminBox-" + this.getTestId() + "";
			com.anfelisa.box.data.BoxCreationData data_2 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryName\" : \"adminBox-" + this.getTestId() + "\"," + 
					"\"dictionaryLookup\" : false," + 
					"\"maxCardsPerDay\" : 10} ",
			com.anfelisa.box.data.BoxCreationData.class);
			timeBeforeRequest = System.currentTimeMillis();
			response = 
			this.httpPost(
				"/box/create", 
				data_2,
				authorization("Admin", "admin-password")
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateBoxMinimalAsAdmin fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateBoxMinimalAsAdmin fails due to {} in {} ms", message, (timeAfterRequest-timeBeforeRequest));
				addToMetrics("CreateBox", (timeAfterRequest-timeBeforeRequest));
				assertFail(message);
			}
			LOG.info("GIVEN: CreateBoxMinimalAsAdmin success in {} ms", (timeAfterRequest-timeBeforeRequest));
			addToMetrics("CreateBox", (timeAfterRequest-timeBeforeRequest));
		} else {
			LOG.info("GIVEN: prerequisite for CreateBoxMinimalAsAdmin not met");
		}
		

		if (prerequisite("CreateCategoryAsAdmin")) {
			uuid = "adminCat-" + this.getTestId() + "";
			com.anfelisa.category.data.CategoryCreationData data_3 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryName\" : \"c\"," + 
					"\"parentCategoryId\" : \"adminBox-" + this.getTestId() + "\"} ",
			com.anfelisa.category.data.CategoryCreationData.class);
			timeBeforeRequest = System.currentTimeMillis();
			response = 
			this.httpPost(
				"/category/create", 
				data_3,
				authorization("Admin", "admin-password")
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateCategoryAsAdmin fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateCategoryAsAdmin fails due to {} in {} ms", message, (timeAfterRequest-timeBeforeRequest));
				addToMetrics("CreateCategory", (timeAfterRequest-timeBeforeRequest));
				assertFail(message);
			}
			LOG.info("GIVEN: CreateCategoryAsAdmin success in {} ms", (timeAfterRequest-timeBeforeRequest));
			addToMetrics("CreateCategory", (timeAfterRequest-timeBeforeRequest));
		} else {
			LOG.info("GIVEN: prerequisite for CreateCategoryAsAdmin not met");
		}
		

		if (prerequisite("CreateCardAsAdmin")) {
			uuid = "c6-" + this.getTestId() + "";
			com.anfelisa.card.data.CardCreationData data_4 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"adminCat-" + this.getTestId() + "\"," + 
					"\"given\" : \"given\"," + 
					"\"image\" : \"image\"," + 
					"\"wanted\" : \"wanted\"} ",
			com.anfelisa.card.data.CardCreationData.class);
			timeBeforeRequest = System.currentTimeMillis();
			response = 
			this.httpPost(
				"/card/create", 
				data_4,
				authorization("Admin", "admin-password")
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateCardAsAdmin fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateCardAsAdmin fails due to {} in {} ms", message, (timeAfterRequest-timeBeforeRequest));
				addToMetrics("CreateCard", (timeAfterRequest-timeBeforeRequest));
				assertFail(message);
			}
			LOG.info("GIVEN: CreateCardAsAdmin success in {} ms", (timeAfterRequest-timeBeforeRequest));
			addToMetrics("CreateCard", (timeAfterRequest-timeBeforeRequest));
		} else {
			LOG.info("GIVEN: prerequisite for CreateCardAsAdmin not met");
		}
		

		if (prerequisite("ScheduleCardsAsAdmin")) {
			uuid = "sc6-" + this.getTestId() + "";
			this.callNotReplayableDataProviderPutSystemTime(uuid, LocalDateTime.parse("20200418 10:30", DateTimeFormatter.ofPattern("yyyyMMdd HH:mm")));
			com.anfelisa.box.data.ScheduledCardsData data_5 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"cardIds\" : [ \"c6-" + this.getTestId() + "\"]} ",
			com.anfelisa.box.data.ScheduledCardsData.class);
			timeBeforeRequest = System.currentTimeMillis();
			response = 
			this.httpPost(
				"/cards/schedule", 
				data_5,
				authorization("Admin", "admin-password")
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response.getStatus() >= 400) {
				String message = "GIVEN ScheduleCardsAsAdmin fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: ScheduleCardsAsAdmin fails due to {} in {} ms", message, (timeAfterRequest-timeBeforeRequest));
				addToMetrics("ScheduleCards", (timeAfterRequest-timeBeforeRequest));
				assertFail(message);
			}
			LOG.info("GIVEN: ScheduleCardsAsAdmin success in {} ms", (timeAfterRequest-timeBeforeRequest));
			addToMetrics("ScheduleCards", (timeAfterRequest-timeBeforeRequest));
		} else {
			LOG.info("GIVEN: prerequisite for ScheduleCardsAsAdmin not met");
		}
		

		if (prerequisite("ScoreCardAsAdmin")) {
			uuid = "admin-score-" + this.getTestId() + "";
			this.callNotReplayableDataProviderPutSystemTime(uuid, LocalDateTime.parse("20200418 16:30", DateTimeFormatter.ofPattern("yyyyMMdd HH:mm")));
			com.anfelisa.box.data.ScoreCardData data_6 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"scoredCardQuality\" : 1," + 
					"\"scheduledCardId\" : \"c6-" + this.getTestId() + "-sc6-" + this.getTestId() + "\"} ",
			com.anfelisa.box.data.ScoreCardData.class);
			timeBeforeRequest = System.currentTimeMillis();
			response = 
			this.httpPost(
				"/card/score", 
				data_6,
				authorization("Admin", "admin-password")
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response.getStatus() >= 400) {
				String message = "GIVEN ScoreCardAsAdmin fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: ScoreCardAsAdmin fails due to {} in {} ms", message, (timeAfterRequest-timeBeforeRequest));
				addToMetrics("ScoreCard", (timeAfterRequest-timeBeforeRequest));
				assertFail(message);
			}
			LOG.info("GIVEN: ScoreCardAsAdmin success in {} ms", (timeAfterRequest-timeBeforeRequest));
			addToMetrics("ScoreCard", (timeAfterRequest-timeBeforeRequest));
		} else {
			LOG.info("GIVEN: prerequisite for ScoreCardAsAdmin not met");
		}
		

		if (prerequisite("RegisterUser")) {
			uuid = "uuid-" + this.getTestId() + "";
			this.callNotReplayableDataProviderPutValue(uuid, "token", 
						objectMapper.readValue("\"TOKEN-" + this.getTestId() + "\"",  String.class));
			com.anfelisa.user.data.UserRegistrationData data_7 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"email\" : \"annette.pohl@anfelisa.de\"," + 
					"\"language\" : \"de\"," + 
					"\"password\" : \"password\"," + 
					"\"username\" : \"Annette-" + this.getTestId() + "\"} ",
			com.anfelisa.user.data.UserRegistrationData.class);
			timeBeforeRequest = System.currentTimeMillis();
			response = 
			this.httpPost(
				"/users/register", 
				data_7,
				null
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response.getStatus() >= 400) {
				String message = "GIVEN RegisterUser fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: RegisterUser fails due to {} in {} ms", message, (timeAfterRequest-timeBeforeRequest));
				addToMetrics("RegisterUser", (timeAfterRequest-timeBeforeRequest));
				assertFail(message);
			}
			LOG.info("GIVEN: RegisterUser success in {} ms", (timeAfterRequest-timeBeforeRequest));
			addToMetrics("RegisterUser", (timeAfterRequest-timeBeforeRequest));
		} else {
			LOG.info("GIVEN: prerequisite for RegisterUser not met");
		}
		

		if (prerequisite("CreateBoxMinimal")) {
			uuid = "boxId-" + this.getTestId() + "";
			com.anfelisa.box.data.BoxCreationData data_8 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryName\" : \"cat\"," + 
					"\"dictionaryLookup\" : false," + 
					"\"maxCardsPerDay\" : 10} ",
			com.anfelisa.box.data.BoxCreationData.class);
			timeBeforeRequest = System.currentTimeMillis();
			response = 
			this.httpPost(
				"/box/create", 
				data_8,
				authorization("Annette-${testId}", "password")
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateBoxMinimal fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateBoxMinimal fails due to {} in {} ms", message, (timeAfterRequest-timeBeforeRequest));
				addToMetrics("CreateBox", (timeAfterRequest-timeBeforeRequest));
				assertFail(message);
			}
			LOG.info("GIVEN: CreateBoxMinimal success in {} ms", (timeAfterRequest-timeBeforeRequest));
			addToMetrics("CreateBox", (timeAfterRequest-timeBeforeRequest));
		} else {
			LOG.info("GIVEN: prerequisite for CreateBoxMinimal not met");
		}
		

		if (prerequisite("CreateCategory")) {
			uuid = "cat1-" + this.getTestId() + "";
			com.anfelisa.category.data.CategoryCreationData data_9 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryName\" : \"level 1 #1\"," + 
					"\"parentCategoryId\" : \"boxId-" + this.getTestId() + "\"} ",
			com.anfelisa.category.data.CategoryCreationData.class);
			timeBeforeRequest = System.currentTimeMillis();
			response = 
			this.httpPost(
				"/category/create", 
				data_9,
				authorization("Annette-${testId}", "password")
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateCategory fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateCategory fails due to {} in {} ms", message, (timeAfterRequest-timeBeforeRequest));
				addToMetrics("CreateCategory", (timeAfterRequest-timeBeforeRequest));
				assertFail(message);
			}
			LOG.info("GIVEN: CreateCategory success in {} ms", (timeAfterRequest-timeBeforeRequest));
			addToMetrics("CreateCategory", (timeAfterRequest-timeBeforeRequest));
		} else {
			LOG.info("GIVEN: prerequisite for CreateCategory not met");
		}
		

		if (prerequisite("CreateCard")) {
			uuid = "c1-" + this.getTestId() + "";
			com.anfelisa.card.data.CardCreationData data_10 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"given\"," + 
					"\"image\" : \"image\"," + 
					"\"wanted\" : \"wanted\"} ",
			com.anfelisa.card.data.CardCreationData.class);
			timeBeforeRequest = System.currentTimeMillis();
			response = 
			this.httpPost(
				"/card/create", 
				data_10,
				authorization("Annette-${testId}", "password")
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateCard fails due to {} in {} ms", message, (timeAfterRequest-timeBeforeRequest));
				addToMetrics("CreateCard", (timeAfterRequest-timeBeforeRequest));
				assertFail(message);
			}
			LOG.info("GIVEN: CreateCard success in {} ms", (timeAfterRequest-timeBeforeRequest));
			addToMetrics("CreateCard", (timeAfterRequest-timeBeforeRequest));
		} else {
			LOG.info("GIVEN: prerequisite for CreateCard not met");
		}
		

		if (prerequisite("CreateSecondCard")) {
			uuid = "c2-" + this.getTestId() + "";
			com.anfelisa.card.data.CardCreationData data_11 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"given2\"," + 
					"\"image\" : \"image2\"," + 
					"\"wanted\" : \"wanted2\"} ",
			com.anfelisa.card.data.CardCreationData.class);
			timeBeforeRequest = System.currentTimeMillis();
			response = 
			this.httpPost(
				"/card/create", 
				data_11,
				authorization("Annette-${testId}", "password")
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateSecondCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateSecondCard fails due to {} in {} ms", message, (timeAfterRequest-timeBeforeRequest));
				addToMetrics("CreateCard", (timeAfterRequest-timeBeforeRequest));
				assertFail(message);
			}
			LOG.info("GIVEN: CreateSecondCard success in {} ms", (timeAfterRequest-timeBeforeRequest));
			addToMetrics("CreateCard", (timeAfterRequest-timeBeforeRequest));
		} else {
			LOG.info("GIVEN: prerequisite for CreateSecondCard not met");
		}
		

		if (prerequisite("CreateThirdCard")) {
			uuid = "c3-" + this.getTestId() + "";
			com.anfelisa.card.data.CardCreationData data_12 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"3given\"," + 
					"\"wanted\" : \"3wanted\"} ",
			com.anfelisa.card.data.CardCreationData.class);
			timeBeforeRequest = System.currentTimeMillis();
			response = 
			this.httpPost(
				"/card/create", 
				data_12,
				authorization("Annette-${testId}", "password")
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateThirdCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateThirdCard fails due to {} in {} ms", message, (timeAfterRequest-timeBeforeRequest));
				addToMetrics("CreateCard", (timeAfterRequest-timeBeforeRequest));
				assertFail(message);
			}
			LOG.info("GIVEN: CreateThirdCard success in {} ms", (timeAfterRequest-timeBeforeRequest));
			addToMetrics("CreateCard", (timeAfterRequest-timeBeforeRequest));
		} else {
			LOG.info("GIVEN: prerequisite for CreateThirdCard not met");
		}
		

		if (prerequisite("CreateFourthCard")) {
			uuid = "c4-" + this.getTestId() + "";
			com.anfelisa.card.data.CardCreationData data_13 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"4given4\"," + 
					"\"wanted\" : \"4wanted4\"} ",
			com.anfelisa.card.data.CardCreationData.class);
			timeBeforeRequest = System.currentTimeMillis();
			response = 
			this.httpPost(
				"/card/create", 
				data_13,
				authorization("Annette-${testId}", "password")
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateFourthCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateFourthCard fails due to {} in {} ms", message, (timeAfterRequest-timeBeforeRequest));
				addToMetrics("CreateCard", (timeAfterRequest-timeBeforeRequest));
				assertFail(message);
			}
			LOG.info("GIVEN: CreateFourthCard success in {} ms", (timeAfterRequest-timeBeforeRequest));
			addToMetrics("CreateCard", (timeAfterRequest-timeBeforeRequest));
		} else {
			LOG.info("GIVEN: prerequisite for CreateFourthCard not met");
		}
		

		if (prerequisite("CreateFifthCard")) {
			uuid = "c5-" + this.getTestId() + "";
			com.anfelisa.card.data.CardCreationData data_14 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"different\"," + 
					"\"wanted\" : \"different\"} ",
			com.anfelisa.card.data.CardCreationData.class);
			timeBeforeRequest = System.currentTimeMillis();
			response = 
			this.httpPost(
				"/card/create", 
				data_14,
				authorization("Annette-${testId}", "password")
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateFifthCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateFifthCard fails due to {} in {} ms", message, (timeAfterRequest-timeBeforeRequest));
				addToMetrics("CreateCard", (timeAfterRequest-timeBeforeRequest));
				assertFail(message);
			}
			LOG.info("GIVEN: CreateFifthCard success in {} ms", (timeAfterRequest-timeBeforeRequest));
			addToMetrics("CreateCard", (timeAfterRequest-timeBeforeRequest));
		} else {
			LOG.info("GIVEN: prerequisite for CreateFifthCard not met");
		}
		

		if (prerequisite("ScheduleCards")) {
			uuid = "sc1-" + this.getTestId() + "";
			this.callNotReplayableDataProviderPutSystemTime(uuid, LocalDateTime.parse("20200418 10:30", DateTimeFormatter.ofPattern("yyyyMMdd HH:mm")));
			com.anfelisa.box.data.ScheduledCardsData data_15 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"cardIds\" : [ \"c1-" + this.getTestId() + "\"," + 
					"\"c3-" + this.getTestId() + "\"," + 
					"\"c4-" + this.getTestId() + "\"]} ",
			com.anfelisa.box.data.ScheduledCardsData.class);
			timeBeforeRequest = System.currentTimeMillis();
			response = 
			this.httpPost(
				"/cards/schedule", 
				data_15,
				authorization("Annette-${testId}", "password")
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response.getStatus() >= 400) {
				String message = "GIVEN ScheduleCards fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: ScheduleCards fails due to {} in {} ms", message, (timeAfterRequest-timeBeforeRequest));
				addToMetrics("ScheduleCards", (timeAfterRequest-timeBeforeRequest));
				assertFail(message);
			}
			LOG.info("GIVEN: ScheduleCards success in {} ms", (timeAfterRequest-timeBeforeRequest));
			addToMetrics("ScheduleCards", (timeAfterRequest-timeBeforeRequest));
		} else {
			LOG.info("GIVEN: prerequisite for ScheduleCards not met");
		}
		

		if (prerequisite("ScoreCard0")) {
			uuid = "score0-" + this.getTestId() + "";
			this.callNotReplayableDataProviderPutSystemTime(uuid, LocalDateTime.parse("20200418 16:30", DateTimeFormatter.ofPattern("yyyyMMdd HH:mm")));
			com.anfelisa.box.data.ScoreCardData data_16 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"scoredCardQuality\" : 0," + 
					"\"scheduledCardId\" : \"c1-" + this.getTestId() + "-sc1-" + this.getTestId() + "\"} ",
			com.anfelisa.box.data.ScoreCardData.class);
			timeBeforeRequest = System.currentTimeMillis();
			response = 
			this.httpPost(
				"/card/score", 
				data_16,
				authorization("Annette-${testId}", "password")
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response.getStatus() >= 400) {
				String message = "GIVEN ScoreCard0 fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: ScoreCard0 fails due to {} in {} ms", message, (timeAfterRequest-timeBeforeRequest));
				addToMetrics("ScoreCard", (timeAfterRequest-timeBeforeRequest));
				assertFail(message);
			}
			LOG.info("GIVEN: ScoreCard0 success in {} ms", (timeAfterRequest-timeBeforeRequest));
			addToMetrics("ScoreCard", (timeAfterRequest-timeBeforeRequest));
		} else {
			LOG.info("GIVEN: prerequisite for ScoreCard0 not met");
		}
		

	}
	
	private Response when() throws Exception {
		String uuid = this.randomUUID();
		com.anfelisa.box.data.DeleteBoxData data_0 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
				"\"boxId\" : \"boxId-" + this.getTestId() + "\"} ",
		com.anfelisa.box.data.DeleteBoxData.class);
		long timeBeforeRequest = System.currentTimeMillis();
		Response response = 
		this.httpDelete(
			"/box/delete?uuid=" + data_0.getUuid() + "&boxId=" + data_0.getBoxId() + "", 
			authorization("Annette-${testId}", "password")
		);
		
		long timeAfterRequest = System.currentTimeMillis();
		LOG.info("WHEN: DeleteBox finished in {} ms", (timeAfterRequest-timeBeforeRequest));
		addToMetrics("DeleteBox", (timeAfterRequest-timeBeforeRequest));
		return response;
	}
	
	private com.anfelisa.box.data.DeleteBoxResponse then(Response response) throws Exception {
		if (response.getStatus() == 500) {
			String message = response.readEntity(String.class);
			assertFail(message);
		}
		if (response.getStatus() != 200) {
			String message = response.readEntity(String.class);
			assertFail(message);
		} else {
			LOG.info("THEN: status 200 passed");
		}
		
		com.anfelisa.box.data.DeleteBoxResponse actual = null;
		try {
			actual = response.readEntity(com.anfelisa.box.data.DeleteBoxResponse.class);
		} catch (Exception x) {
		}
		
		return actual;
	}
			
	@Override
	public void runTest() throws Exception {
		given();
			
		if (prerequisite("DeleteBoxCascadesAll")) {
			Response response = when();

			com.anfelisa.box.data.DeleteBoxResponse actualResponse = then(response);
			
			this.boxWasDeleted();
			this.accessToCategoryWasDeleted();
			this.allCategoriesWereDeleted();
			this.allCardsWereDeleted();
			this.allScheduledCardsWereDeleted();
			this.allReinforceCardsWereDeleted();
		
		} else {
			LOG.info("WHEN: prerequisite for DeleteBoxCascadesAll not met");
		}
	}
	
	
	private void boxWasDeleted() throws Exception {
		com.anfelisa.box.models.IBoxModel actual = daoProvider.getBoxDao().selectByBoxId(handle, "boxId-" + this.getTestId() + "");
		
		assertIsNull(actual);

		LOG.info("THEN: boxWasDeleted passed");
	}
	private void accessToCategoryWasDeleted() throws Exception {
		com.anfelisa.category.models.IUserAccessToCategoryModel actual = daoProvider.getUserAccessToCategoryDao().selectByPrimaryKey(handle, "boxId-" + this.getTestId() + "", "uuid-" + this.getTestId() + "");
		
		assertIsNull(actual);

		LOG.info("THEN: accessToCategoryWasDeleted passed");
	}
	private void allCategoriesWereDeleted() throws Exception {
		Map<String, String> filterMap = new HashMap<String, String>();
		filterMap.put("rootCategoryId", "boxId-" + this.getTestId() + "");
		int actual = daoProvider.getCategoryDao().filterAndCountBy(handle, filterMap);
		
		assertThat(actual, 0);

		LOG.info("THEN: allCategoriesWereDeleted passed");
	}
	private void allCardsWereDeleted() throws Exception {
		Map<String, String> filterMap = new HashMap<String, String>();
		filterMap.put("rootCategoryId", "boxId-" + this.getTestId() + "");
		int actual = daoProvider.getCardDao().filterAndCountBy(handle, filterMap);
		
		assertThat(actual, 0);

		LOG.info("THEN: allCardsWereDeleted passed");
	}
	private void allScheduledCardsWereDeleted() throws Exception {
		Map<String, String> filterMap = new HashMap<String, String>();
		filterMap.put("boxId", "boxId-" + this.getTestId() + "");
		int actual = daoProvider.getScheduledCardDao().filterAndCountBy(handle, filterMap);
		
		assertThat(actual, 0);

		LOG.info("THEN: allScheduledCardsWereDeleted passed");
	}
	private void allReinforceCardsWereDeleted() throws Exception {
		Map<String, String> filterMap = new HashMap<String, String>();
		filterMap.put("boxId", "boxId-" + this.getTestId() + "");
		int actual = daoProvider.getReinforceCardDao().filterAndCountBy(handle, filterMap);
		
		assertThat(actual, 0);

		LOG.info("THEN: allReinforceCardsWereDeleted passed");
	}
	
	@Override
	protected String scenarioName() {
		return "DeleteBoxCascadesAll";
	}

}



/******* S.D.G. *******/


			

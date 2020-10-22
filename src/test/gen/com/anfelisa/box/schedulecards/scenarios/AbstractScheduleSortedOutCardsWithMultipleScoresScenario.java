/********************************************************************************
 * generated by de.acegen 0.9.13
 ********************************************************************************/




package com.anfelisa.box.schedulecards.scenarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.acegen.BaseScenario;
import de.acegen.ITimelineItem;
import de.acegen.NonDeterministicDataProvider;
import de.acegen.HttpResponse;

@SuppressWarnings("unused")
public abstract class AbstractScheduleSortedOutCardsWithMultipleScoresScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractScheduleSortedOutCardsWithMultipleScoresScenario.class);
	
	private Map<String, Object> extractedValues = new HashMap<String, Object>();
	
	private void given() throws Exception {
		String uuid;
		long timeBeforeRequest;
		long timeAfterRequest;
		
		if (prerequisite("RegisterUser")) {
			uuid = "uuid-" + this.getTestId() + "";
			this.callNonDeterministicDataProviderPutValue(uuid, "token", 
						objectMapper.readValue("\"TOKEN-" + this.getTestId() + "\"",  String.class));
			com.anfelisa.user.data.RegisterUserPayload payload_0 = objectMapper.readValue("{" +
				"\"email\" : \"annette.pohl@anfelisa.de\"," + 
				"\"language\" : \"de\"," + 
				"\"password\" : \"password\"," + 
				"\"username\" : \"Annette-" + this.getTestId() + "\"} ",
					com.anfelisa.user.data.RegisterUserPayload.class);
			com.anfelisa.user.data.UserRegistrationData data_0 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"email\" : \"annette.pohl@anfelisa.de\"," + 
			"\"language\" : \"de\"," + 
			"\"password\" : \"password\"," + 
			"\"username\" : \"Annette-" + this.getTestId() + "\"} ",
					com.anfelisa.user.data.UserRegistrationData.class);
			timeBeforeRequest = System.currentTimeMillis();
			HttpResponse<Object> response_0 = 
			this.httpPost(
				"/users/register", 
			 	payload_0,
				null,
				uuid,
				null
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response_0.getStatusCode() >= 400) {
				String message = "GIVEN RegisterUser fails\n" + response_0.getStatusMessage();
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
			com.anfelisa.box.data.CreateBoxPayload payload_1 = objectMapper.readValue("{" +
				"\"categoryName\" : \"cat\"," + 
				"\"dictionaryLookup\" : false," + 
				"\"maxCardsPerDay\" : 10} ",
					com.anfelisa.box.data.CreateBoxPayload.class);
			com.anfelisa.box.data.BoxCreationData data_1 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"categoryName\" : \"cat\"," + 
			"\"dictionaryLookup\" : false," + 
			"\"maxCardsPerDay\" : 10} ",
					com.anfelisa.box.data.BoxCreationData.class);
			timeBeforeRequest = System.currentTimeMillis();
			HttpResponse<Object> response_1 = 
			this.httpPost(
				"/box/create", 
			 	payload_1,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response_1.getStatusCode() >= 400) {
				String message = "GIVEN CreateBoxMinimal fails\n" + response_1.getStatusMessage();
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
			com.anfelisa.category.data.CreateCategoryPayload payload_2 = objectMapper.readValue("{" +
				"\"categoryName\" : \"level 1 #1\"," + 
				"\"parentCategoryId\" : \"boxId-" + this.getTestId() + "\"} ",
					com.anfelisa.category.data.CreateCategoryPayload.class);
			com.anfelisa.category.data.CategoryCreationData data_2 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"categoryName\" : \"level 1 #1\"," + 
			"\"parentCategoryId\" : \"boxId-" + this.getTestId() + "\"} ",
					com.anfelisa.category.data.CategoryCreationData.class);
			timeBeforeRequest = System.currentTimeMillis();
			HttpResponse<Object> response_2 = 
			this.httpPost(
				"/category/create", 
			 	payload_2,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response_2.getStatusCode() >= 400) {
				String message = "GIVEN CreateCategory fails\n" + response_2.getStatusMessage();
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
			com.anfelisa.card.data.CreateCardPayload payload_3 = objectMapper.readValue("{" +
				"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
				"\"given\" : \"given\"," + 
				"\"image\" : \"image\"," + 
				"\"wanted\" : \"wanted\"} ",
					com.anfelisa.card.data.CreateCardPayload.class);
			com.anfelisa.card.data.CardCreationData data_3 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
			"\"given\" : \"given\"," + 
			"\"image\" : \"image\"," + 
			"\"wanted\" : \"wanted\"} ",
					com.anfelisa.card.data.CardCreationData.class);
			timeBeforeRequest = System.currentTimeMillis();
			HttpResponse<Object> response_3 = 
			this.httpPost(
				"/card/create", 
			 	payload_3,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response_3.getStatusCode() >= 400) {
				String message = "GIVEN CreateCard fails\n" + response_3.getStatusMessage();
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
			com.anfelisa.card.data.CreateCardPayload payload_4 = objectMapper.readValue("{" +
				"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
				"\"given\" : \"given2\"," + 
				"\"image\" : \"image2\"," + 
				"\"wanted\" : \"wanted2\"} ",
					com.anfelisa.card.data.CreateCardPayload.class);
			com.anfelisa.card.data.CardCreationData data_4 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
			"\"given\" : \"given2\"," + 
			"\"image\" : \"image2\"," + 
			"\"wanted\" : \"wanted2\"} ",
					com.anfelisa.card.data.CardCreationData.class);
			timeBeforeRequest = System.currentTimeMillis();
			HttpResponse<Object> response_4 = 
			this.httpPost(
				"/card/create", 
			 	payload_4,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response_4.getStatusCode() >= 400) {
				String message = "GIVEN CreateSecondCard fails\n" + response_4.getStatusMessage();
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
			com.anfelisa.card.data.CreateCardPayload payload_5 = objectMapper.readValue("{" +
				"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
				"\"given\" : \"3given\"," + 
				"\"wanted\" : \"3wanted\"} ",
					com.anfelisa.card.data.CreateCardPayload.class);
			com.anfelisa.card.data.CardCreationData data_5 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
			"\"given\" : \"3given\"," + 
			"\"wanted\" : \"3wanted\"} ",
					com.anfelisa.card.data.CardCreationData.class);
			timeBeforeRequest = System.currentTimeMillis();
			HttpResponse<Object> response_5 = 
			this.httpPost(
				"/card/create", 
			 	payload_5,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response_5.getStatusCode() >= 400) {
				String message = "GIVEN CreateThirdCard fails\n" + response_5.getStatusMessage();
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
			com.anfelisa.card.data.CreateCardPayload payload_6 = objectMapper.readValue("{" +
				"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
				"\"given\" : \"4given4\"," + 
				"\"wanted\" : \"4wanted4\"} ",
					com.anfelisa.card.data.CreateCardPayload.class);
			com.anfelisa.card.data.CardCreationData data_6 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
			"\"given\" : \"4given4\"," + 
			"\"wanted\" : \"4wanted4\"} ",
					com.anfelisa.card.data.CardCreationData.class);
			timeBeforeRequest = System.currentTimeMillis();
			HttpResponse<Object> response_6 = 
			this.httpPost(
				"/card/create", 
			 	payload_6,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response_6.getStatusCode() >= 400) {
				String message = "GIVEN CreateFourthCard fails\n" + response_6.getStatusMessage();
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
			com.anfelisa.card.data.CreateCardPayload payload_7 = objectMapper.readValue("{" +
				"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
				"\"given\" : \"different\"," + 
				"\"wanted\" : \"different\"} ",
					com.anfelisa.card.data.CreateCardPayload.class);
			com.anfelisa.card.data.CardCreationData data_7 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
			"\"given\" : \"different\"," + 
			"\"wanted\" : \"different\"} ",
					com.anfelisa.card.data.CardCreationData.class);
			timeBeforeRequest = System.currentTimeMillis();
			HttpResponse<Object> response_7 = 
			this.httpPost(
				"/card/create", 
			 	payload_7,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response_7.getStatusCode() >= 400) {
				String message = "GIVEN CreateFifthCard fails\n" + response_7.getStatusMessage();
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
			this.callNonDeterministicDataProviderPutSystemTime(uuid, LocalDateTime.parse("20200418 10:30", DateTimeFormatter.ofPattern("yyyyMMdd HH:mm")));
			com.anfelisa.box.data.ScheduleCardsPayload payload_8 = objectMapper.readValue("{" +
				"\"cardIds\" : [ \"c1-" + this.getTestId() + "\"," + 
				"\"c3-" + this.getTestId() + "\"," + 
				"\"c4-" + this.getTestId() + "\"]} ",
					com.anfelisa.box.data.ScheduleCardsPayload.class);
			com.anfelisa.box.data.ScheduledCardsData data_8 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"cardIds\" : [ \"c1-" + this.getTestId() + "\"," + 
			"\"c3-" + this.getTestId() + "\"," + 
			"\"c4-" + this.getTestId() + "\"]} ",
					com.anfelisa.box.data.ScheduledCardsData.class);
			timeBeforeRequest = System.currentTimeMillis();
			HttpResponse<Object> response_8 = 
			this.httpPost(
				"/cards/schedule", 
			 	payload_8,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response_8.getStatusCode() >= 400) {
				String message = "GIVEN ScheduleCards fails\n" + response_8.getStatusMessage();
				LOG.info("GIVEN: ScheduleCards fails due to {} in {} ms", message, (timeAfterRequest-timeBeforeRequest));
				addToMetrics("ScheduleCards", (timeAfterRequest-timeBeforeRequest));
				assertFail(message);
			}
			LOG.info("GIVEN: ScheduleCards success in {} ms", (timeAfterRequest-timeBeforeRequest));
			addToMetrics("ScheduleCards", (timeAfterRequest-timeBeforeRequest));
		} else {
			LOG.info("GIVEN: prerequisite for ScheduleCards not met");
		}

		if (prerequisite("ScoreCard3")) {
			uuid = "score3-" + this.getTestId() + "";
			this.callNonDeterministicDataProviderPutSystemTime(uuid, LocalDateTime.parse("20200418 16:30", DateTimeFormatter.ofPattern("yyyyMMdd HH:mm")));
			com.anfelisa.box.data.ScoreCardPayload payload_9 = objectMapper.readValue("{" +
				"\"scoredCardQuality\" : 3," + 
				"\"scheduledCardId\" : \"c1-" + this.getTestId() + "-sc1-" + this.getTestId() + "\"} ",
					com.anfelisa.box.data.ScoreCardPayload.class);
			com.anfelisa.box.data.ScoreCardData data_9 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"scoredCardQuality\" : 3," + 
			"\"scheduledCardId\" : \"c1-" + this.getTestId() + "-sc1-" + this.getTestId() + "\"} ",
					com.anfelisa.box.data.ScoreCardData.class);
			timeBeforeRequest = System.currentTimeMillis();
			HttpResponse<Object> response_9 = 
			this.httpPost(
				"/card/score", 
			 	payload_9,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response_9.getStatusCode() >= 400) {
				String message = "GIVEN ScoreCard3 fails\n" + response_9.getStatusMessage();
				LOG.info("GIVEN: ScoreCard3 fails due to {} in {} ms", message, (timeAfterRequest-timeBeforeRequest));
				addToMetrics("ScoreCard", (timeAfterRequest-timeBeforeRequest));
				assertFail(message);
			}
			LOG.info("GIVEN: ScoreCard3 success in {} ms", (timeAfterRequest-timeBeforeRequest));
			addToMetrics("ScoreCard", (timeAfterRequest-timeBeforeRequest));
		} else {
			LOG.info("GIVEN: prerequisite for ScoreCard3 not met");
		}

		if (prerequisite("UpdateBoxMaxInterval")) {
			uuid = this.randomUUID();
			com.anfelisa.box.data.UpdateBoxPayload payload_10 = objectMapper.readValue("{" +
				"\"boxId\" : \"boxId-" + this.getTestId() + "\"," + 
				"\"categoryId\" : \"boxId-" + this.getTestId() + "\"," + 
				"\"categoryName\" : \"changed\"," + 
				"\"dictionaryLookup\" : false," + 
				"\"maxCardsPerDay\" : 11," + 
				"\"maxInterval\" : 90} ",
					com.anfelisa.box.data.UpdateBoxPayload.class);
			com.anfelisa.box.data.BoxUpdateData data_10 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"boxId\" : \"boxId-" + this.getTestId() + "\"," + 
			"\"categoryId\" : \"boxId-" + this.getTestId() + "\"," + 
			"\"categoryName\" : \"changed\"," + 
			"\"dictionaryLookup\" : false," + 
			"\"maxCardsPerDay\" : 11," + 
			"\"maxInterval\" : 90} ",
					com.anfelisa.box.data.BoxUpdateData.class);
			timeBeforeRequest = System.currentTimeMillis();
			HttpResponse<Object> response_10 = 
			this.httpPut(
				"/box/update", 
			 	payload_10,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response_10.getStatusCode() >= 400) {
				String message = "GIVEN UpdateBoxMaxInterval fails\n" + response_10.getStatusMessage();
				LOG.info("GIVEN: UpdateBoxMaxInterval fails due to {} in {} ms", message, (timeAfterRequest-timeBeforeRequest));
				addToMetrics("UpdateBox", (timeAfterRequest-timeBeforeRequest));
				assertFail(message);
			}
			LOG.info("GIVEN: UpdateBoxMaxInterval success in {} ms", (timeAfterRequest-timeBeforeRequest));
			addToMetrics("UpdateBox", (timeAfterRequest-timeBeforeRequest));
		} else {
			LOG.info("GIVEN: prerequisite for UpdateBoxMaxInterval not met");
		}

		if (prerequisite("ScoreCard31")) {
			uuid = "score31-" + this.getTestId() + "";
			this.callNonDeterministicDataProviderPutSystemTime(uuid, LocalDateTime.parse("20200425 16:30", DateTimeFormatter.ofPattern("yyyyMMdd HH:mm")));
			com.anfelisa.box.data.ScoreCardPayload payload_11 = objectMapper.readValue("{" +
				"\"scoredCardQuality\" : 3," + 
				"\"scheduledCardId\" : \"score3-" + this.getTestId() + "\"} ",
					com.anfelisa.box.data.ScoreCardPayload.class);
			com.anfelisa.box.data.ScoreCardData data_11 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"scoredCardQuality\" : 3," + 
			"\"scheduledCardId\" : \"score3-" + this.getTestId() + "\"} ",
					com.anfelisa.box.data.ScoreCardData.class);
			timeBeforeRequest = System.currentTimeMillis();
			HttpResponse<Object> response_11 = 
			this.httpPost(
				"/card/score", 
			 	payload_11,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response_11.getStatusCode() >= 400) {
				String message = "GIVEN ScoreCard31 fails\n" + response_11.getStatusMessage();
				LOG.info("GIVEN: ScoreCard31 fails due to {} in {} ms", message, (timeAfterRequest-timeBeforeRequest));
				addToMetrics("ScoreCard", (timeAfterRequest-timeBeforeRequest));
				assertFail(message);
			}
			LOG.info("GIVEN: ScoreCard31 success in {} ms", (timeAfterRequest-timeBeforeRequest));
			addToMetrics("ScoreCard", (timeAfterRequest-timeBeforeRequest));
		} else {
			LOG.info("GIVEN: prerequisite for ScoreCard31 not met");
		}

		if (prerequisite("ScoreCard32")) {
			uuid = "score32-" + this.getTestId() + "";
			this.callNonDeterministicDataProviderPutSystemTime(uuid, LocalDateTime.parse("20200515 16:30", DateTimeFormatter.ofPattern("yyyyMMdd HH:mm")));
			com.anfelisa.box.data.ScoreCardPayload payload_12 = objectMapper.readValue("{" +
				"\"scoredCardQuality\" : 3," + 
				"\"scheduledCardId\" : \"score31-" + this.getTestId() + "\"} ",
					com.anfelisa.box.data.ScoreCardPayload.class);
			com.anfelisa.box.data.ScoreCardData data_12 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"scoredCardQuality\" : 3," + 
			"\"scheduledCardId\" : \"score31-" + this.getTestId() + "\"} ",
					com.anfelisa.box.data.ScoreCardData.class);
			timeBeforeRequest = System.currentTimeMillis();
			HttpResponse<Object> response_12 = 
			this.httpPost(
				"/card/score", 
			 	payload_12,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response_12.getStatusCode() >= 400) {
				String message = "GIVEN ScoreCard32 fails\n" + response_12.getStatusMessage();
				LOG.info("GIVEN: ScoreCard32 fails due to {} in {} ms", message, (timeAfterRequest-timeBeforeRequest));
				addToMetrics("ScoreCard", (timeAfterRequest-timeBeforeRequest));
				assertFail(message);
			}
			LOG.info("GIVEN: ScoreCard32 success in {} ms", (timeAfterRequest-timeBeforeRequest));
			addToMetrics("ScoreCard", (timeAfterRequest-timeBeforeRequest));
		} else {
			LOG.info("GIVEN: prerequisite for ScoreCard32 not met");
		}

		if (prerequisite("ScoreCard33")) {
			uuid = "score33-" + this.getTestId() + "";
			this.callNonDeterministicDataProviderPutSystemTime(uuid, LocalDateTime.parse("20200615 16:30", DateTimeFormatter.ofPattern("yyyyMMdd HH:mm")));
			com.anfelisa.box.data.ScoreCardPayload payload_13 = objectMapper.readValue("{" +
				"\"scoredCardQuality\" : 4," + 
				"\"scheduledCardId\" : \"score32-" + this.getTestId() + "\"} ",
					com.anfelisa.box.data.ScoreCardPayload.class);
			com.anfelisa.box.data.ScoreCardData data_13 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"scoredCardQuality\" : 4," + 
			"\"scheduledCardId\" : \"score32-" + this.getTestId() + "\"} ",
					com.anfelisa.box.data.ScoreCardData.class);
			timeBeforeRequest = System.currentTimeMillis();
			HttpResponse<Object> response_13 = 
			this.httpPost(
				"/card/score", 
			 	payload_13,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response_13.getStatusCode() >= 400) {
				String message = "GIVEN ScoreCard33 fails\n" + response_13.getStatusMessage();
				LOG.info("GIVEN: ScoreCard33 fails due to {} in {} ms", message, (timeAfterRequest-timeBeforeRequest));
				addToMetrics("ScoreCard", (timeAfterRequest-timeBeforeRequest));
				assertFail(message);
			}
			LOG.info("GIVEN: ScoreCard33 success in {} ms", (timeAfterRequest-timeBeforeRequest));
			addToMetrics("ScoreCard", (timeAfterRequest-timeBeforeRequest));
		} else {
			LOG.info("GIVEN: prerequisite for ScoreCard33 not met");
		}

		if (prerequisite("ScoreCard34")) {
			uuid = "score34-" + this.getTestId() + "";
			this.callNonDeterministicDataProviderPutSystemTime(uuid, LocalDateTime.parse("20200819 16:30", DateTimeFormatter.ofPattern("yyyyMMdd HH:mm")));
			com.anfelisa.box.data.ScoreCardPayload payload_14 = objectMapper.readValue("{" +
				"\"scoredCardQuality\" : 5," + 
				"\"scheduledCardId\" : \"score33-" + this.getTestId() + "\"} ",
					com.anfelisa.box.data.ScoreCardPayload.class);
			com.anfelisa.box.data.ScoreCardData data_14 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"scoredCardQuality\" : 5," + 
			"\"scheduledCardId\" : \"score33-" + this.getTestId() + "\"} ",
					com.anfelisa.box.data.ScoreCardData.class);
			timeBeforeRequest = System.currentTimeMillis();
			HttpResponse<Object> response_14 = 
			this.httpPost(
				"/card/score", 
			 	payload_14,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response_14.getStatusCode() >= 400) {
				String message = "GIVEN ScoreCard34 fails\n" + response_14.getStatusMessage();
				LOG.info("GIVEN: ScoreCard34 fails due to {} in {} ms", message, (timeAfterRequest-timeBeforeRequest));
				addToMetrics("ScoreCard", (timeAfterRequest-timeBeforeRequest));
				assertFail(message);
			}
			LOG.info("GIVEN: ScoreCard34 success in {} ms", (timeAfterRequest-timeBeforeRequest));
			addToMetrics("ScoreCard", (timeAfterRequest-timeBeforeRequest));
		} else {
			LOG.info("GIVEN: prerequisite for ScoreCard34 not met");
		}

		if (prerequisite("ScoreCard35")) {
			uuid = "score35-" + this.getTestId() + "";
			this.callNonDeterministicDataProviderPutSystemTime(uuid, LocalDateTime.parse("20201120 16:30", DateTimeFormatter.ofPattern("yyyyMMdd HH:mm")));
			com.anfelisa.box.data.ScoreCardPayload payload_15 = objectMapper.readValue("{" +
				"\"scoredCardQuality\" : 3," + 
				"\"scheduledCardId\" : \"score34-" + this.getTestId() + "\"} ",
					com.anfelisa.box.data.ScoreCardPayload.class);
			com.anfelisa.box.data.ScoreCardData data_15 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"scoredCardQuality\" : 3," + 
			"\"scheduledCardId\" : \"score34-" + this.getTestId() + "\"} ",
					com.anfelisa.box.data.ScoreCardData.class);
			timeBeforeRequest = System.currentTimeMillis();
			HttpResponse<Object> response_15 = 
			this.httpPost(
				"/card/score", 
			 	payload_15,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response_15.getStatusCode() >= 400) {
				String message = "GIVEN ScoreCard35 fails\n" + response_15.getStatusMessage();
				LOG.info("GIVEN: ScoreCard35 fails due to {} in {} ms", message, (timeAfterRequest-timeBeforeRequest));
				addToMetrics("ScoreCard", (timeAfterRequest-timeBeforeRequest));
				assertFail(message);
			}
			LOG.info("GIVEN: ScoreCard35 success in {} ms", (timeAfterRequest-timeBeforeRequest));
			addToMetrics("ScoreCard", (timeAfterRequest-timeBeforeRequest));
		} else {
			LOG.info("GIVEN: prerequisite for ScoreCard35 not met");
		}

		if (prerequisite("ScoreCard36")) {
			uuid = "score36-" + this.getTestId() + "";
			this.callNonDeterministicDataProviderPutSystemTime(uuid, LocalDateTime.parse("20210301 16:30", DateTimeFormatter.ofPattern("yyyyMMdd HH:mm")));
			com.anfelisa.box.data.ScoreCardPayload payload_16 = objectMapper.readValue("{" +
				"\"scoredCardQuality\" : 3," + 
				"\"scheduledCardId\" : \"score35-" + this.getTestId() + "\"} ",
					com.anfelisa.box.data.ScoreCardPayload.class);
			com.anfelisa.box.data.ScoreCardData data_16 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"scoredCardQuality\" : 3," + 
			"\"scheduledCardId\" : \"score35-" + this.getTestId() + "\"} ",
					com.anfelisa.box.data.ScoreCardData.class);
			timeBeforeRequest = System.currentTimeMillis();
			HttpResponse<Object> response_16 = 
			this.httpPost(
				"/card/score", 
			 	payload_16,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response_16.getStatusCode() >= 400) {
				String message = "GIVEN ScoreCard36 fails\n" + response_16.getStatusMessage();
				LOG.info("GIVEN: ScoreCard36 fails due to {} in {} ms", message, (timeAfterRequest-timeBeforeRequest));
				addToMetrics("ScoreCard", (timeAfterRequest-timeBeforeRequest));
				assertFail(message);
			}
			LOG.info("GIVEN: ScoreCard36 success in {} ms", (timeAfterRequest-timeBeforeRequest));
			addToMetrics("ScoreCard", (timeAfterRequest-timeBeforeRequest));
		} else {
			LOG.info("GIVEN: prerequisite for ScoreCard36 not met");
		}

		if (prerequisite("ScoreCard37")) {
			uuid = "score37-" + this.getTestId() + "";
			this.callNonDeterministicDataProviderPutSystemTime(uuid, LocalDateTime.parse("20210701 16:30", DateTimeFormatter.ofPattern("yyyyMMdd HH:mm")));
			com.anfelisa.box.data.ScoreCardPayload payload_17 = objectMapper.readValue("{" +
				"\"scoredCardQuality\" : 3," + 
				"\"scheduledCardId\" : \"score36-" + this.getTestId() + "\"} ",
					com.anfelisa.box.data.ScoreCardPayload.class);
			com.anfelisa.box.data.ScoreCardData data_17 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"scoredCardQuality\" : 3," + 
			"\"scheduledCardId\" : \"score36-" + this.getTestId() + "\"} ",
					com.anfelisa.box.data.ScoreCardData.class);
			timeBeforeRequest = System.currentTimeMillis();
			HttpResponse<Object> response_17 = 
			this.httpPost(
				"/card/score", 
			 	payload_17,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response_17.getStatusCode() >= 400) {
				String message = "GIVEN ScoreCard37 fails\n" + response_17.getStatusMessage();
				LOG.info("GIVEN: ScoreCard37 fails due to {} in {} ms", message, (timeAfterRequest-timeBeforeRequest));
				addToMetrics("ScoreCard", (timeAfterRequest-timeBeforeRequest));
				assertFail(message);
			}
			LOG.info("GIVEN: ScoreCard37 success in {} ms", (timeAfterRequest-timeBeforeRequest));
			addToMetrics("ScoreCard", (timeAfterRequest-timeBeforeRequest));
		} else {
			LOG.info("GIVEN: prerequisite for ScoreCard37 not met");
		}

		if (prerequisite("ScoreCard38")) {
			uuid = "score38-" + this.getTestId() + "";
			this.callNonDeterministicDataProviderPutSystemTime(uuid, LocalDateTime.parse("20211001 16:30", DateTimeFormatter.ofPattern("yyyyMMdd HH:mm")));
			com.anfelisa.box.data.ScoreCardPayload payload_18 = objectMapper.readValue("{" +
				"\"scoredCardQuality\" : 3," + 
				"\"scheduledCardId\" : \"score37-" + this.getTestId() + "\"} ",
					com.anfelisa.box.data.ScoreCardPayload.class);
			com.anfelisa.box.data.ScoreCardData data_18 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"scoredCardQuality\" : 3," + 
			"\"scheduledCardId\" : \"score37-" + this.getTestId() + "\"} ",
					com.anfelisa.box.data.ScoreCardData.class);
			timeBeforeRequest = System.currentTimeMillis();
			HttpResponse<Object> response_18 = 
			this.httpPost(
				"/card/score", 
			 	payload_18,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response_18.getStatusCode() >= 400) {
				String message = "GIVEN ScoreCard38 fails\n" + response_18.getStatusMessage();
				LOG.info("GIVEN: ScoreCard38 fails due to {} in {} ms", message, (timeAfterRequest-timeBeforeRequest));
				addToMetrics("ScoreCard", (timeAfterRequest-timeBeforeRequest));
				assertFail(message);
			}
			LOG.info("GIVEN: ScoreCard38 success in {} ms", (timeAfterRequest-timeBeforeRequest));
			addToMetrics("ScoreCard", (timeAfterRequest-timeBeforeRequest));
		} else {
			LOG.info("GIVEN: prerequisite for ScoreCard38 not met");
		}

		if (prerequisite("ScoreCard39")) {
			uuid = "score39-" + this.getTestId() + "";
			this.callNonDeterministicDataProviderPutSystemTime(uuid, LocalDateTime.parse("20220201 16:30", DateTimeFormatter.ofPattern("yyyyMMdd HH:mm")));
			com.anfelisa.box.data.ScoreCardPayload payload_19 = objectMapper.readValue("{" +
				"\"scoredCardQuality\" : 3," + 
				"\"scheduledCardId\" : \"score38-" + this.getTestId() + "\"} ",
					com.anfelisa.box.data.ScoreCardPayload.class);
			com.anfelisa.box.data.ScoreCardData data_19 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"scoredCardQuality\" : 3," + 
			"\"scheduledCardId\" : \"score38-" + this.getTestId() + "\"} ",
					com.anfelisa.box.data.ScoreCardData.class);
			timeBeforeRequest = System.currentTimeMillis();
			HttpResponse<Object> response_19 = 
			this.httpPost(
				"/card/score", 
			 	payload_19,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response_19.getStatusCode() >= 400) {
				String message = "GIVEN ScoreCard39 fails\n" + response_19.getStatusMessage();
				LOG.info("GIVEN: ScoreCard39 fails due to {} in {} ms", message, (timeAfterRequest-timeBeforeRequest));
				addToMetrics("ScoreCard", (timeAfterRequest-timeBeforeRequest));
				assertFail(message);
			}
			LOG.info("GIVEN: ScoreCard39 success in {} ms", (timeAfterRequest-timeBeforeRequest));
			addToMetrics("ScoreCard", (timeAfterRequest-timeBeforeRequest));
		} else {
			LOG.info("GIVEN: prerequisite for ScoreCard39 not met");
		}

		if (prerequisite("SortCardsOut")) {
			uuid = this.randomUUID();
			com.anfelisa.box.data.SortCardsOutPayload payload_20 = objectMapper.readValue("{" +
				"\"cardIds\" : [ \"c1-" + this.getTestId() + "\"," + 
				"\"c4-" + this.getTestId() + "\"]} ",
					com.anfelisa.box.data.SortCardsOutPayload.class);
			com.anfelisa.box.data.SortCardsOutData data_20 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"cardIds\" : [ \"c1-" + this.getTestId() + "\"," + 
			"\"c4-" + this.getTestId() + "\"]} ",
					com.anfelisa.box.data.SortCardsOutData.class);
			timeBeforeRequest = System.currentTimeMillis();
			HttpResponse<Object> response_20 = 
			this.httpPost(
				"/cards/sort-out", 
			 	payload_20,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response_20.getStatusCode() >= 400) {
				String message = "GIVEN SortCardsOut fails\n" + response_20.getStatusMessage();
				LOG.info("GIVEN: SortCardsOut fails due to {} in {} ms", message, (timeAfterRequest-timeBeforeRequest));
				addToMetrics("SortCardsOut", (timeAfterRequest-timeBeforeRequest));
				assertFail(message);
			}
			LOG.info("GIVEN: SortCardsOut success in {} ms", (timeAfterRequest-timeBeforeRequest));
			addToMetrics("SortCardsOut", (timeAfterRequest-timeBeforeRequest));
		} else {
			LOG.info("GIVEN: prerequisite for SortCardsOut not met");
		}

	}
	
	private HttpResponse<Object> when() throws Exception {
		String uuid = "reschedule-" + this.getTestId() + "";
		this.callNonDeterministicDataProviderPutSystemTime(uuid, LocalDateTime.parse("20220318 10:30", DateTimeFormatter.ofPattern("yyyyMMdd HH:mm")));
		com.anfelisa.box.data.ScheduleCardsPayload payload_0 = objectMapper.readValue("{" +
			"\"cardIds\" : [ \"c1-" + this.getTestId() + "\"]} ",
				com.anfelisa.box.data.ScheduleCardsPayload.class);
		com.anfelisa.box.data.ScheduledCardsData data_0 = objectMapper.readValue("{" +
		"\"uuid\" : \"" + uuid + "\"," + 
		"\"cardIds\" : [ \"c1-" + this.getTestId() + "\"]} ",
				com.anfelisa.box.data.ScheduledCardsData.class);
		long timeBeforeRequest = System.currentTimeMillis();
		HttpResponse<Object> response = 
		this.httpPost(
			"/cards/schedule", 
		 	payload_0,
			authorization("Annette-${testId}", "password"),
			uuid,
			null
		);
		
		long timeAfterRequest = System.currentTimeMillis();
		LOG.info("WHEN: ScheduleCards finished in {} ms", (timeAfterRequest-timeBeforeRequest));
		addToMetrics("ScheduleCards", (timeAfterRequest-timeBeforeRequest));
		return response;
	}
	
	private void then(HttpResponse<Object> response) throws Exception {
		if (response.getStatusCode() == 500) {
			assertFail(response.getStatusMessage());
		}
		if (response.getStatusCode() != 200) {
			assertFail(response.getStatusMessage());
		} else {
			LOG.info("THEN: status 200 passed");
		}
		
	}
			
	@Override
	public void runTest() throws Exception {
		given();
			
		if (prerequisite("ScheduleSortedOutCardsWithMultipleScores")) {
			HttpResponse<Object> response = when();

			then(response);
			
			this.cardWasScheduled();
	
		} else {
			LOG.info("WHEN: prerequisite for ScheduleSortedOutCardsWithMultipleScores not met");
		}
	}
	
	
	private void cardWasScheduled() throws Exception {
		com.anfelisa.box.models.IScheduledCardModel actual = daoProvider.getScheduledCardDao().selectByScheduledCardId(handle, "score39-" + this.getTestId() + "");
		
		com.anfelisa.box.models.IScheduledCardModel expected = objectMapper.readValue("{" +
			"\"boxId\" : \"boxId-" + this.getTestId() + "\"," + 
			"\"cardId\" : \"c1-" + this.getTestId() + "\"," + 
			"\"count\" : 10," + 
			"\"createdDate\" : \"2022-02-01T16:30\"," + 
			"\"ef\" : \"1.48F\"," + 
			"\"interval\" : 90," + 
			"\"lastQuality\" : 3," + 
			"\"n\" : 11," + 
			"\"quality\" : null," + 
			"\"scheduledCardId\" : \"score39-" + this.getTestId() + "\"," + 
			"\"scheduledDate\" : \"2022-03-18T10:30\"," + 
			"\"scoredDate\" : null} ",
		com.anfelisa.box.models.ScheduledCardModel.class);
		assertThat(actual, expected);
	
		LOG.info("THEN: cardWasScheduled passed");
	}
		
	@Override
	protected String scenarioName() {
		return "ScheduleSortedOutCardsWithMultipleScores";
	}
	
}



/******* S.D.G. *******/




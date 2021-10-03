/********************************************************************************
 * generated by de.acegen 1.5.6
 ********************************************************************************/




package com.anfelisa.user.deleteuser.scenarios;

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
import de.acegen.SquishyDataProvider;
import de.acegen.HttpResponse;

@SuppressWarnings("unused")
public abstract class AbstractDeleteCascadesScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractDeleteCascadesScenario.class);
	
	private void given() throws Exception {
		String uuid;
		
		if (prerequisite("RegisterUserAdmin")) {
			uuid = "uuid-admin";
			this.callSquishyDataProviderPutValue(uuid, "token",	"ADMIN-TOKEN");
			com.anfelisa.user.data.RegisterUserPayload payload_0 = objectMapper.readValue("{" +
				"\"email\" : \"annette.pohl@anfelisa.de\"," + 
				"\"language\" : \"de\"," + 
				"\"password\" : \"admin-password\"," + 
				"\"username\" : \"Admin\"} ",
					com.anfelisa.user.data.RegisterUserPayload.class);
			com.anfelisa.user.data.UserRegistrationData data_0 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"email\" : \"annette.pohl@anfelisa.de\"," + 
			"\"language\" : \"de\"," + 
			"\"password\" : \"admin-password\"," + 
			"\"username\" : \"Admin\"} ",
					com.anfelisa.user.data.UserRegistrationData.class);
			HttpResponse<Object> response_0 = 
			this.httpPost(
				"/users/register", 
			 	payload_0,
				null,
				uuid,
				null
			);
			
			if (response_0.getStatusCode() >= 400) {
				String statusMessage = response_0.getStatusMessage() != null ? response_0.getStatusMessage() : "";
				String message = "GIVEN RegisterUserAdmin fails\n" + statusMessage;
				LOG.error("GIVEN: RegisterUserAdmin fails due to {} in {} ms", message, response_0.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: RegisterUserAdmin success in {} ms", response_0.getDuration());
			addToMetrics("RegisterUser", response_0.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for RegisterUserAdmin not met");
		}

		if (prerequisite("CreateBoxMinimalAsAdmin")) {
			uuid = "adminBox-" + this.getTestId() + "";
			com.anfelisa.box.data.CreateBoxPayload payload_1 = objectMapper.readValue("{" +
				"\"categoryName\" : \"adminBox-" + this.getTestId() + "\"," + 
				"\"dictionaryLookup\" : false," + 
				"\"maxCardsPerDay\" : 10} ",
					com.anfelisa.box.data.CreateBoxPayload.class);
			com.anfelisa.box.data.BoxCreationData data_1 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"categoryName\" : \"adminBox-" + this.getTestId() + "\"," + 
			"\"dictionaryLookup\" : false," + 
			"\"maxCardsPerDay\" : 10} ",
					com.anfelisa.box.data.BoxCreationData.class);
			HttpResponse<Object> response_1 = 
			this.httpPost(
				"/box/create", 
			 	payload_1,
				authorization("Admin", "admin-password"),
				uuid,
				null
			);
			
			if (response_1.getStatusCode() >= 400) {
				String statusMessage = response_1.getStatusMessage() != null ? response_1.getStatusMessage() : "";
				String message = "GIVEN CreateBoxMinimalAsAdmin fails\n" + statusMessage;
				LOG.error("GIVEN: CreateBoxMinimalAsAdmin fails due to {} in {} ms", message, response_1.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: CreateBoxMinimalAsAdmin success in {} ms", response_1.getDuration());
			addToMetrics("CreateBox", response_1.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for CreateBoxMinimalAsAdmin not met");
		}

		if (prerequisite("CreateCategoryAsAdmin")) {
			uuid = "adminCat-" + this.getTestId() + "";
			com.anfelisa.category.data.CreateCategoryPayload payload_2 = objectMapper.readValue("{" +
				"\"categoryName\" : \"c\"," + 
				"\"parentCategoryId\" : \"adminBox-" + this.getTestId() + "\"} ",
					com.anfelisa.category.data.CreateCategoryPayload.class);
			com.anfelisa.category.data.CategoryCreationData data_2 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"categoryName\" : \"c\"," + 
			"\"parentCategoryId\" : \"adminBox-" + this.getTestId() + "\"} ",
					com.anfelisa.category.data.CategoryCreationData.class);
			HttpResponse<Object> response_2 = 
			this.httpPost(
				"/category/create", 
			 	payload_2,
				authorization("Admin", "admin-password"),
				uuid,
				null
			);
			
			if (response_2.getStatusCode() >= 400) {
				String statusMessage = response_2.getStatusMessage() != null ? response_2.getStatusMessage() : "";
				String message = "GIVEN CreateCategoryAsAdmin fails\n" + statusMessage;
				LOG.error("GIVEN: CreateCategoryAsAdmin fails due to {} in {} ms", message, response_2.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: CreateCategoryAsAdmin success in {} ms", response_2.getDuration());
			addToMetrics("CreateCategory", response_2.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for CreateCategoryAsAdmin not met");
		}

		if (prerequisite("CreateCardAsAdmin")) {
			uuid = "c6-" + this.getTestId() + "";
			com.anfelisa.card.data.CreateCardPayload payload_3 = objectMapper.readValue("{" +
				"\"categoryId\" : \"adminCat-" + this.getTestId() + "\"," + 
				"\"given\" : \"given\"," + 
				"\"wanted\" : \"wanted\"} ",
					com.anfelisa.card.data.CreateCardPayload.class);
			com.anfelisa.card.data.CardCreationData data_3 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"categoryId\" : \"adminCat-" + this.getTestId() + "\"," + 
			"\"given\" : \"given\"," + 
			"\"wanted\" : \"wanted\"} ",
					com.anfelisa.card.data.CardCreationData.class);
			HttpResponse<Object> response_3 = 
			this.httpPost(
				"/card/create", 
			 	payload_3,
				authorization("Admin", "admin-password"),
				uuid,
				null
			);
			
			if (response_3.getStatusCode() >= 400) {
				String statusMessage = response_3.getStatusMessage() != null ? response_3.getStatusMessage() : "";
				String message = "GIVEN CreateCardAsAdmin fails\n" + statusMessage;
				LOG.error("GIVEN: CreateCardAsAdmin fails due to {} in {} ms", message, response_3.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: CreateCardAsAdmin success in {} ms", response_3.getDuration());
			addToMetrics("CreateCard", response_3.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for CreateCardAsAdmin not met");
		}

		if (prerequisite("ScheduleCardsAsAdmin")) {
			uuid = "sc6-" + this.getTestId() + "";
			this.callSquishyDataProviderPutSystemTime(uuid, LocalDateTime.parse("20200418 10:30", DateTimeFormatter.ofPattern("yyyyMMdd HH:mm")));
			com.anfelisa.box.data.ScheduleCardsPayload payload_4 = objectMapper.readValue("{" +
				"\"cardIds\" : [ \"c6-" + this.getTestId() + "\"]," + 
				"\"boxId\" : \"adminBox-" + this.getTestId() + "\"} ",
					com.anfelisa.box.data.ScheduleCardsPayload.class);
			com.anfelisa.box.data.ScheduledCardsData data_4 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"cardIds\" : [ \"c6-" + this.getTestId() + "\"]," + 
			"\"boxId\" : \"adminBox-" + this.getTestId() + "\"} ",
					com.anfelisa.box.data.ScheduledCardsData.class);
			HttpResponse<Object> response_4 = 
			this.httpPost(
				"/cards/schedule", 
			 	payload_4,
				authorization("Admin", "admin-password"),
				uuid,
				null
			);
			
			if (response_4.getStatusCode() >= 400) {
				String statusMessage = response_4.getStatusMessage() != null ? response_4.getStatusMessage() : "";
				String message = "GIVEN ScheduleCardsAsAdmin fails\n" + statusMessage;
				LOG.error("GIVEN: ScheduleCardsAsAdmin fails due to {} in {} ms", message, response_4.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: ScheduleCardsAsAdmin success in {} ms", response_4.getDuration());
			addToMetrics("ScheduleCards", response_4.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for ScheduleCardsAsAdmin not met");
		}

		if (prerequisite("ScoreCardAsAdmin")) {
			uuid = "admin-score-" + this.getTestId() + "";
			this.callSquishyDataProviderPutSystemTime(uuid, LocalDateTime.parse("20200418 16:30", DateTimeFormatter.ofPattern("yyyyMMdd HH:mm")));
			com.anfelisa.box.data.ScoreCardPayload payload_5 = objectMapper.readValue("{" +
				"\"scoredCardQuality\" : 1," + 
				"\"scheduledCardId\" : \"c6-" + this.getTestId() + "-sc6-" + this.getTestId() + "\"} ",
					com.anfelisa.box.data.ScoreCardPayload.class);
			com.anfelisa.box.data.ScoreCardData data_5 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"scoredCardQuality\" : 1," + 
			"\"scheduledCardId\" : \"c6-" + this.getTestId() + "-sc6-" + this.getTestId() + "\"} ",
					com.anfelisa.box.data.ScoreCardData.class);
			HttpResponse<Object> response_5 = 
			this.httpPost(
				"/card/score", 
			 	payload_5,
				authorization("Admin", "admin-password"),
				uuid,
				null
			);
			
			if (response_5.getStatusCode() >= 400) {
				String statusMessage = response_5.getStatusMessage() != null ? response_5.getStatusMessage() : "";
				String message = "GIVEN ScoreCardAsAdmin fails\n" + statusMessage;
				LOG.error("GIVEN: ScoreCardAsAdmin fails due to {} in {} ms", message, response_5.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: ScoreCardAsAdmin success in {} ms", response_5.getDuration());
			addToMetrics("ScoreCard", response_5.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for ScoreCardAsAdmin not met");
		}

		if (prerequisite("RegisterUser")) {
			uuid = "uuid-" + this.getTestId() + "";
			this.callSquishyDataProviderPutValue(uuid, "token",	"TOKEN-" + this.getTestId() + "");
			com.anfelisa.user.data.RegisterUserPayload payload_6 = objectMapper.readValue("{" +
				"\"email\" : \"annette.pohl@anfelisa.de\"," + 
				"\"language\" : \"de\"," + 
				"\"password\" : \"password\"," + 
				"\"username\" : \"Annette-" + this.getTestId() + "\"} ",
					com.anfelisa.user.data.RegisterUserPayload.class);
			com.anfelisa.user.data.UserRegistrationData data_6 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"email\" : \"annette.pohl@anfelisa.de\"," + 
			"\"language\" : \"de\"," + 
			"\"password\" : \"password\"," + 
			"\"username\" : \"Annette-" + this.getTestId() + "\"} ",
					com.anfelisa.user.data.UserRegistrationData.class);
			HttpResponse<Object> response_6 = 
			this.httpPost(
				"/users/register", 
			 	payload_6,
				null,
				uuid,
				null
			);
			
			if (response_6.getStatusCode() >= 400) {
				String statusMessage = response_6.getStatusMessage() != null ? response_6.getStatusMessage() : "";
				String message = "GIVEN RegisterUser fails\n" + statusMessage;
				LOG.error("GIVEN: RegisterUser fails due to {} in {} ms", message, response_6.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: RegisterUser success in {} ms", response_6.getDuration());
			addToMetrics("RegisterUser", response_6.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for RegisterUser not met");
		}

		if (prerequisite("CreateBoxMinimal")) {
			uuid = "boxId-" + this.getTestId() + "";
			com.anfelisa.box.data.CreateBoxPayload payload_7 = objectMapper.readValue("{" +
				"\"categoryName\" : \"cat\"," + 
				"\"dictionaryLookup\" : false," + 
				"\"maxCardsPerDay\" : 10} ",
					com.anfelisa.box.data.CreateBoxPayload.class);
			com.anfelisa.box.data.BoxCreationData data_7 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"categoryName\" : \"cat\"," + 
			"\"dictionaryLookup\" : false," + 
			"\"maxCardsPerDay\" : 10} ",
					com.anfelisa.box.data.BoxCreationData.class);
			HttpResponse<Object> response_7 = 
			this.httpPost(
				"/box/create", 
			 	payload_7,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			if (response_7.getStatusCode() >= 400) {
				String statusMessage = response_7.getStatusMessage() != null ? response_7.getStatusMessage() : "";
				String message = "GIVEN CreateBoxMinimal fails\n" + statusMessage;
				LOG.error("GIVEN: CreateBoxMinimal fails due to {} in {} ms", message, response_7.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: CreateBoxMinimal success in {} ms", response_7.getDuration());
			addToMetrics("CreateBox", response_7.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for CreateBoxMinimal not met");
		}

		if (prerequisite("CreateCategory")) {
			uuid = "cat1-" + this.getTestId() + "";
			com.anfelisa.category.data.CreateCategoryPayload payload_8 = objectMapper.readValue("{" +
				"\"categoryName\" : \"level 1 #1\"," + 
				"\"parentCategoryId\" : \"boxId-" + this.getTestId() + "\"} ",
					com.anfelisa.category.data.CreateCategoryPayload.class);
			com.anfelisa.category.data.CategoryCreationData data_8 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"categoryName\" : \"level 1 #1\"," + 
			"\"parentCategoryId\" : \"boxId-" + this.getTestId() + "\"} ",
					com.anfelisa.category.data.CategoryCreationData.class);
			HttpResponse<Object> response_8 = 
			this.httpPost(
				"/category/create", 
			 	payload_8,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			if (response_8.getStatusCode() >= 400) {
				String statusMessage = response_8.getStatusMessage() != null ? response_8.getStatusMessage() : "";
				String message = "GIVEN CreateCategory fails\n" + statusMessage;
				LOG.error("GIVEN: CreateCategory fails due to {} in {} ms", message, response_8.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: CreateCategory success in {} ms", response_8.getDuration());
			addToMetrics("CreateCategory", response_8.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for CreateCategory not met");
		}

		if (prerequisite("CreateCard")) {
			uuid = "c1-" + this.getTestId() + "";
			com.anfelisa.card.data.CreateCardPayload payload_9 = objectMapper.readValue("{" +
				"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
				"\"given\" : \"given\"," + 
				"\"wanted\" : \"wanted\"} ",
					com.anfelisa.card.data.CreateCardPayload.class);
			com.anfelisa.card.data.CardCreationData data_9 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
			"\"given\" : \"given\"," + 
			"\"wanted\" : \"wanted\"} ",
					com.anfelisa.card.data.CardCreationData.class);
			HttpResponse<Object> response_9 = 
			this.httpPost(
				"/card/create", 
			 	payload_9,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			if (response_9.getStatusCode() >= 400) {
				String statusMessage = response_9.getStatusMessage() != null ? response_9.getStatusMessage() : "";
				String message = "GIVEN CreateCard fails\n" + statusMessage;
				LOG.error("GIVEN: CreateCard fails due to {} in {} ms", message, response_9.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: CreateCard success in {} ms", response_9.getDuration());
			addToMetrics("CreateCard", response_9.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for CreateCard not met");
		}

		if (prerequisite("CreateSecondCard")) {
			uuid = "c2-" + this.getTestId() + "";
			com.anfelisa.card.data.CreateCardPayload payload_10 = objectMapper.readValue("{" +
				"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
				"\"given\" : \"given2\"," + 
				"\"wanted\" : \"wanted2\"} ",
					com.anfelisa.card.data.CreateCardPayload.class);
			com.anfelisa.card.data.CardCreationData data_10 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
			"\"given\" : \"given2\"," + 
			"\"wanted\" : \"wanted2\"} ",
					com.anfelisa.card.data.CardCreationData.class);
			HttpResponse<Object> response_10 = 
			this.httpPost(
				"/card/create", 
			 	payload_10,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			if (response_10.getStatusCode() >= 400) {
				String statusMessage = response_10.getStatusMessage() != null ? response_10.getStatusMessage() : "";
				String message = "GIVEN CreateSecondCard fails\n" + statusMessage;
				LOG.error("GIVEN: CreateSecondCard fails due to {} in {} ms", message, response_10.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: CreateSecondCard success in {} ms", response_10.getDuration());
			addToMetrics("CreateCard", response_10.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for CreateSecondCard not met");
		}

		if (prerequisite("CreateThirdCard")) {
			uuid = "c3-" + this.getTestId() + "";
			com.anfelisa.card.data.CreateCardPayload payload_11 = objectMapper.readValue("{" +
				"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
				"\"given\" : \"3given\"," + 
				"\"wanted\" : \"3wanted\"} ",
					com.anfelisa.card.data.CreateCardPayload.class);
			com.anfelisa.card.data.CardCreationData data_11 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
			"\"given\" : \"3given\"," + 
			"\"wanted\" : \"3wanted\"} ",
					com.anfelisa.card.data.CardCreationData.class);
			HttpResponse<Object> response_11 = 
			this.httpPost(
				"/card/create", 
			 	payload_11,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			if (response_11.getStatusCode() >= 400) {
				String statusMessage = response_11.getStatusMessage() != null ? response_11.getStatusMessage() : "";
				String message = "GIVEN CreateThirdCard fails\n" + statusMessage;
				LOG.error("GIVEN: CreateThirdCard fails due to {} in {} ms", message, response_11.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: CreateThirdCard success in {} ms", response_11.getDuration());
			addToMetrics("CreateCard", response_11.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for CreateThirdCard not met");
		}

		if (prerequisite("CreateFourthCard")) {
			uuid = "c4-" + this.getTestId() + "";
			com.anfelisa.card.data.CreateCardPayload payload_12 = objectMapper.readValue("{" +
				"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
				"\"given\" : \"4given4\"," + 
				"\"wanted\" : \"4wanted4\"} ",
					com.anfelisa.card.data.CreateCardPayload.class);
			com.anfelisa.card.data.CardCreationData data_12 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
			"\"given\" : \"4given4\"," + 
			"\"wanted\" : \"4wanted4\"} ",
					com.anfelisa.card.data.CardCreationData.class);
			HttpResponse<Object> response_12 = 
			this.httpPost(
				"/card/create", 
			 	payload_12,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			if (response_12.getStatusCode() >= 400) {
				String statusMessage = response_12.getStatusMessage() != null ? response_12.getStatusMessage() : "";
				String message = "GIVEN CreateFourthCard fails\n" + statusMessage;
				LOG.error("GIVEN: CreateFourthCard fails due to {} in {} ms", message, response_12.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: CreateFourthCard success in {} ms", response_12.getDuration());
			addToMetrics("CreateCard", response_12.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for CreateFourthCard not met");
		}

		if (prerequisite("CreateFifthCard")) {
			uuid = "c5-" + this.getTestId() + "";
			com.anfelisa.card.data.CreateCardPayload payload_13 = objectMapper.readValue("{" +
				"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
				"\"given\" : \"different\"," + 
				"\"wanted\" : \"different\"} ",
					com.anfelisa.card.data.CreateCardPayload.class);
			com.anfelisa.card.data.CardCreationData data_13 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
			"\"given\" : \"different\"," + 
			"\"wanted\" : \"different\"} ",
					com.anfelisa.card.data.CardCreationData.class);
			HttpResponse<Object> response_13 = 
			this.httpPost(
				"/card/create", 
			 	payload_13,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			if (response_13.getStatusCode() >= 400) {
				String statusMessage = response_13.getStatusMessage() != null ? response_13.getStatusMessage() : "";
				String message = "GIVEN CreateFifthCard fails\n" + statusMessage;
				LOG.error("GIVEN: CreateFifthCard fails due to {} in {} ms", message, response_13.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: CreateFifthCard success in {} ms", response_13.getDuration());
			addToMetrics("CreateCard", response_13.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for CreateFifthCard not met");
		}

		if (prerequisite("ScheduleCards")) {
			uuid = "sc1-" + this.getTestId() + "";
			this.callSquishyDataProviderPutSystemTime(uuid, LocalDateTime.parse("20200418 10:30", DateTimeFormatter.ofPattern("yyyyMMdd HH:mm")));
			com.anfelisa.box.data.ScheduleCardsPayload payload_14 = objectMapper.readValue("{" +
				"\"cardIds\" : [ \"c1-" + this.getTestId() + "\"," + 
				"\"c3-" + this.getTestId() + "\"," + 
				"\"c4-" + this.getTestId() + "\"]," + 
				"\"boxId\" : \"boxId-" + this.getTestId() + "\"} ",
					com.anfelisa.box.data.ScheduleCardsPayload.class);
			com.anfelisa.box.data.ScheduledCardsData data_14 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"cardIds\" : [ \"c1-" + this.getTestId() + "\"," + 
			"\"c3-" + this.getTestId() + "\"," + 
			"\"c4-" + this.getTestId() + "\"]," + 
			"\"boxId\" : \"boxId-" + this.getTestId() + "\"} ",
					com.anfelisa.box.data.ScheduledCardsData.class);
			HttpResponse<Object> response_14 = 
			this.httpPost(
				"/cards/schedule", 
			 	payload_14,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			if (response_14.getStatusCode() >= 400) {
				String statusMessage = response_14.getStatusMessage() != null ? response_14.getStatusMessage() : "";
				String message = "GIVEN ScheduleCards fails\n" + statusMessage;
				LOG.error("GIVEN: ScheduleCards fails due to {} in {} ms", message, response_14.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: ScheduleCards success in {} ms", response_14.getDuration());
			addToMetrics("ScheduleCards", response_14.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for ScheduleCards not met");
		}

		if (prerequisite("ScoreCard0")) {
			uuid = "score0-" + this.getTestId() + "";
			this.callSquishyDataProviderPutSystemTime(uuid, LocalDateTime.parse("20200418 16:30", DateTimeFormatter.ofPattern("yyyyMMdd HH:mm")));
			com.anfelisa.box.data.ScoreCardPayload payload_15 = objectMapper.readValue("{" +
				"\"scoredCardQuality\" : 0," + 
				"\"scheduledCardId\" : \"c1-" + this.getTestId() + "-sc1-" + this.getTestId() + "\"} ",
					com.anfelisa.box.data.ScoreCardPayload.class);
			com.anfelisa.box.data.ScoreCardData data_15 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"scoredCardQuality\" : 0," + 
			"\"scheduledCardId\" : \"c1-" + this.getTestId() + "-sc1-" + this.getTestId() + "\"} ",
					com.anfelisa.box.data.ScoreCardData.class);
			HttpResponse<Object> response_15 = 
			this.httpPost(
				"/card/score", 
			 	payload_15,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			if (response_15.getStatusCode() >= 400) {
				String statusMessage = response_15.getStatusMessage() != null ? response_15.getStatusMessage() : "";
				String message = "GIVEN ScoreCard0 fails\n" + statusMessage;
				LOG.error("GIVEN: ScoreCard0 fails due to {} in {} ms", message, response_15.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: ScoreCard0 success in {} ms", response_15.getDuration());
			addToMetrics("ScoreCard", response_15.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for ScoreCard0 not met");
		}

	}
	
	private HttpResponse<Object> when() throws Exception {
		String uuid = this.randomUUID();
		com.anfelisa.user.data.DeleteUserData data_0 = objectMapper.readValue("{" +
		"\"uuid\" : \"" + uuid + "\"," + 
		"\"usernameToBeDeleted\" : \"Annette-" + this.getTestId() + "\"} ",
				com.anfelisa.user.data.DeleteUserData.class);
		HttpResponse<Object> response = 
		this.httpDelete(
			"/user/delete?usernameToBeDeleted=" + data_0.getUsernameToBeDeleted() + "", 
			authorization("Annette-${testId}", "password"),
			uuid,
			null
		);
		
		LOG.info("WHEN: DeleteUser finished in {} ms", response.getDuration());
		if (response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
			addToMetrics("DeleteUser", response.getDuration());
		}
		return response;
	}
	
	private void then(HttpResponse<Object> response) throws Exception {
		if (response.getStatusCode() == 500) {
			String statusMessage = response.getStatusMessage() != null ? response.getStatusMessage() : "";
			LOG.error("THEN: status " + response.getStatusCode() + " failed: " + statusMessage);
			assertFail(statusMessage);
		}
		if (response.getStatusCode() != 200) {
			String statusMessage = response.getStatusMessage() != null ? response.getStatusMessage() : "";
			LOG.error("THEN: status " + response.getStatusCode() + " failed, expected 200: " + statusMessage);
			assertFail(statusMessage);
		} else {
			LOG.info("THEN: status 200 passed");
		}
		
	}
			
	@Override
	public void runTest() throws Exception {
		given();
			
		if (prerequisite("DeleteCascades")) {
			HttpResponse<Object> response = when();

			then(response);
			
			this.userWasDeleted();
			this.boxWasDeleted();
			this.accessToCategoryWasDeleted();
			this.allCategoriesWereDeleted();
			this.allCardsWereDeleted();
			this.allScheduledCardsWereDeleted();
			this.allReinforceCardsWereDeleted();
			this.otherUserWasNotDeleted();
			this.otherBoxWasNotDeleted();
			this.accessToCategoryOfOtherUserWasNotDeleted();
			this.categoriesOfOtherUserWereNotDeleted();
			this.cardsOfOtherUserWereNotDeleted();
			this.scheduledCardsOfOtherUserWereNotDeleted();
			this.reinforceCardsOfOtherUserWereNotDeleted();
	
		} else {
			LOG.info("WHEN: prerequisite for DeleteCascades not met");
		}
	}
	
	
	private void userWasDeleted() throws Exception {
		com.anfelisa.user.models.IUserModel actual = daoProvider.getUserDao().selectByUsername(handle, "Annette-" + this.getTestId() + "");
		
		assertIsNull(actual);
	
		LOG.info("THEN: userWasDeleted passed");
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
	private void otherUserWasNotDeleted() throws Exception {
		com.anfelisa.user.models.IUserModel actual = daoProvider.getUserDao().selectByUsername(handle, "Admin");
		
		assertIsNotNull(actual);
	
		LOG.info("THEN: otherUserWasNotDeleted passed");
	}
	private void otherBoxWasNotDeleted() throws Exception {
		com.anfelisa.box.models.IBoxModel actual = daoProvider.getBoxDao().selectByBoxId(handle, "adminBox-" + this.getTestId() + "");
		
		assertIsNotNull(actual);
	
		LOG.info("THEN: otherBoxWasNotDeleted passed");
	}
	private void accessToCategoryOfOtherUserWasNotDeleted() throws Exception {
		com.anfelisa.category.models.IUserAccessToCategoryModel actual = daoProvider.getUserAccessToCategoryDao().selectByPrimaryKey(handle, "adminBox-" + this.getTestId() + "", "uuid-admin");
		
		assertIsNotNull(actual);
	
		LOG.info("THEN: accessToCategoryOfOtherUserWasNotDeleted passed");
	}
	private void categoriesOfOtherUserWereNotDeleted() throws Exception {
		Map<String, String> filterMap = new HashMap<String, String>();
		filterMap.put("rootCategoryId", "adminBox-" + this.getTestId() + "");
		int actual = daoProvider.getCategoryDao().filterAndCountBy(handle, filterMap);
		
		assertThat(actual, 2);
	
		LOG.info("THEN: categoriesOfOtherUserWereNotDeleted passed");
	}
	private void cardsOfOtherUserWereNotDeleted() throws Exception {
		Map<String, String> filterMap = new HashMap<String, String>();
		filterMap.put("rootCategoryId", "adminBox-" + this.getTestId() + "");
		int actual = daoProvider.getCardDao().filterAndCountBy(handle, filterMap);
		
		assertThat(actual, 1);
	
		LOG.info("THEN: cardsOfOtherUserWereNotDeleted passed");
	}
	private void scheduledCardsOfOtherUserWereNotDeleted() throws Exception {
		Map<String, String> filterMap = new HashMap<String, String>();
		filterMap.put("boxId", "adminBox-" + this.getTestId() + "");
		int actual = daoProvider.getScheduledCardDao().filterAndCountBy(handle, filterMap);
		
		assertThat(actual, 2);
	
		LOG.info("THEN: scheduledCardsOfOtherUserWereNotDeleted passed");
	}
	private void reinforceCardsOfOtherUserWereNotDeleted() throws Exception {
		Map<String, String> filterMap = new HashMap<String, String>();
		filterMap.put("boxId", "adminBox-" + this.getTestId() + "");
		int actual = daoProvider.getReinforceCardDao().filterAndCountBy(handle, filterMap);
		
		assertThat(actual, 1);
	
		LOG.info("THEN: reinforceCardsOfOtherUserWereNotDeleted passed");
	}
		
	@Override
	protected String scenarioName() {
		return "DeleteCascades";
	}
	
}



/******* S.D.G. *******/




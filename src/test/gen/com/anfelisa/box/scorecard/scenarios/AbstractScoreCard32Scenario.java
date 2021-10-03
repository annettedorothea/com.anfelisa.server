/********************************************************************************
 * generated by de.acegen 1.5.6
 ********************************************************************************/




package com.anfelisa.box.scorecard.scenarios;

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
public abstract class AbstractScoreCard32Scenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractScoreCard32Scenario.class);
	
	private void given() throws Exception {
		String uuid;
		
		if (prerequisite("RegisterUser")) {
			uuid = "uuid-" + this.getTestId() + "";
			this.callSquishyDataProviderPutValue(uuid, "token",	"TOKEN-" + this.getTestId() + "");
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
				String message = "GIVEN RegisterUser fails\n" + statusMessage;
				LOG.error("GIVEN: RegisterUser fails due to {} in {} ms", message, response_0.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: RegisterUser success in {} ms", response_0.getDuration());
			addToMetrics("RegisterUser", response_0.getDuration());
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
			HttpResponse<Object> response_1 = 
			this.httpPost(
				"/box/create", 
			 	payload_1,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			if (response_1.getStatusCode() >= 400) {
				String statusMessage = response_1.getStatusMessage() != null ? response_1.getStatusMessage() : "";
				String message = "GIVEN CreateBoxMinimal fails\n" + statusMessage;
				LOG.error("GIVEN: CreateBoxMinimal fails due to {} in {} ms", message, response_1.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: CreateBoxMinimal success in {} ms", response_1.getDuration());
			addToMetrics("CreateBox", response_1.getDuration());
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
			HttpResponse<Object> response_2 = 
			this.httpPost(
				"/category/create", 
			 	payload_2,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			if (response_2.getStatusCode() >= 400) {
				String statusMessage = response_2.getStatusMessage() != null ? response_2.getStatusMessage() : "";
				String message = "GIVEN CreateCategory fails\n" + statusMessage;
				LOG.error("GIVEN: CreateCategory fails due to {} in {} ms", message, response_2.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: CreateCategory success in {} ms", response_2.getDuration());
			addToMetrics("CreateCategory", response_2.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for CreateCategory not met");
		}

		if (prerequisite("CreateCard")) {
			uuid = "c1-" + this.getTestId() + "";
			com.anfelisa.card.data.CreateCardPayload payload_3 = objectMapper.readValue("{" +
				"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
				"\"given\" : \"given\"," + 
				"\"wanted\" : \"wanted\"} ",
					com.anfelisa.card.data.CreateCardPayload.class);
			com.anfelisa.card.data.CardCreationData data_3 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
			"\"given\" : \"given\"," + 
			"\"wanted\" : \"wanted\"} ",
					com.anfelisa.card.data.CardCreationData.class);
			HttpResponse<Object> response_3 = 
			this.httpPost(
				"/card/create", 
			 	payload_3,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			if (response_3.getStatusCode() >= 400) {
				String statusMessage = response_3.getStatusMessage() != null ? response_3.getStatusMessage() : "";
				String message = "GIVEN CreateCard fails\n" + statusMessage;
				LOG.error("GIVEN: CreateCard fails due to {} in {} ms", message, response_3.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: CreateCard success in {} ms", response_3.getDuration());
			addToMetrics("CreateCard", response_3.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for CreateCard not met");
		}

		if (prerequisite("CreateSecondCard")) {
			uuid = "c2-" + this.getTestId() + "";
			com.anfelisa.card.data.CreateCardPayload payload_4 = objectMapper.readValue("{" +
				"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
				"\"given\" : \"given2\"," + 
				"\"wanted\" : \"wanted2\"} ",
					com.anfelisa.card.data.CreateCardPayload.class);
			com.anfelisa.card.data.CardCreationData data_4 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
			"\"given\" : \"given2\"," + 
			"\"wanted\" : \"wanted2\"} ",
					com.anfelisa.card.data.CardCreationData.class);
			HttpResponse<Object> response_4 = 
			this.httpPost(
				"/card/create", 
			 	payload_4,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			if (response_4.getStatusCode() >= 400) {
				String statusMessage = response_4.getStatusMessage() != null ? response_4.getStatusMessage() : "";
				String message = "GIVEN CreateSecondCard fails\n" + statusMessage;
				LOG.error("GIVEN: CreateSecondCard fails due to {} in {} ms", message, response_4.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: CreateSecondCard success in {} ms", response_4.getDuration());
			addToMetrics("CreateCard", response_4.getDuration());
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
			HttpResponse<Object> response_5 = 
			this.httpPost(
				"/card/create", 
			 	payload_5,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			if (response_5.getStatusCode() >= 400) {
				String statusMessage = response_5.getStatusMessage() != null ? response_5.getStatusMessage() : "";
				String message = "GIVEN CreateThirdCard fails\n" + statusMessage;
				LOG.error("GIVEN: CreateThirdCard fails due to {} in {} ms", message, response_5.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: CreateThirdCard success in {} ms", response_5.getDuration());
			addToMetrics("CreateCard", response_5.getDuration());
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
			HttpResponse<Object> response_6 = 
			this.httpPost(
				"/card/create", 
			 	payload_6,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			if (response_6.getStatusCode() >= 400) {
				String statusMessage = response_6.getStatusMessage() != null ? response_6.getStatusMessage() : "";
				String message = "GIVEN CreateFourthCard fails\n" + statusMessage;
				LOG.error("GIVEN: CreateFourthCard fails due to {} in {} ms", message, response_6.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: CreateFourthCard success in {} ms", response_6.getDuration());
			addToMetrics("CreateCard", response_6.getDuration());
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
			HttpResponse<Object> response_7 = 
			this.httpPost(
				"/card/create", 
			 	payload_7,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			if (response_7.getStatusCode() >= 400) {
				String statusMessage = response_7.getStatusMessage() != null ? response_7.getStatusMessage() : "";
				String message = "GIVEN CreateFifthCard fails\n" + statusMessage;
				LOG.error("GIVEN: CreateFifthCard fails due to {} in {} ms", message, response_7.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: CreateFifthCard success in {} ms", response_7.getDuration());
			addToMetrics("CreateCard", response_7.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for CreateFifthCard not met");
		}

		if (prerequisite("ScheduleCards")) {
			uuid = "sc1-" + this.getTestId() + "";
			this.callSquishyDataProviderPutSystemTime(uuid, LocalDateTime.parse("20200418 10:30", DateTimeFormatter.ofPattern("yyyyMMdd HH:mm")));
			com.anfelisa.box.data.ScheduleCardsPayload payload_8 = objectMapper.readValue("{" +
				"\"cardIds\" : [ \"c1-" + this.getTestId() + "\"," + 
				"\"c3-" + this.getTestId() + "\"," + 
				"\"c4-" + this.getTestId() + "\"]," + 
				"\"boxId\" : \"boxId-" + this.getTestId() + "\"} ",
					com.anfelisa.box.data.ScheduleCardsPayload.class);
			com.anfelisa.box.data.ScheduledCardsData data_8 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"cardIds\" : [ \"c1-" + this.getTestId() + "\"," + 
			"\"c3-" + this.getTestId() + "\"," + 
			"\"c4-" + this.getTestId() + "\"]," + 
			"\"boxId\" : \"boxId-" + this.getTestId() + "\"} ",
					com.anfelisa.box.data.ScheduledCardsData.class);
			HttpResponse<Object> response_8 = 
			this.httpPost(
				"/cards/schedule", 
			 	payload_8,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			if (response_8.getStatusCode() >= 400) {
				String statusMessage = response_8.getStatusMessage() != null ? response_8.getStatusMessage() : "";
				String message = "GIVEN ScheduleCards fails\n" + statusMessage;
				LOG.error("GIVEN: ScheduleCards fails due to {} in {} ms", message, response_8.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: ScheduleCards success in {} ms", response_8.getDuration());
			addToMetrics("ScheduleCards", response_8.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for ScheduleCards not met");
		}

		if (prerequisite("ScoreCard3")) {
			uuid = "score3-" + this.getTestId() + "";
			this.callSquishyDataProviderPutSystemTime(uuid, LocalDateTime.parse("20200418 16:30", DateTimeFormatter.ofPattern("yyyyMMdd HH:mm")));
			com.anfelisa.box.data.ScoreCardPayload payload_9 = objectMapper.readValue("{" +
				"\"scoredCardQuality\" : 3," + 
				"\"scheduledCardId\" : \"c1-" + this.getTestId() + "-sc1-" + this.getTestId() + "\"} ",
					com.anfelisa.box.data.ScoreCardPayload.class);
			com.anfelisa.box.data.ScoreCardData data_9 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"scoredCardQuality\" : 3," + 
			"\"scheduledCardId\" : \"c1-" + this.getTestId() + "-sc1-" + this.getTestId() + "\"} ",
					com.anfelisa.box.data.ScoreCardData.class);
			HttpResponse<Object> response_9 = 
			this.httpPost(
				"/card/score", 
			 	payload_9,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			if (response_9.getStatusCode() >= 400) {
				String statusMessage = response_9.getStatusMessage() != null ? response_9.getStatusMessage() : "";
				String message = "GIVEN ScoreCard3 fails\n" + statusMessage;
				LOG.error("GIVEN: ScoreCard3 fails due to {} in {} ms", message, response_9.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: ScoreCard3 success in {} ms", response_9.getDuration());
			addToMetrics("ScoreCard", response_9.getDuration());
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
			HttpResponse<Object> response_10 = 
			this.httpPut(
				"/box/update", 
			 	payload_10,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			if (response_10.getStatusCode() >= 400) {
				String statusMessage = response_10.getStatusMessage() != null ? response_10.getStatusMessage() : "";
				String message = "GIVEN UpdateBoxMaxInterval fails\n" + statusMessage;
				LOG.error("GIVEN: UpdateBoxMaxInterval fails due to {} in {} ms", message, response_10.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: UpdateBoxMaxInterval success in {} ms", response_10.getDuration());
			addToMetrics("UpdateBox", response_10.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for UpdateBoxMaxInterval not met");
		}

		if (prerequisite("ScoreCard31")) {
			uuid = "score31-" + this.getTestId() + "";
			this.callSquishyDataProviderPutSystemTime(uuid, LocalDateTime.parse("20200425 16:30", DateTimeFormatter.ofPattern("yyyyMMdd HH:mm")));
			com.anfelisa.box.data.ScoreCardPayload payload_11 = objectMapper.readValue("{" +
				"\"scoredCardQuality\" : 3," + 
				"\"scheduledCardId\" : \"score3-" + this.getTestId() + "\"} ",
					com.anfelisa.box.data.ScoreCardPayload.class);
			com.anfelisa.box.data.ScoreCardData data_11 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"scoredCardQuality\" : 3," + 
			"\"scheduledCardId\" : \"score3-" + this.getTestId() + "\"} ",
					com.anfelisa.box.data.ScoreCardData.class);
			HttpResponse<Object> response_11 = 
			this.httpPost(
				"/card/score", 
			 	payload_11,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			if (response_11.getStatusCode() >= 400) {
				String statusMessage = response_11.getStatusMessage() != null ? response_11.getStatusMessage() : "";
				String message = "GIVEN ScoreCard31 fails\n" + statusMessage;
				LOG.error("GIVEN: ScoreCard31 fails due to {} in {} ms", message, response_11.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: ScoreCard31 success in {} ms", response_11.getDuration());
			addToMetrics("ScoreCard", response_11.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for ScoreCard31 not met");
		}

	}
	
	private HttpResponse<Object> when() throws Exception {
		String uuid = "score32-" + this.getTestId() + "";
		this.callSquishyDataProviderPutSystemTime(uuid, LocalDateTime.parse("20200515 16:30", DateTimeFormatter.ofPattern("yyyyMMdd HH:mm")));
		com.anfelisa.box.data.ScoreCardPayload payload_0 = objectMapper.readValue("{" +
			"\"scoredCardQuality\" : 3," + 
			"\"scheduledCardId\" : \"score31-" + this.getTestId() + "\"} ",
				com.anfelisa.box.data.ScoreCardPayload.class);
		com.anfelisa.box.data.ScoreCardData data_0 = objectMapper.readValue("{" +
		"\"uuid\" : \"" + uuid + "\"," + 
		"\"scoredCardQuality\" : 3," + 
		"\"scheduledCardId\" : \"score31-" + this.getTestId() + "\"} ",
				com.anfelisa.box.data.ScoreCardData.class);
		HttpResponse<Object> response = 
		this.httpPost(
			"/card/score", 
		 	payload_0,
			authorization("Annette-${testId}", "password"),
			uuid,
			null
		);
		
		LOG.info("WHEN: ScoreCard finished in {} ms", response.getDuration());
		if (response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
			addToMetrics("ScoreCard", response.getDuration());
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
			
		if (prerequisite("ScoreCard32")) {
			HttpResponse<Object> response = when();

			then(response);
			
			this.newScheduledCardWasCreated();
	
		} else {
			LOG.info("WHEN: prerequisite for ScoreCard32 not met");
		}
	}
	
	
	private void newScheduledCardWasCreated() throws Exception {
		com.anfelisa.box.models.IScheduledCardModel actual = daoProvider.getScheduledCardDao().selectByScheduledCardId(handle, "score32-" + this.getTestId() + "");
		
		com.anfelisa.box.models.IScheduledCardModel expected = objectMapper.readValue("{" +
			"\"boxId\" : \"boxId-" + this.getTestId() + "\"," + 
			"\"cardId\" : \"c1-" + this.getTestId() + "\"," + 
			"\"count\" : 3," + 
			"\"createdDate\" : \"2020-05-15T16:30\"," + 
			"\"ef\" : \"2.08F\"," + 
			"\"interval\" : 27," + 
			"\"lastQuality\" : 3," + 
			"\"n\" : 4," + 
			"\"quality\" : null," + 
			"\"scheduledCardId\" : \"score32-" + this.getTestId() + "\"," + 
			"\"scheduledDate\" : \"2020-06-11T16:30\"," + 
			"\"scoredDate\" : null} ",
		com.anfelisa.box.models.ScheduledCardModel.class);
		assertThat(actual, expected);
	
		LOG.info("THEN: newScheduledCardWasCreated passed");
	}
		
	@Override
	protected String scenarioName() {
		return "ScoreCard32";
	}
	
}



/******* S.D.G. *******/




/********************************************************************************
 * generated by de.acegen 1.5.6
 ********************************************************************************/




package com.anfelisa.card.createcard.scenarios;

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
public abstract class AbstractCreateCardInOtherBoxScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractCreateCardInOtherBoxScenario.class);
	
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

		if (prerequisite("CreateSecondBox")) {
			uuid = "boxId2-" + this.getTestId() + "";
			com.anfelisa.box.data.CreateBoxPayload payload_2 = objectMapper.readValue("{" +
				"\"categoryName\" : \"cat2-" + this.getTestId() + "\"," + 
				"\"dictionaryLookup\" : false," + 
				"\"maxCardsPerDay\" : 8} ",
					com.anfelisa.box.data.CreateBoxPayload.class);
			com.anfelisa.box.data.BoxCreationData data_2 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"categoryName\" : \"cat2-" + this.getTestId() + "\"," + 
			"\"dictionaryLookup\" : false," + 
			"\"maxCardsPerDay\" : 8} ",
					com.anfelisa.box.data.BoxCreationData.class);
			HttpResponse<Object> response_2 = 
			this.httpPost(
				"/box/create", 
			 	payload_2,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			if (response_2.getStatusCode() >= 400) {
				String statusMessage = response_2.getStatusMessage() != null ? response_2.getStatusMessage() : "";
				String message = "GIVEN CreateSecondBox fails\n" + statusMessage;
				LOG.error("GIVEN: CreateSecondBox fails due to {} in {} ms", message, response_2.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: CreateSecondBox success in {} ms", response_2.getDuration());
			addToMetrics("CreateBox", response_2.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for CreateSecondBox not met");
		}

	}
	
	private HttpResponse<Object> when() throws Exception {
		String uuid = "c7-" + this.getTestId() + "";
		com.anfelisa.card.data.CreateCardPayload payload_0 = objectMapper.readValue("{" +
			"\"categoryId\" : \"boxId2-" + this.getTestId() + "\"," + 
			"\"given\" : \"given\"," + 
			"\"wanted\" : \"wanted\"} ",
				com.anfelisa.card.data.CreateCardPayload.class);
		com.anfelisa.card.data.CardCreationData data_0 = objectMapper.readValue("{" +
		"\"uuid\" : \"" + uuid + "\"," + 
		"\"categoryId\" : \"boxId2-" + this.getTestId() + "\"," + 
		"\"given\" : \"given\"," + 
		"\"wanted\" : \"wanted\"} ",
				com.anfelisa.card.data.CardCreationData.class);
		HttpResponse<Object> response = 
		this.httpPost(
			"/card/create", 
		 	payload_0,
			authorization("Annette-${testId}", "password"),
			uuid,
			null
		);
		
		LOG.info("WHEN: CreateCard finished in {} ms", response.getDuration());
		if (response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
			addToMetrics("CreateCard", response.getDuration());
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
			
		if (prerequisite("CreateCardInOtherBox")) {
			HttpResponse<Object> response = when();

			then(response);
			
			this.cardWasCreated();
	
		} else {
			LOG.info("WHEN: prerequisite for CreateCardInOtherBox not met");
		}
	}
	
	
	private void cardWasCreated() throws Exception {
		com.anfelisa.card.models.ICardModel actual = daoProvider.getCardDao().selectByPrimaryKey(handle, "c7-" + this.getTestId() + "");
		
		com.anfelisa.card.models.ICardModel expected = objectMapper.readValue("{" +
			"\"cardAuthor\" : \"Annette-" + this.getTestId() + "\"," + 
			"\"cardId\" : \"c7-" + this.getTestId() + "\"," + 
			"\"cardIndex\" : 1," + 
			"\"categoryId\" : \"boxId2-" + this.getTestId() + "\"," + 
			"\"given\" : \"given\"," + 
			"\"rootCategoryId\" : \"boxId2-" + this.getTestId() + "\"," + 
			"\"wanted\" : \"wanted\"} ",
		com.anfelisa.card.models.CardModel.class);
		assertThat(actual, expected);
	
		LOG.info("THEN: cardWasCreated passed");
	}
		
	@Override
	protected String scenarioName() {
		return "CreateCardInOtherBox";
	}
	
}



/******* S.D.G. *******/




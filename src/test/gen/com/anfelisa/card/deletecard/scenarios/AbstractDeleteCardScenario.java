/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.card.deletecard.scenarios;

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
public abstract class AbstractDeleteCardScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractDeleteCardScenario.class);
	
	private void given() throws Exception {
		String uuid;
		
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

	}
	
	private HttpResponse<Object> when() throws Exception {
		String uuid = this.randomUUID();
		com.anfelisa.card.data.CardDeleteData data_0 = objectMapper.readValue("{" +
		"\"uuid\" : \"" + uuid + "\"," + 
		"\"cardId\" : \"c1-" + this.getTestId() + "\"} ",
				com.anfelisa.card.data.CardDeleteData.class);
		HttpResponse<Object> response = 
		this.httpDelete(
			"/card/delete?cardId=" + data_0.getCardId() + "", 
			authorization("Annette-${testId}", "password"),
			uuid,
			null
		);
		
		LOG.info("WHEN: DeleteCard finished in {} ms", response.getDuration());
		if (response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
			addToMetrics("DeleteCard", response.getDuration());
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
			
		if (prerequisite("DeleteCard")) {
			HttpResponse<Object> response = when();

			then(response);
			
			this.cardWasDeleted();
	
		} else {
			LOG.info("WHEN: prerequisite for DeleteCard not met");
		}
	}
	
	
	private void cardWasDeleted() throws Exception {
		com.anfelisa.card.models.ICardModel actual = daoProvider.getCardDao().selectByCardId(handle, "c1-" + this.getTestId() + "");
		
		assertIsNull(actual);
	
		LOG.info("THEN: cardWasDeleted passed");
	}
		
	@Override
	protected String scenarioName() {
		return "DeleteCard";
	}
	
}



/******* S.D.G. *******/




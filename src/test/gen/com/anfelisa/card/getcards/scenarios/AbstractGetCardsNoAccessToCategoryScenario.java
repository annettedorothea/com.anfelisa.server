/********************************************************************************
 * generated by de.acegen 0.9.13
 ********************************************************************************/




package com.anfelisa.card.getcards.scenarios;

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
public abstract class AbstractGetCardsNoAccessToCategoryScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractGetCardsNoAccessToCategoryScenario.class);
	
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

		if (prerequisite("RegisterUserAdmin")) {
			uuid = "uuid-admin";
			this.callNonDeterministicDataProviderPutValue(uuid, "token", 
						objectMapper.readValue("\"ADMIN-TOKEN\"",  String.class));
			com.anfelisa.user.data.RegisterUserPayload payload_8 = objectMapper.readValue("{" +
				"\"email\" : \"annette.pohl@anfelisa.de\"," + 
				"\"language\" : \"de\"," + 
				"\"password\" : \"admin-password\"," + 
				"\"username\" : \"Admin\"} ",
					com.anfelisa.user.data.RegisterUserPayload.class);
			com.anfelisa.user.data.UserRegistrationData data_8 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"email\" : \"annette.pohl@anfelisa.de\"," + 
			"\"language\" : \"de\"," + 
			"\"password\" : \"admin-password\"," + 
			"\"username\" : \"Admin\"} ",
					com.anfelisa.user.data.UserRegistrationData.class);
			timeBeforeRequest = System.currentTimeMillis();
			HttpResponse<Object> response_8 = 
			this.httpPost(
				"/users/register", 
			 	payload_8,
				null,
				uuid,
				null
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response_8.getStatusCode() >= 400) {
				String message = "GIVEN RegisterUserAdmin fails\n" + response_8.getStatusMessage();
				LOG.info("GIVEN: RegisterUserAdmin fails due to {} in {} ms", message, (timeAfterRequest-timeBeforeRequest));
				addToMetrics("RegisterUser", (timeAfterRequest-timeBeforeRequest));
				assertFail(message);
			}
			LOG.info("GIVEN: RegisterUserAdmin success in {} ms", (timeAfterRequest-timeBeforeRequest));
			addToMetrics("RegisterUser", (timeAfterRequest-timeBeforeRequest));
		} else {
			LOG.info("GIVEN: prerequisite for RegisterUserAdmin not met");
		}

	}
	
	private HttpResponse<com.anfelisa.card.data.GetCardsResponse> when() throws Exception {
		String uuid = this.randomUUID();
		com.anfelisa.card.data.CardListData data_0 = objectMapper.readValue("{" +
		"\"uuid\" : \"" + uuid + "\"," + 
		"\"categoryId\" : \"cat1-" + this.getTestId() + "\"} ",
				com.anfelisa.card.data.CardListData.class);
		long timeBeforeRequest = System.currentTimeMillis();
		HttpResponse<com.anfelisa.card.data.GetCardsResponse> response = 
		this.httpGet(
			"/cards?categoryId=" + data_0.getCategoryId() + "", 
			authorization("Admin", "admin-password"),
			uuid,
			com.anfelisa.card.data.GetCardsResponse.class
		);
		
		long timeAfterRequest = System.currentTimeMillis();
		LOG.info("WHEN: GetCards finished in {} ms", (timeAfterRequest-timeBeforeRequest));
		addToMetrics("GetCards", (timeAfterRequest-timeBeforeRequest));
		return response;
	}
	
	private com.anfelisa.card.data.GetCardsResponse then(HttpResponse<com.anfelisa.card.data.GetCardsResponse> response) throws Exception {
		if (response.getStatusCode() == 500) {
			assertFail(response.getStatusMessage());
		}
		if (response.getStatusCode() != 401) {
			assertFail(response.getStatusMessage());
		} else {
			LOG.info("THEN: status 401 passed");
		}
		
				com.anfelisa.card.data.GetCardsResponse actual = null;
				if (response.getStatusCode() < 400) {
					try {
						actual = response.getEntity();
						//readEntity(com.anfelisa.card.data.GetCardsResponse.class);
						
					} catch (Exception x) {
						LOG.error("THEN: failed to read response", x);
						assertFail(x.getMessage());
					}

				}

				return actual;
	}
			
	@Override
	public void runTest() throws Exception {
		given();
			
		if (prerequisite("GetCardsNoAccessToCategory")) {
			HttpResponse<com.anfelisa.card.data.GetCardsResponse> response = when();

			com.anfelisa.card.data.GetCardsResponse actualResponse = then(response);
			
	
		} else {
			LOG.info("WHEN: prerequisite for GetCardsNoAccessToCategory not met");
		}
	}
	
	
		
	@Override
	protected String scenarioName() {
		return "GetCardsNoAccessToCategory";
	}
	
}



/******* S.D.G. *******/




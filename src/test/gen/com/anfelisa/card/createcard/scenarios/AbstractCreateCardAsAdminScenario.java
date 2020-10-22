/********************************************************************************
 * generated by de.acegen 0.9.13
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
import de.acegen.NonDeterministicDataProvider;
import de.acegen.HttpResponse;

@SuppressWarnings("unused")
public abstract class AbstractCreateCardAsAdminScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractCreateCardAsAdminScenario.class);
	
	private Map<String, Object> extractedValues = new HashMap<String, Object>();
	
	private void given() throws Exception {
		String uuid;
		long timeBeforeRequest;
		long timeAfterRequest;
		
		if (prerequisite("RegisterUserAdmin")) {
			uuid = "uuid-admin";
			this.callNonDeterministicDataProviderPutValue(uuid, "token", 
						objectMapper.readValue("\"ADMIN-TOKEN\"",  String.class));
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
				String message = "GIVEN RegisterUserAdmin fails\n" + response_0.getStatusMessage();
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
			timeBeforeRequest = System.currentTimeMillis();
			HttpResponse<Object> response_1 = 
			this.httpPost(
				"/box/create", 
			 	payload_1,
				authorization("Admin", "admin-password"),
				uuid,
				null
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response_1.getStatusCode() >= 400) {
				String message = "GIVEN CreateBoxMinimalAsAdmin fails\n" + response_1.getStatusMessage();
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
			com.anfelisa.category.data.CreateCategoryPayload payload_2 = objectMapper.readValue("{" +
				"\"categoryName\" : \"c\"," + 
				"\"parentCategoryId\" : \"adminBox-" + this.getTestId() + "\"} ",
					com.anfelisa.category.data.CreateCategoryPayload.class);
			com.anfelisa.category.data.CategoryCreationData data_2 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"categoryName\" : \"c\"," + 
			"\"parentCategoryId\" : \"adminBox-" + this.getTestId() + "\"} ",
					com.anfelisa.category.data.CategoryCreationData.class);
			timeBeforeRequest = System.currentTimeMillis();
			HttpResponse<Object> response_2 = 
			this.httpPost(
				"/category/create", 
			 	payload_2,
				authorization("Admin", "admin-password"),
				uuid,
				null
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response_2.getStatusCode() >= 400) {
				String message = "GIVEN CreateCategoryAsAdmin fails\n" + response_2.getStatusMessage();
				LOG.info("GIVEN: CreateCategoryAsAdmin fails due to {} in {} ms", message, (timeAfterRequest-timeBeforeRequest));
				addToMetrics("CreateCategory", (timeAfterRequest-timeBeforeRequest));
				assertFail(message);
			}
			LOG.info("GIVEN: CreateCategoryAsAdmin success in {} ms", (timeAfterRequest-timeBeforeRequest));
			addToMetrics("CreateCategory", (timeAfterRequest-timeBeforeRequest));
		} else {
			LOG.info("GIVEN: prerequisite for CreateCategoryAsAdmin not met");
		}

	}
	
	private HttpResponse<Object> when() throws Exception {
		String uuid = "c6-" + this.getTestId() + "";
		com.anfelisa.card.data.CreateCardPayload payload_0 = objectMapper.readValue("{" +
			"\"categoryId\" : \"adminCat-" + this.getTestId() + "\"," + 
			"\"given\" : \"given\"," + 
			"\"image\" : \"image\"," + 
			"\"wanted\" : \"wanted\"} ",
				com.anfelisa.card.data.CreateCardPayload.class);
		com.anfelisa.card.data.CardCreationData data_0 = objectMapper.readValue("{" +
		"\"uuid\" : \"" + uuid + "\"," + 
		"\"categoryId\" : \"adminCat-" + this.getTestId() + "\"," + 
		"\"given\" : \"given\"," + 
		"\"image\" : \"image\"," + 
		"\"wanted\" : \"wanted\"} ",
				com.anfelisa.card.data.CardCreationData.class);
		long timeBeforeRequest = System.currentTimeMillis();
		HttpResponse<Object> response = 
		this.httpPost(
			"/card/create", 
		 	payload_0,
			authorization("Admin", "admin-password"),
			uuid,
			null
		);
		
		long timeAfterRequest = System.currentTimeMillis();
		LOG.info("WHEN: CreateCard finished in {} ms", (timeAfterRequest-timeBeforeRequest));
		addToMetrics("CreateCard", (timeAfterRequest-timeBeforeRequest));
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
			
		if (prerequisite("CreateCardAsAdmin")) {
			HttpResponse<Object> response = when();

			then(response);
			
			this.cardWasCreated();
	
		} else {
			LOG.info("WHEN: prerequisite for CreateCardAsAdmin not met");
		}
	}
	
	
	private void cardWasCreated() throws Exception {
		com.anfelisa.card.models.ICardModel actual = daoProvider.getCardDao().selectByPrimaryKey(handle, "c6-" + this.getTestId() + "");
		
		com.anfelisa.card.models.ICardModel expected = objectMapper.readValue("{" +
			"\"cardAuthor\" : \"Admin\"," + 
			"\"cardId\" : \"c6-" + this.getTestId() + "\"," + 
			"\"cardIndex\" : 1," + 
			"\"categoryId\" : \"adminCat-" + this.getTestId() + "\"," + 
			"\"given\" : \"given\"," + 
			"\"image\" : \"image\"," + 
			"\"rootCategoryId\" : \"adminBox-" + this.getTestId() + "\"," + 
			"\"wanted\" : \"wanted\"} ",
		com.anfelisa.card.models.CardModel.class);
		assertThat(actual, expected);
	
		LOG.info("THEN: cardWasCreated passed");
	}
		
	@Override
	protected String scenarioName() {
		return "CreateCardAsAdmin";
	}
	
}



/******* S.D.G. *******/




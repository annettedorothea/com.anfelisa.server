/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.card.getduplicates.scenarios;

import java.util.Map;
import java.util.HashMap;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.acegen.BaseScenario;
import de.acegen.HttpResponse;
import de.acegen.Data;

import com.fasterxml.jackson.core.type.TypeReference;

@SuppressWarnings("unused")
public abstract class AbstractGetDuplicatesLimitScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractGetDuplicatesLimitScenario.class);
	
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
			com.anfelisa.user.models.UserRegistrationModel model_0 = objectMapper.readValue("{" +
				"\"email\" : \"annette.pohl@anfelisa.de\"," + 
				"\"language\" : \"de\"," + 
				"\"password\" : \"password\"," + 
				"\"username\" : \"Annette-" + this.getTestId() + "\"} ", com.anfelisa.user.models.UserRegistrationModel.class);
			Data<com.anfelisa.user.models.UserRegistrationModel> data_0 = new Data<com.anfelisa.user.models.UserRegistrationModel>(uuid);
			data_0.setModel(model_0);
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
			com.anfelisa.box.models.BoxCreationModel model_1 = objectMapper.readValue("{" +
				"\"categoryName\" : \"cat\"," + 
				"\"dictionaryLookup\" : false," + 
				"\"maxCardsPerDay\" : 10} ", com.anfelisa.box.models.BoxCreationModel.class);
			Data<com.anfelisa.box.models.BoxCreationModel> data_1 = new Data<com.anfelisa.box.models.BoxCreationModel>(uuid);
			data_1.setModel(model_1);
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
			com.anfelisa.category.models.CategoryCreationModel model_2 = objectMapper.readValue("{" +
				"\"categoryName\" : \"level 1 #1\"," + 
				"\"parentCategoryId\" : \"boxId-" + this.getTestId() + "\"} ", com.anfelisa.category.models.CategoryCreationModel.class);
			Data<com.anfelisa.category.models.CategoryCreationModel> data_2 = new Data<com.anfelisa.category.models.CategoryCreationModel>(uuid);
			data_2.setModel(model_2);
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

		for (int i=0; i<60; i++) {
			if (prerequisite("CreateRandomCard")) {
				uuid = "" + this.randomString() + "-" + this.getTestId() + "";
				com.anfelisa.card.data.CreateCardPayload payload_3 = objectMapper.readValue("{" +
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"given" + this.randomString() + "\"," + 
					"\"wanted\" : \"wanted" + this.randomString() + "\"} ",
						com.anfelisa.card.data.CreateCardPayload.class);
				com.anfelisa.card.models.CardCreationModel model_3 = objectMapper.readValue("{" +
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"given" + this.randomString() + "\"," + 
					"\"wanted\" : \"wanted" + this.randomString() + "\"} ", com.anfelisa.card.models.CardCreationModel.class);
				Data<com.anfelisa.card.models.CardCreationModel> data_3 = new Data<com.anfelisa.card.models.CardCreationModel>(uuid);
				data_3.setModel(model_3);
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
					String message = "GIVEN CreateRandomCard fails\n" + statusMessage;
					LOG.error("GIVEN: CreateRandomCard fails due to {} in {} ms", message, response_3.getDuration());
					assertFail(message);
				}
				LOG.info("GIVEN: CreateRandomCard success in {} ms", response_3.getDuration());
				addToMetrics("CreateCard", response_3.getDuration());
			} else {
				LOG.info("GIVEN: prerequisite for CreateRandomCard not met");
			}
		}

	}
	
	private HttpResponse<com.anfelisa.card.data.GetDuplicatesResponse> when_0() throws Exception {
		String uuid = this.randomUUID();
		com.anfelisa.card.models.CardSearchModel model_0 = objectMapper.readValue("{" +
			"\"categoryId\" : \"boxId-" + this.getTestId() + "\"," + 
			"\"given\" : \"ive\"," + 
			"\"wanted\" : \"nted\"," + 
			"\"naturalInputOrder\" : true} ", com.anfelisa.card.models.CardSearchModel.class);
		Data<com.anfelisa.card.models.CardSearchModel> data_0 = new Data<com.anfelisa.card.models.CardSearchModel>(uuid);
		data_0.setModel(model_0);
		HttpResponse<com.anfelisa.card.data.GetDuplicatesResponse> response = 
		this.httpGet(
			"/cards/search?given=" + (data_0.getModel().getGiven() != null ? URLEncoder.encode(data_0.getModel().getGiven(), StandardCharsets.UTF_8.toString()) : "") + "&wanted=" + (data_0.getModel().getWanted() != null ? URLEncoder.encode(data_0.getModel().getWanted(), StandardCharsets.UTF_8.toString()) : "") + "&naturalInputOrder=" + data_0.getModel().getNaturalInputOrder() + "&categoryId=" + (data_0.getModel().getCategoryId() != null ? URLEncoder.encode(data_0.getModel().getCategoryId(), StandardCharsets.UTF_8.toString()) : "") + "", 
			authorization("Annette-${testId}", "password"),
			uuid,
			com.anfelisa.card.data.GetDuplicatesResponse.class
		);
		
		LOG.info("WHEN: GetDuplicates finished in {} ms", response.getDuration());
		if (response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
			addToMetrics("GetDuplicates", response.getDuration());
		}
		return response;
	}
	
	private com.anfelisa.card.data.GetDuplicatesResponse then_0(HttpResponse<com.anfelisa.card.data.GetDuplicatesResponse> response) throws Exception {
		if (response.getStatusCode() == 500) {
			String statusMessage = response.getStatusMessage() != null ? response.getStatusMessage() : "";
			String errorMessage = "status " + response.getStatusCode() + " failed: " + statusMessage;
			LOG.error("THEN: " + errorMessage);
			assertFail(errorMessage);
		}
		if (response.getStatusCode() != 200) {
			String statusMessage = response.getStatusMessage() != null ? response.getStatusMessage() : "";
			String errorMessage = "status " + response.getStatusCode() + " failed, expected 200: " + statusMessage;
			LOG.error("THEN: " + errorMessage);
			assertFail(errorMessage);
		} else {
			LOG.info("THEN: status 200 passed");
		}
		
		com.anfelisa.card.data.GetDuplicatesResponse actual = null;
		if (response.getStatusCode() < 400) {
			try {
				actual = response.getEntity();
				
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
		
		if (prerequisite("GetDuplicatesLimit")) {
			
				HttpResponse<com.anfelisa.card.data.GetDuplicatesResponse> response_0 = when_0();
				com.anfelisa.card.data.GetDuplicatesResponse actualResponse_0 = then_0(response_0);
				shouldReturn25Items(actualResponse_0);
				
		
		} else {
			LOG.info("WHEN: prerequisite for GetDuplicatesLimit not met");
		}
		
			
	}
	
	protected abstract void shouldReturn25Items(com.anfelisa.card.data.GetDuplicatesResponse response);
	
		
	@Override
	protected String scenarioName() {
		return "GetDuplicatesLimit";
	}
	
}



/******* S.D.G. *******/




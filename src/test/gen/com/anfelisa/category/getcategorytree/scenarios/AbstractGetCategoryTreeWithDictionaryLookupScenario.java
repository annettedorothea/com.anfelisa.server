/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.category.getcategorytree.scenarios;

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
public abstract class AbstractGetCategoryTreeWithDictionaryLookupScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractGetCategoryTreeWithDictionaryLookupScenario.class);
	
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

		if (prerequisite("CreateBoxDictionaryLookup")) {
			uuid = "boxId-" + this.getTestId() + "";
			com.anfelisa.box.data.CreateBoxPayload payload_1 = objectMapper.readValue("{" +
				"\"categoryName\" : \"cat\"," + 
				"\"maxCardsPerDay\" : 10," + 
				"\"dictionaryLookup\" : true," + 
				"\"givenLanguage\" : \"de\"," + 
				"\"wantedLanguage\" : \"en\"} ",
					com.anfelisa.box.data.CreateBoxPayload.class);
			com.anfelisa.box.models.BoxCreationModel model_1 = objectMapper.readValue("{" +
				"\"categoryName\" : \"cat\"," + 
				"\"maxCardsPerDay\" : 10," + 
				"\"dictionaryLookup\" : true," + 
				"\"givenLanguage\" : \"de\"," + 
				"\"wantedLanguage\" : \"en\"} ", com.anfelisa.box.models.BoxCreationModel.class);
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
				String message = "GIVEN CreateBoxDictionaryLookup fails\n" + statusMessage;
				LOG.error("GIVEN: CreateBoxDictionaryLookup fails due to {} in {} ms", message, response_1.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: CreateBoxDictionaryLookup success in {} ms", response_1.getDuration());
			addToMetrics("CreateBox", response_1.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for CreateBoxDictionaryLookup not met");
		}

		if (prerequisite("CreateCategoryWithDictionaryLookup")) {
			uuid = "dict-" + this.getTestId() + "";
			com.anfelisa.category.data.CreateCategoryPayload payload_2 = objectMapper.readValue("{" +
				"\"categoryName\" : \"dict-" + this.getTestId() + "\"," + 
				"\"parentCategoryId\" : \"boxId-" + this.getTestId() + "\"} ",
					com.anfelisa.category.data.CreateCategoryPayload.class);
			com.anfelisa.category.models.CategoryCreationModel model_2 = objectMapper.readValue("{" +
				"\"categoryName\" : \"dict-" + this.getTestId() + "\"," + 
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
				String message = "GIVEN CreateCategoryWithDictionaryLookup fails\n" + statusMessage;
				LOG.error("GIVEN: CreateCategoryWithDictionaryLookup fails due to {} in {} ms", message, response_2.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: CreateCategoryWithDictionaryLookup success in {} ms", response_2.getDuration());
			addToMetrics("CreateCategory", response_2.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for CreateCategoryWithDictionaryLookup not met");
		}

	}
	
	private HttpResponse<com.anfelisa.category.data.GetCategoryTreeResponse> when_0() throws Exception {
		String uuid = this.randomUUID();
		com.anfelisa.category.models.CategoryTreeModel model_0 = objectMapper.readValue("{" +
			"\"rootCategoryId\" : \"boxId-" + this.getTestId() + "\"," + 
			"\"filterNonScheduled\" : false," + 
			"\"reverse\" : false} ", com.anfelisa.category.models.CategoryTreeModel.class);
		Data<com.anfelisa.category.models.CategoryTreeModel> data_0 = new Data<com.anfelisa.category.models.CategoryTreeModel>(uuid);
		data_0.setModel(model_0);
		HttpResponse<com.anfelisa.category.data.GetCategoryTreeResponse> response = 
		this.httpGet(
			"/category/tree?rootCategoryId=" + (data_0.getModel().getRootCategoryId() != null ? URLEncoder.encode(data_0.getModel().getRootCategoryId(), StandardCharsets.UTF_8.toString()) : "") + "&filterNonScheduled=" + data_0.getModel().getFilterNonScheduled() + "&priority=" + data_0.getModel().getPriority() + "&reverse=" + data_0.getModel().getReverse() + "", 
			authorization("Annette-${testId}", "password"),
			uuid,
			com.anfelisa.category.data.GetCategoryTreeResponse.class
		);
		
		LOG.info("WHEN: GetCategoryTree finished in {} ms", response.getDuration());
		if (response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
			addToMetrics("GetCategoryTree", response.getDuration());
		}
		return response;
	}
	
	private com.anfelisa.category.data.GetCategoryTreeResponse then_0(HttpResponse<com.anfelisa.category.data.GetCategoryTreeResponse> response) throws Exception {
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
		
		com.anfelisa.category.data.GetCategoryTreeResponse actual = null;
		if (response.getStatusCode() < 400) {
			try {
				actual = response.getEntity();
				
			} catch (Exception x) {
				LOG.error("THEN: failed to read response", x);
				assertFail(x.getMessage());
			}
	
			com.anfelisa.category.models.CategoryTreeModel expectedData = objectMapper.readValue("{" +
				"\"boxId\" : \"boxId-" + this.getTestId() + "\"," + 
				"\"reverseBoxExists\" : false," + 
				"\"rootCategory\" : { \"categoryId\" : \"boxId-" + this.getTestId() + "\"," + 
				"\"categoryIndex\" : null," + 
				"\"categoryName\" : \"cat\"," + 
				"\"dictionaryLookup\" : true," + 
				"\"givenLanguage\" : \"de\"," + 
				"\"wantedLanguage\" : \"en\"," + 
				"\"empty\" : false," + 
				"\"rootCategoryId\" : \"boxId-" + this.getTestId() + "\"," + 
				"\"editable\" : true," + 
				"\"childCategories\" : [ { \"categoryId\" : \"dict-" + this.getTestId() + "\"," + 
				"\"categoryIndex\" : 1," + 
				"\"categoryName\" : \"dict-" + this.getTestId() + "\"," + 
				"\"dictionaryLookup\" : true," + 
				"\"givenLanguage\" : \"de\"," + 
				"\"wantedLanguage\" : \"en\"," + 
				"\"empty\" : true," + 
				"\"parentCategoryId\" : \"boxId-" + this.getTestId() + "\"," + 
				"\"rootCategoryId\" : \"boxId-" + this.getTestId() + "\"," + 
				"\"editable\" : true," + 
				"\"childCategories\" : []}]}} ", com.anfelisa.category.models.CategoryTreeModel.class);
			
			com.anfelisa.category.data.GetCategoryTreeResponse expected = new com.anfelisa.category.data.GetCategoryTreeResponse(expectedData);
			
			assertThat(actual, expected);
			
			LOG.info("THEN: response passed");
		}
	
		return actual;
	}
			
	@Override
	public void runTest() throws Exception {
		given();
		
		if (prerequisite("GetCategoryTreeWithDictionaryLookup")) {
			
				HttpResponse<com.anfelisa.category.data.GetCategoryTreeResponse> response_0 = when_0();
				com.anfelisa.category.data.GetCategoryTreeResponse actualResponse_0 = then_0(response_0);
				
		
		} else {
			LOG.info("WHEN: prerequisite for GetCategoryTreeWithDictionaryLookup not met");
		}
		
			
	}
	
	
		
	@Override
	protected String scenarioName() {
		return "GetCategoryTreeWithDictionaryLookup";
	}
	
}



/******* S.D.G. *******/




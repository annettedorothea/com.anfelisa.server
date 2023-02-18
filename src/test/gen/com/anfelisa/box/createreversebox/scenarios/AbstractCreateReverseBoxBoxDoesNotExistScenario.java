/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.box.createreversebox.scenarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.acegen.BaseScenario;
import de.acegen.ITimelineItem;
import de.acegen.SquishyDataProvider;
import de.acegen.HttpResponse;
import de.acegen.Data;

import com.fasterxml.jackson.core.type.TypeReference;

@SuppressWarnings("unused")
public abstract class AbstractCreateReverseBoxBoxDoesNotExistScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractCreateReverseBoxBoxDoesNotExistScenario.class);
	
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

	}
	
	private HttpResponse<Object> when_0() throws Exception {
		String uuid = "reverseBoxId-" + this.getTestId() + "";
		com.anfelisa.box.data.CreateReverseBoxPayload payload_0 = objectMapper.readValue("{" +
			"\"rootCategoryId\" : \"xxx-" + this.getTestId() + "\"} ",
				com.anfelisa.box.data.CreateReverseBoxPayload.class);
		com.anfelisa.box.models.BoxCreationModel model_0 = objectMapper.readValue("{" +
			"\"rootCategoryId\" : \"xxx-" + this.getTestId() + "\"} ", com.anfelisa.box.models.BoxCreationModel.class);
		Data<com.anfelisa.box.models.BoxCreationModel> data_0 = new Data<com.anfelisa.box.models.BoxCreationModel>(uuid);
		data_0.setModel(model_0);
		HttpResponse<Object> response = 
		this.httpPost(
			"/box/create-reverse", 
		 	payload_0,
			authorization("Annette-${testId}", "password"),
			uuid,
			null
		);
		
		LOG.info("WHEN: CreateReverseBox finished in {} ms", response.getDuration());
		if (response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
			addToMetrics("CreateReverseBox", response.getDuration());
		}
		return response;
	}
	
	private void then_0(HttpResponse<Object> response) throws Exception {
		if (response.getStatusCode() == 500) {
			String statusMessage = response.getStatusMessage() != null ? response.getStatusMessage() : "";
			String errorMessage = "status " + response.getStatusCode() + " failed: " + statusMessage;
			LOG.error("THEN: " + errorMessage);
			assertFail(errorMessage);
		}
		if (response.getStatusCode() != 401) {
			String statusMessage = response.getStatusMessage() != null ? response.getStatusMessage() : "";
			String errorMessage = "status " + response.getStatusCode() + " failed, expected 401: " + statusMessage;
			LOG.error("THEN: " + errorMessage);
			assertFail(errorMessage);
		} else {
			LOG.info("THEN: status 401 passed");
		}
		
	}
			
	@Override
	public void runTest() throws Exception {
		given();
		
		if (prerequisite("CreateReverseBoxBoxDoesNotExist")) {
			
				HttpResponse<Object> response_0 = when_0();
				then_0(response_0);
				this.boxWasNotCreated();
				
		
		} else {
			LOG.info("WHEN: prerequisite for CreateReverseBoxBoxDoesNotExist not met");
		}
		
			
	}
	
	
	private void boxWasNotCreated() throws Exception {
		com.anfelisa.box.models.BoxModel actual = daoProvider.getBoxDao().selectByBoxId(handle, "reverseBoxId-" + this.getTestId() + "");
		
		assertIsNull(actual);
	
		LOG.info("THEN: boxWasNotCreated passed");
	}
		
	@Override
	protected String scenarioName() {
		return "CreateReverseBoxBoxDoesNotExist";
	}
	
}



/******* S.D.G. *******/




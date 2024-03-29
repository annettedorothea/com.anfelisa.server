/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.box.createbox.scenarios;

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
public abstract class AbstractCreateBoxCategoryNameEmptyScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractCreateBoxCategoryNameEmptyScenario.class);
	
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

	}
	
	private HttpResponse<Object> when_0() throws Exception {
		String uuid = "boxId-" + this.getTestId() + "";
		com.anfelisa.box.data.CreateBoxPayload payload_0 = objectMapper.readValue("{" +
			"\"categoryName\" : \"\"," + 
			"\"maxCardsPerDay\" : 10," + 
			"\"dictionaryLookup\" : false} ",
				com.anfelisa.box.data.CreateBoxPayload.class);
		com.anfelisa.box.models.BoxCreationModel model_0 = objectMapper.readValue("{" +
			"\"categoryName\" : \"\"," + 
			"\"maxCardsPerDay\" : 10," + 
			"\"dictionaryLookup\" : false} ", com.anfelisa.box.models.BoxCreationModel.class);
		Data<com.anfelisa.box.models.BoxCreationModel> data_0 = new Data<com.anfelisa.box.models.BoxCreationModel>(uuid);
		data_0.setModel(model_0);
		HttpResponse<Object> response = 
		this.httpPost(
			"/box/create", 
		 	payload_0,
			authorization("Annette-${testId}", "password"),
			uuid,
			null
		);
		
		LOG.info("WHEN: CreateBox finished in {} ms", response.getDuration());
		if (response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
			addToMetrics("CreateBox", response.getDuration());
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
		if (response.getStatusCode() != 400) {
			String statusMessage = response.getStatusMessage() != null ? response.getStatusMessage() : "";
			String errorMessage = "status " + response.getStatusCode() + " failed, expected 400: " + statusMessage;
			LOG.error("THEN: " + errorMessage);
			assertFail(errorMessage);
		} else {
			LOG.info("THEN: status 400 passed");
		}
		
	}
			
	@Override
	public void runTest() throws Exception {
		given();
		
		if (prerequisite("CreateBoxCategoryNameEmpty")) {
			
				HttpResponse<Object> response_0 = when_0();
				then_0(response_0);
				this.categoryWasNotCreated();
				this.accessWasNotGranted();
				this.boxWasNotCreated();
				
		
		} else {
			LOG.info("WHEN: prerequisite for CreateBoxCategoryNameEmpty not met");
		}
		
			
	}
	
	
	private void categoryWasNotCreated() throws Exception {
		com.anfelisa.category.models.CategoryModel actual = daoProvider.getCategoryDao().selectByCategoryId(handle, "boxId-" + this.getTestId() + "");
		
		assertIsNull(actual);
	
		LOG.info("THEN: categoryWasNotCreated passed");
	}
	private void accessWasNotGranted() throws Exception {
		com.anfelisa.category.models.UserAccessToCategoryModel actual = daoProvider.getUserAccessToCategoryDao().selectByPrimaryKey(handle, "boxId-" + this.getTestId() + "", "uuid-" + this.getTestId() + "");
		
		assertIsNull(actual);
	
		LOG.info("THEN: accessWasNotGranted passed");
	}
	private void boxWasNotCreated() throws Exception {
		com.anfelisa.box.models.BoxModel actual = daoProvider.getBoxDao().selectByBoxId(handle, "boxId-" + this.getTestId() + "");
		
		assertIsNull(actual);
	
		LOG.info("THEN: boxWasNotCreated passed");
	}
		
	@Override
	protected String scenarioName() {
		return "CreateBoxCategoryNameEmpty";
	}
	
}



/******* S.D.G. *******/




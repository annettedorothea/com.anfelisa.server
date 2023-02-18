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
public abstract class AbstractCreateSecondBoxScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractCreateSecondBoxScenario.class);
	
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
		String uuid = "boxId2-" + this.getTestId() + "";
		com.anfelisa.box.data.CreateBoxPayload payload_0 = objectMapper.readValue("{" +
			"\"categoryName\" : \"cat2-" + this.getTestId() + "\"," + 
			"\"dictionaryLookup\" : false," + 
			"\"maxCardsPerDay\" : 8} ",
				com.anfelisa.box.data.CreateBoxPayload.class);
		com.anfelisa.box.models.BoxCreationModel model_0 = objectMapper.readValue("{" +
			"\"categoryName\" : \"cat2-" + this.getTestId() + "\"," + 
			"\"dictionaryLookup\" : false," + 
			"\"maxCardsPerDay\" : 8} ", com.anfelisa.box.models.BoxCreationModel.class);
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
		if (response.getStatusCode() != 200) {
			String statusMessage = response.getStatusMessage() != null ? response.getStatusMessage() : "";
			String errorMessage = "status " + response.getStatusCode() + " failed, expected 200: " + statusMessage;
			LOG.error("THEN: " + errorMessage);
			assertFail(errorMessage);
		} else {
			LOG.info("THEN: status 200 passed");
		}
		
	}
			
	@Override
	public void runTest() throws Exception {
		given();
		
		if (prerequisite("CreateSecondBox")) {
			
				HttpResponse<Object> response_0 = when_0();
				then_0(response_0);
				this.categoryWasCreated();
				this.accessToCategoryWasGranted();
				this.boxWasCreated();
				
		
		} else {
			LOG.info("WHEN: prerequisite for CreateSecondBox not met");
		}
		
			
	}
	
	
	private void categoryWasCreated() throws Exception {
		com.anfelisa.category.models.CategoryModel actual = daoProvider.getCategoryDao().selectByCategoryId(handle, "boxId2-" + this.getTestId() + "");
		
		com.anfelisa.category.models.CategoryModel expected = objectMapper.readValue("{" +
			"\"categoryAuthor\" : \"Annette-" + this.getTestId() + "\"," + 
			"\"categoryId\" : \"boxId2-" + this.getTestId() + "\"," + 
			"\"categoryIndex\" : null," + 
			"\"categoryName\" : \"cat2-" + this.getTestId() + "\"," + 
			"\"dictionaryLookup\" : false," + 
			"\"parentCategoryId\" : null," + 
			"\"rootCategoryId\" : \"boxId2-" + this.getTestId() + "\"} ",
		com.anfelisa.category.models.CategoryModel.class);
		assertThat(actual, expected);
	
		LOG.info("THEN: categoryWasCreated passed");
	}
	private void accessToCategoryWasGranted() throws Exception {
		com.anfelisa.category.models.UserAccessToCategoryModel actual = daoProvider.getUserAccessToCategoryDao().selectByPrimaryKey(handle, "boxId2-" + this.getTestId() + "", "uuid-" + this.getTestId() + "");
		
		com.anfelisa.category.models.UserAccessToCategoryModel expected = objectMapper.readValue("{" +
			"\"categoryId\" : \"boxId2-" + this.getTestId() + "\"," + 
			"\"editable\" : true," + 
			"\"userId\" : \"uuid-" + this.getTestId() + "\"} ",
		com.anfelisa.category.models.UserAccessToCategoryModel.class);
		assertThat(actual, expected);
	
		LOG.info("THEN: accessToCategoryWasGranted passed");
	}
	private void boxWasCreated() throws Exception {
		com.anfelisa.box.models.BoxModel actual = daoProvider.getBoxDao().selectByBoxId(handle, "boxId2-" + this.getTestId() + "");
		
		com.anfelisa.box.models.BoxModel expected = objectMapper.readValue("{" +
			"\"boxId\" : \"boxId2-" + this.getTestId() + "\"," + 
			"\"categoryId\" : \"boxId2-" + this.getTestId() + "\"," + 
			"\"maxCardsPerDay\" : 8," + 
			"\"userId\" : \"uuid-" + this.getTestId() + "\"," + 
			"\"reverse\" : false," + 
			"\"archived\" : false} ",
		com.anfelisa.box.models.BoxModel.class);
		assertThat(actual, expected);
	
		LOG.info("THEN: boxWasCreated passed");
	}
		
	@Override
	protected String scenarioName() {
		return "CreateSecondBox";
	}
	
}



/******* S.D.G. *******/




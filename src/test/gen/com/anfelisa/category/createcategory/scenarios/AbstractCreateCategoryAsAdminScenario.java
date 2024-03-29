/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.category.createcategory.scenarios;

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
public abstract class AbstractCreateCategoryAsAdminScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractCreateCategoryAsAdminScenario.class);
	
	private void given() throws Exception {
		String uuid;
		
		if (prerequisite("RegisterUserAdmin")) {
			uuid = "uuid-admin";
			this.callSquishyDataProviderPutValue(uuid, "token",	"ADMIN-TOKEN");
			com.anfelisa.user.data.RegisterUserPayload payload_0 = objectMapper.readValue("{" +
				"\"email\" : \"annette.pohl@anfelisa.de\"," + 
				"\"language\" : \"de\"," + 
				"\"password\" : \"admin-password\"," + 
				"\"username\" : \"Admin\"} ",
					com.anfelisa.user.data.RegisterUserPayload.class);
			com.anfelisa.user.models.UserRegistrationModel model_0 = objectMapper.readValue("{" +
				"\"email\" : \"annette.pohl@anfelisa.de\"," + 
				"\"language\" : \"de\"," + 
				"\"password\" : \"admin-password\"," + 
				"\"username\" : \"Admin\"} ", com.anfelisa.user.models.UserRegistrationModel.class);
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
				String message = "GIVEN RegisterUserAdmin fails\n" + statusMessage;
				LOG.error("GIVEN: RegisterUserAdmin fails due to {} in {} ms", message, response_0.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: RegisterUserAdmin success in {} ms", response_0.getDuration());
			addToMetrics("RegisterUser", response_0.getDuration());
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
			com.anfelisa.box.models.BoxCreationModel model_1 = objectMapper.readValue("{" +
				"\"categoryName\" : \"adminBox-" + this.getTestId() + "\"," + 
				"\"dictionaryLookup\" : false," + 
				"\"maxCardsPerDay\" : 10} ", com.anfelisa.box.models.BoxCreationModel.class);
			Data<com.anfelisa.box.models.BoxCreationModel> data_1 = new Data<com.anfelisa.box.models.BoxCreationModel>(uuid);
			data_1.setModel(model_1);
			HttpResponse<Object> response_1 = 
			this.httpPost(
				"/box/create", 
			 	payload_1,
				authorization("Admin", "admin-password"),
				uuid,
				null
			);
			
			if (response_1.getStatusCode() >= 400) {
				String statusMessage = response_1.getStatusMessage() != null ? response_1.getStatusMessage() : "";
				String message = "GIVEN CreateBoxMinimalAsAdmin fails\n" + statusMessage;
				LOG.error("GIVEN: CreateBoxMinimalAsAdmin fails due to {} in {} ms", message, response_1.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: CreateBoxMinimalAsAdmin success in {} ms", response_1.getDuration());
			addToMetrics("CreateBox", response_1.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for CreateBoxMinimalAsAdmin not met");
		}

	}
	
	private HttpResponse<Object> when_0() throws Exception {
		String uuid = "adminCat-" + this.getTestId() + "";
		com.anfelisa.category.data.CreateCategoryPayload payload_0 = objectMapper.readValue("{" +
			"\"categoryName\" : \"c\"," + 
			"\"parentCategoryId\" : \"adminBox-" + this.getTestId() + "\"} ",
				com.anfelisa.category.data.CreateCategoryPayload.class);
		com.anfelisa.category.models.CategoryCreationModel model_0 = objectMapper.readValue("{" +
			"\"categoryName\" : \"c\"," + 
			"\"parentCategoryId\" : \"adminBox-" + this.getTestId() + "\"} ", com.anfelisa.category.models.CategoryCreationModel.class);
		Data<com.anfelisa.category.models.CategoryCreationModel> data_0 = new Data<com.anfelisa.category.models.CategoryCreationModel>(uuid);
		data_0.setModel(model_0);
		HttpResponse<Object> response = 
		this.httpPost(
			"/category/create", 
		 	payload_0,
			authorization("Admin", "admin-password"),
			uuid,
			null
		);
		
		LOG.info("WHEN: CreateCategory finished in {} ms", response.getDuration());
		if (response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
			addToMetrics("CreateCategory", response.getDuration());
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
		
		if (prerequisite("CreateCategoryAsAdmin")) {
			
				HttpResponse<Object> response_0 = when_0();
				then_0(response_0);
				this.adminCatWasCreated();
				
		
		} else {
			LOG.info("WHEN: prerequisite for CreateCategoryAsAdmin not met");
		}
		
			
	}
	
	
	private void adminCatWasCreated() throws Exception {
		com.anfelisa.category.models.CategoryModel actual = daoProvider.getCategoryDao().selectByCategoryId(handle, "adminCat-" + this.getTestId() + "");
		
		com.anfelisa.category.models.CategoryModel expected = objectMapper.readValue("{" +
			"\"categoryAuthor\" : \"Admin\"," + 
			"\"categoryId\" : \"adminCat-" + this.getTestId() + "\"," + 
			"\"categoryIndex\" : 1," + 
			"\"categoryName\" : \"c\"," + 
			"\"dictionaryLookup\" : false," + 
			"\"parentCategoryId\" : \"adminBox-" + this.getTestId() + "\"," + 
			"\"rootCategoryId\" : \"adminBox-" + this.getTestId() + "\"} ",
		com.anfelisa.category.models.CategoryModel.class);
		assertThat(actual, expected);
	
		LOG.info("THEN: adminCatWasCreated passed");
	}
		
	@Override
	protected String scenarioName() {
		return "CreateCategoryAsAdmin";
	}
	
}



/******* S.D.G. *******/




/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.category.updatecategory.scenarios;

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
public abstract class AbstractUpdateCategoryUnauthorizedScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractUpdateCategoryUnauthorizedScenario.class);
	
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

	}
	
	private HttpResponse<Object> when_0() throws Exception {
		String uuid = this.randomUUID();
		com.anfelisa.category.data.UpdateCategoryPayload payload_0 = objectMapper.readValue("{" +
			"\"categoryName\" : \"changed\"," + 
			"\"categoryId\" : \"cat1-" + this.getTestId() + "\"} ",
				com.anfelisa.category.data.UpdateCategoryPayload.class);
		com.anfelisa.category.models.CategoryUpdateModel model_0 = objectMapper.readValue("{" +
			"\"categoryName\" : \"changed\"," + 
			"\"categoryId\" : \"cat1-" + this.getTestId() + "\"} ", com.anfelisa.category.models.CategoryUpdateModel.class);
		Data<com.anfelisa.category.models.CategoryUpdateModel> data_0 = new Data<com.anfelisa.category.models.CategoryUpdateModel>(uuid);
		data_0.setModel(model_0);
		HttpResponse<Object> response = 
		this.httpPut(
			"/category/update", 
		 	payload_0,
			null,
			uuid,
			null
		);
		
		LOG.info("WHEN: UpdateCategory finished in {} ms", response.getDuration());
		if (response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
			addToMetrics("UpdateCategory", response.getDuration());
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
		
		if (prerequisite("UpdateCategoryUnauthorized")) {
			
				HttpResponse<Object> response_0 = when_0();
				then_0(response_0);
				this.categoryWasNotChanged();
				
		
		} else {
			LOG.info("WHEN: prerequisite for UpdateCategoryUnauthorized not met");
		}
		
			
	}
	
	
	private void categoryWasNotChanged() throws Exception {
		com.anfelisa.category.models.CategoryModel actual = daoProvider.getCategoryDao().selectByCategoryId(handle, "cat1-" + this.getTestId() + "");
		
		com.anfelisa.category.models.CategoryModel expected = objectMapper.readValue("{" +
			"\"categoryAuthor\" : \"Annette-" + this.getTestId() + "\"," + 
			"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
			"\"categoryIndex\" : 1," + 
			"\"categoryName\" : \"level 1 #1\"," + 
			"\"dictionaryLookup\" : false," + 
			"\"parentCategoryId\" : \"boxId-" + this.getTestId() + "\"," + 
			"\"rootCategoryId\" : \"boxId-" + this.getTestId() + "\"} ",
		com.anfelisa.category.models.CategoryModel.class);
		assertThat(actual, expected);
	
		LOG.info("THEN: categoryWasNotChanged passed");
	}
		
	@Override
	protected String scenarioName() {
		return "UpdateCategoryUnauthorized";
	}
	
}



/******* S.D.G. *******/




/********************************************************************************
 * generated by de.acegen 1.3.0
 ********************************************************************************/




package com.anfelisa.box.createbox.scenarios;

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
import de.acegen.SquishyDataProvider;
import de.acegen.HttpResponse;

@SuppressWarnings("unused")
public abstract class AbstractCreateBoxMinimalScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractCreateBoxMinimalScenario.class);
	
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

	}
	
	private HttpResponse<Object> when() throws Exception {
		String uuid = "boxId-" + this.getTestId() + "";
		com.anfelisa.box.data.CreateBoxPayload payload_0 = objectMapper.readValue("{" +
			"\"categoryName\" : \"cat\"," + 
			"\"dictionaryLookup\" : false," + 
			"\"maxCardsPerDay\" : 10} ",
				com.anfelisa.box.data.CreateBoxPayload.class);
		com.anfelisa.box.data.BoxCreationData data_0 = objectMapper.readValue("{" +
		"\"uuid\" : \"" + uuid + "\"," + 
		"\"categoryName\" : \"cat\"," + 
		"\"dictionaryLookup\" : false," + 
		"\"maxCardsPerDay\" : 10} ",
				com.anfelisa.box.data.BoxCreationData.class);
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
			
		if (prerequisite("CreateBoxMinimal")) {
			HttpResponse<Object> response = when();

			then(response);
			
			this.categoryWasCreated();
			this.accessToCategoryWasGranted();
			this.boxWasCreated();
	
		} else {
			LOG.info("WHEN: prerequisite for CreateBoxMinimal not met");
		}
	}
	
	
	private void categoryWasCreated() throws Exception {
		com.anfelisa.category.models.ICategoryModel actual = daoProvider.getCategoryDao().selectByCategoryId(handle, "boxId-" + this.getTestId() + "");
		
		com.anfelisa.category.models.ICategoryModel expected = objectMapper.readValue("{" +
			"\"categoryAuthor\" : \"Annette-" + this.getTestId() + "\"," + 
			"\"categoryId\" : \"boxId-" + this.getTestId() + "\"," + 
			"\"categoryIndex\" : null," + 
			"\"categoryName\" : \"cat\"," + 
			"\"dictionaryLookup\" : false," + 
			"\"parentCategoryId\" : null," + 
			"\"rootCategoryId\" : \"boxId-" + this.getTestId() + "\"} ",
		com.anfelisa.category.models.CategoryModel.class);
		assertThat(actual, expected);
	
		LOG.info("THEN: categoryWasCreated passed");
	}
	private void accessToCategoryWasGranted() throws Exception {
		com.anfelisa.category.models.IUserAccessToCategoryModel actual = daoProvider.getUserAccessToCategoryDao().selectByPrimaryKey(handle, "boxId-" + this.getTestId() + "", "uuid-" + this.getTestId() + "");
		
		com.anfelisa.category.models.IUserAccessToCategoryModel expected = objectMapper.readValue("{" +
			"\"categoryId\" : \"boxId-" + this.getTestId() + "\"," + 
			"\"editable\" : true," + 
			"\"userId\" : \"uuid-" + this.getTestId() + "\"} ",
		com.anfelisa.category.models.UserAccessToCategoryModel.class);
		assertThat(actual, expected);
	
		LOG.info("THEN: accessToCategoryWasGranted passed");
	}
	private void boxWasCreated() throws Exception {
		com.anfelisa.box.models.IBoxModel actual = daoProvider.getBoxDao().selectByBoxId(handle, "boxId-" + this.getTestId() + "");
		
		com.anfelisa.box.models.IBoxModel expected = objectMapper.readValue("{" +
			"\"boxId\" : \"boxId-" + this.getTestId() + "\"," + 
			"\"categoryId\" : \"boxId-" + this.getTestId() + "\"," + 
			"\"maxCardsPerDay\" : 10," + 
			"\"userId\" : \"uuid-" + this.getTestId() + "\"," + 
			"\"reverse\" : false," + 
			"\"archived\" : false} ",
		com.anfelisa.box.models.BoxModel.class);
		assertThat(actual, expected);
	
		LOG.info("THEN: boxWasCreated passed");
	}
		
	@Override
	protected String scenarioName() {
		return "CreateBoxMinimal";
	}
	
}



/******* S.D.G. *******/




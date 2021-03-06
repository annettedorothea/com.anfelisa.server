/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.category.movecategory.scenarios;

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
public abstract class AbstractMoveCategoryNoAccessToMovedCategoryScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractMoveCategoryNoAccessToMovedCategoryScenario.class);
	
	private void given() throws Exception {
		String uuid;
		
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
			HttpResponse<Object> response_0 = 
			this.httpPost(
				"/users/register", 
			 	payload_0,
				null,
				uuid,
				null
			);
			
			if (response_0.getStatusCode() >= 400) {
				String message = "GIVEN RegisterUser fails\n" + response_0.getStatusMessage();
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
			com.anfelisa.box.data.BoxCreationData data_1 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"categoryName\" : \"cat\"," + 
			"\"dictionaryLookup\" : false," + 
			"\"maxCardsPerDay\" : 10} ",
					com.anfelisa.box.data.BoxCreationData.class);
			HttpResponse<Object> response_1 = 
			this.httpPost(
				"/box/create", 
			 	payload_1,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			if (response_1.getStatusCode() >= 400) {
				String message = "GIVEN CreateBoxMinimal fails\n" + response_1.getStatusMessage();
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
			com.anfelisa.category.data.CategoryCreationData data_2 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"categoryName\" : \"level 1 #1\"," + 
			"\"parentCategoryId\" : \"boxId-" + this.getTestId() + "\"} ",
					com.anfelisa.category.data.CategoryCreationData.class);
			HttpResponse<Object> response_2 = 
			this.httpPost(
				"/category/create", 
			 	payload_2,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			if (response_2.getStatusCode() >= 400) {
				String message = "GIVEN CreateCategory fails\n" + response_2.getStatusMessage();
				LOG.error("GIVEN: CreateCategory fails due to {} in {} ms", message, response_2.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: CreateCategory success in {} ms", response_2.getDuration());
			addToMetrics("CreateCategory", response_2.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for CreateCategory not met");
		}

		if (prerequisite("CreateSecondCategory")) {
			uuid = "cat2-" + this.getTestId() + "";
			com.anfelisa.category.data.CreateCategoryPayload payload_3 = objectMapper.readValue("{" +
				"\"categoryName\" : \"level 1 #2\"," + 
				"\"parentCategoryId\" : \"boxId-" + this.getTestId() + "\"} ",
					com.anfelisa.category.data.CreateCategoryPayload.class);
			com.anfelisa.category.data.CategoryCreationData data_3 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"categoryName\" : \"level 1 #2\"," + 
			"\"parentCategoryId\" : \"boxId-" + this.getTestId() + "\"} ",
					com.anfelisa.category.data.CategoryCreationData.class);
			HttpResponse<Object> response_3 = 
			this.httpPost(
				"/category/create", 
			 	payload_3,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			if (response_3.getStatusCode() >= 400) {
				String message = "GIVEN CreateSecondCategory fails\n" + response_3.getStatusMessage();
				LOG.error("GIVEN: CreateSecondCategory fails due to {} in {} ms", message, response_3.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: CreateSecondCategory success in {} ms", response_3.getDuration());
			addToMetrics("CreateCategory", response_3.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for CreateSecondCategory not met");
		}

		if (prerequisite("CreateCategorySecondLevel")) {
			uuid = "cat3-" + this.getTestId() + "";
			com.anfelisa.category.data.CreateCategoryPayload payload_4 = objectMapper.readValue("{" +
				"\"categoryName\" : \"level 2 #1\"," + 
				"\"parentCategoryId\" : \"cat2-" + this.getTestId() + "\"} ",
					com.anfelisa.category.data.CreateCategoryPayload.class);
			com.anfelisa.category.data.CategoryCreationData data_4 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"categoryName\" : \"level 2 #1\"," + 
			"\"parentCategoryId\" : \"cat2-" + this.getTestId() + "\"} ",
					com.anfelisa.category.data.CategoryCreationData.class);
			HttpResponse<Object> response_4 = 
			this.httpPost(
				"/category/create", 
			 	payload_4,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			if (response_4.getStatusCode() >= 400) {
				String message = "GIVEN CreateCategorySecondLevel fails\n" + response_4.getStatusMessage();
				LOG.error("GIVEN: CreateCategorySecondLevel fails due to {} in {} ms", message, response_4.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: CreateCategorySecondLevel success in {} ms", response_4.getDuration());
			addToMetrics("CreateCategory", response_4.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for CreateCategorySecondLevel not met");
		}

		if (prerequisite("RegisterUserAdmin")) {
			uuid = "uuid-admin";
			this.callNonDeterministicDataProviderPutValue(uuid, "token", 
						objectMapper.readValue("\"ADMIN-TOKEN\"",  String.class));
			com.anfelisa.user.data.RegisterUserPayload payload_5 = objectMapper.readValue("{" +
				"\"email\" : \"annette.pohl@anfelisa.de\"," + 
				"\"language\" : \"de\"," + 
				"\"password\" : \"admin-password\"," + 
				"\"username\" : \"Admin\"} ",
					com.anfelisa.user.data.RegisterUserPayload.class);
			com.anfelisa.user.data.UserRegistrationData data_5 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"email\" : \"annette.pohl@anfelisa.de\"," + 
			"\"language\" : \"de\"," + 
			"\"password\" : \"admin-password\"," + 
			"\"username\" : \"Admin\"} ",
					com.anfelisa.user.data.UserRegistrationData.class);
			HttpResponse<Object> response_5 = 
			this.httpPost(
				"/users/register", 
			 	payload_5,
				null,
				uuid,
				null
			);
			
			if (response_5.getStatusCode() >= 400) {
				String message = "GIVEN RegisterUserAdmin fails\n" + response_5.getStatusMessage();
				LOG.error("GIVEN: RegisterUserAdmin fails due to {} in {} ms", message, response_5.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: RegisterUserAdmin success in {} ms", response_5.getDuration());
			addToMetrics("RegisterUser", response_5.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for RegisterUserAdmin not met");
		}

		if (prerequisite("CreateBoxMinimalAsAdmin")) {
			uuid = "adminBox-" + this.getTestId() + "";
			com.anfelisa.box.data.CreateBoxPayload payload_6 = objectMapper.readValue("{" +
				"\"categoryName\" : \"adminBox-" + this.getTestId() + "\"," + 
				"\"dictionaryLookup\" : false," + 
				"\"maxCardsPerDay\" : 10} ",
					com.anfelisa.box.data.CreateBoxPayload.class);
			com.anfelisa.box.data.BoxCreationData data_6 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"categoryName\" : \"adminBox-" + this.getTestId() + "\"," + 
			"\"dictionaryLookup\" : false," + 
			"\"maxCardsPerDay\" : 10} ",
					com.anfelisa.box.data.BoxCreationData.class);
			HttpResponse<Object> response_6 = 
			this.httpPost(
				"/box/create", 
			 	payload_6,
				authorization("Admin", "admin-password"),
				uuid,
				null
			);
			
			if (response_6.getStatusCode() >= 400) {
				String message = "GIVEN CreateBoxMinimalAsAdmin fails\n" + response_6.getStatusMessage();
				LOG.error("GIVEN: CreateBoxMinimalAsAdmin fails due to {} in {} ms", message, response_6.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: CreateBoxMinimalAsAdmin success in {} ms", response_6.getDuration());
			addToMetrics("CreateBox", response_6.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for CreateBoxMinimalAsAdmin not met");
		}

		if (prerequisite("CreateCategoryAsAdmin")) {
			uuid = "adminCat-" + this.getTestId() + "";
			com.anfelisa.category.data.CreateCategoryPayload payload_7 = objectMapper.readValue("{" +
				"\"categoryName\" : \"c\"," + 
				"\"parentCategoryId\" : \"adminBox-" + this.getTestId() + "\"} ",
					com.anfelisa.category.data.CreateCategoryPayload.class);
			com.anfelisa.category.data.CategoryCreationData data_7 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"categoryName\" : \"c\"," + 
			"\"parentCategoryId\" : \"adminBox-" + this.getTestId() + "\"} ",
					com.anfelisa.category.data.CategoryCreationData.class);
			HttpResponse<Object> response_7 = 
			this.httpPost(
				"/category/create", 
			 	payload_7,
				authorization("Admin", "admin-password"),
				uuid,
				null
			);
			
			if (response_7.getStatusCode() >= 400) {
				String message = "GIVEN CreateCategoryAsAdmin fails\n" + response_7.getStatusMessage();
				LOG.error("GIVEN: CreateCategoryAsAdmin fails due to {} in {} ms", message, response_7.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: CreateCategoryAsAdmin success in {} ms", response_7.getDuration());
			addToMetrics("CreateCategory", response_7.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for CreateCategoryAsAdmin not met");
		}

	}
	
	private HttpResponse<Object> when() throws Exception {
		String uuid = this.randomUUID();
		com.anfelisa.category.data.MoveCategoryPayload payload_0 = objectMapper.readValue("{" +
			"\"movedCategoryId\" : \"adminCat-" + this.getTestId() + "\"," + 
			"\"targetCategoryId\" : \"cat2-" + this.getTestId() + "\"} ",
				com.anfelisa.category.data.MoveCategoryPayload.class);
		com.anfelisa.category.data.CategoryMoveData data_0 = objectMapper.readValue("{" +
		"\"uuid\" : \"" + uuid + "\"," + 
		"\"movedCategoryId\" : \"adminCat-" + this.getTestId() + "\"," + 
		"\"targetCategoryId\" : \"cat2-" + this.getTestId() + "\"} ",
				com.anfelisa.category.data.CategoryMoveData.class);
		HttpResponse<Object> response = 
		this.httpPut(
			"/category/move", 
		 	payload_0,
			authorization("Annette-${testId}", "password"),
			uuid,
			null
		);
		
		LOG.info("WHEN: MoveCategory finished in {} ms", response.getDuration());
		if (response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
			addToMetrics("MoveCategory", response.getDuration());
		}
		return response;
	}
	
	private void then(HttpResponse<Object> response) throws Exception {
		if (response.getStatusCode() == 500) {
			LOG.error("THEN: status " + response.getStatusCode() + " failed: " + response.getStatusMessage());
			assertFail(response.getStatusMessage());
		}
		if (response.getStatusCode() != 401) {
			LOG.error("THEN: status " + response.getStatusCode() + " failed, expected 401: " + response.getStatusMessage());
			assertFail(response.getStatusMessage());
		} else {
			LOG.info("THEN: status 401 passed");
		}
		
	}
			
	@Override
	public void runTest() throws Exception {
		given();
			
		if (prerequisite("MoveCategoryNoAccessToMovedCategory")) {
			HttpResponse<Object> response = when();

			then(response);
			
			this.thirdCategoryWasNotTouched();
			this.secondCategoryWasNotTouched();
			this.firstCategoryWasNotTouched();
	
		} else {
			LOG.info("WHEN: prerequisite for MoveCategoryNoAccessToMovedCategory not met");
		}
	}
	
	
	private void thirdCategoryWasNotTouched() throws Exception {
		com.anfelisa.category.models.ICategoryModel actual = daoProvider.getCategoryDao().selectByCategoryId(handle, "cat3-" + this.getTestId() + "");
		
		com.anfelisa.category.models.ICategoryModel expected = objectMapper.readValue("{" +
			"\"categoryAuthor\" : \"Annette-" + this.getTestId() + "\"," + 
			"\"categoryId\" : \"cat3-" + this.getTestId() + "\"," + 
			"\"categoryIndex\" : 1," + 
			"\"categoryName\" : \"level 2 #1\"," + 
			"\"dictionaryLookup\" : false," + 
			"\"parentCategoryId\" : \"cat2-" + this.getTestId() + "\"," + 
			"\"rootCategoryId\" : \"boxId-" + this.getTestId() + "\"} ",
		com.anfelisa.category.models.CategoryModel.class);
		assertThat(actual, expected);
	
		LOG.info("THEN: thirdCategoryWasNotTouched passed");
	}
	private void secondCategoryWasNotTouched() throws Exception {
		com.anfelisa.category.models.ICategoryModel actual = daoProvider.getCategoryDao().selectByCategoryId(handle, "cat2-" + this.getTestId() + "");
		
		com.anfelisa.category.models.ICategoryModel expected = objectMapper.readValue("{" +
			"\"categoryAuthor\" : \"Annette-" + this.getTestId() + "\"," + 
			"\"categoryId\" : \"cat2-" + this.getTestId() + "\"," + 
			"\"categoryIndex\" : 2," + 
			"\"categoryName\" : \"level 1 #2\"," + 
			"\"dictionaryLookup\" : false," + 
			"\"parentCategoryId\" : \"boxId-" + this.getTestId() + "\"," + 
			"\"rootCategoryId\" : \"boxId-" + this.getTestId() + "\"} ",
		com.anfelisa.category.models.CategoryModel.class);
		assertThat(actual, expected);
	
		LOG.info("THEN: secondCategoryWasNotTouched passed");
	}
	private void firstCategoryWasNotTouched() throws Exception {
		com.anfelisa.category.models.ICategoryModel actual = daoProvider.getCategoryDao().selectByCategoryId(handle, "cat1-" + this.getTestId() + "");
		
		com.anfelisa.category.models.ICategoryModel expected = objectMapper.readValue("{" +
			"\"categoryAuthor\" : \"Annette-" + this.getTestId() + "\"," + 
			"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
			"\"categoryIndex\" : 1," + 
			"\"categoryName\" : \"level 1 #1\"," + 
			"\"dictionaryLookup\" : false," + 
			"\"parentCategoryId\" : \"boxId-" + this.getTestId() + "\"," + 
			"\"rootCategoryId\" : \"boxId-" + this.getTestId() + "\"} ",
		com.anfelisa.category.models.CategoryModel.class);
		assertThat(actual, expected);
	
		LOG.info("THEN: firstCategoryWasNotTouched passed");
	}
		
	@Override
	protected String scenarioName() {
		return "MoveCategoryNoAccessToMovedCategory";
	}
	
}



/******* S.D.G. *******/




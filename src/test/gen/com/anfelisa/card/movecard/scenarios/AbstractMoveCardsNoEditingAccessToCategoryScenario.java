/********************************************************************************
 * generated by de.acegen 1.6.4
 ********************************************************************************/




package com.anfelisa.card.movecard.scenarios;

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
public abstract class AbstractMoveCardsNoEditingAccessToCategoryScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractMoveCardsNoEditingAccessToCategoryScenario.class);
	
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

		if (prerequisite("CreateCard")) {
			uuid = "c1-" + this.getTestId() + "";
			com.anfelisa.card.data.CreateCardPayload payload_3 = objectMapper.readValue("{" +
				"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
				"\"given\" : \"given\"," + 
				"\"wanted\" : \"wanted\"} ",
					com.anfelisa.card.data.CreateCardPayload.class);
			com.anfelisa.card.data.CardCreationData data_3 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
			"\"given\" : \"given\"," + 
			"\"wanted\" : \"wanted\"} ",
					com.anfelisa.card.data.CardCreationData.class);
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
				String message = "GIVEN CreateCard fails\n" + statusMessage;
				LOG.error("GIVEN: CreateCard fails due to {} in {} ms", message, response_3.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: CreateCard success in {} ms", response_3.getDuration());
			addToMetrics("CreateCard", response_3.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for CreateCard not met");
		}

		if (prerequisite("CreateSecondCategory")) {
			uuid = "cat2-" + this.getTestId() + "";
			com.anfelisa.category.data.CreateCategoryPayload payload_4 = objectMapper.readValue("{" +
				"\"categoryName\" : \"level 1 #2\"," + 
				"\"parentCategoryId\" : \"boxId-" + this.getTestId() + "\"} ",
					com.anfelisa.category.data.CreateCategoryPayload.class);
			com.anfelisa.category.data.CategoryCreationData data_4 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"categoryName\" : \"level 1 #2\"," + 
			"\"parentCategoryId\" : \"boxId-" + this.getTestId() + "\"} ",
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
				String statusMessage = response_4.getStatusMessage() != null ? response_4.getStatusMessage() : "";
				String message = "GIVEN CreateSecondCategory fails\n" + statusMessage;
				LOG.error("GIVEN: CreateSecondCategory fails due to {} in {} ms", message, response_4.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: CreateSecondCategory success in {} ms", response_4.getDuration());
			addToMetrics("CreateCategory", response_4.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for CreateSecondCategory not met");
		}

		if (prerequisite("RegisterTwoUsers")) {
			uuid = "uuid2-" + this.getTestId() + "";
			this.callSquishyDataProviderPutValue(uuid, "token",	"TOKEN_2-" + this.getTestId() + "");
			com.anfelisa.user.data.RegisterUserPayload payload_5 = objectMapper.readValue("{" +
				"\"email\" : \"info@anfelisa.de\"," + 
				"\"language\" : \"de\"," + 
				"\"password\" : \"pw\"," + 
				"\"username\" : \"Anne-" + this.getTestId() + "\"} ",
					com.anfelisa.user.data.RegisterUserPayload.class);
			com.anfelisa.user.data.UserRegistrationData data_5 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"email\" : \"info@anfelisa.de\"," + 
			"\"language\" : \"de\"," + 
			"\"password\" : \"pw\"," + 
			"\"username\" : \"Anne-" + this.getTestId() + "\"} ",
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
				String statusMessage = response_5.getStatusMessage() != null ? response_5.getStatusMessage() : "";
				String message = "GIVEN RegisterTwoUsers fails\n" + statusMessage;
				LOG.error("GIVEN: RegisterTwoUsers fails due to {} in {} ms", message, response_5.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: RegisterTwoUsers success in {} ms", response_5.getDuration());
			addToMetrics("RegisterUser", response_5.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for RegisterTwoUsers not met");
		}

		if (prerequisite("InviteUserToCategory")) {
			uuid = "boxIdOfInvitedUser-" + this.getTestId() + "";
			com.anfelisa.category.data.InviteUserToCategoryPayload payload_6 = objectMapper.readValue("{" +
				"\"categoryId\" : \"boxId-" + this.getTestId() + "\"," + 
				"\"invitedUsername\" : \"Anne-" + this.getTestId() + "\"} ",
					com.anfelisa.category.data.InviteUserToCategoryPayload.class);
			com.anfelisa.category.data.UserToCategoryInvitationData data_6 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"categoryId\" : \"boxId-" + this.getTestId() + "\"," + 
			"\"invitedUsername\" : \"Anne-" + this.getTestId() + "\"} ",
					com.anfelisa.category.data.UserToCategoryInvitationData.class);
			HttpResponse<Object> response_6 = 
			this.httpPut(
				"/category/invite", 
			 	payload_6,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			if (response_6.getStatusCode() >= 400) {
				String statusMessage = response_6.getStatusMessage() != null ? response_6.getStatusMessage() : "";
				String message = "GIVEN InviteUserToCategory fails\n" + statusMessage;
				LOG.error("GIVEN: InviteUserToCategory fails due to {} in {} ms", message, response_6.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: InviteUserToCategory success in {} ms", response_6.getDuration());
			addToMetrics("InviteUserToCategory", response_6.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for InviteUserToCategory not met");
		}

	}
	
	private HttpResponse<Object> when() throws Exception {
		String uuid = this.randomUUID();
		com.anfelisa.card.data.MoveCardsPayload payload_0 = objectMapper.readValue("{" +
			"\"categoryId\" : \"cat2-" + this.getTestId() + "\"," + 
			"\"cardIdList\" : [ \"c1-" + this.getTestId() + "\"]} ",
				com.anfelisa.card.data.MoveCardsPayload.class);
		com.anfelisa.card.data.MoveCardsData data_0 = objectMapper.readValue("{" +
		"\"uuid\" : \"" + uuid + "\"," + 
		"\"categoryId\" : \"cat2-" + this.getTestId() + "\"," + 
		"\"cardIdList\" : [ \"c1-" + this.getTestId() + "\"]} ",
				com.anfelisa.card.data.MoveCardsData.class);
		HttpResponse<Object> response = 
		this.httpPut(
			"/cards/move", 
		 	payload_0,
			authorization("Anne-${testId}", "pw"),
			uuid,
			null
		);
		
		LOG.info("WHEN: MoveCards finished in {} ms", response.getDuration());
		if (response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
			addToMetrics("MoveCards", response.getDuration());
		}
		return response;
	}
	
	private void then(HttpResponse<Object> response) throws Exception {
		if (response.getStatusCode() == 500) {
			String statusMessage = response.getStatusMessage() != null ? response.getStatusMessage() : "";
			LOG.error("THEN: status " + response.getStatusCode() + " failed: " + statusMessage);
			assertFail(statusMessage);
		}
		if (response.getStatusCode() != 401) {
			String statusMessage = response.getStatusMessage() != null ? response.getStatusMessage() : "";
			LOG.error("THEN: status " + response.getStatusCode() + " failed, expected 401: " + statusMessage);
			assertFail(statusMessage);
		} else {
			LOG.info("THEN: status 401 passed");
		}
		
	}
			
	@Override
	public void runTest() throws Exception {
		given();
			
		if (prerequisite("MoveCardsNoEditingAccessToCategory")) {
			HttpResponse<Object> response = when();

			then(response);
			
			this.firstCard();
	
		} else {
			LOG.info("WHEN: prerequisite for MoveCardsNoEditingAccessToCategory not met");
		}
	}
	
	
	private void firstCard() throws Exception {
		com.anfelisa.card.models.ICardModel actual = daoProvider.getCardDao().selectByPrimaryKey(handle, "c1-" + this.getTestId() + "");
		
		com.anfelisa.card.models.ICardModel expected = objectMapper.readValue("{" +
			"\"cardAuthor\" : \"Annette-" + this.getTestId() + "\"," + 
			"\"cardId\" : \"c1-" + this.getTestId() + "\"," + 
			"\"cardIndex\" : 1," + 
			"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
			"\"given\" : \"given\"," + 
			"\"rootCategoryId\" : \"boxId-" + this.getTestId() + "\"," + 
			"\"wanted\" : \"wanted\"} ",
		com.anfelisa.card.models.CardModel.class);
		assertThat(actual, expected);
	
		LOG.info("THEN: firstCard passed");
	}
		
	@Override
	protected String scenarioName() {
		return "MoveCardsNoEditingAccessToCategory";
	}
	
}



/******* S.D.G. *******/




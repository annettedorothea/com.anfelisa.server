/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.category.inviteusertocategory.scenarios;

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
public abstract class AbstractInviteUserToCategoryUseMaxCardsPerDayAndMaxIntervalOfOriginalBoxScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractInviteUserToCategoryUseMaxCardsPerDayAndMaxIntervalOfOriginalBoxScenario.class);
	
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

		if (prerequisite("CreateBoxMinimalWithMaxCardsPerDayAndMaxInterval")) {
			uuid = "boxId-" + this.getTestId() + "";
			com.anfelisa.box.data.CreateBoxPayload payload_1 = objectMapper.readValue("{" +
				"\"categoryName\" : \"cat\"," + 
				"\"dictionaryLookup\" : false," + 
				"\"maxCardsPerDay\" : 3," + 
				"\"maxInterval\" : 14} ",
					com.anfelisa.box.data.CreateBoxPayload.class);
			com.anfelisa.box.models.BoxCreationModel model_1 = objectMapper.readValue("{" +
				"\"categoryName\" : \"cat\"," + 
				"\"dictionaryLookup\" : false," + 
				"\"maxCardsPerDay\" : 3," + 
				"\"maxInterval\" : 14} ", com.anfelisa.box.models.BoxCreationModel.class);
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
				String message = "GIVEN CreateBoxMinimalWithMaxCardsPerDayAndMaxInterval fails\n" + statusMessage;
				LOG.error("GIVEN: CreateBoxMinimalWithMaxCardsPerDayAndMaxInterval fails due to {} in {} ms", message, response_1.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: CreateBoxMinimalWithMaxCardsPerDayAndMaxInterval success in {} ms", response_1.getDuration());
			addToMetrics("CreateBox", response_1.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for CreateBoxMinimalWithMaxCardsPerDayAndMaxInterval not met");
		}

		if (prerequisite("RegisterTwoUsers")) {
			uuid = "uuid2-" + this.getTestId() + "";
			this.callSquishyDataProviderPutValue(uuid, "token",	"TOKEN_2-" + this.getTestId() + "");
			com.anfelisa.user.data.RegisterUserPayload payload_2 = objectMapper.readValue("{" +
				"\"email\" : \"info@anfelisa.de\"," + 
				"\"language\" : \"de\"," + 
				"\"password\" : \"pw\"," + 
				"\"username\" : \"Anne-" + this.getTestId() + "\"} ",
					com.anfelisa.user.data.RegisterUserPayload.class);
			com.anfelisa.user.models.UserRegistrationModel model_2 = objectMapper.readValue("{" +
				"\"email\" : \"info@anfelisa.de\"," + 
				"\"language\" : \"de\"," + 
				"\"password\" : \"pw\"," + 
				"\"username\" : \"Anne-" + this.getTestId() + "\"} ", com.anfelisa.user.models.UserRegistrationModel.class);
			Data<com.anfelisa.user.models.UserRegistrationModel> data_2 = new Data<com.anfelisa.user.models.UserRegistrationModel>(uuid);
			data_2.setModel(model_2);
			HttpResponse<Object> response_2 = 
			this.httpPost(
				"/users/register", 
			 	payload_2,
				null,
				uuid,
				null
			);
			
			if (response_2.getStatusCode() >= 400) {
				String statusMessage = response_2.getStatusMessage() != null ? response_2.getStatusMessage() : "";
				String message = "GIVEN RegisterTwoUsers fails\n" + statusMessage;
				LOG.error("GIVEN: RegisterTwoUsers fails due to {} in {} ms", message, response_2.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: RegisterTwoUsers success in {} ms", response_2.getDuration());
			addToMetrics("RegisterUser", response_2.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for RegisterTwoUsers not met");
		}

	}
	
	private HttpResponse<Object> when_0() throws Exception {
		String uuid = "boxIdOfInvitedUser-" + this.getTestId() + "";
		com.anfelisa.category.data.InviteUserToCategoryPayload payload_0 = objectMapper.readValue("{" +
			"\"categoryId\" : \"boxId-" + this.getTestId() + "\"," + 
			"\"invitedUsername\" : \"Anne-" + this.getTestId() + "\"," + 
			"\"editable\" : true} ",
				com.anfelisa.category.data.InviteUserToCategoryPayload.class);
		com.anfelisa.category.models.UserToCategoryInvitationModel model_0 = objectMapper.readValue("{" +
			"\"categoryId\" : \"boxId-" + this.getTestId() + "\"," + 
			"\"invitedUsername\" : \"Anne-" + this.getTestId() + "\"," + 
			"\"editable\" : true} ", com.anfelisa.category.models.UserToCategoryInvitationModel.class);
		Data<com.anfelisa.category.models.UserToCategoryInvitationModel> data_0 = new Data<com.anfelisa.category.models.UserToCategoryInvitationModel>(uuid);
		data_0.setModel(model_0);
		HttpResponse<Object> response = 
		this.httpPut(
			"/category/invite", 
		 	payload_0,
			authorization("Annette-${testId}", "password"),
			uuid,
			null
		);
		
		LOG.info("WHEN: InviteUserToCategory finished in {} ms", response.getDuration());
		if (response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
			addToMetrics("InviteUserToCategory", response.getDuration());
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
		
		if (prerequisite("InviteUserToCategoryUseMaxCardsPerDayAndMaxIntervalOfOriginalBox")) {
			
				HttpResponse<Object> response_0 = when_0();
				then_0(response_0);
				this.accessToCategoryWasGranted();
				this.boxWasCreated();
				
		
		} else {
			LOG.info("WHEN: prerequisite for InviteUserToCategoryUseMaxCardsPerDayAndMaxIntervalOfOriginalBox not met");
		}
		
			
	}
	
	
	private void accessToCategoryWasGranted() throws Exception {
		com.anfelisa.category.models.UserAccessToCategoryModel actual = daoProvider.getUserAccessToCategoryDao().selectByPrimaryKey(handle, "boxId-" + this.getTestId() + "", "uuid2-" + this.getTestId() + "");
		
		com.anfelisa.category.models.UserAccessToCategoryModel expected = objectMapper.readValue("{" +
			"\"categoryId\" : \"boxId-" + this.getTestId() + "\"," + 
			"\"editable\" : true," + 
			"\"userId\" : \"uuid2-" + this.getTestId() + "\"} ",
		com.anfelisa.category.models.UserAccessToCategoryModel.class);
		assertThat(actual, expected);
	
		LOG.info("THEN: accessToCategoryWasGranted passed");
	}
	private void boxWasCreated() throws Exception {
		com.anfelisa.box.models.BoxModel actual = daoProvider.getBoxDao().selectByPrimaryKey(handle, "boxIdOfInvitedUser-" + this.getTestId() + "");
		
		com.anfelisa.box.models.BoxModel expected = objectMapper.readValue("{" +
			"\"categoryId\" : \"boxId-" + this.getTestId() + "\"," + 
			"\"userId\" : \"uuid2-" + this.getTestId() + "\"," + 
			"\"boxId\" : \"boxIdOfInvitedUser-" + this.getTestId() + "\"," + 
			"\"maxCardsPerDay\" : 3," + 
			"\"maxInterval\" : 14," + 
			"\"reverse\" : false," + 
			"\"archived\" : false} ",
		com.anfelisa.box.models.BoxModel.class);
		assertThat(actual, expected);
	
		LOG.info("THEN: boxWasCreated passed");
	}
		
	@Override
	protected String scenarioName() {
		return "InviteUserToCategoryUseMaxCardsPerDayAndMaxIntervalOfOriginalBox";
	}
	
}



/******* S.D.G. *******/




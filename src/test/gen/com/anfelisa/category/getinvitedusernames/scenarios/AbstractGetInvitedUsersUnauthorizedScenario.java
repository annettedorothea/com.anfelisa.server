/********************************************************************************
 * generated by de.acegen 1.6.0
 ********************************************************************************/




package com.anfelisa.category.getinvitedusernames.scenarios;

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
public abstract class AbstractGetInvitedUsersUnauthorizedScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractGetInvitedUsersUnauthorizedScenario.class);
	
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

		if (prerequisite("RegisterTwoUsers")) {
			uuid = "uuid2-" + this.getTestId() + "";
			this.callSquishyDataProviderPutValue(uuid, "token",	"TOKEN_2-" + this.getTestId() + "");
			com.anfelisa.user.data.RegisterUserPayload payload_2 = objectMapper.readValue("{" +
				"\"email\" : \"info@anfelisa.de\"," + 
				"\"language\" : \"de\"," + 
				"\"password\" : \"pw\"," + 
				"\"username\" : \"Anne-" + this.getTestId() + "\"} ",
					com.anfelisa.user.data.RegisterUserPayload.class);
			com.anfelisa.user.data.UserRegistrationData data_2 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"email\" : \"info@anfelisa.de\"," + 
			"\"language\" : \"de\"," + 
			"\"password\" : \"pw\"," + 
			"\"username\" : \"Anne-" + this.getTestId() + "\"} ",
					com.anfelisa.user.data.UserRegistrationData.class);
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

		if (prerequisite("InviteUserToCategory")) {
			uuid = "boxIdOfInvitedUser-" + this.getTestId() + "";
			com.anfelisa.category.data.InviteUserToCategoryPayload payload_3 = objectMapper.readValue("{" +
				"\"categoryId\" : \"boxId-" + this.getTestId() + "\"," + 
				"\"invitedUsername\" : \"Anne-" + this.getTestId() + "\"} ",
					com.anfelisa.category.data.InviteUserToCategoryPayload.class);
			com.anfelisa.category.data.UserToCategoryInvitationData data_3 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"categoryId\" : \"boxId-" + this.getTestId() + "\"," + 
			"\"invitedUsername\" : \"Anne-" + this.getTestId() + "\"} ",
					com.anfelisa.category.data.UserToCategoryInvitationData.class);
			HttpResponse<Object> response_3 = 
			this.httpPut(
				"/category/invite", 
			 	payload_3,
				authorization("Annette-${testId}", "password"),
				uuid,
				null
			);
			
			if (response_3.getStatusCode() >= 400) {
				String statusMessage = response_3.getStatusMessage() != null ? response_3.getStatusMessage() : "";
				String message = "GIVEN InviteUserToCategory fails\n" + statusMessage;
				LOG.error("GIVEN: InviteUserToCategory fails due to {} in {} ms", message, response_3.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: InviteUserToCategory success in {} ms", response_3.getDuration());
			addToMetrics("InviteUserToCategory", response_3.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for InviteUserToCategory not met");
		}

	}
	
	private HttpResponse<com.anfelisa.category.data.GetInvitedUsersResponse> when() throws Exception {
		String uuid = this.randomUUID();
		com.anfelisa.category.data.AlreadyInvitedUsernamesData data_0 = objectMapper.readValue("{" +
		"\"uuid\" : \"" + uuid + "\"," + 
		"\"categoryId\" : \"boxId-" + this.getTestId() + "\"} ",
				com.anfelisa.category.data.AlreadyInvitedUsernamesData.class);
		HttpResponse<com.anfelisa.category.data.GetInvitedUsersResponse> response = 
		this.httpGet(
			"/category/invited-usernames?categoryId=" + data_0.getCategoryId() + "", 
			null,
			uuid,
			com.anfelisa.category.data.GetInvitedUsersResponse.class
		);
		
		LOG.info("WHEN: GetInvitedUsers finished in {} ms", response.getDuration());
		if (response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
			addToMetrics("GetInvitedUsers", response.getDuration());
		}
		return response;
	}
	
	private com.anfelisa.category.data.GetInvitedUsersResponse then(HttpResponse<com.anfelisa.category.data.GetInvitedUsersResponse> response) throws Exception {
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
		
				com.anfelisa.category.data.GetInvitedUsersResponse actual = null;
				if (response.getStatusCode() < 400) {
					try {
						actual = response.getEntity();
						
					} catch (Exception x) {
						LOG.error("THEN: failed to read response", x);
						assertFail(x.getMessage());
					}

				}

				return actual;
	}
			
	@Override
	public void runTest() throws Exception {
		given();
			
		if (prerequisite("GetInvitedUsersUnauthorized")) {
			HttpResponse<com.anfelisa.category.data.GetInvitedUsersResponse> response = when();

			com.anfelisa.category.data.GetInvitedUsersResponse actualResponse = then(response);
			
	
		} else {
			LOG.info("WHEN: prerequisite for GetInvitedUsersUnauthorized not met");
		}
	}
	
	
		
	@Override
	protected String scenarioName() {
		return "GetInvitedUsersUnauthorized";
	}
	
}



/******* S.D.G. *******/




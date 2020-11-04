/********************************************************************************
 * generated by de.acegen 1.0.1
 ********************************************************************************/




package com.anfelisa.user.deleteuser.scenarios;

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
public abstract class AbstractDeleteAdminScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractDeleteAdminScenario.class);
	
	private void given() throws Exception {
		String uuid;
		
		if (prerequisite("RegisterUserAdmin")) {
			uuid = "uuid-admin";
			this.callNonDeterministicDataProviderPutValue(uuid, "token", 
						objectMapper.readValue("\"ADMIN-TOKEN\"",  String.class));
			com.anfelisa.user.data.RegisterUserPayload payload_0 = objectMapper.readValue("{" +
				"\"email\" : \"annette.pohl@anfelisa.de\"," + 
				"\"language\" : \"de\"," + 
				"\"password\" : \"admin-password\"," + 
				"\"username\" : \"Admin\"} ",
					com.anfelisa.user.data.RegisterUserPayload.class);
			com.anfelisa.user.data.UserRegistrationData data_0 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"email\" : \"annette.pohl@anfelisa.de\"," + 
			"\"language\" : \"de\"," + 
			"\"password\" : \"admin-password\"," + 
			"\"username\" : \"Admin\"} ",
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
				String message = "GIVEN RegisterUserAdmin fails\n" + response_0.getStatusMessage();
				LOG.error("GIVEN: RegisterUserAdmin fails due to {} in {} ms", message, response_0.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: RegisterUserAdmin success in {} ms", response_0.getDuration());
			addToMetrics("RegisterUser", response_0.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for RegisterUserAdmin not met");
		}

		if (prerequisite("RegisterUser")) {
			uuid = "uuid-" + this.getTestId() + "";
			this.callNonDeterministicDataProviderPutValue(uuid, "token", 
						objectMapper.readValue("\"TOKEN-" + this.getTestId() + "\"",  String.class));
			com.anfelisa.user.data.RegisterUserPayload payload_1 = objectMapper.readValue("{" +
				"\"email\" : \"annette.pohl@anfelisa.de\"," + 
				"\"language\" : \"de\"," + 
				"\"password\" : \"password\"," + 
				"\"username\" : \"Annette-" + this.getTestId() + "\"} ",
					com.anfelisa.user.data.RegisterUserPayload.class);
			com.anfelisa.user.data.UserRegistrationData data_1 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"email\" : \"annette.pohl@anfelisa.de\"," + 
			"\"language\" : \"de\"," + 
			"\"password\" : \"password\"," + 
			"\"username\" : \"Annette-" + this.getTestId() + "\"} ",
					com.anfelisa.user.data.UserRegistrationData.class);
			HttpResponse<Object> response_1 = 
			this.httpPost(
				"/users/register", 
			 	payload_1,
				null,
				uuid,
				null
			);
			
			if (response_1.getStatusCode() >= 400) {
				String message = "GIVEN RegisterUser fails\n" + response_1.getStatusMessage();
				LOG.error("GIVEN: RegisterUser fails due to {} in {} ms", message, response_1.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: RegisterUser success in {} ms", response_1.getDuration());
			addToMetrics("RegisterUser", response_1.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for RegisterUser not met");
		}

		if (prerequisite("ChangeUserRoleToAdmin")) {
			uuid = this.randomUUID();
			com.anfelisa.user.data.ChangeUserRolePayload payload_2 = objectMapper.readValue("{" +
				"\"editedUserId\" : \"uuid-" + this.getTestId() + "\"," + 
				"\"newRole\" : \"ADMIN\"} ",
					com.anfelisa.user.data.ChangeUserRolePayload.class);
			com.anfelisa.user.data.ChangeUserRoleData data_2 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"editedUserId\" : \"uuid-" + this.getTestId() + "\"," + 
			"\"newRole\" : \"ADMIN\"} ",
					com.anfelisa.user.data.ChangeUserRoleData.class);
			HttpResponse<Object> response_2 = 
			this.httpPut(
				"/user/role", 
			 	payload_2,
				authorization("Admin", "admin-password"),
				uuid,
				null
			);
			
			if (response_2.getStatusCode() >= 400) {
				String message = "GIVEN ChangeUserRoleToAdmin fails\n" + response_2.getStatusMessage();
				LOG.error("GIVEN: ChangeUserRoleToAdmin fails due to {} in {} ms", message, response_2.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: ChangeUserRoleToAdmin success in {} ms", response_2.getDuration());
			addToMetrics("ChangeUserRole", response_2.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for ChangeUserRoleToAdmin not met");
		}

	}
	
	private HttpResponse<Object> when() throws Exception {
		String uuid = this.randomUUID();
		com.anfelisa.user.data.DeleteUserData data_0 = objectMapper.readValue("{" +
		"\"uuid\" : \"" + uuid + "\"," + 
		"\"usernameToBeDeleted\" : \"Annette-" + this.getTestId() + "\"} ",
				com.anfelisa.user.data.DeleteUserData.class);
		HttpResponse<Object> response = 
		this.httpDelete(
			"/user/delete?usernameToBeDeleted=" + data_0.getUsernameToBeDeleted() + "", 
			authorization("Admin", "admin-password"),
			uuid,
			null
		);
		
		LOG.info("WHEN: DeleteUser finished in {} ms", response.getDuration());
		if (response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
			addToMetrics("DeleteUser", response.getDuration());
		}
		return response;
	}
	
	private void then(HttpResponse<Object> response) throws Exception {
		if (response.getStatusCode() == 500) {
			LOG.error("THEN: status " + response.getStatusCode() + " failed: " + response.getStatusMessage());
			assertFail(response.getStatusMessage());
		}
		if (response.getStatusCode() != 200) {
			LOG.error("THEN: status " + response.getStatusCode() + " failed, expected 200: " + response.getStatusMessage());
			assertFail(response.getStatusMessage());
		} else {
			LOG.info("THEN: status 200 passed");
		}
		
	}
			
	@Override
	public void runTest() throws Exception {
		given();
			
		if (prerequisite("DeleteAdmin")) {
			HttpResponse<Object> response = when();

			then(response);
			
			this.userWasDeleted();
	
		} else {
			LOG.info("WHEN: prerequisite for DeleteAdmin not met");
		}
	}
	
	
	private void userWasDeleted() throws Exception {
		com.anfelisa.user.models.IUserModel actual = daoProvider.getUserDao().selectByUsername(handle, "Annette-" + this.getTestId() + "");
		
		assertIsNull(actual);
	
		LOG.info("THEN: userWasDeleted passed");
	}
		
	@Override
	protected String scenarioName() {
		return "DeleteAdmin";
	}
	
}



/******* S.D.G. *******/




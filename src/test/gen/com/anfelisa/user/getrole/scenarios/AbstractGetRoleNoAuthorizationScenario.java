/********************************************************************************
 * generated by de.acegen 1.0.1
 ********************************************************************************/




package com.anfelisa.user.getrole.scenarios;

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
public abstract class AbstractGetRoleNoAuthorizationScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractGetRoleNoAuthorizationScenario.class);
	
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

		if (prerequisite("RegisterUserAdmin")) {
			uuid = "uuid-admin";
			this.callNonDeterministicDataProviderPutValue(uuid, "token", 
						objectMapper.readValue("\"ADMIN-TOKEN\"",  String.class));
			com.anfelisa.user.data.RegisterUserPayload payload_1 = objectMapper.readValue("{" +
				"\"email\" : \"annette.pohl@anfelisa.de\"," + 
				"\"language\" : \"de\"," + 
				"\"password\" : \"admin-password\"," + 
				"\"username\" : \"Admin\"} ",
					com.anfelisa.user.data.RegisterUserPayload.class);
			com.anfelisa.user.data.UserRegistrationData data_1 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"email\" : \"annette.pohl@anfelisa.de\"," + 
			"\"language\" : \"de\"," + 
			"\"password\" : \"admin-password\"," + 
			"\"username\" : \"Admin\"} ",
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
				String message = "GIVEN RegisterUserAdmin fails\n" + response_1.getStatusMessage();
				LOG.error("GIVEN: RegisterUserAdmin fails due to {} in {} ms", message, response_1.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: RegisterUserAdmin success in {} ms", response_1.getDuration());
			addToMetrics("RegisterUser", response_1.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for RegisterUserAdmin not met");
		}

	}
	
	private HttpResponse<com.anfelisa.user.data.GetRoleResponse> when() throws Exception {
		String uuid = this.randomUUID();
		com.anfelisa.user.data.RoleData data_0 = objectMapper.readValue("{" +
		"\"uuid\" : \"" + uuid + "\" }",
		com.anfelisa.user.data.RoleData.class);
		HttpResponse<com.anfelisa.user.data.GetRoleResponse> response = 
		this.httpGet(
			"/user/role", 
			null,
			uuid,
			com.anfelisa.user.data.GetRoleResponse.class
		);
		
		LOG.info("WHEN: GetRole finished in {} ms", response.getDuration());
		if (response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
			addToMetrics("GetRole", response.getDuration());
		}
		return response;
	}
	
	private com.anfelisa.user.data.GetRoleResponse then(HttpResponse<com.anfelisa.user.data.GetRoleResponse> response) throws Exception {
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
		
				com.anfelisa.user.data.GetRoleResponse actual = null;
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
			
		if (prerequisite("GetRoleNoAuthorization")) {
			HttpResponse<com.anfelisa.user.data.GetRoleResponse> response = when();

			com.anfelisa.user.data.GetRoleResponse actualResponse = then(response);
			
	
		} else {
			LOG.info("WHEN: prerequisite for GetRoleNoAuthorization not met");
		}
	}
	
	
		
	@Override
	protected String scenarioName() {
		return "GetRoleNoAuthorization";
	}
	
}



/******* S.D.G. *******/




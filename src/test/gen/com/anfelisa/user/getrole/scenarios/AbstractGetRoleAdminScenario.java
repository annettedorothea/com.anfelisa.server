/********************************************************************************
 * generated by de.acegen 0.9.13
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
public abstract class AbstractGetRoleAdminScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractGetRoleAdminScenario.class);
	
	private Map<String, Object> extractedValues = new HashMap<String, Object>();
	
	private void given() throws Exception {
		String uuid;
		long timeBeforeRequest;
		long timeAfterRequest;
		
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
			timeBeforeRequest = System.currentTimeMillis();
			HttpResponse<Object> response_0 = 
			this.httpPost(
				"/users/register", 
			 	payload_0,
				null,
				uuid,
				null
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response_0.getStatusCode() >= 400) {
				String message = "GIVEN RegisterUser fails\n" + response_0.getStatusMessage();
				LOG.info("GIVEN: RegisterUser fails due to {} in {} ms", message, (timeAfterRequest-timeBeforeRequest));
				addToMetrics("RegisterUser", (timeAfterRequest-timeBeforeRequest));
				assertFail(message);
			}
			LOG.info("GIVEN: RegisterUser success in {} ms", (timeAfterRequest-timeBeforeRequest));
			addToMetrics("RegisterUser", (timeAfterRequest-timeBeforeRequest));
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
			timeBeforeRequest = System.currentTimeMillis();
			HttpResponse<Object> response_1 = 
			this.httpPost(
				"/users/register", 
			 	payload_1,
				null,
				uuid,
				null
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response_1.getStatusCode() >= 400) {
				String message = "GIVEN RegisterUserAdmin fails\n" + response_1.getStatusMessage();
				LOG.info("GIVEN: RegisterUserAdmin fails due to {} in {} ms", message, (timeAfterRequest-timeBeforeRequest));
				addToMetrics("RegisterUser", (timeAfterRequest-timeBeforeRequest));
				assertFail(message);
			}
			LOG.info("GIVEN: RegisterUserAdmin success in {} ms", (timeAfterRequest-timeBeforeRequest));
			addToMetrics("RegisterUser", (timeAfterRequest-timeBeforeRequest));
		} else {
			LOG.info("GIVEN: prerequisite for RegisterUserAdmin not met");
		}

	}
	
	private HttpResponse<com.anfelisa.user.data.GetRoleResponse> when() throws Exception {
		String uuid = this.randomUUID();
		com.anfelisa.user.data.RoleData data_0 = objectMapper.readValue("{" +
		"\"uuid\" : \"" + uuid + "\" }",
		com.anfelisa.user.data.RoleData.class);
		long timeBeforeRequest = System.currentTimeMillis();
		HttpResponse<com.anfelisa.user.data.GetRoleResponse> response = 
		this.httpGet(
			"/user/role", 
			authorization("Admin", "admin-password"),
			uuid,
			com.anfelisa.user.data.GetRoleResponse.class
		);
		
		long timeAfterRequest = System.currentTimeMillis();
		LOG.info("WHEN: GetRole finished in {} ms", (timeAfterRequest-timeBeforeRequest));
		addToMetrics("GetRole", (timeAfterRequest-timeBeforeRequest));
		return response;
	}
	
	private com.anfelisa.user.data.GetRoleResponse then(HttpResponse<com.anfelisa.user.data.GetRoleResponse> response) throws Exception {
		if (response.getStatusCode() == 500) {
			assertFail(response.getStatusMessage());
		}
		if (response.getStatusCode() != 200) {
			assertFail(response.getStatusMessage());
		} else {
			LOG.info("THEN: status 200 passed");
		}
		
				com.anfelisa.user.data.GetRoleResponse actual = null;
				if (response.getStatusCode() < 400) {
					try {
						actual = response.getEntity();
						//readEntity(com.anfelisa.user.data.GetRoleResponse.class);
						
					} catch (Exception x) {
						LOG.error("THEN: failed to read response", x);
						assertFail(x.getMessage());
					}

					com.anfelisa.user.data.RoleData expectedData = objectMapper.readValue("{" +
						"\"uuid\" : \"\"," + 
						"\"role\" : \"ADMIN\"} ",
					com.anfelisa.user.data.RoleData.class);
					
					com.anfelisa.user.data.GetRoleResponse expected = new com.anfelisa.user.data.GetRoleResponse(expectedData);
					
					assertThat(actual, expected);
					
					LOG.info("THEN: response passed");
				}

				return actual;
	}
			
	@Override
	public void runTest() throws Exception {
		given();
			
		if (prerequisite("GetRoleAdmin")) {
			HttpResponse<com.anfelisa.user.data.GetRoleResponse> response = when();

			com.anfelisa.user.data.GetRoleResponse actualResponse = then(response);
			
	
		} else {
			LOG.info("WHEN: prerequisite for GetRoleAdmin not met");
		}
	}
	
	
		
	@Override
	protected String scenarioName() {
		return "GetRoleAdmin";
	}
	
}



/******* S.D.G. *******/




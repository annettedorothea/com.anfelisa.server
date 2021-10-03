/********************************************************************************
 * generated by de.acegen 1.5.4
 ********************************************************************************/




package com.anfelisa.user.gettoken.scenarios;

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
public abstract class AbstractGetTokenWrongPasswordScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractGetTokenWrongPasswordScenario.class);
	
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
	
	private HttpResponse<com.anfelisa.user.data.GetTokenResponse> when() throws Exception {
		String uuid = "" + this.getTestId() + "";
		com.anfelisa.user.data.GetTokenPayload payload_0 = objectMapper.readValue("{" +
			"\"username\" : \"Annette-" + this.getTestId() + "\"," + 
			"\"password\" : \"wrong\"} ",
				com.anfelisa.user.data.GetTokenPayload.class);
		com.anfelisa.user.data.TokenData data_0 = objectMapper.readValue("{" +
		"\"uuid\" : \"" + uuid + "\"," + 
		"\"username\" : \"Annette-" + this.getTestId() + "\"," + 
		"\"password\" : \"wrong\"} ",
				com.anfelisa.user.data.TokenData.class);
		HttpResponse<com.anfelisa.user.data.GetTokenResponse> response = 
		this.httpPut(
			"/user/token", 
		 	payload_0,
			null,
			uuid,
			com.anfelisa.user.data.GetTokenResponse.class
		);
		
		LOG.info("WHEN: GetToken finished in {} ms", response.getDuration());
		if (response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
			addToMetrics("GetToken", response.getDuration());
		}
		return response;
	}
	
	private com.anfelisa.user.data.GetTokenResponse then(HttpResponse<com.anfelisa.user.data.GetTokenResponse> response) throws Exception {
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
		
				com.anfelisa.user.data.GetTokenResponse actual = null;
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
			
		if (prerequisite("GetTokenWrongPassword")) {
			HttpResponse<com.anfelisa.user.data.GetTokenResponse> response = when();

			com.anfelisa.user.data.GetTokenResponse actualResponse = then(response);
			
	
		} else {
			LOG.info("WHEN: prerequisite for GetTokenWrongPassword not met");
		}
	}
	
	
		
	@Override
	protected String scenarioName() {
		return "GetTokenWrongPassword";
	}
	
}



/******* S.D.G. *******/




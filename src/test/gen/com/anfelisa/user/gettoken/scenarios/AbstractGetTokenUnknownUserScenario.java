/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.user.gettoken.scenarios;

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

@SuppressWarnings("unused")
public abstract class AbstractGetTokenUnknownUserScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractGetTokenUnknownUserScenario.class);
	
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
	
	private HttpResponse<com.anfelisa.user.data.GetTokenResponse> when_0() throws Exception {
		String uuid = "" + this.getTestId() + "";
		com.anfelisa.user.data.GetTokenPayload payload_0 = objectMapper.readValue("{" +
			"\"username\" : \"lala\"," + 
			"\"password\" : \"password\"} ",
				com.anfelisa.user.data.GetTokenPayload.class);
		com.anfelisa.user.data.TokenData data_0 = objectMapper.readValue("{" +
		"\"uuid\" : \"" + uuid + "\"," + 
		"\"username\" : \"lala\"," + 
		"\"password\" : \"password\"} ",
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
	
	private com.anfelisa.user.data.GetTokenResponse then_0(HttpResponse<com.anfelisa.user.data.GetTokenResponse> response) throws Exception {
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
		
		if (prerequisite("GetTokenUnknownUser")) {
			
				HttpResponse<com.anfelisa.user.data.GetTokenResponse> response_0 = when_0();
				com.anfelisa.user.data.GetTokenResponse actualResponse_0 = then_0(response_0);
				
		
		} else {
			LOG.info("WHEN: prerequisite for GetTokenUnknownUser not met");
		}
		
			
	}
	
	
		
	@Override
	protected String scenarioName() {
		return "GetTokenUnknownUser";
	}
	
}



/******* S.D.G. *******/




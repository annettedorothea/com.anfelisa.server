/********************************************************************************
 * generated by de.acegen 1.6.4
 ********************************************************************************/




package com.anfelisa.user.forgotpassword.scenarios;

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
public abstract class AbstractForgotPasswordOKScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractForgotPasswordOKScenario.class);
	
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
		String uuid = this.randomUUID();
		this.callSquishyDataProviderPutValue(uuid, "token",	"RESET-PW-TOKEN-" + this.getTestId() + "");
		com.anfelisa.user.data.ForgotPasswordPayload payload_0 = objectMapper.readValue("{" +
			"\"language\" : \"de\"," + 
			"\"username\" : \"Annette-" + this.getTestId() + "\"} ",
				com.anfelisa.user.data.ForgotPasswordPayload.class);
		com.anfelisa.user.data.ForgotPasswordData data_0 = objectMapper.readValue("{" +
		"\"uuid\" : \"" + uuid + "\"," + 
		"\"language\" : \"de\"," + 
		"\"username\" : \"Annette-" + this.getTestId() + "\"} ",
				com.anfelisa.user.data.ForgotPasswordData.class);
		HttpResponse<Object> response = 
		this.httpPost(
			"/users/forgot-password", 
		 	payload_0,
			null,
			uuid,
			null
		);
		
		LOG.info("WHEN: ForgotPassword finished in {} ms", response.getDuration());
		if (response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
			addToMetrics("ForgotPassword", response.getDuration());
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
			
		if (prerequisite("ForgotPasswordOK")) {
			HttpResponse<Object> response = when();

			then(response);
			
			this.resetPasswordTokenWasCreated();
	
		} else {
			LOG.info("WHEN: prerequisite for ForgotPasswordOK not met");
		}
	}
	
	
	private void resetPasswordTokenWasCreated() throws Exception {
		com.anfelisa.user.models.IResetPasswordModel actual = daoProvider.getResetPasswordDao().selectByToken(handle, "RESET-PW-TOKEN-" + this.getTestId() + "");
		
		com.anfelisa.user.models.IResetPasswordModel expected = objectMapper.readValue("{" +
			"\"token\" : \"RESET-PW-TOKEN-" + this.getTestId() + "\"," + 
			"\"userId\" : \"uuid-" + this.getTestId() + "\"} ",
		com.anfelisa.user.models.ResetPasswordModel.class);
		assertThat(actual, expected);
	
		LOG.info("THEN: resetPasswordTokenWasCreated passed");
	}
		
	@Override
	protected String scenarioName() {
		return "ForgotPasswordOK";
	}
	
}



/******* S.D.G. *******/




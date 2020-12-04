/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.user.confirmemail.scenarios;

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
public abstract class AbstractConfirmEmailConfirmationTokenDoesNotExistScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractConfirmEmailConfirmationTokenDoesNotExistScenario.class);
	
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

	}
	
	private HttpResponse<Object> when() throws Exception {
		String uuid = this.randomUUID();
		com.anfelisa.user.data.ConfirmEmailPayload payload_0 = objectMapper.readValue("{" +
			"\"token\" : \"DOES_NOT_EXIST\"," + 
			"\"username\" : \"Annette-" + this.getTestId() + "\"} ",
				com.anfelisa.user.data.ConfirmEmailPayload.class);
		com.anfelisa.user.data.ConfirmEmailData data_0 = objectMapper.readValue("{" +
		"\"uuid\" : \"" + uuid + "\"," + 
		"\"token\" : \"DOES_NOT_EXIST\"," + 
		"\"username\" : \"Annette-" + this.getTestId() + "\"} ",
				com.anfelisa.user.data.ConfirmEmailData.class);
		HttpResponse<Object> response = 
		this.httpPut(
			"/users/confirm", 
		 	payload_0,
			null,
			uuid,
			null
		);
		
		LOG.info("WHEN: ConfirmEmail finished in {} ms", response.getDuration());
		if (response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
			addToMetrics("ConfirmEmail", response.getDuration());
		}
		return response;
	}
	
	private void then(HttpResponse<Object> response) throws Exception {
		if (response.getStatusCode() == 500) {
			LOG.error("THEN: status " + response.getStatusCode() + " failed: " + response.getStatusMessage());
			assertFail(response.getStatusMessage());
		}
		if (response.getStatusCode() != 400) {
			LOG.error("THEN: status " + response.getStatusCode() + " failed, expected 400: " + response.getStatusMessage());
			assertFail(response.getStatusMessage());
		} else {
			LOG.info("THEN: status 400 passed");
		}
		
	}
			
	@Override
	public void runTest() throws Exception {
		given();
			
		if (prerequisite("ConfirmEmailConfirmationTokenDoesNotExist")) {
			HttpResponse<Object> response = when();

			then(response);
			
			this.confirmedIsNotSetToTrue();
			this.tokenIsNotDeleted();
	
		} else {
			LOG.info("WHEN: prerequisite for ConfirmEmailConfirmationTokenDoesNotExist not met");
		}
	}
	
	
	private void confirmedIsNotSetToTrue() throws Exception {
		com.anfelisa.user.models.IUserModel actual = daoProvider.getUserDao().selectByUsername(handle, "Annette-" + this.getTestId() + "");
		
		com.anfelisa.user.models.IUserModel expected = objectMapper.readValue("{" +
			"\"email\" : \"annette.pohl@anfelisa.de\"," + 
			"\"emailConfirmed\" : false," + 
			"\"password\" : \"password\"," + 
			"\"role\" : \"STUDENT\"," + 
			"\"userId\" : \"uuid-" + this.getTestId() + "\"," + 
			"\"username\" : \"Annette-" + this.getTestId() + "\"} ",
		com.anfelisa.user.models.UserModel.class);
		assertThat(actual, expected);
	
		LOG.info("THEN: confirmedIsNotSetToTrue passed");
	}
	private void tokenIsNotDeleted() throws Exception {
		com.anfelisa.user.models.IEmailConfirmationModel actual = daoProvider.getEmailConfirmationDao().selectByToken(handle, "TOKEN-" + this.getTestId() + "");
		
		assertIsNotNull(actual);
	
		LOG.info("THEN: tokenIsNotDeleted passed");
	}
		
	@Override
	protected String scenarioName() {
		return "ConfirmEmailConfirmationTokenDoesNotExist";
	}
	
}



/******* S.D.G. *******/




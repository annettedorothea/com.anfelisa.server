/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.user.registeruser.scenarios;

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
public abstract class AbstractRegisterTwoUsersScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractRegisterTwoUsersScenario.class);
	
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
		String uuid = "uuid2-" + this.getTestId() + "";
		this.callNonDeterministicDataProviderPutValue(uuid, "token", 
					objectMapper.readValue("\"TOKEN_2-" + this.getTestId() + "\"",  String.class));
		com.anfelisa.user.data.RegisterUserPayload payload_0 = objectMapper.readValue("{" +
			"\"email\" : \"info@anfelisa.de\"," + 
			"\"language\" : \"de\"," + 
			"\"password\" : \"pw\"," + 
			"\"username\" : \"Anne-" + this.getTestId() + "\"} ",
				com.anfelisa.user.data.RegisterUserPayload.class);
		com.anfelisa.user.data.UserRegistrationData data_0 = objectMapper.readValue("{" +
		"\"uuid\" : \"" + uuid + "\"," + 
		"\"email\" : \"info@anfelisa.de\"," + 
		"\"language\" : \"de\"," + 
		"\"password\" : \"pw\"," + 
		"\"username\" : \"Anne-" + this.getTestId() + "\"} ",
				com.anfelisa.user.data.UserRegistrationData.class);
		HttpResponse<Object> response = 
		this.httpPost(
			"/users/register", 
		 	payload_0,
			null,
			uuid,
			null
		);
		
		LOG.info("WHEN: RegisterUser finished in {} ms", response.getDuration());
		if (response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
			addToMetrics("RegisterUser", response.getDuration());
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
			
		if (prerequisite("RegisterTwoUsers")) {
			HttpResponse<Object> response = when();

			then(response);
			
			this.userWasCreated();
			this.emailConfirmationWasCreated();
			this.secondUserWasCreated();
			this.secondEmailConfirmationWasCreated();
	
		} else {
			LOG.info("WHEN: prerequisite for RegisterTwoUsers not met");
		}
	}
	
	
	private void userWasCreated() throws Exception {
		com.anfelisa.user.models.IUserModel actual = daoProvider.getUserDao().selectByUserId(handle, "uuid-" + this.getTestId() + "");
		
		com.anfelisa.user.models.IUserModel expected = objectMapper.readValue("{" +
			"\"email\" : \"annette.pohl@anfelisa.de\"," + 
			"\"emailConfirmed\" : false," + 
			"\"password\" : \"password\"," + 
			"\"role\" : \"STUDENT\"," + 
			"\"userId\" : \"uuid-" + this.getTestId() + "\"," + 
			"\"username\" : \"Annette-" + this.getTestId() + "\"} ",
		com.anfelisa.user.models.UserModel.class);
		assertThat(actual, expected);
	
		LOG.info("THEN: userWasCreated passed");
	}
	private void emailConfirmationWasCreated() throws Exception {
		com.anfelisa.user.models.IEmailConfirmationModel actual = daoProvider.getEmailConfirmationDao().selectByToken(handle, "TOKEN-" + this.getTestId() + "");
		
		com.anfelisa.user.models.IEmailConfirmationModel expected = objectMapper.readValue("{" +
			"\"token\" : \"TOKEN-" + this.getTestId() + "\"," + 
			"\"userId\" : \"uuid-" + this.getTestId() + "\"} ",
		com.anfelisa.user.models.EmailConfirmationModel.class);
		assertThat(actual, expected);
	
		LOG.info("THEN: emailConfirmationWasCreated passed");
	}
	private void secondUserWasCreated() throws Exception {
		com.anfelisa.user.models.IUserModel actual = daoProvider.getUserDao().selectByUserId(handle, "uuid2-" + this.getTestId() + "");
		
		com.anfelisa.user.models.IUserModel expected = objectMapper.readValue("{" +
			"\"email\" : \"info@anfelisa.de\"," + 
			"\"emailConfirmed\" : false," + 
			"\"password\" : \"pw\"," + 
			"\"role\" : \"STUDENT\"," + 
			"\"userId\" : \"uuid2-" + this.getTestId() + "\"," + 
			"\"username\" : \"Anne-" + this.getTestId() + "\"} ",
		com.anfelisa.user.models.UserModel.class);
		assertThat(actual, expected);
	
		LOG.info("THEN: secondUserWasCreated passed");
	}
	private void secondEmailConfirmationWasCreated() throws Exception {
		com.anfelisa.user.models.IEmailConfirmationModel actual = daoProvider.getEmailConfirmationDao().selectByToken(handle, "TOKEN_2-" + this.getTestId() + "");
		
		com.anfelisa.user.models.IEmailConfirmationModel expected = objectMapper.readValue("{" +
			"\"token\" : \"TOKEN_2-" + this.getTestId() + "\"," + 
			"\"userId\" : \"uuid2-" + this.getTestId() + "\"} ",
		com.anfelisa.user.models.EmailConfirmationModel.class);
		assertThat(actual, expected);
	
		LOG.info("THEN: secondEmailConfirmationWasCreated passed");
	}
		
	@Override
	protected String scenarioName() {
		return "RegisterTwoUsers";
	}
	
}



/******* S.D.G. *******/




/********************************************************************************
 * generated by de.acegen 1.0.1
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
public abstract class AbstractConfirmEmailAlreadyConfirmedScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractConfirmEmailAlreadyConfirmedScenario.class);
	
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

		if (prerequisite("ConfirmEmailOK")) {
			uuid = this.randomUUID();
			com.anfelisa.user.data.ConfirmEmailPayload payload_1 = objectMapper.readValue("{" +
				"\"token\" : \"TOKEN-" + this.getTestId() + "\"," + 
				"\"username\" : \"Annette-" + this.getTestId() + "\"} ",
					com.anfelisa.user.data.ConfirmEmailPayload.class);
			com.anfelisa.user.data.ConfirmEmailData data_1 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
			"\"token\" : \"TOKEN-" + this.getTestId() + "\"," + 
			"\"username\" : \"Annette-" + this.getTestId() + "\"} ",
					com.anfelisa.user.data.ConfirmEmailData.class);
			HttpResponse<Object> response_1 = 
			this.httpPut(
				"/users/confirm", 
			 	payload_1,
				null,
				uuid,
				null
			);
			
			if (response_1.getStatusCode() >= 400) {
				String message = "GIVEN ConfirmEmailOK fails\n" + response_1.getStatusMessage();
				LOG.error("GIVEN: ConfirmEmailOK fails due to {} in {} ms", message, response_1.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: ConfirmEmailOK success in {} ms", response_1.getDuration());
			addToMetrics("ConfirmEmail", response_1.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for ConfirmEmailOK not met");
		}

	}
	
	private HttpResponse<Object> when() throws Exception {
		String uuid = this.randomUUID();
		com.anfelisa.user.data.ConfirmEmailPayload payload_0 = objectMapper.readValue("{" +
			"\"token\" : \"TOKEN-" + this.getTestId() + "\"," + 
			"\"username\" : \"Annette-" + this.getTestId() + "\"} ",
				com.anfelisa.user.data.ConfirmEmailPayload.class);
		com.anfelisa.user.data.ConfirmEmailData data_0 = objectMapper.readValue("{" +
		"\"uuid\" : \"" + uuid + "\"," + 
		"\"token\" : \"TOKEN-" + this.getTestId() + "\"," + 
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
			
		if (prerequisite("ConfirmEmailAlreadyConfirmed")) {
			HttpResponse<Object> response = when();

			then(response);
			
			this.confirmedIsStillTrue();
			this.tokenWasDeleted();
	
		} else {
			LOG.info("WHEN: prerequisite for ConfirmEmailAlreadyConfirmed not met");
		}
	}
	
	
	private void confirmedIsStillTrue() throws Exception {
		com.anfelisa.user.models.IUserModel actual = daoProvider.getUserDao().selectByUsername(handle, "Annette-" + this.getTestId() + "");
		
		com.anfelisa.user.models.IUserModel expected = objectMapper.readValue("{" +
			"\"email\" : \"annette.pohl@anfelisa.de\"," + 
			"\"emailConfirmed\" : true," + 
			"\"password\" : \"password\"," + 
			"\"role\" : \"STUDENT\"," + 
			"\"userId\" : \"uuid-" + this.getTestId() + "\"," + 
			"\"username\" : \"Annette-" + this.getTestId() + "\"} ",
		com.anfelisa.user.models.UserModel.class);
		assertThat(actual, expected);
	
		LOG.info("THEN: confirmedIsStillTrue passed");
	}
	private void tokenWasDeleted() throws Exception {
		com.anfelisa.user.models.IEmailConfirmationModel actual = daoProvider.getEmailConfirmationDao().selectByToken(handle, "TOKEN-" + this.getTestId() + "");
		
		assertIsNull(actual);
	
		LOG.info("THEN: tokenWasDeleted passed");
	}
		
	@Override
	protected String scenarioName() {
		return "ConfirmEmailAlreadyConfirmed";
	}
	
}



/******* S.D.G. *******/




/********************************************************************************
 * generated by de.acegen 1.3.0
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
import de.acegen.SquishyDataProvider;
import de.acegen.HttpResponse;

@SuppressWarnings("unused")
public abstract class AbstractRegisterUserBlankUsernameScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractRegisterUserBlankUsernameScenario.class);
	
	private void given() throws Exception {
		String uuid;
		
	}
	
	private HttpResponse<Object> when() throws Exception {
		String uuid = "uuid-" + this.getTestId() + "";
		this.callSquishyDataProviderPutValue(uuid, "token",	"TOKEN-" + this.getTestId() + "");
		com.anfelisa.user.data.RegisterUserPayload payload_0 = objectMapper.readValue("{" +
			"\"email\" : \"annette.pohl@anfelisa.de\"," + 
			"\"language\" : \"de\"," + 
			"\"password\" : \"password\"," + 
			"\"username\" : \"  \"} ",
				com.anfelisa.user.data.RegisterUserPayload.class);
		com.anfelisa.user.data.UserRegistrationData data_0 = objectMapper.readValue("{" +
		"\"uuid\" : \"" + uuid + "\"," + 
		"\"email\" : \"annette.pohl@anfelisa.de\"," + 
		"\"language\" : \"de\"," + 
		"\"password\" : \"password\"," + 
		"\"username\" : \"  \"} ",
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
			String statusMessage = response.getStatusMessage() != null ? response.getStatusMessage() : "";
			LOG.error("THEN: status " + response.getStatusCode() + " failed: " + statusMessage);
			assertFail(statusMessage);
		}
		if (response.getStatusCode() != 400) {
			String statusMessage = response.getStatusMessage() != null ? response.getStatusMessage() : "";
			LOG.error("THEN: status " + response.getStatusCode() + " failed, expected 400: " + statusMessage);
			assertFail(statusMessage);
		} else {
			LOG.info("THEN: status 400 passed");
		}
		
	}
			
	@Override
	public void runTest() throws Exception {
		given();
			
		if (prerequisite("RegisterUserBlankUsername")) {
			HttpResponse<Object> response = when();

			then(response);
			
			this.userWasNotCreated();
			this.emailConfirmationWasNotCreated();
	
		} else {
			LOG.info("WHEN: prerequisite for RegisterUserBlankUsername not met");
		}
	}
	
	
	private void userWasNotCreated() throws Exception {
		com.anfelisa.user.models.IUserModel actual = daoProvider.getUserDao().selectByUserId(handle, "uuid-" + this.getTestId() + "");
		
		assertIsNull(actual);
	
		LOG.info("THEN: userWasNotCreated passed");
	}
	private void emailConfirmationWasNotCreated() throws Exception {
		com.anfelisa.user.models.IEmailConfirmationModel actual = daoProvider.getEmailConfirmationDao().selectByToken(handle, "TOKEN-" + this.getTestId() + "");
		
		assertIsNull(actual);
	
		LOG.info("THEN: emailConfirmationWasNotCreated passed");
	}
		
	@Override
	protected String scenarioName() {
		return "RegisterUserBlankUsername";
	}
	
}



/******* S.D.G. *******/




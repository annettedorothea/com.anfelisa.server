/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.user.registeruser.scenarios;

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
import de.acegen.Data;

import com.fasterxml.jackson.core.type.TypeReference;

@SuppressWarnings("unused")
public abstract class AbstractRegisterUserEmptyUsernameScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractRegisterUserEmptyUsernameScenario.class);
	
	private void given() throws Exception {
		String uuid;
		
	}
	
	private HttpResponse<Object> when_0() throws Exception {
		String uuid = "uuid-" + this.getTestId() + "";
		this.callSquishyDataProviderPutValue(uuid, "token",	"TOKEN-" + this.getTestId() + "");
		com.anfelisa.user.data.RegisterUserPayload payload_0 = objectMapper.readValue("{" +
			"\"email\" : \"annette.pohl@anfelisa.de\"," + 
			"\"language\" : \"de\"," + 
			"\"password\" : \"password\"," + 
			"\"username\" : \"\"} ",
				com.anfelisa.user.data.RegisterUserPayload.class);
		com.anfelisa.user.models.UserRegistrationModel model_0 = objectMapper.readValue("{" +
			"\"email\" : \"annette.pohl@anfelisa.de\"," + 
			"\"language\" : \"de\"," + 
			"\"password\" : \"password\"," + 
			"\"username\" : \"\"} ", com.anfelisa.user.models.UserRegistrationModel.class);
		Data<com.anfelisa.user.models.UserRegistrationModel> data_0 = new Data<com.anfelisa.user.models.UserRegistrationModel>(uuid);
		data_0.setModel(model_0);
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
	
	private void then_0(HttpResponse<Object> response) throws Exception {
		if (response.getStatusCode() == 500) {
			String statusMessage = response.getStatusMessage() != null ? response.getStatusMessage() : "";
			String errorMessage = "status " + response.getStatusCode() + " failed: " + statusMessage;
			LOG.error("THEN: " + errorMessage);
			assertFail(errorMessage);
		}
		if (response.getStatusCode() != 400) {
			String statusMessage = response.getStatusMessage() != null ? response.getStatusMessage() : "";
			String errorMessage = "status " + response.getStatusCode() + " failed, expected 400: " + statusMessage;
			LOG.error("THEN: " + errorMessage);
			assertFail(errorMessage);
		} else {
			LOG.info("THEN: status 400 passed");
		}
		
	}
			
	@Override
	public void runTest() throws Exception {
		given();
		
		if (prerequisite("RegisterUserEmptyUsername")) {
			
				HttpResponse<Object> response_0 = when_0();
				then_0(response_0);
				this.userWasNotCreated();
				this.emailConfirmationWasNotCreated();
				
		
		} else {
			LOG.info("WHEN: prerequisite for RegisterUserEmptyUsername not met");
		}
		
			
	}
	
	
	private void userWasNotCreated() throws Exception {
		com.anfelisa.user.models.UserModel actual = daoProvider.getUserDao().selectByUserId(handle, "uuid-" + this.getTestId() + "");
		
		assertIsNull(actual);
	
		LOG.info("THEN: userWasNotCreated passed");
	}
	private void emailConfirmationWasNotCreated() throws Exception {
		com.anfelisa.user.models.EmailConfirmationModel actual = daoProvider.getEmailConfirmationDao().selectByToken(handle, "TOKEN-" + this.getTestId() + "");
		
		assertIsNull(actual);
	
		LOG.info("THEN: emailConfirmationWasNotCreated passed");
	}
		
	@Override
	protected String scenarioName() {
		return "RegisterUserEmptyUsername";
	}
	
}



/******* S.D.G. *******/




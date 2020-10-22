/********************************************************************************
 * generated by de.acegen 0.9.13
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
public abstract class AbstractRegisterUserAdminScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractRegisterUserAdminScenario.class);
	
	private Map<String, Object> extractedValues = new HashMap<String, Object>();
	
	private void given() throws Exception {
		String uuid;
		long timeBeforeRequest;
		long timeAfterRequest;
		
	}
	
	private HttpResponse<Object> when() throws Exception {
		String uuid = "uuid-admin";
		this.callNonDeterministicDataProviderPutValue(uuid, "token", 
					objectMapper.readValue("\"ADMIN-TOKEN\"",  String.class));
		com.anfelisa.user.data.RegisterUserPayload payload_0 = objectMapper.readValue("{" +
			"\"email\" : \"annette.pohl@anfelisa.de\"," + 
			"\"language\" : \"de\"," + 
			"\"password\" : \"admin-password\"," + 
			"\"username\" : \"Admin\"} ",
				com.anfelisa.user.data.RegisterUserPayload.class);
		com.anfelisa.user.data.UserRegistrationData data_0 = objectMapper.readValue("{" +
		"\"uuid\" : \"" + uuid + "\"," + 
		"\"email\" : \"annette.pohl@anfelisa.de\"," + 
		"\"language\" : \"de\"," + 
		"\"password\" : \"admin-password\"," + 
		"\"username\" : \"Admin\"} ",
				com.anfelisa.user.data.UserRegistrationData.class);
		long timeBeforeRequest = System.currentTimeMillis();
		HttpResponse<Object> response = 
		this.httpPost(
			"/users/register", 
		 	payload_0,
			null,
			uuid,
			null
		);
		
		long timeAfterRequest = System.currentTimeMillis();
		LOG.info("WHEN: RegisterUser finished in {} ms", (timeAfterRequest-timeBeforeRequest));
		addToMetrics("RegisterUser", (timeAfterRequest-timeBeforeRequest));
		return response;
	}
	
	private void then(HttpResponse<Object> response) throws Exception {
		if (response.getStatusCode() == 500) {
			assertFail(response.getStatusMessage());
		}
		if (response.getStatusCode() != 200) {
			assertFail(response.getStatusMessage());
		} else {
			LOG.info("THEN: status 200 passed");
		}
		
	}
			
	@Override
	public void runTest() throws Exception {
		given();
			
		if (prerequisite("RegisterUserAdmin")) {
			HttpResponse<Object> response = when();

			then(response);
			
			this.userWasCreated();
			this.emailConfirmationWasCreated();
	
		} else {
			LOG.info("WHEN: prerequisite for RegisterUserAdmin not met");
		}
	}
	
	
	private void userWasCreated() throws Exception {
		com.anfelisa.user.models.IUserModel actual = daoProvider.getUserDao().selectByUserId(handle, "uuid-admin");
		
		com.anfelisa.user.models.IUserModel expected = objectMapper.readValue("{" +
			"\"email\" : \"annette.pohl@anfelisa.de\"," + 
			"\"emailConfirmed\" : false," + 
			"\"password\" : \"admin-password\"," + 
			"\"role\" : \"ADMIN\"," + 
			"\"userId\" : \"uuid-admin\"," + 
			"\"username\" : \"Admin\"} ",
		com.anfelisa.user.models.UserModel.class);
		assertThat(actual, expected);
	
		LOG.info("THEN: userWasCreated passed");
	}
	private void emailConfirmationWasCreated() throws Exception {
		com.anfelisa.user.models.IEmailConfirmationModel actual = daoProvider.getEmailConfirmationDao().selectByToken(handle, "ADMIN-TOKEN");
		
		com.anfelisa.user.models.IEmailConfirmationModel expected = objectMapper.readValue("{" +
			"\"token\" : \"ADMIN-TOKEN\"," + 
			"\"userId\" : \"uuid-admin\"} ",
		com.anfelisa.user.models.EmailConfirmationModel.class);
		assertThat(actual, expected);
	
		LOG.info("THEN: emailConfirmationWasCreated passed");
	}
		
	@Override
	protected String scenarioName() {
		return "RegisterUserAdmin";
	}
	
}



/******* S.D.G. *******/




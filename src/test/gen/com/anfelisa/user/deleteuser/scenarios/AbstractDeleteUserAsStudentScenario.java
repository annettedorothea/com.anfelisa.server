/********************************************************************************
 * generated by de.acegen 0.9.10
 ********************************************************************************/




package com.anfelisa.user.deleteuser.scenarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import javax.ws.rs.core.Response;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.acegen.BaseScenario;
import de.acegen.ITimelineItem;
import de.acegen.NotReplayableDataProvider;

@SuppressWarnings("unused")
public abstract class AbstractDeleteUserAsStudentScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractDeleteUserAsStudentScenario.class);
	
	private Map<String, Object> extractedValues = new HashMap<String, Object>();
	
	private void given() throws Exception {
		Response response;
		String uuid;
		long timeBeforeRequest;
		long timeAfterRequest;
		
		if (prerequisite("RegisterUser")) {
			uuid = "uuid-" + this.getTestId() + "";
			this.callNotReplayableDataProviderPutValue(uuid, "token", 
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
			response = 
			this.httpPost(
				"/users/register", 
			 	payload_0,
				null,
				uuid
			);
			
			timeAfterRequest = System.currentTimeMillis();
			if (response.getStatus() >= 400) {
				String message = "GIVEN RegisterUser fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: RegisterUser fails due to {} in {} ms", message, (timeAfterRequest-timeBeforeRequest));
				addToMetrics("RegisterUser", (timeAfterRequest-timeBeforeRequest));
				assertFail(message);
			}
			LOG.info("GIVEN: RegisterUser success in {} ms", (timeAfterRequest-timeBeforeRequest));
			addToMetrics("RegisterUser", (timeAfterRequest-timeBeforeRequest));
		} else {
			LOG.info("GIVEN: prerequisite for RegisterUser not met");
		}

	}
	
	private Response when() throws Exception {
		String uuid = this.randomUUID();
		com.anfelisa.user.data.DeleteUserData data_0 = objectMapper.readValue("{" +
		"\"uuid\" : \"" + uuid + "\"," + 
		"\"usernameToBeDeleted\" : \"Annette-" + this.getTestId() + "\"} ",
				com.anfelisa.user.data.DeleteUserData.class);
		long timeBeforeRequest = System.currentTimeMillis();
		Response response = 
		this.httpDelete(
			"/user/delete?usernameToBeDeleted=" + data_0.getUsernameToBeDeleted() + "", 
			authorization("Annette-${testId}", "password"),
			uuid
		);
		
		long timeAfterRequest = System.currentTimeMillis();
		LOG.info("WHEN: DeleteUser finished in {} ms", (timeAfterRequest-timeBeforeRequest));
		addToMetrics("DeleteUser", (timeAfterRequest-timeBeforeRequest));
		return response;
	}
	
	private void then(Response response) throws Exception {
		if (response.getStatus() == 500) {
			String message = response.readEntity(String.class);
			assertFail(message);
		}
		if (response.getStatus() != 200) {
			String message = response.readEntity(String.class);
			assertFail(message);
		} else {
			LOG.info("THEN: status 200 passed");
		}
		
	}
			
	@Override
	public void runTest() throws Exception {
		given();
			
		if (prerequisite("DeleteUserAsStudent")) {
			Response response = when();

			then(response);
			
			this.userWasDeleted();
	
		} else {
			LOG.info("WHEN: prerequisite for DeleteUserAsStudent not met");
		}
	}
	
	
	private void userWasDeleted() throws Exception {
		com.anfelisa.user.models.IUserModel actual = daoProvider.getUserDao().selectByUsername(handle, "Annette-" + this.getTestId() + "");
		
		assertIsNull(actual);
	
		LOG.info("THEN: userWasDeleted passed");
	}
		
	@Override
	protected String scenarioName() {
		return "DeleteUserAsStudent";
	}
	
}



/******* S.D.G. *******/




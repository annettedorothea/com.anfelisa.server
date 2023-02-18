/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.user.changeuserrole.scenarios;

import java.util.Map;
import java.util.HashMap;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.acegen.BaseScenario;
import de.acegen.HttpResponse;
import de.acegen.Data;

import com.fasterxml.jackson.core.type.TypeReference;

@SuppressWarnings("unused")
public abstract class AbstractChangeUserRoleAdminRoleMustNotBeChangedScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractChangeUserRoleAdminRoleMustNotBeChangedScenario.class);
	
	private void given() throws Exception {
		String uuid;
		
		if (prerequisite("RegisterUserAdmin")) {
			uuid = "uuid-admin";
			this.callSquishyDataProviderPutValue(uuid, "token",	"ADMIN-TOKEN");
			com.anfelisa.user.data.RegisterUserPayload payload_0 = objectMapper.readValue("{" +
				"\"email\" : \"annette.pohl@anfelisa.de\"," + 
				"\"language\" : \"de\"," + 
				"\"password\" : \"admin-password\"," + 
				"\"username\" : \"Admin\"} ",
					com.anfelisa.user.data.RegisterUserPayload.class);
			com.anfelisa.user.models.UserRegistrationModel model_0 = objectMapper.readValue("{" +
				"\"email\" : \"annette.pohl@anfelisa.de\"," + 
				"\"language\" : \"de\"," + 
				"\"password\" : \"admin-password\"," + 
				"\"username\" : \"Admin\"} ", com.anfelisa.user.models.UserRegistrationModel.class);
			Data<com.anfelisa.user.models.UserRegistrationModel> data_0 = new Data<com.anfelisa.user.models.UserRegistrationModel>(uuid);
			data_0.setModel(model_0);
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
				String message = "GIVEN RegisterUserAdmin fails\n" + statusMessage;
				LOG.error("GIVEN: RegisterUserAdmin fails due to {} in {} ms", message, response_0.getDuration());
				assertFail(message);
			}
			LOG.info("GIVEN: RegisterUserAdmin success in {} ms", response_0.getDuration());
			addToMetrics("RegisterUser", response_0.getDuration());
		} else {
			LOG.info("GIVEN: prerequisite for RegisterUserAdmin not met");
		}

	}
	
	private HttpResponse<Object> when_0() throws Exception {
		String uuid = this.randomUUID();
		com.anfelisa.user.data.ChangeUserRolePayload payload_0 = objectMapper.readValue("{" +
			"\"editedUserId\" : \"uuid-admin\"," + 
			"\"newRole\" : \"STUDENT\"} ",
				com.anfelisa.user.data.ChangeUserRolePayload.class);
		com.anfelisa.user.models.ChangeUserRoleModel model_0 = objectMapper.readValue("{" +
			"\"editedUserId\" : \"uuid-admin\"," + 
			"\"newRole\" : \"STUDENT\"} ", com.anfelisa.user.models.ChangeUserRoleModel.class);
		Data<com.anfelisa.user.models.ChangeUserRoleModel> data_0 = new Data<com.anfelisa.user.models.ChangeUserRoleModel>(uuid);
		data_0.setModel(model_0);
		HttpResponse<Object> response = 
		this.httpPut(
			"/user/role", 
		 	payload_0,
			authorization("Admin", "admin-password"),
			uuid,
			null
		);
		
		LOG.info("WHEN: ChangeUserRole finished in {} ms", response.getDuration());
		if (response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
			addToMetrics("ChangeUserRole", response.getDuration());
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
		
		if (prerequisite("ChangeUserRoleAdminRoleMustNotBeChanged")) {
			
				HttpResponse<Object> response_0 = when_0();
				then_0(response_0);
				this.roleWasNotChanged();
				
		
		} else {
			LOG.info("WHEN: prerequisite for ChangeUserRoleAdminRoleMustNotBeChanged not met");
		}
		
			
	}
	
	
	private void roleWasNotChanged() throws Exception {
		com.anfelisa.user.models.UserModel actual = daoProvider.getUserDao().selectByUserId(handle, "uuid-admin");
		
		com.anfelisa.user.models.UserModel expected = objectMapper.readValue("{" +
			"\"email\" : \"annette.pohl@anfelisa.de\"," + 
			"\"emailConfirmed\" : false," + 
			"\"password\" : \"admin-password\"," + 
			"\"role\" : \"ADMIN\"," + 
			"\"userId\" : \"uuid-admin\"," + 
			"\"username\" : \"Admin\"} ",
		com.anfelisa.user.models.UserModel.class);
		assertThat(actual, expected);
	
		LOG.info("THEN: roleWasNotChanged passed");
	}
		
	@Override
	protected String scenarioName() {
		return "ChangeUserRoleAdminRoleMustNotBeChanged";
	}
	
}



/******* S.D.G. *******/




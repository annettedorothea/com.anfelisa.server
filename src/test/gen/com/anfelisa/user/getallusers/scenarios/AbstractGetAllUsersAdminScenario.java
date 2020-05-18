/* 
 * Copyright (c) 2019, Annette Pohl, Koblenz, Germany
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.

 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */




package com.anfelisa.user.getallusers.scenarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.Response;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;

import org.junit.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.acegen.BaseScenario;
import de.acegen.ITimelineItem;
import de.acegen.NotReplayableDataProvider;

@SuppressWarnings("unused")
public abstract class AbstractGetAllUsersAdminScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractGetAllUsersAdminScenario.class);
	
	private void given() throws Exception {
		Response response;
		String uuid;
		if (prerequisite("RegisterUserAdmin")) {
			uuid = "uuid-admin".replace("${testId}", this.getTestId());
			this.callNotReplayableDataProviderPutValue(uuid, "token", 
						objectMapper.readValue("\"ADMIN-TOKEN\"",  String.class),
						this.getProtocol(), this.getHost(), this.getPort());
			response = 
			com.anfelisa.user.ActionCalls.callRegisterUser(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"email\" : \"annette.pohl@anfelisa.de\"," + 
					"\"language\" : \"de\"," + 
					"\"password\" : \"admin-password\"," + 
					"\"username\" : \"Admin\"} ",
			com.anfelisa.user.data.UserRegistrationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort());
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN RegisterUserAdmin fails\n" + response.readEntity(String.class);
				assertFail(message);
			}
			LOG.info("GIVEN: RegisterUserAdmin");
		} else {
			LOG.info("GIVEN: prerequisite for RegisterUserAdmin not met");
		}
		

		if (prerequisite("RegisterUser")) {
			uuid = "uuid-${testId}".replace("${testId}", this.getTestId());
			this.callNotReplayableDataProviderPutValue(uuid, "token", 
						objectMapper.readValue("\"TOKEN-" + this.getTestId() + "\"",  String.class),
						this.getProtocol(), this.getHost(), this.getPort());
			response = 
			com.anfelisa.user.ActionCalls.callRegisterUser(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"email\" : \"annette.pohl@anfelisa.de\"," + 
					"\"language\" : \"de\"," + 
					"\"password\" : \"password\"," + 
					"\"username\" : \"Annette-" + this.getTestId() + "\"} ",
			com.anfelisa.user.data.UserRegistrationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort());
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN RegisterUser fails\n" + response.readEntity(String.class);
				assertFail(message);
			}
			LOG.info("GIVEN: RegisterUser");
		} else {
			LOG.info("GIVEN: prerequisite for RegisterUser not met");
		}
		

		if (prerequisite("ConfirmEmailOK")) {
			uuid = this.randomUUID();
			response = 
			com.anfelisa.user.ActionCalls.callConfirmEmail(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"token\" : \"TOKEN-" + this.getTestId() + "\"," + 
					"\"username\" : \"Annette-" + this.getTestId() + "\"} ",
			com.anfelisa.user.data.ConfirmEmailData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort());
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN ConfirmEmailOK fails\n" + response.readEntity(String.class);
				assertFail(message);
			}
			LOG.info("GIVEN: ConfirmEmailOK");
		} else {
			LOG.info("GIVEN: prerequisite for ConfirmEmailOK not met");
		}
		

	}
	
	private Response when() throws Exception {
		String uuid = this.randomUUID();
		
		return 
		com.anfelisa.user.ActionCalls.callGetAllUsers(objectMapper.readValue("{}",
		com.anfelisa.user.data.UserListData.class)
		
		, this.getProtocol(), this.getHost(), this.getPort(), authorization("Admin", "admin-password"));
		
	}
	
	private com.anfelisa.user.data.GetAllUsersResponse then(Response response) throws Exception {
		if (response.getStatus() == 500) {
			String message = response.readEntity(String.class);
			assertFail(message);
		}
		if (response.getStatus() != 200) {
			String message = response.readEntity(String.class);
			assertFail(message);
		}
		
		com.anfelisa.user.data.GetAllUsersResponse actual = null;
		try {
			actual = response.readEntity(com.anfelisa.user.data.GetAllUsersResponse.class);
		} catch (Exception x) {
		}
		com.anfelisa.user.data.UserListData expectedData = objectMapper.readValue("{" +
			"\"uuid\" : \"\"," + 
				"\"userList\" : [ { \"email\" : \"annette.pohl@anfelisa.de\"," + 
				"\"password\" : \"admin-password\"," + 
				"\"username\" : \"Admin\"," + 
				"\"userId\" : \"uuid-admin\"," + 
				"\"emailConfirmed\" : false," + 
				"\"role\" : \"ADMIN\"}," + 
				"{ \"email\" : \"annette.pohl@anfelisa.de\"," + 
				"\"password\" : \"password\"," + 
				"\"username\" : \"Annette-" + this.getTestId() + "\"," + 
				"\"emailConfirmed\" : true," + 
				"\"role\" : \"STUDENT\"," + 
				"\"userId\" : \"uuid-" + this.getTestId() + "\"}]} ",
		com.anfelisa.user.data.UserListData.class)
		
		;
		
		com.anfelisa.user.data.GetAllUsersResponse expected = new com.anfelisa.user.data.GetAllUsersResponse(expectedData);


		assertThat(actual, expected);
			
			return actual;
				}
				
				@Test
				public void getAllUsersAdmin() throws Exception {
					given();
						
					if (prerequisite("GetAllUsersAdmin")) {
						Response response = when();
		
						LOG.info("WHEN: GetAllUsers");
				
						com.anfelisa.user.data.GetAllUsersResponse actualResponse = then(response);
						
						verifications(actualResponse);
					} else {
						LOG.info("prerequisite for GetAllUsersAdmin not met");
					}
				}
				
				protected abstract void verifications(com.anfelisa.user.data.GetAllUsersResponse response);
				
				@Override
				protected String scenarioName() {
					return "GetAllUsersAdmin";
				}
			
			}
			
			
			
			/******* S.D.G. *******/
			
			
			

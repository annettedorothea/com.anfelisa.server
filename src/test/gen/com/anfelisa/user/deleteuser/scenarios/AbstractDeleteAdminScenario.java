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




package com.anfelisa.user.deleteuser.scenarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.Response;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.acegen.BaseScenario;
import de.acegen.ITimelineItem;
import de.acegen.NotReplayableDataProvider;

@SuppressWarnings("unused")
public abstract class AbstractDeleteAdminScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractDeleteAdminScenario.class);
	
	private void given() throws Exception {
		Response response;
		String uuid;
		if (prerequisite("RegisterUserAdmin")) {
			uuid = "uuid-admin".replace("${testId}", this.getTestId());
			this.callNotReplayableDataProviderPutValue(uuid, "token", 
						objectMapper.readValue("\"ADMIN-TOKEN\"",  String.class));
			com.anfelisa.user.data.UserRegistrationData data_1 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"email\" : \"annette.pohl@anfelisa.de\"," + 
					"\"language\" : \"de\"," + 
					"\"password\" : \"admin-password\"," + 
					"\"username\" : \"Admin\"} ",
			com.anfelisa.user.data.UserRegistrationData.class);
			response = 
			this.httpPost(
				"/users/register", 
				data_1,
				null
			);
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN RegisterUserAdmin fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: RegisterUserAdmin fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: RegisterUserAdmin success");
		} else {
			LOG.info("GIVEN: prerequisite for RegisterUserAdmin not met");
		}
		

		if (prerequisite("RegisterUser")) {
			uuid = "uuid-${testId}".replace("${testId}", this.getTestId());
			this.callNotReplayableDataProviderPutValue(uuid, "token", 
						objectMapper.readValue("\"TOKEN-" + this.getTestId() + "\"",  String.class));
			com.anfelisa.user.data.UserRegistrationData data_2 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"email\" : \"annette.pohl@anfelisa.de\"," + 
					"\"language\" : \"de\"," + 
					"\"password\" : \"password\"," + 
					"\"username\" : \"Annette-" + this.getTestId() + "\"} ",
			com.anfelisa.user.data.UserRegistrationData.class);
			response = 
			this.httpPost(
				"/users/register", 
				data_2,
				null
			);
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN RegisterUser fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: RegisterUser fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: RegisterUser success");
		} else {
			LOG.info("GIVEN: prerequisite for RegisterUser not met");
		}
		

		if (prerequisite("ChangeUserRoleToAdmin")) {
			uuid = this.randomUUID();
			com.anfelisa.user.data.ChangeUserRoleData data_3 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"editedUserId\" : \"uuid-" + this.getTestId() + "\"," + 
					"\"newRole\" : \"ADMIN\"} ",
			com.anfelisa.user.data.ChangeUserRoleData.class);
			response = 
			this.httpPut(
				"/user/role?uuid=" + data_3.getUuid() + "", 
				data_3,
				authorization("Admin", "admin-password")
			);
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN ChangeUserRoleToAdmin fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: ChangeUserRoleToAdmin fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: ChangeUserRoleToAdmin success");
		} else {
			LOG.info("GIVEN: prerequisite for ChangeUserRoleToAdmin not met");
		}
		

	}
	
	private Response when() throws Exception {
		String uuid = this.randomUUID();
		com.anfelisa.user.data.DeleteUserData data_0 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
				"\"usernameToBeDeleted\" : \"Annette-" + this.getTestId() + "\"} ",
		com.anfelisa.user.data.DeleteUserData.class);
		
		return 
		this.httpDelete(
			"/user/delete?uuid=" + data_0.getUuid() + "&usernameToBeDeleted=" + data_0.getUsernameToBeDeleted() + "", 
			authorization("Admin", "admin-password")
		);
		
	}
	
	private void then(Response response) throws Exception {
		if (response.getStatus() == 500) {
			String message = response.readEntity(String.class);
			assertFail(message);
		}
		if (response.getStatus() != 200) {
			String message = response.readEntity(String.class);
			assertFail(message);
		}
		
			
				}
				
				@Override
				public void runTest() throws Exception {
					given();
						
					if (prerequisite("DeleteAdmin")) {
						Response response = when();
		
						LOG.info("WHEN: DeleteUser");
				
						then(response);
						
						verifications();
					} else {
						LOG.info("WHEN: prerequisite for DeleteAdmin not met");
					}
				}
				
				protected abstract void verifications();
				
				@Override
				protected String scenarioName() {
					return "DeleteAdmin";
				}
			
			}
			
			
			
			/******* S.D.G. *******/
			
			
			

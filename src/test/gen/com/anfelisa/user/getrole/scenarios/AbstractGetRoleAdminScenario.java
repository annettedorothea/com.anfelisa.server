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




package com.anfelisa.user.getrole.scenarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.Response;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;

import org.junit.Test;

import de.acegen.BaseScenario;
import de.acegen.ITimelineItem;
import de.acegen.NotReplayableDataProvider;

@SuppressWarnings("unused")
public abstract class AbstractGetRoleAdminScenario extends BaseScenario {

	private void given() throws Exception {
		Response response;
		NotReplayableDataProvider.put("token", objectMapper.readValue("\"TOKEN\"",
				 String.class));
		response = 
		com.anfelisa.user.ActionCalls.callRegisterUser(objectMapper.readValue("{" +
			"\"uuid\" : \"uuid\"," + 
				"\"email\" : \"annette.pohl@anfelisa.de\"," + 
				"\"language\" : \"de\"," + 
				"\"password\" : \"password\"," + 
				"\"username\" : \"Annette\"} ",
		com.anfelisa.user.data.UserRegistrationData.class)
		
		, DROPWIZARD.getLocalPort());
		
		if (response.getStatus() == 500) {
			String message = "GIVEN RegisterUser fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		

		NotReplayableDataProvider.put("token", objectMapper.readValue("\"ADMIN-TOKEN\"",
				 String.class));
		response = 
		com.anfelisa.user.ActionCalls.callRegisterUser(objectMapper.readValue("{" +
			"\"uuid\" : \"uuid-admin\"," + 
				"\"email\" : \"annette.pohl@anfelisa.de\"," + 
				"\"language\" : \"de\"," + 
				"\"password\" : \"admin-password\"," + 
				"\"username\" : \"Admin\"} ",
		com.anfelisa.user.data.UserRegistrationData.class)
		
		, DROPWIZARD.getLocalPort());
		
		if (response.getStatus() == 500) {
			String message = "GIVEN RegisterUser fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		

	}
	
	private Response when() throws Exception {
		
		return 
		com.anfelisa.user.ActionCalls.callGetRole(objectMapper.readValue("{}",
		com.anfelisa.user.data.RoleData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Admin", "admin-password"));
		
	}
	
	private com.anfelisa.user.data.GetRoleResponse then(Response response) throws Exception {
		if (response.getStatus() == 500) {
			String message = response.readEntity(String.class);
			assertFail(message);
		}
		assertThat(response.getStatus(), 200);
		
		com.anfelisa.user.data.GetRoleResponse actual = null;
		try {
			actual = response.readEntity(com.anfelisa.user.data.GetRoleResponse.class);
		} catch (Exception x) {
		}
		com.anfelisa.user.data.RoleData expectedData = objectMapper.readValue("{" +
			"\"uuid\" : \"" + this.randomUUID() + "\"," + 
				"\"role\" : \"ADMIN\"} ",
		com.anfelisa.user.data.RoleData.class)
		
		;
		
		com.anfelisa.user.data.GetRoleResponse expected = new com.anfelisa.user.data.GetRoleResponse(expectedData);


		assertThat(actual, expected);
			
			return actual;
				}
				
				@Test
				public void getRoleAdmin() throws Exception {
					given();
					
					Response response = when();
			
					com.anfelisa.user.data.GetRoleResponse actualResponse = then(response);
					
					verifications(actualResponse);
				}
				
				protected abstract void verifications(com.anfelisa.user.data.GetRoleResponse response);
				
				@Override
				protected String scenarioName() {
					return "GetRoleAdmin";
				}
			
			}
			
			
			
			/******* S.D.G. *******/
			
			
			

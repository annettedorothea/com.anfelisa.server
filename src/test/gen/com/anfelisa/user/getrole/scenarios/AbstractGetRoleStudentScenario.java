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
import org.joda.time.format.DateTimeFormat;

import org.junit.Test;

import de.acegen.BaseScenario;
import de.acegen.ITimelineItem;
import de.acegen.NotReplayableDataProvider;

@SuppressWarnings("unused")
public abstract class AbstractGetRoleStudentScenario extends BaseScenario {

	private void given() throws Exception {
		NotReplayableDataProvider.put("token", this.templateStringValue("ADMIN-TOKEN", null));
		com.anfelisa.user.data.UserRegistrationData registerUser0 = new com.anfelisa.user.data.UserRegistrationData("uuid-admin");
		registerUser0.setEmail(this.templateStringValue("annette.pohl@anfelisa.de", 0));
		registerUser0.setLanguage(this.templateStringValue("de", 0));
		registerUser0.setPassword(this.templateStringValue("admin-password", 0));
		registerUser0.setUsername(this.templateStringValue("Admin", 0));
		registerUser0.setToken(this.templateStringValue("ADMIN-TOKEN", 0));
		
		
		com.anfelisa.user.ActionCalls.callRegisterUser(registerUser0, DROPWIZARD.getLocalPort());
		

		NotReplayableDataProvider.put("token", this.templateStringValue("TOKEN", null));
		com.anfelisa.user.data.UserRegistrationData registerUser1 = new com.anfelisa.user.data.UserRegistrationData("uuid");
		registerUser1.setEmail(this.templateStringValue("annette.pohl@anfelisa.de", 1));
		registerUser1.setLanguage(this.templateStringValue("de", 1));
		registerUser1.setPassword(this.templateStringValue("password", 1));
		registerUser1.setUsername(this.templateStringValue("Annette", 1));
		registerUser1.setToken(this.templateStringValue("TOKEN", 1));
		
		
		com.anfelisa.user.ActionCalls.callRegisterUser(registerUser1, DROPWIZARD.getLocalPort());
		

	}
	
	private Response when() throws Exception {
		com.anfelisa.user.data.RoleData getRole0 = new com.anfelisa.user.data.RoleData(randomUUID());
		
		return 
		com.anfelisa.user.ActionCalls.callGetRole(getRole0, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
	}
	
	private com.anfelisa.user.data.GetRoleResponse then(Response response) throws Exception {
		assertThat(response.getStatus(), 200);
		
		com.anfelisa.user.data.GetRoleResponse actual = null;
		try {
			actual = response.readEntity(com.anfelisa.user.data.GetRoleResponse.class);
		} catch (Exception x) {
		}
		com.anfelisa.user.data.RoleData expectedData = new com.anfelisa.user.data.RoleData(randomUUID());
		expectedData.setRole(this.templateStringValue("STUDENT", null));
		
		
		com.anfelisa.user.data.GetRoleResponse expected = new com.anfelisa.user.data.GetRoleResponse(expectedData);


		assertThat(actual, expected);
			
			return actual;
				}
				
				@Test
				public void getRoleStudent() throws Exception {
					given();
					
					Response response = when();
			
					com.anfelisa.user.data.GetRoleResponse actualResponse = then(response);
					
					verifications(actualResponse);
			}
			
			protected abstract void verifications(com.anfelisa.user.data.GetRoleResponse response);
			
			}
			
			
			
			
			/******* S.D.G. *******/
			
			
			

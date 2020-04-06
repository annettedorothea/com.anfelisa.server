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
import org.joda.time.format.DateTimeFormat;

import org.junit.Test;

import de.acegen.BaseScenario;
import de.acegen.ITimelineItem;
import de.acegen.NotReplayableDataProvider;

@SuppressWarnings("unused")
public abstract class AbstractDeleteAdminScenario extends BaseScenario {

	private void given() throws Exception {
		NotReplayableDataProvider.put("token", this.templateStringValue("ADMIN-TOKEN", null));
		com.anfelisa.user.data.UserRegistrationData registerUser0 = new com.anfelisa.user.data.UserRegistrationData("uuid-admin");
		registerUser0.setEmail(this.templateStringValue("annette.pohl@anfelisa.de", null));
		registerUser0.setLanguage(this.templateStringValue("de", null));
		registerUser0.setPassword(this.templateStringValue("admin-password", null));
		registerUser0.setUsername(this.templateStringValue("Admin", null));
		registerUser0.setToken(this.templateStringValue("ADMIN-TOKEN", null));
		
		com.anfelisa.user.ActionCalls.callRegisterUser(registerUser0, DROPWIZARD.getLocalPort());

		NotReplayableDataProvider.put("token", this.templateStringValue("TOKEN", null));
		com.anfelisa.user.data.UserRegistrationData registerUser1 = new com.anfelisa.user.data.UserRegistrationData("uuid");
		registerUser1.setEmail(this.templateStringValue("annette.pohl@anfelisa.de", null));
		registerUser1.setLanguage(this.templateStringValue("de", null));
		registerUser1.setPassword(this.templateStringValue("password", null));
		registerUser1.setUsername(this.templateStringValue("Annette", null));
		registerUser1.setToken(this.templateStringValue("TOKEN", null));
		
		com.anfelisa.user.ActionCalls.callRegisterUser(registerUser1, DROPWIZARD.getLocalPort());

		NotReplayableDataProvider.put("token", this.templateStringValue("ADMIN-TOKEN", null));
		com.anfelisa.user.data.UserRegistrationData registerUser2 = new com.anfelisa.user.data.UserRegistrationData("uuid-admin");
		registerUser2.setEmail(this.templateStringValue("annette.pohl@anfelisa.de", null));
		registerUser2.setLanguage(this.templateStringValue("de", null));
		registerUser2.setPassword(this.templateStringValue("admin-password", null));
		registerUser2.setUsername(this.templateStringValue("Admin", null));
		registerUser2.setToken(this.templateStringValue("ADMIN-TOKEN", null));
		
		com.anfelisa.user.ActionCalls.callRegisterUser(registerUser2, DROPWIZARD.getLocalPort());

		com.anfelisa.user.data.ChangeUserRoleData changeUserRole3 = new com.anfelisa.user.data.ChangeUserRoleData(randomUUID());
		changeUserRole3.setEditedUserId(this.templateStringValue("uuid", null));
		changeUserRole3.setNewRole(this.templateStringValue("ADMIN", null));
		
		com.anfelisa.user.ActionCalls.callChangeUserRole(changeUserRole3, DROPWIZARD.getLocalPort(), authorization("Admin", "admin-password"));

	}
	
	private Response when() throws Exception {
		com.anfelisa.user.data.DeleteUserData deleteUser0 = new com.anfelisa.user.data.DeleteUserData(randomUUID());
		deleteUser0.setUsernameToBeDeleted(this.templateStringValue("Annette", null));
		
		return 
		com.anfelisa.user.ActionCalls.callDeleteUser(deleteUser0, DROPWIZARD.getLocalPort(), authorization("Admin", "admin-password"));
	}
	
	private void then(Response response) throws Exception {
		assertThat(response.getStatus(), 200);
		
			
				}
				
				@Test
				public void deleteAdmin() throws Exception {
					given();
					
					Response response = when();
			
					then(response);
					
					verifications();
			}
			
			protected abstract void verifications();
			
			}
			
			
			
			
			/******* S.D.G. *******/
			
			
			

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
import java.util.List;

import javax.ws.rs.core.Response;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import org.junit.Test;

import com.anfelisa.ace.BaseScenario;
import com.anfelisa.ace.ITimelineItem;
import com.anfelisa.ace.NotReplayableDataProvider;

@SuppressWarnings("unused")
public abstract class AbstractGetAllUsersAdminScenario extends BaseScenario {

	private void given() throws Exception {
		NotReplayableDataProvider.put("token", "ADMIN-TOKEN");
		com.anfelisa.user.ActionCalls.callRegisterUser("uuid-admin", "admin-password", "Admin", "annette.pohl@anfelisa.de", "de", DROPWIZARD.getLocalPort());

		NotReplayableDataProvider.put("token", "TOKEN");
		com.anfelisa.user.ActionCalls.callRegisterUser("uuid", "password", "Annette", "annette.pohl@anfelisa.de", "de", DROPWIZARD.getLocalPort());

		NotReplayableDataProvider.put("token", "TOKEN");
		com.anfelisa.user.ActionCalls.callConfirmEmail(randomUUID(), "TOKEN", "Annette", DROPWIZARD.getLocalPort());

	}
	
	private Response when() throws Exception {
		return com.anfelisa.user.ActionCalls.callGetAllUsers(randomUUID(), DROPWIZARD.getLocalPort(), authorization("Admin", "admin-password"));
	}
	
	private void then(Response response) throws Exception {
		assertThat(response.getStatus(), 200);
		
		com.anfelisa.user.data.UserListData expectedData = new com.anfelisa.user.data.UserListData(randomUUID());
		List<com.anfelisa.user.models.IUserModel> expectedDataUserList = new ArrayList<com.anfelisa.user.models.IUserModel>();
		com.anfelisa.user.models.IUserModel expectedDataUserList0 = new com.anfelisa.user.models.UserModel();
		expectedDataUserList0.setEmail("annette.pohl@anfelisa.de");
		expectedDataUserList0.setPassword("password");
		expectedDataUserList0.setUsername("Annette");
		expectedDataUserList0.setEmailConfirmed(new Boolean("true"));
		expectedDataUserList0.setRole("STUDENT");
		expectedDataUserList0.setUserId("uuid");
		expectedDataUserList.add(expectedDataUserList0);
		com.anfelisa.user.models.IUserModel expectedDataUserList1 = new com.anfelisa.user.models.UserModel();
		expectedDataUserList1.setEmail("annette.pohl@anfelisa.de");
		expectedDataUserList1.setPassword("admin-password");
		expectedDataUserList1.setUsername("Admin");
		expectedDataUserList1.setUserId("uuid-admin");
		expectedDataUserList1.setEmailConfirmed(new Boolean("false"));
		expectedDataUserList1.setRole("ADMIN");
		expectedDataUserList.add(expectedDataUserList1);
		expectedData.setUserList(expectedDataUserList);
		
		com.anfelisa.user.data.GetAllUsersResponse expected = new com.anfelisa.user.data.GetAllUsersResponse(expectedData);

		com.anfelisa.user.data.GetAllUsersResponse actual = response.readEntity(com.anfelisa.user.data.GetAllUsersResponse.class);

		assertThat(actual, expected);
		
	}
	
	@Test
	public void getAllUsersAdmin() throws Exception {
		given();
		
		Response response = when();

		then(response);
		
		verifications(response);
	}
	
	protected abstract void verifications(Response response);

}




/******* S.D.G. *******/




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
import java.util.List;

import javax.ws.rs.core.Response;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import org.junit.Test;

import com.anfelisa.ace.BaseScenario;
import com.anfelisa.ace.ITimelineItem;
import com.anfelisa.ace.NotReplayableDataProvider;

@SuppressWarnings("unused")
public abstract class AbstractGetRoleStudentScenario extends BaseScenario {

	private void given() throws Exception {
		NotReplayableDataProvider.put("token", "ADMIN-TOKEN");
		com.anfelisa.user.ActionCalls.callRegisterUser("uuid-admin", "admin-password", "Admin", "annette.pohl@anfelisa.de", "de", DROPWIZARD.getLocalPort());

		NotReplayableDataProvider.put("token", "TOKEN");
		com.anfelisa.user.ActionCalls.callRegisterUser("uuid", "password", "Annette", "annette.pohl@anfelisa.de", "de", DROPWIZARD.getLocalPort());

	}
	
	private Response when() throws Exception {
		return com.anfelisa.user.ActionCalls.callGetRole(randomUUID(), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
	}
	
	private void then(Response response) throws Exception {
		assertThat(response.getStatus(), 200);
		
		com.anfelisa.user.data.RoleData expectedData = new com.anfelisa.user.data.RoleData(randomUUID());
		// generateDataCreation
		expectedData.setRole("STUDENT");
		
		com.anfelisa.user.data.GetRoleResponse expected = new com.anfelisa.user.data.GetRoleResponse(expectedData);

		com.anfelisa.user.data.GetRoleResponse actual = response.readEntity(com.anfelisa.user.data.GetRoleResponse.class);

		assertThat(actual, expected);
		
	}
	
	@Test
	public void getRoleStudent() throws Exception {
		given();
		
		Response response = when();

		then(response);
		
		verifications(response);
	}
	
	protected abstract void verifications(Response response);

}




/******* S.D.G. *******/




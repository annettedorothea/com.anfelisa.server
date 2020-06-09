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
public abstract class AbstractGetRoleUnknownUserScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractGetRoleUnknownUserScenario.class);
	
	private void given() throws Exception {
		Response response;
		String uuid;
		long timeBeforeRequest;
		long timeAfterRequest;
		if (prerequisite("RegisterUser")) {
			uuid = "uuid-" + this.getTestId() + "";
			this.callNotReplayableDataProviderPutValue(uuid, "token", 
						objectMapper.readValue("\"TOKEN-" + this.getTestId() + "\"",  String.class));
			com.anfelisa.user.data.UserRegistrationData data_1 = objectMapper.readValue("{" +
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
				data_1,
				null
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
		com.anfelisa.user.data.RoleData data_0 = objectMapper.readValue("{ \"uuid\" : \"" + uuid + "\"}",
		com.anfelisa.user.data.RoleData.class);
		long timeBeforeRequest = System.currentTimeMillis();
		Response response = 
		this.httpGet(
			"/user/role?uuid=" + data_0.getUuid() + "", 
			authorization("lala", "password")
		);
		
		long timeAfterRequest = System.currentTimeMillis();
		LOG.info("WHEN: GetRole finished in {} ms", (timeAfterRequest-timeBeforeRequest));
		addToMetrics("GetRole", (timeAfterRequest-timeBeforeRequest));
		return response;
	}
	
	private com.anfelisa.user.data.GetRoleResponse then(Response response) throws Exception {
		if (response.getStatus() == 500) {
			String message = response.readEntity(String.class);
			assertFail(message);
		}
		if (response.getStatus() != 401) {
			String message = response.readEntity(String.class);
			assertFail(message);
		} else {
			LOG.info("THEN: status 401 passed");
		}
		
		com.anfelisa.user.data.GetRoleResponse actual = null;
		try {
			actual = response.readEntity(com.anfelisa.user.data.GetRoleResponse.class);
		} catch (Exception x) {
		}
		
		return actual;
	}
			
	@Override
	public void runTest() throws Exception {
		given();
			
		if (prerequisite("GetRoleUnknownUser")) {
			Response response = when();

			com.anfelisa.user.data.GetRoleResponse actualResponse = then(response);
			
		
		} else {
			LOG.info("WHEN: prerequisite for GetRoleUnknownUser not met");
		}
	}
	
	
	
	@Override
	protected String scenarioName() {
		return "GetRoleUnknownUser";
	}

}



/******* S.D.G. *******/


			

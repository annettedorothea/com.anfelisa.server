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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.acegen.BaseScenario;
import de.acegen.ITimelineItem;
import de.acegen.NotReplayableDataProvider;

@SuppressWarnings("unused")
public abstract class AbstractGetRoleWrongPasswordScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractGetRoleWrongPasswordScenario.class);
	
	private void given() throws Exception {
		Response response;
		String uuid;
		if (prerequisite("RegisterUser")) {
			uuid = "uuid-${testId}".replace("${testId}", this.getTestId());
			LOG.info("GIVEN: RegisterUser uuid " + uuid);
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
				LOG.info("GIVEN: RegisterUser fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: RegisterUser success");
		} else {
			LOG.info("GIVEN: prerequisite for RegisterUser not met");
		}
		

	}
	
	private Response when() throws Exception {
		String uuid = this.randomUUID();
		
		return 
		com.anfelisa.user.ActionCalls.callGetRole(objectMapper.readValue("{}",
		com.anfelisa.user.data.RoleData.class)
		
		, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "wrong"));
		
	}
	
	private com.anfelisa.user.data.GetRoleResponse then(Response response) throws Exception {
		if (response.getStatus() == 500) {
			String message = response.readEntity(String.class);
			assertFail(message);
		}
		if (response.getStatus() != 401) {
			String message = response.readEntity(String.class);
			assertFail(message);
		}
		
		com.anfelisa.user.data.GetRoleResponse actual = null;
		try {
			actual = response.readEntity(com.anfelisa.user.data.GetRoleResponse.class);
		} catch (Exception x) {
		}
			
			return actual;
				}
				
				@Test
				public void getRoleWrongPassword() throws Exception {
					given();
						
					if (prerequisite("GetRoleWrongPassword")) {
						Response response = when();
		
						LOG.info("WHEN: GetRole");
				
						com.anfelisa.user.data.GetRoleResponse actualResponse = then(response);
						
						verifications(actualResponse);
					} else {
						LOG.info("prerequisite for GetRoleWrongPassword not met");
					}
				}
				
				protected abstract void verifications(com.anfelisa.user.data.GetRoleResponse response);
				
				@Override
				protected String scenarioName() {
					return "GetRoleWrongPassword";
				}
			
			}
			
			
			
			/******* S.D.G. *******/
			
			
			

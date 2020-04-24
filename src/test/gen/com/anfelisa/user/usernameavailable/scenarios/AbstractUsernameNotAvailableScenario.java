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




package com.anfelisa.user.usernameavailable.scenarios;

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
public abstract class AbstractUsernameNotAvailableScenario extends BaseScenario {

	private void given() throws Exception {
		NotReplayableDataProvider.put("token", objectMapper.readValue("\"TOKEN\"",
				 String.class));
		
		com.anfelisa.user.ActionCalls.callRegisterUser(objectMapper.readValue("{" +
			"\"uuid\" : \"uuid\"," + 
				"\"email\" : \"annette.pohl@anfelisa.de\"," + 
				"\"language\" : \"de\"," + 
				"\"password\" : \"password\"," + 
				"\"username\" : \"Annette\"," + 
				"\"token\" : \"TOKEN\"} ",
		com.anfelisa.user.data.UserRegistrationData.class)
		
		, DROPWIZARD.getLocalPort());
		

	}
	
	private Response when() throws Exception {
		
		return 
		com.anfelisa.user.ActionCalls.callUsernameAvailable(objectMapper.readValue("{" +
			"\"uuid\" : \"ac94ee3e-6fda-429e-8d64-d4b2cc6660e3\"," + 
				"\"username\" : \"Annette\"} ",
		com.anfelisa.user.data.UsernameAvailableData.class)
		
		, DROPWIZARD.getLocalPort());
		
	}
	
	private com.anfelisa.user.data.UsernameAvailableResponse then(Response response) throws Exception {
		assertThat(response.getStatus(), 200);
		
		com.anfelisa.user.data.UsernameAvailableResponse actual = null;
		try {
			actual = response.readEntity(com.anfelisa.user.data.UsernameAvailableResponse.class);
		} catch (Exception x) {
		}
		com.anfelisa.user.data.UsernameAvailableData expectedData = objectMapper.readValue("{" +
			"\"uuid\" : \"f541aa16-0361-4b3d-90cc-5894813517b1\"," + 
				"\"available\" : false} ",
		com.anfelisa.user.data.UsernameAvailableData.class)
		
		;
		
		com.anfelisa.user.data.UsernameAvailableResponse expected = new com.anfelisa.user.data.UsernameAvailableResponse(expectedData);


		assertThat(actual, expected);
			
			return actual;
				}
				
				@Test
				public void usernameNotAvailable() throws Exception {
					given();
					
					Response response = when();
			
					com.anfelisa.user.data.UsernameAvailableResponse actualResponse = then(response);
					
					verifications(actualResponse);
			}
			
			protected abstract void verifications(com.anfelisa.user.data.UsernameAvailableResponse response);
			
			}
			
			
			
			
			/******* S.D.G. *******/
			
			
			

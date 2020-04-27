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




package com.anfelisa.user.resetpassword.scenarios;

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
public abstract class AbstractResetPasswordScenario extends BaseScenario {

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
		

		NotReplayableDataProvider.put("token", objectMapper.readValue("\"RESET-PW-TOKEN\"",
				 String.class));
		
		com.anfelisa.user.ActionCalls.callForgotPassword(objectMapper.readValue("{" +
			"\"uuid\" : \"6e8286cd-9dd2-4017-843e-4a8bea9009a6\"," + 
				"\"language\" : \"de\"," + 
				"\"username\" : \"Annette\"," + 
				"\"token\" : \"RESET-PW-TOKEN\"} ",
		com.anfelisa.user.data.ForgotPasswordData.class)
		
		, DROPWIZARD.getLocalPort());
		

	}
	
	private Response when() throws Exception {
		NotReplayableDataProvider.put("token", objectMapper.readValue("\"RESET-PW-TOKEN\"",
				 String.class));
		
		return 
		com.anfelisa.user.ActionCalls.callResetPassword(objectMapper.readValue("{" +
			"\"uuid\" : \"fa02f57f-71ab-48ff-a0e5-48ebaa516272\"," + 
				"\"token\" : \"RESET-PW-TOKEN\"," + 
				"\"password\" : \"newPassword\"} ",
		com.anfelisa.user.data.ResetPasswordWithNewPasswordData.class)
		
		, DROPWIZARD.getLocalPort());
		
	}
	
	private void then(Response response) throws Exception {
		assertThat(response.getStatus(), 200);
		
			
				}
				
				@Test
				public void resetPassword() throws Exception {
					given();
					
					Response response = when();
			
					then(response);
					
					verifications();
			}
			
			protected abstract void verifications();
			
			}
			
			
			
			
			/******* S.D.G. *******/
			
			
			

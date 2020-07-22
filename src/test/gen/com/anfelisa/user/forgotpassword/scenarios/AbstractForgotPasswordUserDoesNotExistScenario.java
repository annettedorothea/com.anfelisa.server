/* 
 * Copyright (c) 2020, Annette Pohl, Koblenz, Germany
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
 *
 * generated with de.acegen 0.9.7
 *
 */




package com.anfelisa.user.forgotpassword.scenarios;

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
public abstract class AbstractForgotPasswordUserDoesNotExistScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractForgotPasswordUserDoesNotExistScenario.class);
	
	private Map<String, Object> extractedValues = new HashMap<String, Object>();
	
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
		this.callNotReplayableDataProviderPutValue(uuid, "token", 
					objectMapper.readValue("\"RESET-PW-TOKEN-" + this.getTestId() + "\"",  String.class));
		com.anfelisa.user.data.ForgotPasswordData data_0 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
				"\"language\" : \"de\"," + 
				"\"username\" : \"doesNotExist\"} ",
		com.anfelisa.user.data.ForgotPasswordData.class);
		long timeBeforeRequest = System.currentTimeMillis();
		Response response = 
		this.httpPost(
			"/users/forgot-password", 
			data_0,
			null
		);
		
		long timeAfterRequest = System.currentTimeMillis();
		LOG.info("WHEN: ForgotPassword finished in {} ms", (timeAfterRequest-timeBeforeRequest));
		addToMetrics("ForgotPassword", (timeAfterRequest-timeBeforeRequest));
		return response;
	}
	
	private com.anfelisa.user.data.ForgotPasswordResponse then(Response response) throws Exception {
		if (response.getStatus() == 500) {
			String message = response.readEntity(String.class);
			assertFail(message);
		}
		if (response.getStatus() != 200) {
			String message = response.readEntity(String.class);
			assertFail(message);
		} else {
			LOG.info("THEN: status 200 passed");
		}
		
		com.anfelisa.user.data.ForgotPasswordResponse actual = null;
		try {
			actual = response.readEntity(com.anfelisa.user.data.ForgotPasswordResponse.class);
		} catch (Exception x) {
		}
		
		return actual;
	}
			
	@Override
	public void runTest() throws Exception {
		given();
			
		if (prerequisite("ForgotPasswordUserDoesNotExist")) {
			Response response = when();

			com.anfelisa.user.data.ForgotPasswordResponse actualResponse = then(response);
			
			this.resetPasswordTokenWasNotCreated();
		
		} else {
			LOG.info("WHEN: prerequisite for ForgotPasswordUserDoesNotExist not met");
		}
	}
	
	
	private void resetPasswordTokenWasNotCreated() throws Exception {
		com.anfelisa.user.models.IResetPasswordModel actual = daoProvider.getResetPasswordDao().selectByToken(handle, "RESET-PW-TOKEN-" + this.getTestId() + "");
		
		assertIsNull(actual);

		LOG.info("THEN: resetPasswordTokenWasNotCreated passed");
	}
	
	@Override
	protected String scenarioName() {
		return "ForgotPasswordUserDoesNotExist";
	}

}



/******* S.D.G. *******/


			

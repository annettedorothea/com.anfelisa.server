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




package com.anfelisa.card.getduplicates.scenarios;

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
public abstract class AbstractGetDuplicatesLimitScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractGetDuplicatesLimitScenario.class);
	
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
		

		if (prerequisite("CreateBoxMinimal")) {
			uuid = "boxId-${testId}".replace("${testId}", this.getTestId());
			LOG.info("GIVEN: CreateBoxMinimal uuid " + uuid);
			response = 
			com.anfelisa.box.ActionCalls.callCreateBox(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryName\" : \"cat\"," + 
					"\"dictionaryLookup\" : false," + 
					"\"maxCardsPerDay\" : 10} ",
			com.anfelisa.box.data.BoxCreationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateBoxMinimal fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateBoxMinimal fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateBoxMinimal success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateBoxMinimal not met");
		}
		

		if (prerequisite("CreateCategory")) {
			uuid = "cat1-${testId}".replace("${testId}", this.getTestId());
			LOG.info("GIVEN: CreateCategory uuid " + uuid);
			response = 
			com.anfelisa.category.ActionCalls.callCreateCategory(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryName\" : \"level 1 #1\"," + 
					"\"parentCategoryId\" : \"boxId-" + this.getTestId() + "\"} ",
			com.anfelisa.category.data.CategoryCreationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateCategory fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateCategory fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateCategory success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateCategory not met");
		}
		

		if (prerequisite("CreateRandomCard")) {
			uuid = this.randomUUID();
			LOG.info("GIVEN: CreateRandomCard uuid " + uuid);
			response = 
			com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"0given" + this.randomString() + "\"," + 
					"\"wanted\" : \"1wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateRandomCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateRandomCard fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateRandomCard success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateRandomCard not met");
		}
		
		if (prerequisite("CreateRandomCard")) {
			uuid = this.randomUUID();
			LOG.info("GIVEN: CreateRandomCard uuid " + uuid);
			response = 
			com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"2given" + this.randomString() + "\"," + 
					"\"wanted\" : \"3wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateRandomCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateRandomCard fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateRandomCard success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateRandomCard not met");
		}
		
		if (prerequisite("CreateRandomCard")) {
			uuid = this.randomUUID();
			LOG.info("GIVEN: CreateRandomCard uuid " + uuid);
			response = 
			com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"4given" + this.randomString() + "\"," + 
					"\"wanted\" : \"5wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateRandomCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateRandomCard fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateRandomCard success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateRandomCard not met");
		}
		
		if (prerequisite("CreateRandomCard")) {
			uuid = this.randomUUID();
			LOG.info("GIVEN: CreateRandomCard uuid " + uuid);
			response = 
			com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"6given" + this.randomString() + "\"," + 
					"\"wanted\" : \"7wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateRandomCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateRandomCard fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateRandomCard success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateRandomCard not met");
		}
		
		if (prerequisite("CreateRandomCard")) {
			uuid = this.randomUUID();
			LOG.info("GIVEN: CreateRandomCard uuid " + uuid);
			response = 
			com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"8given" + this.randomString() + "\"," + 
					"\"wanted\" : \"9wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateRandomCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateRandomCard fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateRandomCard success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateRandomCard not met");
		}
		
		if (prerequisite("CreateRandomCard")) {
			uuid = this.randomUUID();
			LOG.info("GIVEN: CreateRandomCard uuid " + uuid);
			response = 
			com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"10given" + this.randomString() + "\"," + 
					"\"wanted\" : \"11wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateRandomCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateRandomCard fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateRandomCard success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateRandomCard not met");
		}
		
		if (prerequisite("CreateRandomCard")) {
			uuid = this.randomUUID();
			LOG.info("GIVEN: CreateRandomCard uuid " + uuid);
			response = 
			com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"12given" + this.randomString() + "\"," + 
					"\"wanted\" : \"13wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateRandomCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateRandomCard fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateRandomCard success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateRandomCard not met");
		}
		
		if (prerequisite("CreateRandomCard")) {
			uuid = this.randomUUID();
			LOG.info("GIVEN: CreateRandomCard uuid " + uuid);
			response = 
			com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"14given" + this.randomString() + "\"," + 
					"\"wanted\" : \"15wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateRandomCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateRandomCard fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateRandomCard success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateRandomCard not met");
		}
		
		if (prerequisite("CreateRandomCard")) {
			uuid = this.randomUUID();
			LOG.info("GIVEN: CreateRandomCard uuid " + uuid);
			response = 
			com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"16given" + this.randomString() + "\"," + 
					"\"wanted\" : \"17wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateRandomCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateRandomCard fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateRandomCard success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateRandomCard not met");
		}
		
		if (prerequisite("CreateRandomCard")) {
			uuid = this.randomUUID();
			LOG.info("GIVEN: CreateRandomCard uuid " + uuid);
			response = 
			com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"18given" + this.randomString() + "\"," + 
					"\"wanted\" : \"19wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateRandomCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateRandomCard fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateRandomCard success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateRandomCard not met");
		}
		
		if (prerequisite("CreateRandomCard")) {
			uuid = this.randomUUID();
			LOG.info("GIVEN: CreateRandomCard uuid " + uuid);
			response = 
			com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"20given" + this.randomString() + "\"," + 
					"\"wanted\" : \"21wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateRandomCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateRandomCard fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateRandomCard success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateRandomCard not met");
		}
		
		if (prerequisite("CreateRandomCard")) {
			uuid = this.randomUUID();
			LOG.info("GIVEN: CreateRandomCard uuid " + uuid);
			response = 
			com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"22given" + this.randomString() + "\"," + 
					"\"wanted\" : \"23wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateRandomCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateRandomCard fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateRandomCard success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateRandomCard not met");
		}
		
		if (prerequisite("CreateRandomCard")) {
			uuid = this.randomUUID();
			LOG.info("GIVEN: CreateRandomCard uuid " + uuid);
			response = 
			com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"24given" + this.randomString() + "\"," + 
					"\"wanted\" : \"25wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateRandomCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateRandomCard fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateRandomCard success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateRandomCard not met");
		}
		
		if (prerequisite("CreateRandomCard")) {
			uuid = this.randomUUID();
			LOG.info("GIVEN: CreateRandomCard uuid " + uuid);
			response = 
			com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"26given" + this.randomString() + "\"," + 
					"\"wanted\" : \"27wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateRandomCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateRandomCard fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateRandomCard success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateRandomCard not met");
		}
		
		if (prerequisite("CreateRandomCard")) {
			uuid = this.randomUUID();
			LOG.info("GIVEN: CreateRandomCard uuid " + uuid);
			response = 
			com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"28given" + this.randomString() + "\"," + 
					"\"wanted\" : \"29wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateRandomCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateRandomCard fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateRandomCard success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateRandomCard not met");
		}
		
		if (prerequisite("CreateRandomCard")) {
			uuid = this.randomUUID();
			LOG.info("GIVEN: CreateRandomCard uuid " + uuid);
			response = 
			com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"30given" + this.randomString() + "\"," + 
					"\"wanted\" : \"31wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateRandomCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateRandomCard fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateRandomCard success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateRandomCard not met");
		}
		
		if (prerequisite("CreateRandomCard")) {
			uuid = this.randomUUID();
			LOG.info("GIVEN: CreateRandomCard uuid " + uuid);
			response = 
			com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"32given" + this.randomString() + "\"," + 
					"\"wanted\" : \"33wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateRandomCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateRandomCard fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateRandomCard success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateRandomCard not met");
		}
		
		if (prerequisite("CreateRandomCard")) {
			uuid = this.randomUUID();
			LOG.info("GIVEN: CreateRandomCard uuid " + uuid);
			response = 
			com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"34given" + this.randomString() + "\"," + 
					"\"wanted\" : \"35wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateRandomCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateRandomCard fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateRandomCard success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateRandomCard not met");
		}
		
		if (prerequisite("CreateRandomCard")) {
			uuid = this.randomUUID();
			LOG.info("GIVEN: CreateRandomCard uuid " + uuid);
			response = 
			com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"36given" + this.randomString() + "\"," + 
					"\"wanted\" : \"37wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateRandomCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateRandomCard fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateRandomCard success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateRandomCard not met");
		}
		
		if (prerequisite("CreateRandomCard")) {
			uuid = this.randomUUID();
			LOG.info("GIVEN: CreateRandomCard uuid " + uuid);
			response = 
			com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"38given" + this.randomString() + "\"," + 
					"\"wanted\" : \"39wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateRandomCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateRandomCard fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateRandomCard success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateRandomCard not met");
		}
		
		if (prerequisite("CreateRandomCard")) {
			uuid = this.randomUUID();
			LOG.info("GIVEN: CreateRandomCard uuid " + uuid);
			response = 
			com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"40given" + this.randomString() + "\"," + 
					"\"wanted\" : \"41wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateRandomCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateRandomCard fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateRandomCard success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateRandomCard not met");
		}
		
		if (prerequisite("CreateRandomCard")) {
			uuid = this.randomUUID();
			LOG.info("GIVEN: CreateRandomCard uuid " + uuid);
			response = 
			com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"42given" + this.randomString() + "\"," + 
					"\"wanted\" : \"43wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateRandomCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateRandomCard fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateRandomCard success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateRandomCard not met");
		}
		
		if (prerequisite("CreateRandomCard")) {
			uuid = this.randomUUID();
			LOG.info("GIVEN: CreateRandomCard uuid " + uuid);
			response = 
			com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"44given" + this.randomString() + "\"," + 
					"\"wanted\" : \"45wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateRandomCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateRandomCard fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateRandomCard success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateRandomCard not met");
		}
		
		if (prerequisite("CreateRandomCard")) {
			uuid = this.randomUUID();
			LOG.info("GIVEN: CreateRandomCard uuid " + uuid);
			response = 
			com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"46given" + this.randomString() + "\"," + 
					"\"wanted\" : \"47wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateRandomCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateRandomCard fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateRandomCard success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateRandomCard not met");
		}
		
		if (prerequisite("CreateRandomCard")) {
			uuid = this.randomUUID();
			LOG.info("GIVEN: CreateRandomCard uuid " + uuid);
			response = 
			com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"48given" + this.randomString() + "\"," + 
					"\"wanted\" : \"49wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateRandomCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateRandomCard fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateRandomCard success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateRandomCard not met");
		}
		
		if (prerequisite("CreateRandomCard")) {
			uuid = this.randomUUID();
			LOG.info("GIVEN: CreateRandomCard uuid " + uuid);
			response = 
			com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"50given" + this.randomString() + "\"," + 
					"\"wanted\" : \"51wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateRandomCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateRandomCard fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateRandomCard success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateRandomCard not met");
		}
		
		if (prerequisite("CreateRandomCard")) {
			uuid = this.randomUUID();
			LOG.info("GIVEN: CreateRandomCard uuid " + uuid);
			response = 
			com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"52given" + this.randomString() + "\"," + 
					"\"wanted\" : \"53wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateRandomCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateRandomCard fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateRandomCard success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateRandomCard not met");
		}
		
		if (prerequisite("CreateRandomCard")) {
			uuid = this.randomUUID();
			LOG.info("GIVEN: CreateRandomCard uuid " + uuid);
			response = 
			com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"54given" + this.randomString() + "\"," + 
					"\"wanted\" : \"55wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateRandomCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateRandomCard fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateRandomCard success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateRandomCard not met");
		}
		
		if (prerequisite("CreateRandomCard")) {
			uuid = this.randomUUID();
			LOG.info("GIVEN: CreateRandomCard uuid " + uuid);
			response = 
			com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"56given" + this.randomString() + "\"," + 
					"\"wanted\" : \"57wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateRandomCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateRandomCard fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateRandomCard success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateRandomCard not met");
		}
		
		if (prerequisite("CreateRandomCard")) {
			uuid = this.randomUUID();
			LOG.info("GIVEN: CreateRandomCard uuid " + uuid);
			response = 
			com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"58given" + this.randomString() + "\"," + 
					"\"wanted\" : \"59wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateRandomCard fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateRandomCard fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateRandomCard success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateRandomCard not met");
		}
		

	}
	
	private Response when() throws Exception {
		String uuid = this.randomUUID();
		
		return 
		com.anfelisa.card.ActionCalls.callGetDuplicates(objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
				"\"categoryId\" : \"boxId-" + this.getTestId() + "\"," + 
				"\"given\" : \"ive\"," + 
				"\"wanted\" : \"nted\"," + 
				"\"naturalInputOrder\" : true} ",
		com.anfelisa.card.data.CardSearchData.class)
		
		, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "password"));
		
	}
	
	private com.anfelisa.card.data.GetDuplicatesResponse then(Response response) throws Exception {
		if (response.getStatus() == 500) {
			String message = response.readEntity(String.class);
			assertFail(message);
		}
		if (response.getStatus() != 200) {
			String message = response.readEntity(String.class);
			assertFail(message);
		}
		
		com.anfelisa.card.data.GetDuplicatesResponse actual = null;
		try {
			actual = response.readEntity(com.anfelisa.card.data.GetDuplicatesResponse.class);
		} catch (Exception x) {
		}
			
			return actual;
				}
				
				@Test
				public void getDuplicatesLimit() throws Exception {
					given();
						
					if (prerequisite("GetDuplicatesLimit")) {
						Response response = when();
		
						LOG.info("WHEN: GetDuplicates");
				
						com.anfelisa.card.data.GetDuplicatesResponse actualResponse = then(response);
						
						verifications(actualResponse);
					} else {
						LOG.info("prerequisite for GetDuplicatesLimit not met");
					}
				}
				
				protected abstract void verifications(com.anfelisa.card.data.GetDuplicatesResponse response);
				
				@Override
				protected String scenarioName() {
					return "GetDuplicatesLimit";
				}
			
			}
			
			
			
			/******* S.D.G. *******/
			
			
			

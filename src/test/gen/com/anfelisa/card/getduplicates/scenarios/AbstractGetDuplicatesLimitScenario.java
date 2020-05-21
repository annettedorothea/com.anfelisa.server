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
			this.callNotReplayableDataProviderPutValue(uuid, "token", 
						objectMapper.readValue("\"TOKEN-" + this.getTestId() + "\"",  String.class),
						this.getProtocol(), this.getHost(), this.getPort());
			com.anfelisa.user.data.UserRegistrationData data_1 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"email\" : \"annette.pohl@anfelisa.de\"," + 
					"\"language\" : \"de\"," + 
					"\"password\" : \"password\"," + 
					"\"username\" : \"Annette-" + this.getTestId() + "\"} ",
			com.anfelisa.user.data.UserRegistrationData.class);
			response = 
			this.httpPost(
				"/users/register", 
				data_1,
				null
			);
			
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
			com.anfelisa.box.data.BoxCreationData data_2 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryName\" : \"cat\"," + 
					"\"dictionaryLookup\" : false," + 
					"\"maxCardsPerDay\" : 10} ",
			com.anfelisa.box.data.BoxCreationData.class);
			response = 
			this.httpPost(
				"/box/create", 
				data_2,
				authorization("Annette-${testId}", "password")
			);
			
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
			com.anfelisa.category.data.CategoryCreationData data_3 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryName\" : \"level 1 #1\"," + 
					"\"parentCategoryId\" : \"boxId-" + this.getTestId() + "\"} ",
			com.anfelisa.category.data.CategoryCreationData.class);
			response = 
			this.httpPost(
				"/category/create", 
				data_3,
				authorization("Annette-${testId}", "password")
			);
			
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
			com.anfelisa.card.data.CardCreationData data_4 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"1552given" + this.randomString() + "\"," + 
					"\"wanted\" : \"1553wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class);
			response = 
			this.httpPost(
				"/card/create", 
				data_4,
				authorization("Annette-${testId}", "password")
			);
			
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
			com.anfelisa.card.data.CardCreationData data_5 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"1554given" + this.randomString() + "\"," + 
					"\"wanted\" : \"1555wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class);
			response = 
			this.httpPost(
				"/card/create", 
				data_5,
				authorization("Annette-${testId}", "password")
			);
			
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
			com.anfelisa.card.data.CardCreationData data_6 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"1556given" + this.randomString() + "\"," + 
					"\"wanted\" : \"1557wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class);
			response = 
			this.httpPost(
				"/card/create", 
				data_6,
				authorization("Annette-${testId}", "password")
			);
			
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
			com.anfelisa.card.data.CardCreationData data_7 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"1558given" + this.randomString() + "\"," + 
					"\"wanted\" : \"1559wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class);
			response = 
			this.httpPost(
				"/card/create", 
				data_7,
				authorization("Annette-${testId}", "password")
			);
			
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
			com.anfelisa.card.data.CardCreationData data_8 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"1560given" + this.randomString() + "\"," + 
					"\"wanted\" : \"1561wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class);
			response = 
			this.httpPost(
				"/card/create", 
				data_8,
				authorization("Annette-${testId}", "password")
			);
			
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
			com.anfelisa.card.data.CardCreationData data_9 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"1562given" + this.randomString() + "\"," + 
					"\"wanted\" : \"1563wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class);
			response = 
			this.httpPost(
				"/card/create", 
				data_9,
				authorization("Annette-${testId}", "password")
			);
			
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
			com.anfelisa.card.data.CardCreationData data_10 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"1564given" + this.randomString() + "\"," + 
					"\"wanted\" : \"1565wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class);
			response = 
			this.httpPost(
				"/card/create", 
				data_10,
				authorization("Annette-${testId}", "password")
			);
			
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
			com.anfelisa.card.data.CardCreationData data_11 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"1566given" + this.randomString() + "\"," + 
					"\"wanted\" : \"1567wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class);
			response = 
			this.httpPost(
				"/card/create", 
				data_11,
				authorization("Annette-${testId}", "password")
			);
			
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
			com.anfelisa.card.data.CardCreationData data_12 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"1568given" + this.randomString() + "\"," + 
					"\"wanted\" : \"1569wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class);
			response = 
			this.httpPost(
				"/card/create", 
				data_12,
				authorization("Annette-${testId}", "password")
			);
			
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
			com.anfelisa.card.data.CardCreationData data_13 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"1570given" + this.randomString() + "\"," + 
					"\"wanted\" : \"1571wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class);
			response = 
			this.httpPost(
				"/card/create", 
				data_13,
				authorization("Annette-${testId}", "password")
			);
			
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
			com.anfelisa.card.data.CardCreationData data_14 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"1572given" + this.randomString() + "\"," + 
					"\"wanted\" : \"1573wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class);
			response = 
			this.httpPost(
				"/card/create", 
				data_14,
				authorization("Annette-${testId}", "password")
			);
			
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
			com.anfelisa.card.data.CardCreationData data_15 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"1574given" + this.randomString() + "\"," + 
					"\"wanted\" : \"1575wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class);
			response = 
			this.httpPost(
				"/card/create", 
				data_15,
				authorization("Annette-${testId}", "password")
			);
			
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
			com.anfelisa.card.data.CardCreationData data_16 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"1576given" + this.randomString() + "\"," + 
					"\"wanted\" : \"1577wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class);
			response = 
			this.httpPost(
				"/card/create", 
				data_16,
				authorization("Annette-${testId}", "password")
			);
			
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
			com.anfelisa.card.data.CardCreationData data_17 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"1578given" + this.randomString() + "\"," + 
					"\"wanted\" : \"1579wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class);
			response = 
			this.httpPost(
				"/card/create", 
				data_17,
				authorization("Annette-${testId}", "password")
			);
			
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
			com.anfelisa.card.data.CardCreationData data_18 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"1580given" + this.randomString() + "\"," + 
					"\"wanted\" : \"1581wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class);
			response = 
			this.httpPost(
				"/card/create", 
				data_18,
				authorization("Annette-${testId}", "password")
			);
			
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
			com.anfelisa.card.data.CardCreationData data_19 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"1582given" + this.randomString() + "\"," + 
					"\"wanted\" : \"1583wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class);
			response = 
			this.httpPost(
				"/card/create", 
				data_19,
				authorization("Annette-${testId}", "password")
			);
			
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
			com.anfelisa.card.data.CardCreationData data_20 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"1584given" + this.randomString() + "\"," + 
					"\"wanted\" : \"1585wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class);
			response = 
			this.httpPost(
				"/card/create", 
				data_20,
				authorization("Annette-${testId}", "password")
			);
			
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
			com.anfelisa.card.data.CardCreationData data_21 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"1586given" + this.randomString() + "\"," + 
					"\"wanted\" : \"1587wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class);
			response = 
			this.httpPost(
				"/card/create", 
				data_21,
				authorization("Annette-${testId}", "password")
			);
			
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
			com.anfelisa.card.data.CardCreationData data_22 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"1588given" + this.randomString() + "\"," + 
					"\"wanted\" : \"1589wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class);
			response = 
			this.httpPost(
				"/card/create", 
				data_22,
				authorization("Annette-${testId}", "password")
			);
			
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
			com.anfelisa.card.data.CardCreationData data_23 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"1590given" + this.randomString() + "\"," + 
					"\"wanted\" : \"1591wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class);
			response = 
			this.httpPost(
				"/card/create", 
				data_23,
				authorization("Annette-${testId}", "password")
			);
			
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
			com.anfelisa.card.data.CardCreationData data_24 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"1592given" + this.randomString() + "\"," + 
					"\"wanted\" : \"1593wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class);
			response = 
			this.httpPost(
				"/card/create", 
				data_24,
				authorization("Annette-${testId}", "password")
			);
			
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
			com.anfelisa.card.data.CardCreationData data_25 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"1594given" + this.randomString() + "\"," + 
					"\"wanted\" : \"1595wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class);
			response = 
			this.httpPost(
				"/card/create", 
				data_25,
				authorization("Annette-${testId}", "password")
			);
			
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
			com.anfelisa.card.data.CardCreationData data_26 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"1596given" + this.randomString() + "\"," + 
					"\"wanted\" : \"1597wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class);
			response = 
			this.httpPost(
				"/card/create", 
				data_26,
				authorization("Annette-${testId}", "password")
			);
			
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
			com.anfelisa.card.data.CardCreationData data_27 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"1598given" + this.randomString() + "\"," + 
					"\"wanted\" : \"1599wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class);
			response = 
			this.httpPost(
				"/card/create", 
				data_27,
				authorization("Annette-${testId}", "password")
			);
			
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
			com.anfelisa.card.data.CardCreationData data_28 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"1600given" + this.randomString() + "\"," + 
					"\"wanted\" : \"1601wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class);
			response = 
			this.httpPost(
				"/card/create", 
				data_28,
				authorization("Annette-${testId}", "password")
			);
			
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
			com.anfelisa.card.data.CardCreationData data_29 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"1602given" + this.randomString() + "\"," + 
					"\"wanted\" : \"1603wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class);
			response = 
			this.httpPost(
				"/card/create", 
				data_29,
				authorization("Annette-${testId}", "password")
			);
			
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
			com.anfelisa.card.data.CardCreationData data_30 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"1604given" + this.randomString() + "\"," + 
					"\"wanted\" : \"1605wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class);
			response = 
			this.httpPost(
				"/card/create", 
				data_30,
				authorization("Annette-${testId}", "password")
			);
			
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
			com.anfelisa.card.data.CardCreationData data_31 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"1606given" + this.randomString() + "\"," + 
					"\"wanted\" : \"1607wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class);
			response = 
			this.httpPost(
				"/card/create", 
				data_31,
				authorization("Annette-${testId}", "password")
			);
			
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
			com.anfelisa.card.data.CardCreationData data_32 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"1608given" + this.randomString() + "\"," + 
					"\"wanted\" : \"1609wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class);
			response = 
			this.httpPost(
				"/card/create", 
				data_32,
				authorization("Annette-${testId}", "password")
			);
			
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
			com.anfelisa.card.data.CardCreationData data_33 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
					"\"given\" : \"1610given" + this.randomString() + "\"," + 
					"\"wanted\" : \"1611wanted" + this.randomString() + "\"} ",
			com.anfelisa.card.data.CardCreationData.class);
			response = 
			this.httpPost(
				"/card/create", 
				data_33,
				authorization("Annette-${testId}", "password")
			);
			
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
		com.anfelisa.card.data.CardSearchData data_0 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
				"\"categoryId\" : \"boxId-" + this.getTestId() + "\"," + 
				"\"given\" : \"ive\"," + 
				"\"wanted\" : \"nted\"," + 
				"\"naturalInputOrder\" : true} ",
		com.anfelisa.card.data.CardSearchData.class);
		
		return 
		this.httpGet(
			"/cards/search?uuid=" + data_0.getUuid() + "&given=" + data_0.getGiven() + "&wanted=" + data_0.getWanted() + "&naturalInputOrder=" + data_0.getNaturalInputOrder() + "&categoryId=" + data_0.getCategoryId() + "", 
			authorization("Annette-${testId}", "password")
		);
		
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
						LOG.info("WHEN: prerequisite for GetDuplicatesLimit not met");
					}
				}
				
				protected abstract void verifications(com.anfelisa.card.data.GetDuplicatesResponse response);
				
				@Override
				protected String scenarioName() {
					return "GetDuplicatesLimit";
				}
			
			}
			
			
			
			/******* S.D.G. *******/
			
			
			

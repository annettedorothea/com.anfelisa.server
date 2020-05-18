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
public abstract class AbstractGetDuplicatesNaturalInputOrderIsNullScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractGetDuplicatesNaturalInputOrderIsNullScenario.class);
	
	private void given() throws Exception {
		Response response;
		String uuid;
		if (prerequisite("RegisterUser")) {
			uuid = "uuid-${testId}".replace("${testId}", this.getTestId());
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
				assertFail(message);
			}
			LOG.info("GIVEN: RegisterUser");
		} else {
			LOG.info("GIVEN: prerequisite for RegisterUser not met");
		}
		

		if (prerequisite("CreateBoxMinimal")) {
			uuid = "boxId-${testId}".replace("${testId}", this.getTestId());
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
				assertFail(message);
			}
			LOG.info("GIVEN: CreateBoxMinimal");
		} else {
			LOG.info("GIVEN: prerequisite for CreateBoxMinimal not met");
		}
		

		if (prerequisite("CreateCategory")) {
			uuid = "cat1".replace("${testId}", this.getTestId());
			response = 
			com.anfelisa.category.ActionCalls.callCreateCategory(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryName\" : \"level 1 #1\"," + 
					"\"parentCategoryId\" : \"boxId-" + this.getTestId() + "\"} ",
			com.anfelisa.category.data.CategoryCreationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateCategory fails\n" + response.readEntity(String.class);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateCategory");
		} else {
			LOG.info("GIVEN: prerequisite for CreateCategory not met");
		}
		

		if (prerequisite("CreateCard")) {
			uuid = "c1".replace("${testId}", this.getTestId());
			response = 
			com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryId\" : \"cat1\"," + 
					"\"given\" : \"given\"," + 
					"\"image\" : \"image\"," + 
					"\"wanted\" : \"wanted\"} ",
			com.anfelisa.card.data.CardCreationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateCard");
		} else {
			LOG.info("GIVEN: prerequisite for CreateCard not met");
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
				"\"naturalInputOrder\" : null} ",
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
		com.anfelisa.card.data.CardSearchData expectedData = objectMapper.readValue("{" +
			"\"uuid\" : \"\"," + 
				"\"cardList\" : [ { \"cardAuthor\" : \"Annette-" + this.getTestId() + "\"," + 
				"\"cardId\" : \"c1\"," + 
				"\"cardIndex\" : 1," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"given\"," + 
				"\"image\" : \"image\"," + 
				"\"rootCategoryId\" : \"boxId-" + this.getTestId() + "\"," + 
				"\"wanted\" : \"wanted\"," + 
				"\"categoryName\" : \"level 1 #1\"}]} ",
		com.anfelisa.card.data.CardSearchData.class)
		
		;
		
		com.anfelisa.card.data.GetDuplicatesResponse expected = new com.anfelisa.card.data.GetDuplicatesResponse(expectedData);


		assertThat(actual, expected);
			
			return actual;
				}
				
				@Test
				public void getDuplicatesNaturalInputOrderIsNull() throws Exception {
					given();
						
					if (prerequisite("GetDuplicatesNaturalInputOrderIsNull")) {
						Response response = when();
		
						LOG.info("WHEN: GetDuplicates");
				
						com.anfelisa.card.data.GetDuplicatesResponse actualResponse = then(response);
						
						verifications(actualResponse);
					} else {
						LOG.info("prerequisite for GetDuplicatesNaturalInputOrderIsNull not met");
					}
				}
				
				protected abstract void verifications(com.anfelisa.card.data.GetDuplicatesResponse response);
				
				@Override
				protected String scenarioName() {
					return "GetDuplicatesNaturalInputOrderIsNull";
				}
			
			}
			
			
			
			/******* S.D.G. *******/
			
			
			
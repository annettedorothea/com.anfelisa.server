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




package com.anfelisa.category.getcategorytree.scenarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.Response;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.acegen.BaseScenario;
import de.acegen.ITimelineItem;
import de.acegen.NotReplayableDataProvider;

@SuppressWarnings("unused")
public abstract class AbstractGetCategoryTreeWithDictionaryLookupScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractGetCategoryTreeWithDictionaryLookupScenario.class);
	
	private void given() throws Exception {
		Response response;
		String uuid;
		if (prerequisite("RegisterUser")) {
			uuid = "uuid-${testId}".replace("${testId}", this.getTestId());
			this.callNotReplayableDataProviderPutValue(uuid, "token", 
						objectMapper.readValue("\"TOKEN-" + this.getTestId() + "\"",  String.class));
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
		

		if (prerequisite("CreateBoxDictionaryLookup")) {
			uuid = "boxId-${testId}".replace("${testId}", this.getTestId());
			com.anfelisa.box.data.BoxCreationData data_2 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryName\" : \"cat\"," + 
					"\"maxCardsPerDay\" : 10," + 
					"\"dictionaryLookup\" : true," + 
					"\"givenLanguage\" : \"de\"," + 
					"\"wantedLanguage\" : \"en\"} ",
			com.anfelisa.box.data.BoxCreationData.class);
			response = 
			this.httpPost(
				"/box/create", 
				data_2,
				authorization("Annette-${testId}", "password")
			);
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateBoxDictionaryLookup fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateBoxDictionaryLookup fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateBoxDictionaryLookup success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateBoxDictionaryLookup not met");
		}
		

		if (prerequisite("CreateCategoryWithDictionaryLookup")) {
			uuid = "dict-${testId}".replace("${testId}", this.getTestId());
			com.anfelisa.category.data.CategoryCreationData data_3 = objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryName\" : \"dict-" + this.getTestId() + "\"," + 
					"\"parentCategoryId\" : \"boxId-" + this.getTestId() + "\"} ",
			com.anfelisa.category.data.CategoryCreationData.class);
			response = 
			this.httpPost(
				"/category/create", 
				data_3,
				authorization("Annette-${testId}", "password")
			);
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateCategoryWithDictionaryLookup fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateCategoryWithDictionaryLookup fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateCategoryWithDictionaryLookup success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateCategoryWithDictionaryLookup not met");
		}
		

	}
	
	private Response when() throws Exception {
		String uuid = this.randomUUID();
		com.anfelisa.category.data.CategoryTreeData data_0 = objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
				"\"rootCategoryId\" : \"boxId-" + this.getTestId() + "\"} ",
		com.anfelisa.category.data.CategoryTreeData.class);
		
		return 
		this.httpGet(
			"/category/tree?uuid=" + data_0.getUuid() + "&rootCategoryId=" + data_0.getRootCategoryId() + "", 
			authorization("Annette-${testId}", "password")
		);
		
	}
	
	private com.anfelisa.category.data.GetCategoryTreeResponse then(Response response) throws Exception {
		if (response.getStatus() == 500) {
			String message = response.readEntity(String.class);
			assertFail(message);
		}
		if (response.getStatus() != 200) {
			String message = response.readEntity(String.class);
			assertFail(message);
		}
		
		com.anfelisa.category.data.GetCategoryTreeResponse actual = null;
		try {
			actual = response.readEntity(com.anfelisa.category.data.GetCategoryTreeResponse.class);
		} catch (Exception x) {
		}
		com.anfelisa.category.data.CategoryTreeData expectedData = objectMapper.readValue("{" +
			"\"uuid\" : \"\"," + 
				"\"rootCategory\" : { \"categoryId\" : \"boxId-" + this.getTestId() + "\"," + 
				"\"categoryIndex\" : 1," + 
				"\"categoryName\" : \"cat\"," + 
				"\"dictionaryLookup\" : true," + 
				"\"givenLanguage\" : \"de\"," + 
				"\"wantedLanguage\" : \"en\"," + 
				"\"empty\" : false," + 
				"\"rootCategoryId\" : \"boxId-" + this.getTestId() + "\"," + 
				"\"childCategories\" : [ { \"categoryId\" : \"dict-" + this.getTestId() + "\"," + 
				"\"categoryIndex\" : 1," + 
				"\"categoryName\" : \"dict-" + this.getTestId() + "\"," + 
				"\"dictionaryLookup\" : true," + 
				"\"givenLanguage\" : \"de\"," + 
				"\"wantedLanguage\" : \"en\"," + 
				"\"empty\" : true," + 
				"\"parentCategoryId\" : \"boxId-" + this.getTestId() + "\"," + 
				"\"rootCategoryId\" : \"boxId-" + this.getTestId() + "\"," + 
				"\"childCategories\" : []}]}} ",
		com.anfelisa.category.data.CategoryTreeData.class);
		
		com.anfelisa.category.data.GetCategoryTreeResponse expected = new com.anfelisa.category.data.GetCategoryTreeResponse(expectedData);


		assertThat(actual, expected);
			
			return actual;
				}
				
				@Override
				public void runTest() throws Exception {
					given();
						
					if (prerequisite("GetCategoryTreeWithDictionaryLookup")) {
						Response response = when();
		
						LOG.info("WHEN: GetCategoryTree");
				
						com.anfelisa.category.data.GetCategoryTreeResponse actualResponse = then(response);
						
						verifications(actualResponse);
					} else {
						LOG.info("WHEN: prerequisite for GetCategoryTreeWithDictionaryLookup not met");
					}
				}
				
				protected abstract void verifications(com.anfelisa.category.data.GetCategoryTreeResponse response);
				
				@Override
				protected String scenarioName() {
					return "GetCategoryTreeWithDictionaryLookup";
				}
			
			}
			
			
			
			/******* S.D.G. *******/
			
			
			

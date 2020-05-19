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

import org.junit.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.acegen.BaseScenario;
import de.acegen.ITimelineItem;
import de.acegen.NotReplayableDataProvider;

@SuppressWarnings("unused")
public abstract class AbstractGetCategoryTreeScenario extends BaseScenario {

	static final Logger LOG = LoggerFactory.getLogger(AbstractGetCategoryTreeScenario.class);
	
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
		

		if (prerequisite("CreateSecondCategory")) {
			uuid = "cat2-${testId}".replace("${testId}", this.getTestId());
			LOG.info("GIVEN: CreateSecondCategory uuid " + uuid);
			response = 
			com.anfelisa.category.ActionCalls.callCreateCategory(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryName\" : \"level 1 #2\"," + 
					"\"parentCategoryId\" : \"boxId-" + this.getTestId() + "\"} ",
			com.anfelisa.category.data.CategoryCreationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateSecondCategory fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateSecondCategory fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateSecondCategory success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateSecondCategory not met");
		}
		

		if (prerequisite("CreateCategorySecondLevel")) {
			uuid = "cat3-${testId}".replace("${testId}", this.getTestId());
			LOG.info("GIVEN: CreateCategorySecondLevel uuid " + uuid);
			response = 
			com.anfelisa.category.ActionCalls.callCreateCategory(objectMapper.readValue("{" +
				"\"uuid\" : \"" + uuid + "\"," + 
					"\"categoryName\" : \"level 2 #1\"," + 
					"\"parentCategoryId\" : \"cat2-" + this.getTestId() + "\"} ",
			com.anfelisa.category.data.CategoryCreationData.class)
			
			, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "password"));
			
			if (response.getStatus() >= 400) {
				String message = "GIVEN CreateCategorySecondLevel fails\n" + response.readEntity(String.class);
				LOG.info("GIVEN: CreateCategorySecondLevel fails due to " + message);
				assertFail(message);
			}
			LOG.info("GIVEN: CreateCategorySecondLevel success");
		} else {
			LOG.info("GIVEN: prerequisite for CreateCategorySecondLevel not met");
		}
		

	}
	
	private Response when() throws Exception {
		String uuid = this.randomUUID();
		
		return 
		com.anfelisa.category.ActionCalls.callGetCategoryTree(objectMapper.readValue("{" +
			"\"uuid\" : \"" + uuid + "\"," + 
				"\"rootCategoryId\" : \"boxId-" + this.getTestId() + "\"} ",
		com.anfelisa.category.data.CategoryTreeData.class)
		
		, this.getProtocol(), this.getHost(), this.getPort(), authorization("Annette-${testId}", "password"));
		
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
				"\"dictionaryLookup\" : false," + 
				"\"empty\" : false," + 
				"\"rootCategoryId\" : \"boxId-" + this.getTestId() + "\"," + 
				"\"childCategories\" : [ { \"categoryId\" : \"cat1-" + this.getTestId() + "\"," + 
				"\"categoryIndex\" : 1," + 
				"\"categoryName\" : \"level 1 #1\"," + 
				"\"dictionaryLookup\" : false," + 
				"\"empty\" : true," + 
				"\"parentCategoryId\" : \"boxId-" + this.getTestId() + "\"," + 
				"\"rootCategoryId\" : \"boxId-" + this.getTestId() + "\"," + 
				"\"childCategories\" : []}," + 
				"{ \"categoryId\" : \"cat2-" + this.getTestId() + "\"," + 
				"\"categoryIndex\" : 2," + 
				"\"categoryName\" : \"level 1 #2\"," + 
				"\"dictionaryLookup\" : false," + 
				"\"empty\" : false," + 
				"\"parentCategoryId\" : \"boxId-" + this.getTestId() + "\"," + 
				"\"rootCategoryId\" : \"boxId-" + this.getTestId() + "\"," + 
				"\"childCategories\" : [ { \"categoryId\" : \"cat3-" + this.getTestId() + "\"," + 
				"\"categoryIndex\" : 1," + 
				"\"categoryName\" : \"level 2 #1\"," + 
				"\"dictionaryLookup\" : false," + 
				"\"empty\" : true," + 
				"\"parentCategoryId\" : \"cat2-" + this.getTestId() + "\"," + 
				"\"rootCategoryId\" : \"boxId-" + this.getTestId() + "\"," + 
				"\"childCategories\" : []}]}]}} ",
		com.anfelisa.category.data.CategoryTreeData.class)
		
		;
		
		com.anfelisa.category.data.GetCategoryTreeResponse expected = new com.anfelisa.category.data.GetCategoryTreeResponse(expectedData);


		assertThat(actual, expected);
			
			return actual;
				}
				
				@Test
				public void getCategoryTree() throws Exception {
					given();
						
					if (prerequisite("GetCategoryTree")) {
						Response response = when();
		
						LOG.info("WHEN: GetCategoryTree");
				
						com.anfelisa.category.data.GetCategoryTreeResponse actualResponse = then(response);
						
						verifications(actualResponse);
					} else {
						LOG.info("prerequisite for GetCategoryTree not met");
					}
				}
				
				protected abstract void verifications(com.anfelisa.category.data.GetCategoryTreeResponse response);
				
				@Override
				protected String scenarioName() {
					return "GetCategoryTree";
				}
			
			}
			
			
			
			/******* S.D.G. *******/
			
			
			

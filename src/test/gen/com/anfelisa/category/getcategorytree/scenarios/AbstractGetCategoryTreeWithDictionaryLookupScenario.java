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

import de.acegen.BaseScenario;
import de.acegen.ITimelineItem;
import de.acegen.NotReplayableDataProvider;

@SuppressWarnings("unused")
public abstract class AbstractGetCategoryTreeWithDictionaryLookupScenario extends BaseScenario {

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
		

		
		com.anfelisa.box.ActionCalls.callCreateBox(objectMapper.readValue("{" +
			"\"uuid\" : \"boxId\"," + 
				"\"categoryName\" : \"cat\"," + 
				"\"maxCardsPerDay\" : 10," + 
				"\"dictionaryLookup\" : true," + 
				"\"givenLanguage\" : \"de\"," + 
				"\"wantedLanguage\" : \"en\"} ",
		com.anfelisa.box.data.BoxCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		
		com.anfelisa.category.ActionCalls.callCreateCategory(objectMapper.readValue("{" +
			"\"uuid\" : \"dict\"," + 
				"\"categoryName\" : \"dict\"," + 
				"\"parentCategoryId\" : \"boxId\"} ",
		com.anfelisa.category.data.CategoryCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

	}
	
	private Response when() throws Exception {
		
		return 
		com.anfelisa.category.ActionCalls.callGetCategoryTree(objectMapper.readValue("{" +
			"\"uuid\" : \"0773d710-6ab7-4f93-8ac5-bdaf479e2547\"," + 
				"\"rootCategoryId\" : \"boxId\"} ",
		com.anfelisa.category.data.CategoryTreeData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
	}
	
	private com.anfelisa.category.data.GetCategoryTreeResponse then(Response response) throws Exception {
		assertThat(response.getStatus(), 200);
		
		com.anfelisa.category.data.GetCategoryTreeResponse actual = null;
		try {
			actual = response.readEntity(com.anfelisa.category.data.GetCategoryTreeResponse.class);
		} catch (Exception x) {
		}
		com.anfelisa.category.data.CategoryTreeData expectedData = objectMapper.readValue("{" +
			"\"uuid\" : \"6c783b64-44de-45d0-8cdc-e704dbb72aeb\"," + 
				"\"rootCategory\" : { \"categoryId\" : \"boxId\"," + 
				"\"categoryIndex\" : 1," + 
				"\"categoryName\" : \"cat\"," + 
				"\"dictionaryLookup\" : true," + 
				"\"givenLanguage\" : \"de\"," + 
				"\"wantedLanguage\" : \"en\"," + 
				"\"empty\" : false," + 
				"\"rootCategoryId\" : \"boxId\"," + 
				"\"childCategories\" : [ { \"categoryId\" : \"dict\"," + 
				"\"categoryIndex\" : 1," + 
				"\"categoryName\" : \"dict\"," + 
				"\"dictionaryLookup\" : true," + 
				"\"givenLanguage\" : \"de\"," + 
				"\"wantedLanguage\" : \"en\"," + 
				"\"empty\" : true," + 
				"\"parentCategoryId\" : \"boxId\"," + 
				"\"rootCategoryId\" : \"boxId\"," + 
				"\"childCategories\" : []}]}} ",
		com.anfelisa.category.data.CategoryTreeData.class)
		
		;
		
		com.anfelisa.category.data.GetCategoryTreeResponse expected = new com.anfelisa.category.data.GetCategoryTreeResponse(expectedData);


		assertThat(actual, expected);
			
			return actual;
				}
				
				@Test
				public void getCategoryTreeWithDictionaryLookup() throws Exception {
					given();
					
					Response response = when();
			
					com.anfelisa.category.data.GetCategoryTreeResponse actualResponse = then(response);
					
					verifications(actualResponse);
			}
			
			protected abstract void verifications(com.anfelisa.category.data.GetCategoryTreeResponse response);
			
			}
			
			
			
			
			/******* S.D.G. *******/
			
			
			

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

import de.acegen.BaseScenario;
import de.acegen.ITimelineItem;
import de.acegen.NotReplayableDataProvider;

@SuppressWarnings("unused")
public abstract class AbstractGetDuplicatesScenario extends BaseScenario {

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
				"\"dictionaryLookup\" : false," + 
				"\"maxCardsPerDay\" : 1} ",
		com.anfelisa.box.data.BoxCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		
		com.anfelisa.category.ActionCalls.callCreateCategory(objectMapper.readValue("{" +
			"\"uuid\" : \"cat1\"," + 
				"\"categoryName\" : \"level 1 #1\"," + 
				"\"parentCategoryId\" : \"boxId\"} ",
		com.anfelisa.category.data.CategoryCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"c1\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"given\"," + 
				"\"image\" : \"image\"," + 
				"\"wanted\" : \"wanted\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"c2\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"given2\"," + 
				"\"image\" : \"image2\"," + 
				"\"wanted\" : \"wanted2\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"c3\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"3given\"," + 
				"\"wanted\" : \"3wanted\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"c4\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"4given4\"," + 
				"\"wanted\" : \"4wanted4\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"c5\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"different\"," + 
				"\"wanted\" : \"different\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		
		com.anfelisa.category.ActionCalls.callCreateCategory(objectMapper.readValue("{" +
			"\"uuid\" : \"cat1\"," + 
				"\"categoryName\" : \"level 1 #1\"," + 
				"\"parentCategoryId\" : \"boxId\"} ",
		com.anfelisa.category.data.CategoryCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		
		com.anfelisa.category.ActionCalls.callCreateCategory(objectMapper.readValue("{" +
			"\"uuid\" : \"cat2\"," + 
				"\"categoryName\" : \"level 1 #2\"," + 
				"\"parentCategoryId\" : \"boxId\"} ",
		com.anfelisa.category.data.CategoryCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"c6\"," + 
				"\"categoryId\" : \"cat2\"," + 
				"\"given\" : \"aa-given\"," + 
				"\"wanted\" : \"zz-wanted\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		
		com.anfelisa.box.ActionCalls.callCreateBox(objectMapper.readValue("{" +
			"\"uuid\" : \"boxId\"," + 
				"\"categoryName\" : \"cat\"," + 
				"\"dictionaryLookup\" : false," + 
				"\"maxCardsPerDay\" : 1} ",
		com.anfelisa.box.data.BoxCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		
		com.anfelisa.box.ActionCalls.callCreateBox(objectMapper.readValue("{" +
			"\"uuid\" : \"boxId2\"," + 
				"\"categoryName\" : \"cat2\"," + 
				"\"dictionaryLookup\" : false," + 
				"\"maxCardsPerDay\" : 8} ",
		com.anfelisa.box.data.BoxCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"c7\"," + 
				"\"categoryId\" : \"boxId2\"," + 
				"\"given\" : \"given\"," + 
				"\"wanted\" : \"wanted\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

	}
	
	private Response when() throws Exception {
		
		return 
		com.anfelisa.card.ActionCalls.callGetDuplicates(objectMapper.readValue("{" +
			"\"uuid\" : \"f2064d7f-5963-4edb-bc95-6fa7d991e971\"," + 
				"\"categoryId\" : \"boxId\"," + 
				"\"given\" : \"ive\"," + 
				"\"wanted\" : \"nted\"," + 
				"\"naturalInputOrder\" : true} ",
		com.anfelisa.card.data.CardSearchData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
	}
	
	private com.anfelisa.card.data.GetDuplicatesResponse then(Response response) throws Exception {
		assertThat(response.getStatus(), 200);
		
		com.anfelisa.card.data.GetDuplicatesResponse actual = null;
		try {
			actual = response.readEntity(com.anfelisa.card.data.GetDuplicatesResponse.class);
		} catch (Exception x) {
		}
		com.anfelisa.card.data.CardSearchData expectedData = objectMapper.readValue("{" +
			"\"uuid\" : \"37c469b9-b9f0-4177-975f-049b03430481\"," + 
				"\"cardList\" : [ { \"cardAuthor\" : \"Annette\"," + 
				"\"cardId\" : \"c3\"," + 
				"\"cardIndex\" : 3," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"3given\"," + 
				"\"rootCategoryId\" : \"boxId\"," + 
				"\"wanted\" : \"3wanted\"," + 
				"\"categoryName\" : \"level 1 #1\"}," + 
				"{ \"cardAuthor\" : \"Annette\"," + 
				"\"cardId\" : \"c4\"," + 
				"\"cardIndex\" : 4," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"4given4\"," + 
				"\"rootCategoryId\" : \"boxId\"," + 
				"\"wanted\" : \"4wanted4\"," + 
				"\"categoryName\" : \"level 1 #1\"}," + 
				"{ \"cardAuthor\" : \"Annette\"," + 
				"\"cardId\" : \"c6\"," + 
				"\"cardIndex\" : 1," + 
				"\"categoryId\" : \"cat2\"," + 
				"\"given\" : \"aa-given\"," + 
				"\"rootCategoryId\" : \"boxId\"," + 
				"\"wanted\" : \"zz-wanted\"," + 
				"\"categoryName\" : \"level 1 #2\"}," + 
				"{ \"cardAuthor\" : \"Annette\"," + 
				"\"cardId\" : \"c1\"," + 
				"\"cardIndex\" : 1," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"given\"," + 
				"\"image\" : \"image\"," + 
				"\"rootCategoryId\" : \"boxId\"," + 
				"\"wanted\" : \"wanted\"," + 
				"\"categoryName\" : \"level 1 #1\"}," + 
				"{ \"cardAuthor\" : \"Annette\"," + 
				"\"cardId\" : \"c2\"," + 
				"\"cardIndex\" : 2," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"given2\"," + 
				"\"image\" : \"image2\"," + 
				"\"rootCategoryId\" : \"boxId\"," + 
				"\"wanted\" : \"wanted2\"," + 
				"\"categoryName\" : \"level 1 #1\"}]} ",
		com.anfelisa.card.data.CardSearchData.class)
		
		;
		
		com.anfelisa.card.data.GetDuplicatesResponse expected = new com.anfelisa.card.data.GetDuplicatesResponse(expectedData);


		assertThat(actual, expected);
			
			return actual;
				}
				
				@Test
				public void getDuplicates() throws Exception {
					given();
					
					Response response = when();
			
					com.anfelisa.card.data.GetDuplicatesResponse actualResponse = then(response);
					
					verifications(actualResponse);
			}
			
			protected abstract void verifications(com.anfelisa.card.data.GetDuplicatesResponse response);
			
			}
			
			
			
			
			/******* S.D.G. *******/
			
			
			

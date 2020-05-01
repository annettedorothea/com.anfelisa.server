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




package com.anfelisa.box.loadnextcard.scenarios;

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
public abstract class AbstractLoadNextCardNotMyBoxScenario extends BaseScenario {

	private void given() throws Exception {
		Response response;
		NotReplayableDataProvider.put("token", objectMapper.readValue("\"TOKEN\"",
				 String.class));
		response = 
		com.anfelisa.user.ActionCalls.callRegisterUser(objectMapper.readValue("{" +
			"\"uuid\" : \"uuid\"," + 
				"\"email\" : \"annette.pohl@anfelisa.de\"," + 
				"\"language\" : \"de\"," + 
				"\"password\" : \"password\"," + 
				"\"username\" : \"Annette\"} ",
		com.anfelisa.user.data.UserRegistrationData.class)
		
		, DROPWIZARD.getLocalPort());
		
		if (response.getStatus() == 500) {
			String message = "GIVEN RegisterUser fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		

		response = 
		com.anfelisa.box.ActionCalls.callCreateBox(objectMapper.readValue("{" +
			"\"uuid\" : \"boxId\"," + 
				"\"categoryName\" : \"cat\"," + 
				"\"dictionaryLookup\" : false," + 
				"\"maxCardsPerDay\" : 10} ",
		com.anfelisa.box.data.BoxCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN CreateBox fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		

		response = 
		com.anfelisa.category.ActionCalls.callCreateCategory(objectMapper.readValue("{" +
			"\"uuid\" : \"cat1\"," + 
				"\"categoryName\" : \"level 1 #1\"," + 
				"\"parentCategoryId\" : \"boxId\"} ",
		com.anfelisa.category.data.CategoryCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN CreateCategory fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		

		response = 
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"c1\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"given\"," + 
				"\"image\" : \"image\"," + 
				"\"wanted\" : \"wanted\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		

		response = 
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"c2\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"given2\"," + 
				"\"image\" : \"image2\"," + 
				"\"wanted\" : \"wanted2\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		

		response = 
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"c3\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"3given\"," + 
				"\"wanted\" : \"3wanted\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		

		response = 
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"c4\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"4given4\"," + 
				"\"wanted\" : \"4wanted4\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		

		response = 
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"c5\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"different\"," + 
				"\"wanted\" : \"different\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		

		NotReplayableDataProvider.setSystemTime(DateTime.parse("20200418 10:30", DateTimeFormat.forPattern("yyyyMMdd HH:mm")).withZone(DateTimeZone.UTC));
		response = 
		com.anfelisa.box.ActionCalls.callScheduleCards(objectMapper.readValue("{" +
			"\"uuid\" : \"sc1\"," + 
				"\"cardIds\" : [ \"c1\"," + 
				"\"c3\"," + 
				"\"c4\"]} ",
		com.anfelisa.box.data.ScheduledCardsData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN ScheduleCards fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		

		NotReplayableDataProvider.put("token", objectMapper.readValue("\"ADMIN-TOKEN\"",
				 String.class));
		response = 
		com.anfelisa.user.ActionCalls.callRegisterUser(objectMapper.readValue("{" +
			"\"uuid\" : \"uuid-admin\"," + 
				"\"email\" : \"annette.pohl@anfelisa.de\"," + 
				"\"language\" : \"de\"," + 
				"\"password\" : \"admin-password\"," + 
				"\"username\" : \"Admin\"} ",
		com.anfelisa.user.data.UserRegistrationData.class)
		
		, DROPWIZARD.getLocalPort());
		
		if (response.getStatus() == 500) {
			String message = "GIVEN RegisterUser fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		

	}
	
	private Response when() throws Exception {
		
		return 
		com.anfelisa.box.ActionCalls.callLoadNextCard(objectMapper.readValue("{" +
			"\"uuid\" : \"" + this.randomUUID() + "\"," + 
				"\"boxId\" : \"boxId\"," + 
				"\"todayAtMidnightInUTC\" : \"2020-04-18T00:00:00.000Z\"} ",
		com.anfelisa.box.data.NextCardData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Admin", "admin-password"));
		
	}
	
	private com.anfelisa.box.data.LoadNextCardResponse then(Response response) throws Exception {
		if (response.getStatus() == 500) {
			String message = response.readEntity(String.class);
			assertFail(message);
		}
		assertThat(response.getStatus(), 401);
		
		com.anfelisa.box.data.LoadNextCardResponse actual = null;
		try {
			actual = response.readEntity(com.anfelisa.box.data.LoadNextCardResponse.class);
		} catch (Exception x) {
		}
			
			return actual;
				}
				
				@Test
				public void loadNextCardNotMyBox() throws Exception {
					given();
					
					Response response = when();
			
					com.anfelisa.box.data.LoadNextCardResponse actualResponse = then(response);
					
					verifications(actualResponse);
				}
				
				protected abstract void verifications(com.anfelisa.box.data.LoadNextCardResponse response);
				
				@Override
				protected String scenarioName() {
					return "LoadNextCardNotMyBox";
				}
			
			}
			
			
			
			/******* S.D.G. *******/
			
			
			

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
public abstract class AbstractGetDuplicatesLimitScenario extends BaseScenario {

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
			"\"uuid\" : \"" + this.randomUUID() + "\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"0given" + this.randomString() + "\"," + 
				"\"wanted\" : \"1wanted" + this.randomString() + "\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		
		response = 
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"" + this.randomUUID() + "\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"2given" + this.randomString() + "\"," + 
				"\"wanted\" : \"3wanted" + this.randomString() + "\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		
		response = 
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"" + this.randomUUID() + "\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"4given" + this.randomString() + "\"," + 
				"\"wanted\" : \"5wanted" + this.randomString() + "\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		
		response = 
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"" + this.randomUUID() + "\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"6given" + this.randomString() + "\"," + 
				"\"wanted\" : \"7wanted" + this.randomString() + "\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		
		response = 
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"" + this.randomUUID() + "\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"8given" + this.randomString() + "\"," + 
				"\"wanted\" : \"9wanted" + this.randomString() + "\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		
		response = 
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"" + this.randomUUID() + "\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"10given" + this.randomString() + "\"," + 
				"\"wanted\" : \"11wanted" + this.randomString() + "\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		
		response = 
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"" + this.randomUUID() + "\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"12given" + this.randomString() + "\"," + 
				"\"wanted\" : \"13wanted" + this.randomString() + "\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		
		response = 
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"" + this.randomUUID() + "\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"14given" + this.randomString() + "\"," + 
				"\"wanted\" : \"15wanted" + this.randomString() + "\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		
		response = 
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"" + this.randomUUID() + "\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"16given" + this.randomString() + "\"," + 
				"\"wanted\" : \"17wanted" + this.randomString() + "\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		
		response = 
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"" + this.randomUUID() + "\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"18given" + this.randomString() + "\"," + 
				"\"wanted\" : \"19wanted" + this.randomString() + "\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		
		response = 
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"" + this.randomUUID() + "\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"20given" + this.randomString() + "\"," + 
				"\"wanted\" : \"21wanted" + this.randomString() + "\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		
		response = 
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"" + this.randomUUID() + "\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"22given" + this.randomString() + "\"," + 
				"\"wanted\" : \"23wanted" + this.randomString() + "\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		
		response = 
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"" + this.randomUUID() + "\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"24given" + this.randomString() + "\"," + 
				"\"wanted\" : \"25wanted" + this.randomString() + "\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		
		response = 
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"" + this.randomUUID() + "\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"26given" + this.randomString() + "\"," + 
				"\"wanted\" : \"27wanted" + this.randomString() + "\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		
		response = 
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"" + this.randomUUID() + "\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"28given" + this.randomString() + "\"," + 
				"\"wanted\" : \"29wanted" + this.randomString() + "\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		
		response = 
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"" + this.randomUUID() + "\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"30given" + this.randomString() + "\"," + 
				"\"wanted\" : \"31wanted" + this.randomString() + "\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		
		response = 
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"" + this.randomUUID() + "\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"32given" + this.randomString() + "\"," + 
				"\"wanted\" : \"33wanted" + this.randomString() + "\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		
		response = 
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"" + this.randomUUID() + "\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"34given" + this.randomString() + "\"," + 
				"\"wanted\" : \"35wanted" + this.randomString() + "\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		
		response = 
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"" + this.randomUUID() + "\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"36given" + this.randomString() + "\"," + 
				"\"wanted\" : \"37wanted" + this.randomString() + "\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		
		response = 
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"" + this.randomUUID() + "\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"38given" + this.randomString() + "\"," + 
				"\"wanted\" : \"39wanted" + this.randomString() + "\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		
		response = 
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"" + this.randomUUID() + "\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"40given" + this.randomString() + "\"," + 
				"\"wanted\" : \"41wanted" + this.randomString() + "\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		
		response = 
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"" + this.randomUUID() + "\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"42given" + this.randomString() + "\"," + 
				"\"wanted\" : \"43wanted" + this.randomString() + "\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		
		response = 
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"" + this.randomUUID() + "\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"44given" + this.randomString() + "\"," + 
				"\"wanted\" : \"45wanted" + this.randomString() + "\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		
		response = 
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"" + this.randomUUID() + "\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"46given" + this.randomString() + "\"," + 
				"\"wanted\" : \"47wanted" + this.randomString() + "\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		
		response = 
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"" + this.randomUUID() + "\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"48given" + this.randomString() + "\"," + 
				"\"wanted\" : \"49wanted" + this.randomString() + "\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		
		response = 
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"" + this.randomUUID() + "\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"50given" + this.randomString() + "\"," + 
				"\"wanted\" : \"51wanted" + this.randomString() + "\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		
		response = 
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"" + this.randomUUID() + "\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"52given" + this.randomString() + "\"," + 
				"\"wanted\" : \"53wanted" + this.randomString() + "\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		
		response = 
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"" + this.randomUUID() + "\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"54given" + this.randomString() + "\"," + 
				"\"wanted\" : \"55wanted" + this.randomString() + "\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		
		response = 
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"" + this.randomUUID() + "\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"56given" + this.randomString() + "\"," + 
				"\"wanted\" : \"57wanted" + this.randomString() + "\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		
		response = 
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"" + this.randomUUID() + "\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"58given" + this.randomString() + "\"," + 
				"\"wanted\" : \"59wanted" + this.randomString() + "\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		if (response.getStatus() == 500) {
			String message = "GIVEN CreateCard fails\n" + response.readEntity(String.class);
			assertFail(message);
		}
		

	}
	
	private Response when() throws Exception {
		
		return 
		com.anfelisa.card.ActionCalls.callGetDuplicates(objectMapper.readValue("{" +
			"\"uuid\" : \"" + this.randomUUID() + "\"," + 
				"\"categoryId\" : \"boxId\"," + 
				"\"given\" : \"ive\"," + 
				"\"wanted\" : \"nted\"," + 
				"\"naturalInputOrder\" : true} ",
		com.anfelisa.card.data.CardSearchData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
	}
	
	private com.anfelisa.card.data.GetDuplicatesResponse then(Response response) throws Exception {
		if (response.getStatus() == 500) {
			String message = response.readEntity(String.class);
			assertFail(message);
		}
		assertThat(response.getStatus(), 200);
		
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
					
					Response response = when();
			
					com.anfelisa.card.data.GetDuplicatesResponse actualResponse = then(response);
					
					verifications(actualResponse);
				}
				
				protected abstract void verifications(com.anfelisa.card.data.GetDuplicatesResponse response);
				
				@Override
				protected String scenarioName() {
					return "GetDuplicatesLimit";
				}
			
			}
			
			
			
			/******* S.D.G. *******/
			
			
			

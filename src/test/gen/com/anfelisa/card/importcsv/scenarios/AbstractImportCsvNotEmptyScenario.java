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




package com.anfelisa.card.importcsv.scenarios;

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
public abstract class AbstractImportCsvNotEmptyScenario extends BaseScenario {

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
		

	}
	
	private Response when() throws Exception {
		
		return 
		com.anfelisa.card.ActionCalls.callImportCsv(objectMapper.readValue("{" +
			"\"uuid\" : \"e6251f60-3d3c-48a9-a64a-0dd185112baa\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"previewCsv\" : [ { \"given\" : \"g1\"," + 
				"\"wanted\" : \"w1\"," + 
				"\"id\" : \"1\"}," + 
				"{ \"given\" : \"g2\"," + 
				"\"wanted\" : \"w2\"," + 
				"\"id\" : \"2\"}," + 
				"{ \"given\" : \"g3\"," + 
				"\"wanted\" : \"w3\"," + 
				"\"id\" : \"3\"}]} ",
		com.anfelisa.card.data.CsvUploadData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
	}
	
	private void then(Response response) throws Exception {
		assertThat(response.getStatus(), 200);
		
			
				}
				
				@Test
				public void importCsvNotEmpty() throws Exception {
					given();
					
					Response response = when();
			
					then(response);
					
					verifications();
			}
			
			protected abstract void verifications();
			
			}
			
			
			
			
			/******* S.D.G. *******/
			
			
			

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
			"\"uuid\" : \"ceabee63-4391-4cf7-bfc9-78e31d9ced7c\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"0givenc2795437\"," + 
				"\"wanted\" : \"1wanted0c99f741\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"b2d64d91-faef-41a0-ba1c-1c1b7122924a\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"2given06118e76\"," + 
				"\"wanted\" : \"3wantedb231dcbd\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"ab9ff3ff-3ab0-4bc7-8e00-125c5c9e14d4\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"4givena3df31fb\"," + 
				"\"wanted\" : \"5wanted60bf0632\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"25c28413-3af6-40c1-a9d3-64927d99ed8e\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"6given4b8c57c4\"," + 
				"\"wanted\" : \"7wanted7eab72ef\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"50d6fec0-0695-41cf-91da-6aa9e35d9e05\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"8given3d7fa59a\"," + 
				"\"wanted\" : \"9wanted3ba35749\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"8765f8d5-7d17-475e-85be-d60f263f2a11\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"10given2492f5cc\"," + 
				"\"wanted\" : \"11wanted1f42c63a\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"22baa135-339b-41d6-bde2-8d0e64ee9fdc\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"12givenc6c2505c\"," + 
				"\"wanted\" : \"13wantede7bf3058\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"a573a038-090f-45b2-9234-b166ab120783\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"14given3df2ad80\"," + 
				"\"wanted\" : \"15wantedfd8a5f4f\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"f88e3b1f-3d3b-410b-b55c-2a5474ffee19\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"16given5718db19\"," + 
				"\"wanted\" : \"17wanted1231cde2\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"f0a3ff4a-eef3-41c5-8fbe-f1f0c9330531\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"18given525a8d9a\"," + 
				"\"wanted\" : \"19wantede55f0f37\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"945836b6-b3cc-4991-a805-79e938893ab4\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"20given39ac72de\"," + 
				"\"wanted\" : \"21wanted59039111\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"74d232bc-388a-473f-92c9-d562c7db6786\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"22given4612c5ff\"," + 
				"\"wanted\" : \"23wanteddb73ef42\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"8213713b-0dc9-4ca0-834d-fd0046c26ada\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"24given93d867b4\"," + 
				"\"wanted\" : \"25wanted6e0c514a\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"fc270953-5573-4635-aa67-cba91f520607\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"26given923cde63\"," + 
				"\"wanted\" : \"27wanted189c0329\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"43151699-7296-4f95-931a-a5c027a0d137\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"28givenbf3a53fb\"," + 
				"\"wanted\" : \"29wanted18739731\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"24214f40-0321-40d7-8ce4-bfed4a3318c6\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"30given6c6ff256\"," + 
				"\"wanted\" : \"31wanteda236cec1\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"ce2988d4-8a00-4dce-85b3-44a3074f82fe\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"32given1af4c3c5\"," + 
				"\"wanted\" : \"33wantedd406ef8b\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"7ac78de0-52e0-4794-b1af-bf4aabf0b074\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"34given81d299d1\"," + 
				"\"wanted\" : \"35wanted5a4c27df\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"cf9ddc65-419d-47bf-90c0-5af25e52b4de\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"36given8dfb3118\"," + 
				"\"wanted\" : \"37wanted02616677\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"7859048e-af28-47d6-b12d-021d51c2eab7\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"38given9a0d1097\"," + 
				"\"wanted\" : \"39wanted2d460455\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"c1c6ea7f-d870-4996-87d5-ff9e9ae47ea3\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"40given3dc31278\"," + 
				"\"wanted\" : \"41wanted0c988a00\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"57306078-3252-49e4-8ae6-b7b5979fa35f\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"42givenef6b47f1\"," + 
				"\"wanted\" : \"43wantede27a7f62\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"1a9efe7a-d6a7-4ea4-9715-437476b52df1\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"44givenf90cbe4d\"," + 
				"\"wanted\" : \"45wanted744108b1\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"2b817ed2-914c-4b22-bd24-778af7508832\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"46givenc58bdb92\"," + 
				"\"wanted\" : \"47wantedab50f4fb\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"dbfc1a1e-b6e5-4a03-952a-b94da3a22925\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"48given52be29f0\"," + 
				"\"wanted\" : \"49wanted1fd3ad6c\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"a6bd9504-7ef6-4b11-9cea-3fbc15aaad16\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"50given96758a0e\"," + 
				"\"wanted\" : \"51wanted280fd0e6\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"2964110e-9d49-421e-ab11-333036017553\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"52given55f4d815\"," + 
				"\"wanted\" : \"53wanted2fad8e37\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"ba9c723a-682e-46c9-8f51-1e50335e6620\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"54givenff33d3c7\"," + 
				"\"wanted\" : \"55wanted1c23453f\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"6a6f549a-917d-42c8-ae91-ada19c315f63\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"56given70a632bf\"," + 
				"\"wanted\" : \"57wanted0e07b60a\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"c8200ed6-7de0-456b-98ea-abe9a7319511\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"58given4e88f579\"," + 
				"\"wanted\" : \"59wantedbc27c343\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		

	}
	
	private Response when() throws Exception {
		
		return 
		com.anfelisa.card.ActionCalls.callGetDuplicates(objectMapper.readValue("{" +
			"\"uuid\" : \"a3579046-b31e-4e26-9edc-1158ae2344c0\"," + 
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
			
			}
			
			
			
			
			/******* S.D.G. *******/
			
			
			

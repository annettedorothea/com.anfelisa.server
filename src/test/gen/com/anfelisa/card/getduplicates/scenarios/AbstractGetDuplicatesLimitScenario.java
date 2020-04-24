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
			"\"uuid\" : \"0e757022-e1bc-473f-af47-a1122d99beef\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"0given4c5635b1\"," + 
				"\"wanted\" : \"1wanted18e15dc2\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"1e38da27-9597-41b7-801b-0fcc5ee35066\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"2given1c78f7a8\"," + 
				"\"wanted\" : \"3wanted9ba7ac9c\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"c155cee9-8d5f-4adb-9494-c87af882da61\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"4givenafd6da61\"," + 
				"\"wanted\" : \"5wanted350fec82\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"a3f388f7-5789-4f6b-86b5-306a29e6b39b\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"6given5f3e596b\"," + 
				"\"wanted\" : \"7wanted0aaea2ad\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"d8979946-a7e2-49f0-8527-cd28513a47e6\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"8given5944942b\"," + 
				"\"wanted\" : \"9wanted05b147ff\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"a33a939a-3703-4c0c-bc15-ba709fe092bf\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"10given507cbc13\"," + 
				"\"wanted\" : \"11wantedfdf95c27\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"407773dd-ce65-4fac-a1f4-975c07440d44\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"12givendeeceb78\"," + 
				"\"wanted\" : \"13wanteddab41caf\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"8315be16-2930-41ce-bc7a-821dff3e1fea\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"14given7b306dd8\"," + 
				"\"wanted\" : \"15wanted04d64b0f\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"8d72702f-1973-4d29-a570-5d2fb37e0ba1\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"16given9bda136a\"," + 
				"\"wanted\" : \"17wantedcce56d46\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"679428aa-3f2f-45ab-8eef-e33897519ec2\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"18givenfc8dbe19\"," + 
				"\"wanted\" : \"19wanted04175e38\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"00e5c8b5-fd24-46ef-bb09-9a5c16c97450\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"20givenb35faad5\"," + 
				"\"wanted\" : \"21wantedffd9527e\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"e1fe9e2b-334f-4709-8e41-c0a56142ebe7\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"22given4782cc37\"," + 
				"\"wanted\" : \"23wantedb40a770a\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"23814398-604f-4ced-897b-60e61d8f62e7\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"24given911e4955\"," + 
				"\"wanted\" : \"25wanted409c24c2\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"0287b8da-7f85-4ddd-828e-a8222003a455\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"26givenf32fcfa4\"," + 
				"\"wanted\" : \"27wantede17f2c62\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"5c420017-3280-48ba-97ca-b8f80c409569\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"28given806a028f\"," + 
				"\"wanted\" : \"29wanted531720bc\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"c06f922b-7a6d-4a36-a810-380680b2069e\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"30givend11526eb\"," + 
				"\"wanted\" : \"31wanted2705a994\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"7df7b3d8-8d4f-43cf-819e-0129b8f65b64\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"32given84696af7\"," + 
				"\"wanted\" : \"33wanted5dfb5dc4\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"29b01751-9f93-47f2-a2a3-ff0b1189c5ce\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"34given03368c63\"," + 
				"\"wanted\" : \"35wantedbb9541a5\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"038368b6-2082-48e0-958d-f52c124b09bd\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"36given6e126e42\"," + 
				"\"wanted\" : \"37wanted95bda9ec\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"22b23e95-5fc8-4078-a5d3-186345cd2364\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"38givenbd6980a0\"," + 
				"\"wanted\" : \"39wantedc911a53e\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"6c1d60ee-adac-486b-8dd4-6efba4be424e\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"40given201246f2\"," + 
				"\"wanted\" : \"41wanted762ae9d2\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"fc710eab-01f0-4e8e-8750-36927576ac1d\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"42givenf9b880d1\"," + 
				"\"wanted\" : \"43wantedc4da37eb\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"b970742d-eb54-42fd-ba9b-15c34bc928b4\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"44given05214ac7\"," + 
				"\"wanted\" : \"45wantedb163dab0\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"55464f39-c526-4424-bb29-442cd6fa76b0\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"46given9d2ebb85\"," + 
				"\"wanted\" : \"47wanted1661a287\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"b3510882-010e-4394-8963-ef4fa72926a1\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"48given5198e5e8\"," + 
				"\"wanted\" : \"49wantedcc4f552f\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"9e5f76dd-65b4-42f6-9375-ef6794216edd\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"50given831d34b6\"," + 
				"\"wanted\" : \"51wanted317306f6\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"f83fe15e-b418-4b9a-b1ac-d52cf79d7d49\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"52givenefdbbb41\"," + 
				"\"wanted\" : \"53wanted8cf25ed7\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"b470e1a8-2e9e-43c1-88a8-b7e380ca935c\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"54given87ec85f3\"," + 
				"\"wanted\" : \"55wantedb16a12d3\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"222eff24-7034-4aea-bd4d-085de179ebfd\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"56given56f4a322\"," + 
				"\"wanted\" : \"57wanted49875956\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"07e16519-a069-404f-898a-57cee2c8bade\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"58given09d6478b\"," + 
				"\"wanted\" : \"59wanteddb840521\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		

	}
	
	private Response when() throws Exception {
		
		return 
		com.anfelisa.card.ActionCalls.callGetDuplicates(objectMapper.readValue("{" +
			"\"uuid\" : \"aef26d08-15c4-47e0-8ae0-b4d118bb0b19\"," + 
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
			
			
			

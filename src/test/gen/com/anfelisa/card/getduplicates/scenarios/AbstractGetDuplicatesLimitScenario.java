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
				"\"maxCardsPerDay\" : 10} ",
		com.anfelisa.box.data.BoxCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		
		com.anfelisa.category.ActionCalls.callCreateCategory(objectMapper.readValue("{" +
			"\"uuid\" : \"cat1\"," + 
				"\"categoryName\" : \"level 1 #1\"," + 
				"\"parentCategoryId\" : \"boxId\"} ",
		com.anfelisa.category.data.CategoryCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"242ff316-d012-407e-b161-d4fe23c49c26\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"0given7a04c63e\"," + 
				"\"wanted\" : \"1wantedb8cb292b\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"f503cd71-0e90-4a8c-b433-9e5a386acf93\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"2given675aa90f\"," + 
				"\"wanted\" : \"3wantedd415767d\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"15f1be96-7fdb-4cd4-b9ec-ec82b5556a39\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"4given359cc5fc\"," + 
				"\"wanted\" : \"5wanted0c6327d7\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"901f9c87-30d5-4704-8ef7-83c4ace6ef48\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"6givenbb0ced57\"," + 
				"\"wanted\" : \"7wanted756fadfc\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"9aef87cf-b86c-41a6-a105-c841ceefa07c\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"8given79491cd9\"," + 
				"\"wanted\" : \"9wantedaa299c8c\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"c53161cf-cb7e-487c-b3e6-01c051f2ed9a\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"10given84aaa59c\"," + 
				"\"wanted\" : \"11wantedd54f5e33\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"df12b7f7-fbce-482d-a301-d5e06079045e\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"12givenf5011fe0\"," + 
				"\"wanted\" : \"13wantedd4e9a9bb\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"46af3c67-f363-4d2f-8b34-64b453cdbb43\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"14givenfdd0af5e\"," + 
				"\"wanted\" : \"15wanted215c0f45\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"4311752a-4eba-4d95-852c-4c684dcfa5a6\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"16given815c0b8f\"," + 
				"\"wanted\" : \"17wanted50b6f8d4\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"6fa315d4-3d6c-4871-bd2e-97b4531e3929\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"18given0d4620a7\"," + 
				"\"wanted\" : \"19wanted6ca56e50\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"cf385e3d-908b-4d03-b029-d0993a3ace30\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"20given3b2940c1\"," + 
				"\"wanted\" : \"21wanted23a094ce\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"9612db2b-d78f-4f34-9af0-9ea79fa30313\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"22given4fd6fd61\"," + 
				"\"wanted\" : \"23wanted981f3c9d\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"bed47458-997d-4a70-a458-940a00ef793b\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"24given29819c9c\"," + 
				"\"wanted\" : \"25wantedb8c3d988\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"ce475602-a1b7-46fe-afaf-a0288b78f6b5\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"26given5eb2a782\"," + 
				"\"wanted\" : \"27wantedabae7f8d\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"74c9a4a5-0550-4d72-8935-c179d30920ca\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"28given718e5690\"," + 
				"\"wanted\" : \"29wantedc67d78aa\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"09b274c7-ebc3-48f2-8588-332882bc42b6\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"30givenc3c20bd7\"," + 
				"\"wanted\" : \"31wanted8790d82b\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"c3ac0932-db86-4aca-b25c-4690d77bd79f\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"32given8cf05ada\"," + 
				"\"wanted\" : \"33wanted3e375606\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"5f18f416-8452-4237-808a-089698f7a6e6\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"34given52c8164d\"," + 
				"\"wanted\" : \"35wanted1289b544\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"976fd5f2-4e89-4a3d-87e9-85175fbac9e7\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"36givenc6f355dc\"," + 
				"\"wanted\" : \"37wanted8ca56193\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"9d4cd302-1130-4c92-baa3-56f0b26009e9\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"38given8fc2e744\"," + 
				"\"wanted\" : \"39wanted07fbfd1f\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"09e80b6d-9375-497f-8c3c-b448c5b18c61\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"40given4f73e7c1\"," + 
				"\"wanted\" : \"41wanted51c8ea15\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"99971983-aed4-471b-947a-6b5fdc5c8f84\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"42given97779511\"," + 
				"\"wanted\" : \"43wanted04db3bb1\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"dadcfbb8-8168-4d69-ae24-d77a27ad973f\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"44given61616a6f\"," + 
				"\"wanted\" : \"45wantedef0deea4\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"509b3dc9-4bb0-477e-bdd7-ec98098cb16f\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"46given824a2840\"," + 
				"\"wanted\" : \"47wanted435e12eb\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"08a4df15-d390-48f1-834b-962457c764ae\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"48givena72d7b22\"," + 
				"\"wanted\" : \"49wantedb36ebce3\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"59342ad1-e26f-4975-876e-a797d7670dc6\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"50givenf2d88db5\"," + 
				"\"wanted\" : \"51wantedb430487d\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"a879e159-f826-44ee-9ef8-ccc1cda76680\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"52given03b573c8\"," + 
				"\"wanted\" : \"53wanted38bf34b7\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"bdbc3a3f-4e81-437c-98d7-02e56dbcce5c\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"54given26e3f754\"," + 
				"\"wanted\" : \"55wanted78a0259f\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"fb318d64-e140-408d-8db5-61d583791450\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"56given3d4ec18a\"," + 
				"\"wanted\" : \"57wanted5ada6f8c\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"b6a33aff-ca29-4f1b-8bf2-6986d6ce8cc3\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"58given1ad24f4f\"," + 
				"\"wanted\" : \"59wanted49027725\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		

	}
	
	private Response when() throws Exception {
		
		return 
		com.anfelisa.card.ActionCalls.callGetDuplicates(objectMapper.readValue("{" +
			"\"uuid\" : \"c189be3f-4d78-45ca-b3ce-2025c0c27538\"," + 
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
			
			
			

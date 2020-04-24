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
			"\"uuid\" : \"1d571f67-0a3d-4390-92f4-d7a0cd9783b5\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"0giveneee5fb64\"," + 
				"\"wanted\" : \"1wanteddbebc85e\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"e0b5edac-b3a4-494c-ab24-147d2bd03459\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"2given99bc4ca8\"," + 
				"\"wanted\" : \"3wanted0d0c026c\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"f9bf14eb-f258-4238-aee7-16358bfd4ba6\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"4givena54c8a72\"," + 
				"\"wanted\" : \"5wantedd81d864f\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"c7cc7498-939e-4c23-aa11-f22559647842\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"6given8796b7cb\"," + 
				"\"wanted\" : \"7wanted54b44f94\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"292e70b8-c9db-464e-ade3-9d17c665f4c9\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"8given65c29cd5\"," + 
				"\"wanted\" : \"9wanted30cd68a6\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"150cb926-8b19-440b-abd0-14f01b457704\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"10givenca44bcbb\"," + 
				"\"wanted\" : \"11wanted5f4b9bc3\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"abba8771-165c-4856-b942-f25f88ecc3d0\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"12given4de6dc76\"," + 
				"\"wanted\" : \"13wantedb6ff8c5f\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"d052ea05-4445-40f4-930a-bf52221ddf3e\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"14given46d87078\"," + 
				"\"wanted\" : \"15wanted9c91789b\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"d4545950-f032-4174-bf97-9ed412b70606\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"16given1f3be8e3\"," + 
				"\"wanted\" : \"17wanted5db58a26\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"65b6de6b-4651-4027-994b-2c9a760246e6\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"18given8d0fdefc\"," + 
				"\"wanted\" : \"19wanted788148b8\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"a23f3fd2-be19-41d7-b234-75529961d024\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"20given6cbe5189\"," + 
				"\"wanted\" : \"21wanted4105278c\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"ff83a369-e9e0-4cd7-a1e6-c86f72b2064a\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"22given5bf6c047\"," + 
				"\"wanted\" : \"23wantedd0bd5046\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"a8d50483-f5de-4c2d-90de-0a2d51d6e042\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"24given0e80b29c\"," + 
				"\"wanted\" : \"25wantede4a128ef\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"75ed4622-9275-409e-83ee-1fcdcb96170e\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"26given0f3b89bb\"," + 
				"\"wanted\" : \"27wantedc041829b\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"4a0152fd-986d-412b-9653-7d696b8e9196\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"28givenaf07eb1a\"," + 
				"\"wanted\" : \"29wantedd48cba66\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"cf83a476-6cc4-410d-87c4-f04de5939f3f\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"30givene6c629fc\"," + 
				"\"wanted\" : \"31wanted75b8a7ed\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"bb5fc172-e629-4ecd-b6e0-baeb7443f033\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"32given09c25c86\"," + 
				"\"wanted\" : \"33wantedf2daa884\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"6a35ba22-e786-4753-967b-1218dbc69067\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"34given8771d633\"," + 
				"\"wanted\" : \"35wantedd6d5909e\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"4fe060b1-f8c1-4324-ac38-849db38061fd\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"36givendc0442eb\"," + 
				"\"wanted\" : \"37wanted000695ac\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"90d6b811-6468-49b1-8576-899e77ea3b52\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"38givenf33e2827\"," + 
				"\"wanted\" : \"39wanted3787a7a4\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"f893485f-b15b-4cb4-9709-32acf85d7501\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"40given41d822d5\"," + 
				"\"wanted\" : \"41wantedfa30d39c\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"4c1d6d99-e7b9-45be-bfcd-5c552935b94b\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"42given23af06a4\"," + 
				"\"wanted\" : \"43wantedc9261dbf\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"f7aa4036-0e34-459d-960a-4e0431c19a2d\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"44given7beb24d1\"," + 
				"\"wanted\" : \"45wanted0876aec9\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"0f23cd1a-8bbb-413c-9492-a7b977c4fcab\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"46given3c3694c2\"," + 
				"\"wanted\" : \"47wanted0094fd7e\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"b0e56dec-c122-475e-8980-fe2f3c13340b\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"48given7a0b0d67\"," + 
				"\"wanted\" : \"49wanted4fb9e76d\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"e27e74ab-088b-49ff-8db8-f3a839bde354\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"50giveneb3d6a16\"," + 
				"\"wanted\" : \"51wanted8f21531f\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"f2c098a4-6c04-4108-a4d5-b301526d8961\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"52givend0e161cd\"," + 
				"\"wanted\" : \"53wanted1a6e88de\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"bc1b1729-3144-458b-b89a-b5b811488bae\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"54givenc899a255\"," + 
				"\"wanted\" : \"55wanteddcc83fcf\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"f87a51e9-a461-4c6b-a611-63d004b0bf65\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"56givenc909145a\"," + 
				"\"wanted\" : \"57wantedc24dc2e2\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(objectMapper.readValue("{" +
			"\"uuid\" : \"4633e766-67c3-43e9-818c-db98a3adb175\"," + 
				"\"categoryId\" : \"cat1\"," + 
				"\"given\" : \"58given072302e5\"," + 
				"\"wanted\" : \"59wantedd1c9e4a0\"} ",
		com.anfelisa.card.data.CardCreationData.class)
		
		, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		

	}
	
	private Response when() throws Exception {
		
		return 
		com.anfelisa.card.ActionCalls.callGetDuplicates(objectMapper.readValue("{" +
			"\"uuid\" : \"ce4e39b8-5499-49a8-988b-70320fb3cfec\"," + 
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
			
			
			

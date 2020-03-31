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
import java.util.List;

import javax.ws.rs.core.Response;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import org.junit.Test;

import de.acegen.BaseScenario;
import de.acegen.ITimelineItem;
import de.acegen.NotReplayableDataProvider;

@SuppressWarnings("unused")
public abstract class AbstractGetDuplicatesOrderByWantedScenario extends BaseScenario {

	private void given() throws Exception {
		NotReplayableDataProvider.put("token", "TOKEN");
		com.anfelisa.user.ActionCalls.callRegisterUser("uuid", "password", "Annette", "annette.pohl@anfelisa.de", "de", DROPWIZARD.getLocalPort());

		com.anfelisa.box.ActionCalls.callCreateBox("boxId", "cat", new Boolean("false"), null, null, 10, null, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.category.ActionCalls.callCreateCategory("cat1", "level 1 #1", "boxId", DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.card.ActionCalls.callCreateCard("c1", "wanted", "given", "image", "cat1", DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.card.ActionCalls.callCreateCard("c2", "wanted2", "given2", "image2", "cat1", DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.card.ActionCalls.callCreateCard("c3", "3wanted", "3given", null, "cat1", DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.card.ActionCalls.callCreateCard("c4", "4wanted4", "4given4", null, "cat1", DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.card.ActionCalls.callCreateCard("c5", "different", "different", null, "cat1", DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		NotReplayableDataProvider.put("token", "TOKEN");
		com.anfelisa.user.ActionCalls.callRegisterUser("uuid", "password", "Annette", "annette.pohl@anfelisa.de", "de", DROPWIZARD.getLocalPort());

		com.anfelisa.box.ActionCalls.callCreateBox("boxId", "cat", new Boolean("false"), null, null, 10, null, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.category.ActionCalls.callCreateCategory("cat1", "level 1 #1", "boxId", DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.category.ActionCalls.callCreateCategory("cat2", "level 1 #2", "boxId", DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.card.ActionCalls.callCreateCard("c6", "zz-wanted", "aa-given", null, "cat2", DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		NotReplayableDataProvider.put("token", "TOKEN");
		com.anfelisa.user.ActionCalls.callRegisterUser("uuid", "password", "Annette", "annette.pohl@anfelisa.de", "de", DROPWIZARD.getLocalPort());

		com.anfelisa.box.ActionCalls.callCreateBox("boxId", "cat", new Boolean("false"), null, null, 10, null, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.box.ActionCalls.callCreateBox("boxId2", "cat2", new Boolean("false"), null, null, 8, null, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.card.ActionCalls.callCreateCard("c7", "wanted", "given", null, "boxId2", DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

	}
	
	private Response when() throws Exception {
		return com.anfelisa.card.ActionCalls.callGetDuplicates(randomUUID(), "ive", "nted", new Boolean("false"), "boxId", DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
	}
	
	private com.anfelisa.card.data.GetDuplicatesResponse then(Response response) throws Exception {
		assertThat(response.getStatus(), 200);
		
		com.anfelisa.card.data.GetDuplicatesResponse actual = null;
		try {
			actual = response.readEntity(com.anfelisa.card.data.GetDuplicatesResponse.class);
		} catch (Exception x) {
		}
		com.anfelisa.card.data.CardSearchData expectedData = new com.anfelisa.card.data.CardSearchData(randomUUID());
		
			List<com.anfelisa.card.models.ICardWithCategoryNameModel> expectedDataCardList = new ArrayList<com.anfelisa.card.models.ICardWithCategoryNameModel>();
			com.anfelisa.card.models.ICardWithCategoryNameModel item1 = new com.anfelisa.card.models.CardWithCategoryNameModel();
			item1.setCardAuthor("Annette");
			item1.setCardId("c3");
			item1.setCardIndex(3);
			item1.setCategoryId("cat1");
			item1.setGiven("3given");
			item1.setRootCategoryId("boxId");
			item1.setWanted("3wanted");
			item1.setCategoryName("level 1 #1");
			expectedDataCardList.add(item1);
		
			com.anfelisa.card.models.ICardWithCategoryNameModel item2 = new com.anfelisa.card.models.CardWithCategoryNameModel();
			item2.setCardAuthor("Annette");
			item2.setCardId("c4");
			item2.setCardIndex(4);
			item2.setCategoryId("cat1");
			item2.setGiven("4given4");
			item2.setRootCategoryId("boxId");
			item2.setWanted("4wanted4");
			item2.setCategoryName("level 1 #1");
			expectedDataCardList.add(item2);
		
			com.anfelisa.card.models.ICardWithCategoryNameModel item3 = new com.anfelisa.card.models.CardWithCategoryNameModel();
			item3.setCardAuthor("Annette");
			item3.setCardId("c1");
			item3.setCardIndex(1);
			item3.setCategoryId("cat1");
			item3.setGiven("given");
			item3.setImage("image");
			item3.setRootCategoryId("boxId");
			item3.setWanted("wanted");
			item3.setCategoryName("level 1 #1");
			expectedDataCardList.add(item3);
		
			com.anfelisa.card.models.ICardWithCategoryNameModel item4 = new com.anfelisa.card.models.CardWithCategoryNameModel();
			item4.setCardAuthor("Annette");
			item4.setCardId("c2");
			item4.setCardIndex(2);
			item4.setCategoryId("cat1");
			item4.setGiven("given2");
			item4.setImage("image2");
			item4.setRootCategoryId("boxId");
			item4.setWanted("wanted2");
			item4.setCategoryName("level 1 #1");
			expectedDataCardList.add(item4);
		
			com.anfelisa.card.models.ICardWithCategoryNameModel item5 = new com.anfelisa.card.models.CardWithCategoryNameModel();
			item5.setCardAuthor("Annette");
			item5.setCardId("c6");
			item5.setCardIndex(1);
			item5.setCategoryId("cat2");
			item5.setGiven("aa-given");
			item5.setRootCategoryId("boxId");
			item5.setWanted("zz-wanted");
			item5.setCategoryName("level 1 #2");
			expectedDataCardList.add(item5);
		
			
		expectedData.setCardList(expectedDataCardList);
		
		com.anfelisa.card.data.GetDuplicatesResponse expected = new com.anfelisa.card.data.GetDuplicatesResponse(expectedData);


		assertThat(actual, expected);
		
		return actual;
	}
	
	@Test
	public void getDuplicatesOrderByWanted() throws Exception {
		given();
		
		Response response = when();

		com.anfelisa.card.data.GetDuplicatesResponse actualResponse = then(response);
		
		verifications(actualResponse);
	}
	
	protected abstract void verifications(com.anfelisa.card.data.GetDuplicatesResponse response);

}




/******* S.D.G. *******/




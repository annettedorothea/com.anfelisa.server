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




package com.anfelisa.card.getcards.scenarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.Response;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import org.junit.Test;

import de.acegen.BaseScenario;
import de.acegen.ITimelineItem;
import de.acegen.NotReplayableDataProvider;

@SuppressWarnings("unused")
public abstract class AbstractGetCardsScenario extends BaseScenario {

	private void given() throws Exception {
		NotReplayableDataProvider.put("token", this.templateStringValue("TOKEN", null));
		com.anfelisa.user.ActionCalls.callRegisterUser("uuid", this.templateStringValue("password", 0), this.templateStringValue("Annette", 0), this.templateStringValue("annette.pohl@anfelisa.de", 0), this.templateStringValue("de", 0), DROPWIZARD.getLocalPort());

		com.anfelisa.box.ActionCalls.callCreateBox("boxId", this.templateStringValue("cat", 1), new Boolean("false"), null, null, 10, null, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.category.ActionCalls.callCreateCategory("cat1", this.templateStringValue("level 1 #1", 2), this.templateStringValue("boxId", 2), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.card.ActionCalls.callCreateCard("c1", this.templateStringValue("wanted", 3), this.templateStringValue("given", 3), this.templateStringValue("image", 3), this.templateStringValue("cat1", 3), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.card.ActionCalls.callCreateCard("c2", this.templateStringValue("wanted2", 4), this.templateStringValue("given2", 4), this.templateStringValue("image2", 4), this.templateStringValue("cat1", 4), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.card.ActionCalls.callCreateCard("c3", this.templateStringValue("3wanted", 5), this.templateStringValue("3given", 5), null, this.templateStringValue("cat1", 5), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.card.ActionCalls.callCreateCard("c4", this.templateStringValue("4wanted4", 6), this.templateStringValue("4given4", 6), null, this.templateStringValue("cat1", 6), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.card.ActionCalls.callCreateCard("c5", this.templateStringValue("different", 7), this.templateStringValue("different", 7), null, this.templateStringValue("cat1", 7), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.category.ActionCalls.callCreateCategory("cat1", this.templateStringValue("level 1 #1", 8), this.templateStringValue("boxId", 8), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.category.ActionCalls.callCreateCategory("cat2", this.templateStringValue("level 1 #2", 9), this.templateStringValue("boxId", 9), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.card.ActionCalls.callCreateCard("c6", this.templateStringValue("zz-wanted", 10), this.templateStringValue("aa-given", 10), null, this.templateStringValue("cat2", 10), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

	}
	
	private Response when() throws Exception {
		return com.anfelisa.card.ActionCalls.callGetCards(randomUUID(), this.templateStringValue("cat1", 0), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
	}
	
	private com.anfelisa.card.data.GetCardsResponse then(Response response) throws Exception {
		assertThat(response.getStatus(), 200);
		
		com.anfelisa.card.data.GetCardsResponse actual = null;
		try {
			actual = response.readEntity(com.anfelisa.card.data.GetCardsResponse.class);
		} catch (Exception x) {
		}
		com.anfelisa.card.data.CardListData expectedData = new com.anfelisa.card.data.CardListData(randomUUID());
		
			List<com.anfelisa.card.models.ICardWithInfoModel> expectedDataCardList = new ArrayList<com.anfelisa.card.models.ICardWithInfoModel>();
			com.anfelisa.card.models.ICardWithInfoModel item1 = new com.anfelisa.card.models.CardWithInfoModel();
			item1.setCardAuthor(this.templateStringValue("Annette", null));
			item1.setCardId(this.templateStringValue("c1", null));
			item1.setCardIndex(1);
			item1.setCategoryId(this.templateStringValue("cat1", null));
			item1.setGiven(this.templateStringValue("given", null));
			item1.setImage(this.templateStringValue("image", null));
			item1.setRootCategoryId(this.templateStringValue("boxId", null));
			item1.setWanted(this.templateStringValue("wanted", null));
			expectedDataCardList.add(item1);
		
			com.anfelisa.card.models.ICardWithInfoModel item2 = new com.anfelisa.card.models.CardWithInfoModel();
			item2.setCardAuthor(this.templateStringValue("Annette", null));
			item2.setCardId(this.templateStringValue("c2", null));
			item2.setCardIndex(2);
			item2.setCategoryId(this.templateStringValue("cat1", null));
			item2.setGiven(this.templateStringValue("given2", null));
			item2.setImage(this.templateStringValue("image2", null));
			item2.setRootCategoryId(this.templateStringValue("boxId", null));
			item2.setWanted(this.templateStringValue("wanted2", null));
			expectedDataCardList.add(item2);
		
			com.anfelisa.card.models.ICardWithInfoModel item3 = new com.anfelisa.card.models.CardWithInfoModel();
			item3.setCardAuthor(this.templateStringValue("Annette", null));
			item3.setCardId(this.templateStringValue("c3", null));
			item3.setCardIndex(3);
			item3.setCategoryId(this.templateStringValue("cat1", null));
			item3.setGiven(this.templateStringValue("3given", null));
			item3.setRootCategoryId(this.templateStringValue("boxId", null));
			item3.setWanted(this.templateStringValue("3wanted", null));
			expectedDataCardList.add(item3);
		
			com.anfelisa.card.models.ICardWithInfoModel item4 = new com.anfelisa.card.models.CardWithInfoModel();
			item4.setCardAuthor(this.templateStringValue("Annette", null));
			item4.setCardId(this.templateStringValue("c4", null));
			item4.setCardIndex(4);
			item4.setCategoryId(this.templateStringValue("cat1", null));
			item4.setGiven(this.templateStringValue("4given4", null));
			item4.setRootCategoryId(this.templateStringValue("boxId", null));
			item4.setWanted(this.templateStringValue("4wanted4", null));
			expectedDataCardList.add(item4);
		
			com.anfelisa.card.models.ICardWithInfoModel item5 = new com.anfelisa.card.models.CardWithInfoModel();
			item5.setCardAuthor(this.templateStringValue("Annette", null));
			item5.setCardId(this.templateStringValue("c5", null));
			item5.setCardIndex(5);
			item5.setCategoryId(this.templateStringValue("cat1", null));
			item5.setGiven(this.templateStringValue("different", null));
			item5.setRootCategoryId(this.templateStringValue("boxId", null));
			item5.setWanted(this.templateStringValue("different", null));
			expectedDataCardList.add(item5);
		
			
		expectedData.setCardList(expectedDataCardList);
		
		com.anfelisa.card.data.GetCardsResponse expected = new com.anfelisa.card.data.GetCardsResponse(expectedData);


		assertThat(actual, expected);
			
			return actual;
				}
				
				@Test
				public void getCards() throws Exception {
					given();
					
					Response response = when();
			
					com.anfelisa.card.data.GetCardsResponse actualResponse = then(response);
					
					verifications(actualResponse);
			}
			
			protected abstract void verifications(com.anfelisa.card.data.GetCardsResponse response);
			
			}
			
			
			
			
			/******* S.D.G. *******/
			
			
			

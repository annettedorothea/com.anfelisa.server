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
import org.joda.time.format.DateTimeFormat;

import org.junit.Test;

import de.acegen.BaseScenario;
import de.acegen.ITimelineItem;
import de.acegen.NotReplayableDataProvider;

@SuppressWarnings("unused")
public abstract class AbstractGetDuplicatesOrderByWantedScenario extends BaseScenario {

	private void given() throws Exception {
		NotReplayableDataProvider.put("token", this.templateStringValue("TOKEN", null));
		com.anfelisa.user.data.UserRegistrationData registerUser0 = new com.anfelisa.user.data.UserRegistrationData("uuid");
		registerUser0.setEmail(this.templateStringValue("annette.pohl@anfelisa.de", 0));
		registerUser0.setLanguage(this.templateStringValue("de", 0));
		registerUser0.setPassword(this.templateStringValue("password", 0));
		registerUser0.setUsername(this.templateStringValue("Annette", 0));
		registerUser0.setToken(this.templateStringValue("TOKEN", 0));
		
		
		com.anfelisa.user.ActionCalls.callRegisterUser(registerUser0, DROPWIZARD.getLocalPort());
		

		com.anfelisa.box.data.BoxCreationData createBox1 = new com.anfelisa.box.data.BoxCreationData("boxId");
		createBox1.setCategoryName(this.templateStringValue("cat", 1));
		createBox1.setDictionaryLookup(new Boolean("false"));
		createBox1.setMaxCardsPerDay(1);
		
		
		com.anfelisa.box.ActionCalls.callCreateBox(createBox1, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		com.anfelisa.category.data.CategoryCreationData createCategory2 = new com.anfelisa.category.data.CategoryCreationData("cat1");
		createCategory2.setCategoryName(this.templateStringValue("level 1 #1", 2));
		createCategory2.setParentCategoryId(this.templateStringValue("boxId", 2));
		
		
		com.anfelisa.category.ActionCalls.callCreateCategory(createCategory2, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		com.anfelisa.card.data.CardCreationData createCard3 = new com.anfelisa.card.data.CardCreationData("c1");
		createCard3.setCategoryId(this.templateStringValue("cat1", 3));
		createCard3.setGiven(this.templateStringValue("given", 3));
		createCard3.setImage(this.templateStringValue("image", 3));
		createCard3.setWanted(this.templateStringValue("wanted", 3));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard3, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		com.anfelisa.card.data.CardCreationData createCard4 = new com.anfelisa.card.data.CardCreationData("c2");
		createCard4.setCategoryId(this.templateStringValue("cat1", 4));
		createCard4.setGiven(this.templateStringValue("given2", 4));
		createCard4.setImage(this.templateStringValue("image2", 4));
		createCard4.setWanted(this.templateStringValue("wanted2", 4));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard4, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		com.anfelisa.card.data.CardCreationData createCard5 = new com.anfelisa.card.data.CardCreationData("c3");
		createCard5.setCategoryId(this.templateStringValue("cat1", 5));
		createCard5.setGiven(this.templateStringValue("3given", 5));
		createCard5.setWanted(this.templateStringValue("3wanted", 5));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard5, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		com.anfelisa.card.data.CardCreationData createCard6 = new com.anfelisa.card.data.CardCreationData("c4");
		createCard6.setCategoryId(this.templateStringValue("cat1", 6));
		createCard6.setGiven(this.templateStringValue("4given4", 6));
		createCard6.setWanted(this.templateStringValue("4wanted4", 6));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard6, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		com.anfelisa.card.data.CardCreationData createCard7 = new com.anfelisa.card.data.CardCreationData("c5");
		createCard7.setCategoryId(this.templateStringValue("cat1", 7));
		createCard7.setGiven(this.templateStringValue("different", 7));
		createCard7.setWanted(this.templateStringValue("different", 7));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard7, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		com.anfelisa.category.data.CategoryCreationData createCategory8 = new com.anfelisa.category.data.CategoryCreationData("cat1");
		createCategory8.setCategoryName(this.templateStringValue("level 1 #1", 8));
		createCategory8.setParentCategoryId(this.templateStringValue("boxId", 8));
		
		
		com.anfelisa.category.ActionCalls.callCreateCategory(createCategory8, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		com.anfelisa.category.data.CategoryCreationData createCategory9 = new com.anfelisa.category.data.CategoryCreationData("cat2");
		createCategory9.setCategoryName(this.templateStringValue("level 1 #2", 9));
		createCategory9.setParentCategoryId(this.templateStringValue("boxId", 9));
		
		
		com.anfelisa.category.ActionCalls.callCreateCategory(createCategory9, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		com.anfelisa.card.data.CardCreationData createCard10 = new com.anfelisa.card.data.CardCreationData("c6");
		createCard10.setCategoryId(this.templateStringValue("cat2", 10));
		createCard10.setGiven(this.templateStringValue("aa-given", 10));
		createCard10.setWanted(this.templateStringValue("zz-wanted", 10));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard10, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		com.anfelisa.box.data.BoxCreationData createBox11 = new com.anfelisa.box.data.BoxCreationData("boxId");
		createBox11.setCategoryName(this.templateStringValue("cat", 11));
		createBox11.setDictionaryLookup(new Boolean("false"));
		createBox11.setMaxCardsPerDay(1);
		
		
		com.anfelisa.box.ActionCalls.callCreateBox(createBox11, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		com.anfelisa.box.data.BoxCreationData createBox12 = new com.anfelisa.box.data.BoxCreationData("boxId2");
		createBox12.setCategoryName(this.templateStringValue("cat2", 12));
		createBox12.setDictionaryLookup(new Boolean("false"));
		createBox12.setMaxCardsPerDay(8);
		
		
		com.anfelisa.box.ActionCalls.callCreateBox(createBox12, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		com.anfelisa.card.data.CardCreationData createCard13 = new com.anfelisa.card.data.CardCreationData("c7");
		createCard13.setCategoryId(this.templateStringValue("boxId2", 13));
		createCard13.setGiven(this.templateStringValue("given", 13));
		createCard13.setWanted(this.templateStringValue("wanted", 13));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard13, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

	}
	
	private Response when() throws Exception {
		com.anfelisa.card.data.CardSearchData getDuplicates0 = new com.anfelisa.card.data.CardSearchData(randomUUID());
		getDuplicates0.setCategoryId(this.templateStringValue("boxId", 0));
		getDuplicates0.setGiven(this.templateStringValue("ive", 0));
		getDuplicates0.setWanted(this.templateStringValue("nted", 0));
		getDuplicates0.setNaturalInputOrder(new Boolean("false"));
		
		
		return 
		com.anfelisa.card.ActionCalls.callGetDuplicates(getDuplicates0, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
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
			item1.setCardAuthor(this.templateStringValue("Annette", null));
			item1.setCardId(this.templateStringValue("c3", null));
			item1.setCardIndex(3);
			item1.setCategoryId(this.templateStringValue("cat1", null));
			item1.setGiven(this.templateStringValue("3given", null));
			item1.setRootCategoryId(this.templateStringValue("boxId", null));
			item1.setWanted(this.templateStringValue("3wanted", null));
			item1.setCategoryName(this.templateStringValue("level 1 #1", null));
			expectedDataCardList.add(item1);
		
			com.anfelisa.card.models.ICardWithCategoryNameModel item2 = new com.anfelisa.card.models.CardWithCategoryNameModel();
			item2.setCardAuthor(this.templateStringValue("Annette", null));
			item2.setCardId(this.templateStringValue("c4", null));
			item2.setCardIndex(4);
			item2.setCategoryId(this.templateStringValue("cat1", null));
			item2.setGiven(this.templateStringValue("4given4", null));
			item2.setRootCategoryId(this.templateStringValue("boxId", null));
			item2.setWanted(this.templateStringValue("4wanted4", null));
			item2.setCategoryName(this.templateStringValue("level 1 #1", null));
			expectedDataCardList.add(item2);
		
			com.anfelisa.card.models.ICardWithCategoryNameModel item3 = new com.anfelisa.card.models.CardWithCategoryNameModel();
			item3.setCardAuthor(this.templateStringValue("Annette", null));
			item3.setCardId(this.templateStringValue("c1", null));
			item3.setCardIndex(1);
			item3.setCategoryId(this.templateStringValue("cat1", null));
			item3.setGiven(this.templateStringValue("given", null));
			item3.setImage(this.templateStringValue("image", null));
			item3.setRootCategoryId(this.templateStringValue("boxId", null));
			item3.setWanted(this.templateStringValue("wanted", null));
			item3.setCategoryName(this.templateStringValue("level 1 #1", null));
			expectedDataCardList.add(item3);
		
			com.anfelisa.card.models.ICardWithCategoryNameModel item4 = new com.anfelisa.card.models.CardWithCategoryNameModel();
			item4.setCardAuthor(this.templateStringValue("Annette", null));
			item4.setCardId(this.templateStringValue("c2", null));
			item4.setCardIndex(2);
			item4.setCategoryId(this.templateStringValue("cat1", null));
			item4.setGiven(this.templateStringValue("given2", null));
			item4.setImage(this.templateStringValue("image2", null));
			item4.setRootCategoryId(this.templateStringValue("boxId", null));
			item4.setWanted(this.templateStringValue("wanted2", null));
			item4.setCategoryName(this.templateStringValue("level 1 #1", null));
			expectedDataCardList.add(item4);
		
			com.anfelisa.card.models.ICardWithCategoryNameModel item5 = new com.anfelisa.card.models.CardWithCategoryNameModel();
			item5.setCardAuthor(this.templateStringValue("Annette", null));
			item5.setCardId(this.templateStringValue("c6", null));
			item5.setCardIndex(1);
			item5.setCategoryId(this.templateStringValue("cat2", null));
			item5.setGiven(this.templateStringValue("aa-given", null));
			item5.setRootCategoryId(this.templateStringValue("boxId", null));
			item5.setWanted(this.templateStringValue("zz-wanted", null));
			item5.setCategoryName(this.templateStringValue("level 1 #2", null));
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
			
			
			

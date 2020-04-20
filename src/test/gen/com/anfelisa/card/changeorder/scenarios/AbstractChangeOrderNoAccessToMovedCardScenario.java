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




package com.anfelisa.card.changeorder.scenarios;

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
public abstract class AbstractChangeOrderNoAccessToMovedCardScenario extends BaseScenario {

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
		

		NotReplayableDataProvider.put("token", this.templateStringValue("ADMIN-TOKEN", null));
		com.anfelisa.user.data.UserRegistrationData registerUser4 = new com.anfelisa.user.data.UserRegistrationData("uuid-admin");
		registerUser4.setEmail(this.templateStringValue("annette.pohl@anfelisa.de", 4));
		registerUser4.setLanguage(this.templateStringValue("de", 4));
		registerUser4.setPassword(this.templateStringValue("admin-password", 4));
		registerUser4.setUsername(this.templateStringValue("Admin", 4));
		registerUser4.setToken(this.templateStringValue("ADMIN-TOKEN", 4));
		
		
		com.anfelisa.user.ActionCalls.callRegisterUser(registerUser4, DROPWIZARD.getLocalPort());
		

		com.anfelisa.box.data.BoxCreationData createBox5 = new com.anfelisa.box.data.BoxCreationData("adminBox");
		createBox5.setCategoryName(this.templateStringValue("adminBox", 5));
		createBox5.setDictionaryLookup(new Boolean("false"));
		createBox5.setMaxCardsPerDay(10);
		
		
		com.anfelisa.box.ActionCalls.callCreateBox(createBox5, DROPWIZARD.getLocalPort(), authorization("Admin", "admin-password"));
		

		com.anfelisa.category.data.CategoryCreationData createCategory6 = new com.anfelisa.category.data.CategoryCreationData("adminCat");
		createCategory6.setCategoryName(this.templateStringValue("c", 6));
		createCategory6.setParentCategoryId(this.templateStringValue("adminBox", 6));
		
		
		com.anfelisa.category.ActionCalls.callCreateCategory(createCategory6, DROPWIZARD.getLocalPort(), authorization("Admin", "admin-password"));
		

		com.anfelisa.card.data.CardCreationData createCard7 = new com.anfelisa.card.data.CardCreationData("c6");
		createCard7.setCategoryId(this.templateStringValue("adminCat", 7));
		createCard7.setGiven(this.templateStringValue("given", 7));
		createCard7.setImage(this.templateStringValue("image", 7));
		createCard7.setWanted(this.templateStringValue("wanted", 7));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard7, DROPWIZARD.getLocalPort(), authorization("Admin", "admin-password"));
		

	}
	
	private Response when() throws Exception {
		com.anfelisa.card.data.ChangeCardOrderListData changeOrder0 = new com.anfelisa.card.data.ChangeCardOrderListData(randomUUID());
		changeOrder0.setCardId(this.templateStringValue("c1", 0));
		
			List<String> changeOrder0CardIdList = new ArrayList<String>();
			changeOrder0CardIdList.add("c6");
		
			
		changeOrder0.setCardIdList(changeOrder0CardIdList);
		
		
		return 
		com.anfelisa.card.ActionCalls.callChangeOrder(changeOrder0, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
	}
	
	private void then(Response response) throws Exception {
		assertThat(response.getStatus(), 401);
		
			
				}
				
				@Test
				public void changeOrderNoAccessToMovedCard() throws Exception {
					given();
					
					Response response = when();
			
					then(response);
					
					verifications();
			}
			
			protected abstract void verifications();
			
			}
			
			
			
			
			/******* S.D.G. *******/
			
			
			

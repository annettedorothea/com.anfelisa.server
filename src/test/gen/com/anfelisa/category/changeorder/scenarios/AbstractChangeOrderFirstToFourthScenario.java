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




package com.anfelisa.category.changeorder.scenarios;

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
public abstract class AbstractChangeOrderFirstToFourthScenario extends BaseScenario {

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
		

		com.anfelisa.category.data.CategoryCreationData createCategory3 = new com.anfelisa.category.data.CategoryCreationData("cat2");
		createCategory3.setCategoryName(this.templateStringValue("level 1 #2", 3));
		createCategory3.setParentCategoryId(this.templateStringValue("boxId", 3));
		
		
		com.anfelisa.category.ActionCalls.callCreateCategory(createCategory3, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		com.anfelisa.category.data.CategoryCreationData createCategory4 = new com.anfelisa.category.data.CategoryCreationData("cat3");
		createCategory4.setCategoryName(this.templateStringValue("level 1 #3", 4));
		createCategory4.setParentCategoryId(this.templateStringValue("boxId", 4));
		
		
		com.anfelisa.category.ActionCalls.callCreateCategory(createCategory4, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		com.anfelisa.category.data.CategoryCreationData createCategory5 = new com.anfelisa.category.data.CategoryCreationData("cat4");
		createCategory5.setCategoryName(this.templateStringValue("level 1 #4", 5));
		createCategory5.setParentCategoryId(this.templateStringValue("boxId", 5));
		
		
		com.anfelisa.category.ActionCalls.callCreateCategory(createCategory5, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

	}
	
	private Response when() throws Exception {
		com.anfelisa.category.data.CategoryChangeOrderData changeOrderCategory0 = new com.anfelisa.category.data.CategoryChangeOrderData(randomUUID());
		changeOrderCategory0.setMovedCategoryId(this.templateStringValue("cat1", 0));
		changeOrderCategory0.setTargetCategoryId(this.templateStringValue("cat4", 0));
		
		
		return 
		com.anfelisa.category.ActionCalls.callChangeOrderCategory(changeOrderCategory0, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
	}
	
	private void then(Response response) throws Exception {
		assertThat(response.getStatus(), 200);
		
			
				}
				
				@Test
				public void changeOrderFirstToFourth() throws Exception {
					given();
					
					Response response = when();
			
					then(response);
					
					verifications();
			}
			
			protected abstract void verifications();
			
			}
			
			
			
			
			/******* S.D.G. *******/
			
			
			

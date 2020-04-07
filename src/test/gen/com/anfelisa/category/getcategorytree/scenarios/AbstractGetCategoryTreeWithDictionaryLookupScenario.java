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




package com.anfelisa.category.getcategorytree.scenarios;

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
public abstract class AbstractGetCategoryTreeWithDictionaryLookupScenario extends BaseScenario {

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
		createBox1.setMaxCardsPerDay(10);
		createBox1.setDictionaryLookup(new Boolean("true"));
		createBox1.setGivenLanguage(this.templateStringValue("de", 1));
		createBox1.setWantedLanguage(this.templateStringValue("en", 1));
		
		
		com.anfelisa.box.ActionCalls.callCreateBox(createBox1, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		com.anfelisa.category.data.CategoryCreationData createCategory2 = new com.anfelisa.category.data.CategoryCreationData("dict");
		createCategory2.setCategoryName(this.templateStringValue("dict", 2));
		createCategory2.setParentCategoryId(this.templateStringValue("boxId", 2));
		
		
		com.anfelisa.category.ActionCalls.callCreateCategory(createCategory2, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

	}
	
	private Response when() throws Exception {
		com.anfelisa.category.data.CategoryTreeData getCategoryTree0 = new com.anfelisa.category.data.CategoryTreeData(randomUUID());
		getCategoryTree0.setRootCategoryId(this.templateStringValue("boxId", 0));
		
		
		return 
		com.anfelisa.category.ActionCalls.callGetCategoryTree(getCategoryTree0, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
	}
	
	private com.anfelisa.category.data.GetCategoryTreeResponse then(Response response) throws Exception {
		assertThat(response.getStatus(), 200);
		
		com.anfelisa.category.data.GetCategoryTreeResponse actual = null;
		try {
			actual = response.readEntity(com.anfelisa.category.data.GetCategoryTreeResponse.class);
		} catch (Exception x) {
		}
		com.anfelisa.category.data.CategoryTreeData expectedData = new com.anfelisa.category.data.CategoryTreeData(randomUUID());
		
			com.anfelisa.category.models.ICategoryTreeItemModel expectedDataRootCategory = new com.anfelisa.category.models.CategoryTreeItemModel();
			expectedDataRootCategory.setCategoryId(this.templateStringValue("boxId", null));
			expectedDataRootCategory.setCategoryIndex(1);
			expectedDataRootCategory.setCategoryName(this.templateStringValue("cat", null));
			expectedDataRootCategory.setDictionaryLookup(new Boolean("true"));
			expectedDataRootCategory.setGivenLanguage(this.templateStringValue("de", null));
			expectedDataRootCategory.setWantedLanguage(this.templateStringValue("en", null));
			expectedDataRootCategory.setEmpty(new Boolean("false"));
			expectedDataRootCategory.setRootCategoryId(this.templateStringValue("boxId", null));
			
				List<com.anfelisa.category.models.ICategoryTreeItemModel> list1 = new ArrayList<com.anfelisa.category.models.ICategoryTreeItemModel>();
				com.anfelisa.category.models.ICategoryTreeItemModel item2 = new com.anfelisa.category.models.CategoryTreeItemModel();
				item2.setCategoryId(this.templateStringValue("dict", null));
				item2.setCategoryIndex(1);
				item2.setCategoryName(this.templateStringValue("dict", null));
				item2.setDictionaryLookup(new Boolean("true"));
				item2.setGivenLanguage(this.templateStringValue("de", null));
				item2.setWantedLanguage(this.templateStringValue("en", null));
				item2.setEmpty(new Boolean("true"));
				item2.setParentCategoryId(this.templateStringValue("boxId", null));
				item2.setRootCategoryId(this.templateStringValue("boxId", null));
				
					List<com.anfelisa.category.models.ICategoryTreeItemModel> list3 = new ArrayList<com.anfelisa.category.models.ICategoryTreeItemModel>();
					
				item2.setChildCategories(list3);
				list1.add(item2);
			
				
			expectedDataRootCategory.setChildCategories(list1);
			
		expectedData.setRootCategory(expectedDataRootCategory);
		
		
		com.anfelisa.category.data.GetCategoryTreeResponse expected = new com.anfelisa.category.data.GetCategoryTreeResponse(expectedData);


		assertThat(actual, expected);
			
			return actual;
				}
				
				@Test
				public void getCategoryTreeWithDictionaryLookup() throws Exception {
					given();
					
					Response response = when();
			
					com.anfelisa.category.data.GetCategoryTreeResponse actualResponse = then(response);
					
					verifications(actualResponse);
			}
			
			protected abstract void verifications(com.anfelisa.category.data.GetCategoryTreeResponse response);
			
			}
			
			
			
			
			/******* S.D.G. *******/
			
			
			

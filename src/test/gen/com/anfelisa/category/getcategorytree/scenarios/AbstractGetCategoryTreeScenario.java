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
import java.util.List;

import javax.ws.rs.core.Response;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import org.junit.Test;

import de.acegen.BaseScenario;
import de.acegen.ITimelineItem;
import de.acegen.NotReplayableDataProvider;

@SuppressWarnings("unused")
public abstract class AbstractGetCategoryTreeScenario extends BaseScenario {

	private void given() throws Exception {
		NotReplayableDataProvider.put("token", this.templateStringValue("TOKEN", null));
		com.anfelisa.user.ActionCalls.callRegisterUser("uuid", this.templateStringValue("password", 0), this.templateStringValue("Annette", 0), this.templateStringValue("annette.pohl@anfelisa.de", 0), this.templateStringValue("de", 0), DROPWIZARD.getLocalPort());

		com.anfelisa.box.ActionCalls.callCreateBox("boxId", this.templateStringValue("cat", 1), new Boolean("false"), null, null, 10, null, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.category.ActionCalls.callCreateCategory("cat1", this.templateStringValue("level 1 #1", 2), this.templateStringValue("boxId", 2), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.category.ActionCalls.callCreateCategory("cat2", this.templateStringValue("level 1 #2", 3), this.templateStringValue("boxId", 3), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.category.ActionCalls.callCreateCategory("cat3", this.templateStringValue("level 2 #1", 4), this.templateStringValue("cat2", 4), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

	}
	
	private Response when() throws Exception {
		return com.anfelisa.category.ActionCalls.callGetCategoryTree(randomUUID(), this.templateStringValue("boxId", 0), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
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
			expectedDataRootCategory.setDictionaryLookup(new Boolean("false"));
			expectedDataRootCategory.setEmpty(new Boolean("false"));
			expectedDataRootCategory.setRootCategoryId(this.templateStringValue("boxId", null));
			
				List<com.anfelisa.category.models.ICategoryTreeItemModel> list1 = new ArrayList<com.anfelisa.category.models.ICategoryTreeItemModel>();
				com.anfelisa.category.models.ICategoryTreeItemModel item2 = new com.anfelisa.category.models.CategoryTreeItemModel();
				item2.setCategoryId(this.templateStringValue("cat1", null));
				item2.setCategoryIndex(1);
				item2.setCategoryName(this.templateStringValue("level 1 #1", null));
				item2.setDictionaryLookup(new Boolean("false"));
				item2.setEmpty(new Boolean("true"));
				item2.setParentCategoryId(this.templateStringValue("boxId", null));
				item2.setRootCategoryId(this.templateStringValue("boxId", null));
				
					List<com.anfelisa.category.models.ICategoryTreeItemModel> list3 = new ArrayList<com.anfelisa.category.models.ICategoryTreeItemModel>();
					
				item2.setChildCategories(list3);
				list1.add(item2);
			
				com.anfelisa.category.models.ICategoryTreeItemModel item4 = new com.anfelisa.category.models.CategoryTreeItemModel();
				item4.setCategoryId(this.templateStringValue("cat2", null));
				item4.setCategoryIndex(2);
				item4.setCategoryName(this.templateStringValue("level 1 #2", null));
				item4.setDictionaryLookup(new Boolean("false"));
				item4.setEmpty(new Boolean("false"));
				item4.setParentCategoryId(this.templateStringValue("boxId", null));
				item4.setRootCategoryId(this.templateStringValue("boxId", null));
				
					List<com.anfelisa.category.models.ICategoryTreeItemModel> list5 = new ArrayList<com.anfelisa.category.models.ICategoryTreeItemModel>();
					com.anfelisa.category.models.ICategoryTreeItemModel item6 = new com.anfelisa.category.models.CategoryTreeItemModel();
					item6.setCategoryId(this.templateStringValue("cat3", null));
					item6.setCategoryIndex(1);
					item6.setCategoryName(this.templateStringValue("level 2 #1", null));
					item6.setDictionaryLookup(new Boolean("false"));
					item6.setEmpty(new Boolean("true"));
					item6.setParentCategoryId(this.templateStringValue("cat2", null));
					item6.setRootCategoryId(this.templateStringValue("boxId", null));
					
						List<com.anfelisa.category.models.ICategoryTreeItemModel> list7 = new ArrayList<com.anfelisa.category.models.ICategoryTreeItemModel>();
						
					item6.setChildCategories(list7);
					list5.add(item6);
				
					
				item4.setChildCategories(list5);
				list1.add(item4);
			
				
			expectedDataRootCategory.setChildCategories(list1);
			
		expectedData.setRootCategory(expectedDataRootCategory);
		
		com.anfelisa.category.data.GetCategoryTreeResponse expected = new com.anfelisa.category.data.GetCategoryTreeResponse(expectedData);


		assertThat(actual, expected);
			
			return actual;
				}
				
				@Test
				public void getCategoryTree() throws Exception {
					given();
					
					Response response = when();
			
					com.anfelisa.category.data.GetCategoryTreeResponse actualResponse = then(response);
					
					verifications(actualResponse);
			}
			
			protected abstract void verifications(com.anfelisa.category.data.GetCategoryTreeResponse response);
			
			}
			
			
			
			
			/******* S.D.G. *******/
			
			
			

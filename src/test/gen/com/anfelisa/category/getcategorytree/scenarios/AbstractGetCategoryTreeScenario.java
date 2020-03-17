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

import com.anfelisa.ace.BaseScenario;
import com.anfelisa.ace.ITimelineItem;
import com.anfelisa.ace.NotReplayableDataProvider;

@SuppressWarnings("unused")
public abstract class AbstractGetCategoryTreeScenario extends BaseScenario {

	private void given() throws Exception {
		NotReplayableDataProvider.put("token", "TOKEN");
		com.anfelisa.user.ActionCalls.callRegisterUser("uuid", "password", "Annette", "annette.pohl@anfelisa.de", "de", DROPWIZARD.getLocalPort());

		com.anfelisa.box.ActionCalls.callCreateBox("boxId", "cat", new Boolean("false"), null, null, 10, null, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.category.ActionCalls.callCreateCategory("cat1", "level 1 #1", "boxId", DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.category.ActionCalls.callCreateCategory("cat2", "level 1 #2", "boxId", DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.category.ActionCalls.callCreateCategory("cat3", "level 2 #1", "cat2", DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

	}
	
	private Response when() throws Exception {
		return com.anfelisa.category.ActionCalls.callGetCategoryTree(randomUUID(), "boxId", DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
	}
	
	private void then(Response response) throws Exception {
		assertThat(response.getStatus(), 200);
		
		com.anfelisa.category.data.CategoryTreeData expectedData = new com.anfelisa.category.data.CategoryTreeData(randomUUID());
		
			com.anfelisa.category.models.ICategoryTreeItemModel expectedDataRootCategory = new com.anfelisa.category.models.CategoryTreeItemModel();
			expectedDataRootCategory.setCategoryId("boxId");
			expectedDataRootCategory.setCategoryIndex(1);
			expectedDataRootCategory.setCategoryName("cat");
			expectedDataRootCategory.setDictionaryLookup(new Boolean("false"));
			expectedDataRootCategory.setEmpty(new Boolean("false"));
			expectedDataRootCategory.setRootCategoryId("boxId");
			
				List<com.anfelisa.category.models.ICategoryTreeItemModel> list1 = new ArrayList<com.anfelisa.category.models.ICategoryTreeItemModel>();
				com.anfelisa.category.models.ICategoryTreeItemModel item2 = new com.anfelisa.category.models.CategoryTreeItemModel();
				item2.setCategoryId("cat1");
				item2.setCategoryIndex(1);
				item2.setCategoryName("level 1 #1");
				item2.setDictionaryLookup(new Boolean("false"));
				item2.setEmpty(new Boolean("true"));
				item2.setParentCategoryId("boxId");
				item2.setRootCategoryId("boxId");
				
					List<com.anfelisa.category.models.ICategoryTreeItemModel> list3 = new ArrayList<com.anfelisa.category.models.ICategoryTreeItemModel>();
					
				item2.setChildCategories(list3);
				list1.add(item2);
			
				com.anfelisa.category.models.ICategoryTreeItemModel item4 = new com.anfelisa.category.models.CategoryTreeItemModel();
				item4.setCategoryId("cat2");
				item4.setCategoryIndex(2);
				item4.setCategoryName("level 1 #2");
				item4.setDictionaryLookup(new Boolean("false"));
				item4.setEmpty(new Boolean("false"));
				item4.setParentCategoryId("boxId");
				item4.setRootCategoryId("boxId");
				
					List<com.anfelisa.category.models.ICategoryTreeItemModel> list5 = new ArrayList<com.anfelisa.category.models.ICategoryTreeItemModel>();
					com.anfelisa.category.models.ICategoryTreeItemModel item6 = new com.anfelisa.category.models.CategoryTreeItemModel();
					item6.setCategoryId("cat3");
					item6.setCategoryIndex(1);
					item6.setCategoryName("level 2 #1");
					item6.setDictionaryLookup(new Boolean("false"));
					item6.setEmpty(new Boolean("true"));
					item6.setParentCategoryId("cat2");
					item6.setRootCategoryId("boxId");
					
						List<com.anfelisa.category.models.ICategoryTreeItemModel> list7 = new ArrayList<com.anfelisa.category.models.ICategoryTreeItemModel>();
						
					item6.setChildCategories(list7);
					list5.add(item6);
				
					
				item4.setChildCategories(list5);
				list1.add(item4);
			
				
			expectedDataRootCategory.setChildCategories(list1);
			
		expectedData.setRootCategory(expectedDataRootCategory);
		
		com.anfelisa.category.data.GetCategoryTreeResponse expected = new com.anfelisa.category.data.GetCategoryTreeResponse(expectedData);

		com.anfelisa.category.data.GetCategoryTreeResponse actual = response.readEntity(com.anfelisa.category.data.GetCategoryTreeResponse.class);

		assertThat(actual, expected);
		
	}
	
	@Test
	public void getCategoryTree() throws Exception {
		given();
		
		Response response = when();

		then(response);
		
		verifications(response);
	}
	
	protected abstract void verifications(Response response);

}




/******* S.D.G. *******/




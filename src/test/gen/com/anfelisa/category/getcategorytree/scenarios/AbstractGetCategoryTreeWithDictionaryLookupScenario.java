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
public abstract class AbstractGetCategoryTreeWithDictionaryLookupScenario extends BaseScenario {

	private void given() throws Exception {
		NotReplayableDataProvider.put("token", "TOKEN");
		com.anfelisa.user.ActionCalls.callRegisterUser("uuid", "password", "Annette", "annette.pohl@anfelisa.de", "de", DROPWIZARD.getLocalPort());

		com.anfelisa.box.ActionCalls.callCreateBox("boxId", "cat", new Boolean("true"), "de", "en", 10, null, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.category.ActionCalls.callCreateCategory("dict", "dict", "boxId", DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

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
			expectedDataRootCategory.setDictionaryLookup(new Boolean("true"));
			expectedDataRootCategory.setGivenLanguage("de");
			expectedDataRootCategory.setWantedLanguage("en");
			expectedDataRootCategory.setEmpty(new Boolean("false"));
			expectedDataRootCategory.setRootCategoryId("boxId");
			
				List<com.anfelisa.category.models.ICategoryTreeItemModel> list1 = new ArrayList<com.anfelisa.category.models.ICategoryTreeItemModel>();
				com.anfelisa.category.models.ICategoryTreeItemModel item2 = new com.anfelisa.category.models.CategoryTreeItemModel();
				item2.setCategoryId("dict");
				item2.setCategoryIndex(1);
				item2.setCategoryName("dict");
				item2.setDictionaryLookup(new Boolean("true"));
				item2.setGivenLanguage("de");
				item2.setWantedLanguage("en");
				item2.setEmpty(new Boolean("true"));
				item2.setParentCategoryId("boxId");
				item2.setRootCategoryId("boxId");
				
					List<com.anfelisa.category.models.ICategoryTreeItemModel> list3 = new ArrayList<com.anfelisa.category.models.ICategoryTreeItemModel>();
					
				item2.setChildCategories(list3);
				list1.add(item2);
			
				
			expectedDataRootCategory.setChildCategories(list1);
			
		expectedData.setRootCategory(expectedDataRootCategory);
		
		com.anfelisa.category.data.GetCategoryTreeResponse expected = new com.anfelisa.category.data.GetCategoryTreeResponse(expectedData);

		com.anfelisa.category.data.GetCategoryTreeResponse actual = response.readEntity(com.anfelisa.category.data.GetCategoryTreeResponse.class);

		assertThat(actual, expected);
		
	}
	
	@Test
	public void getCategoryTreeWithDictionaryLookup() throws Exception {
		given();
		
		Response response = when();

		then(response);
		
		verifications(response);
	}
	
	protected abstract void verifications(Response response);

}




/******* S.D.G. *******/




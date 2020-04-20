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
public abstract class AbstractGetCategoryTreeNoAccessScenario extends BaseScenario {

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
		

		NotReplayableDataProvider.put("token", this.templateStringValue("ADMIN-TOKEN", null));
		com.anfelisa.user.data.UserRegistrationData registerUser3 = new com.anfelisa.user.data.UserRegistrationData("uuid-admin");
		registerUser3.setEmail(this.templateStringValue("annette.pohl@anfelisa.de", 3));
		registerUser3.setLanguage(this.templateStringValue("de", 3));
		registerUser3.setPassword(this.templateStringValue("admin-password", 3));
		registerUser3.setUsername(this.templateStringValue("Admin", 3));
		registerUser3.setToken(this.templateStringValue("ADMIN-TOKEN", 3));
		
		
		com.anfelisa.user.ActionCalls.callRegisterUser(registerUser3, DROPWIZARD.getLocalPort());
		

	}
	
	private Response when() throws Exception {
		com.anfelisa.category.data.CategoryTreeData getCategoryTree0 = new com.anfelisa.category.data.CategoryTreeData(randomUUID());
		getCategoryTree0.setRootCategoryId(this.templateStringValue("boxId", 0));
		
		
		return 
		com.anfelisa.category.ActionCalls.callGetCategoryTree(getCategoryTree0, DROPWIZARD.getLocalPort(), authorization("Admin", "admin-password"));
		
	}
	
	private com.anfelisa.category.data.GetCategoryTreeResponse then(Response response) throws Exception {
		assertThat(response.getStatus(), 401);
		
		com.anfelisa.category.data.GetCategoryTreeResponse actual = null;
		try {
			actual = response.readEntity(com.anfelisa.category.data.GetCategoryTreeResponse.class);
		} catch (Exception x) {
		}
			
			return actual;
				}
				
				@Test
				public void getCategoryTreeNoAccess() throws Exception {
					given();
					
					Response response = when();
			
					com.anfelisa.category.data.GetCategoryTreeResponse actualResponse = then(response);
					
					verifications(actualResponse);
			}
			
			protected abstract void verifications(com.anfelisa.category.data.GetCategoryTreeResponse response);
			
			}
			
			
			
			
			/******* S.D.G. *******/
			
			
			

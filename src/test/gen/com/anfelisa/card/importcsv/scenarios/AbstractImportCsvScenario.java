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




package com.anfelisa.card.importcsv.scenarios;

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
public abstract class AbstractImportCsvScenario extends BaseScenario {

	private void given() throws Exception {
		NotReplayableDataProvider.put("token", this.templateStringValue("TOKEN", null));
		com.anfelisa.user.data.UserRegistrationData registerUser0 = new com.anfelisa.user.data.UserRegistrationData("uuid");
		registerUser0.setEmail(this.templateStringValue("annette.pohl@anfelisa.de", null));
		registerUser0.setLanguage(this.templateStringValue("de", null));
		registerUser0.setPassword(this.templateStringValue("password", null));
		registerUser0.setUsername(this.templateStringValue("Annette", null));
		registerUser0.setToken(this.templateStringValue("TOKEN", null));
		
		com.anfelisa.user.ActionCalls.callRegisterUser(registerUser0, DROPWIZARD.getLocalPort());

		com.anfelisa.box.data.BoxCreationData createBox1 = new com.anfelisa.box.data.BoxCreationData("boxId");
		createBox1.setCategoryName(this.templateStringValue("cat", null));
		createBox1.setDictionaryLookup(new Boolean("false"));
		createBox1.setMaxCardsPerDay(10);
		
		com.anfelisa.box.ActionCalls.callCreateBox(createBox1, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.category.data.CategoryCreationData createCategory2 = new com.anfelisa.category.data.CategoryCreationData("cat1");
		createCategory2.setCategoryName(this.templateStringValue("level 1 #1", null));
		createCategory2.setParentCategoryId(this.templateStringValue("boxId", null));
		
		com.anfelisa.category.ActionCalls.callCreateCategory(createCategory2, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

	}
	
	private Response when() throws Exception {
		com.anfelisa.card.data.CsvUploadData importCsv0 = new com.anfelisa.card.data.CsvUploadData("c1");
		importCsv0.setCategoryId(this.templateStringValue("cat1", null));
		
			List<com.anfelisa.card.models.ISimpleCardModel> importCsv0PreviewCsv = new ArrayList<com.anfelisa.card.models.ISimpleCardModel>();
			com.anfelisa.card.models.ISimpleCardModel item1 = new com.anfelisa.card.models.SimpleCardModel();
			item1.setGiven(this.templateStringValue("g1", null));
			item1.setWanted(this.templateStringValue("w1", null));
			item1.setId(this.templateStringValue("1", null));
			importCsv0PreviewCsv.add(item1);
		
			com.anfelisa.card.models.ISimpleCardModel item2 = new com.anfelisa.card.models.SimpleCardModel();
			item2.setGiven(this.templateStringValue("g2", null));
			item2.setWanted(this.templateStringValue("w2", null));
			item2.setId(this.templateStringValue("2", null));
			importCsv0PreviewCsv.add(item2);
		
			com.anfelisa.card.models.ISimpleCardModel item3 = new com.anfelisa.card.models.SimpleCardModel();
			item3.setGiven(this.templateStringValue("g3", null));
			item3.setWanted(this.templateStringValue("w3", null));
			item3.setId(this.templateStringValue("3", null));
			importCsv0PreviewCsv.add(item3);
		
			
		importCsv0.setPreviewCsv(importCsv0PreviewCsv);
		
		return 
		com.anfelisa.card.ActionCalls.callImportCsv(importCsv0, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
	}
	
	private void then(Response response) throws Exception {
		assertThat(response.getStatus(), 200);
		
			
				}
				
				@Test
				public void importCsv() throws Exception {
					given();
					
					Response response = when();
			
					then(response);
					
					verifications();
			}
			
			protected abstract void verifications();
			
			}
			
			
			
			
			/******* S.D.G. *******/
			
			
			

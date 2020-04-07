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
public abstract class AbstractGetDuplicatesLimitScenario extends BaseScenario {

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
		createBox1.setMaxCardsPerDay(10);
		
		
		com.anfelisa.box.ActionCalls.callCreateBox(createBox1, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		com.anfelisa.category.data.CategoryCreationData createCategory2 = new com.anfelisa.category.data.CategoryCreationData("cat1");
		createCategory2.setCategoryName(this.templateStringValue("level 1 #1", 2));
		createCategory2.setParentCategoryId(this.templateStringValue("boxId", 2));
		
		
		com.anfelisa.category.ActionCalls.callCreateCategory(createCategory2, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		

		com.anfelisa.card.data.CardCreationData createCard3 = new com.anfelisa.card.data.CardCreationData(randomUUID());
		createCard3.setCategoryId(this.templateStringValue("cat1", 3));
		createCard3.setGiven(this.templateStringValue("${index}given${random}", 3));
		createCard3.setWanted(this.templateStringValue("${index}wanted${random}", 3));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard3, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		com.anfelisa.card.data.CardCreationData createCard4 = new com.anfelisa.card.data.CardCreationData(randomUUID());
		createCard4.setCategoryId(this.templateStringValue("cat1", 4));
		createCard4.setGiven(this.templateStringValue("${index}given${random}", 4));
		createCard4.setWanted(this.templateStringValue("${index}wanted${random}", 4));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard4, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		com.anfelisa.card.data.CardCreationData createCard5 = new com.anfelisa.card.data.CardCreationData(randomUUID());
		createCard5.setCategoryId(this.templateStringValue("cat1", 5));
		createCard5.setGiven(this.templateStringValue("${index}given${random}", 5));
		createCard5.setWanted(this.templateStringValue("${index}wanted${random}", 5));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard5, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		com.anfelisa.card.data.CardCreationData createCard6 = new com.anfelisa.card.data.CardCreationData(randomUUID());
		createCard6.setCategoryId(this.templateStringValue("cat1", 6));
		createCard6.setGiven(this.templateStringValue("${index}given${random}", 6));
		createCard6.setWanted(this.templateStringValue("${index}wanted${random}", 6));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard6, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		com.anfelisa.card.data.CardCreationData createCard7 = new com.anfelisa.card.data.CardCreationData(randomUUID());
		createCard7.setCategoryId(this.templateStringValue("cat1", 7));
		createCard7.setGiven(this.templateStringValue("${index}given${random}", 7));
		createCard7.setWanted(this.templateStringValue("${index}wanted${random}", 7));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard7, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		com.anfelisa.card.data.CardCreationData createCard8 = new com.anfelisa.card.data.CardCreationData(randomUUID());
		createCard8.setCategoryId(this.templateStringValue("cat1", 8));
		createCard8.setGiven(this.templateStringValue("${index}given${random}", 8));
		createCard8.setWanted(this.templateStringValue("${index}wanted${random}", 8));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard8, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		com.anfelisa.card.data.CardCreationData createCard9 = new com.anfelisa.card.data.CardCreationData(randomUUID());
		createCard9.setCategoryId(this.templateStringValue("cat1", 9));
		createCard9.setGiven(this.templateStringValue("${index}given${random}", 9));
		createCard9.setWanted(this.templateStringValue("${index}wanted${random}", 9));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard9, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		com.anfelisa.card.data.CardCreationData createCard10 = new com.anfelisa.card.data.CardCreationData(randomUUID());
		createCard10.setCategoryId(this.templateStringValue("cat1", 10));
		createCard10.setGiven(this.templateStringValue("${index}given${random}", 10));
		createCard10.setWanted(this.templateStringValue("${index}wanted${random}", 10));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard10, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		com.anfelisa.card.data.CardCreationData createCard11 = new com.anfelisa.card.data.CardCreationData(randomUUID());
		createCard11.setCategoryId(this.templateStringValue("cat1", 11));
		createCard11.setGiven(this.templateStringValue("${index}given${random}", 11));
		createCard11.setWanted(this.templateStringValue("${index}wanted${random}", 11));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard11, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		com.anfelisa.card.data.CardCreationData createCard12 = new com.anfelisa.card.data.CardCreationData(randomUUID());
		createCard12.setCategoryId(this.templateStringValue("cat1", 12));
		createCard12.setGiven(this.templateStringValue("${index}given${random}", 12));
		createCard12.setWanted(this.templateStringValue("${index}wanted${random}", 12));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard12, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		com.anfelisa.card.data.CardCreationData createCard13 = new com.anfelisa.card.data.CardCreationData(randomUUID());
		createCard13.setCategoryId(this.templateStringValue("cat1", 13));
		createCard13.setGiven(this.templateStringValue("${index}given${random}", 13));
		createCard13.setWanted(this.templateStringValue("${index}wanted${random}", 13));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard13, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		com.anfelisa.card.data.CardCreationData createCard14 = new com.anfelisa.card.data.CardCreationData(randomUUID());
		createCard14.setCategoryId(this.templateStringValue("cat1", 14));
		createCard14.setGiven(this.templateStringValue("${index}given${random}", 14));
		createCard14.setWanted(this.templateStringValue("${index}wanted${random}", 14));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard14, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		com.anfelisa.card.data.CardCreationData createCard15 = new com.anfelisa.card.data.CardCreationData(randomUUID());
		createCard15.setCategoryId(this.templateStringValue("cat1", 15));
		createCard15.setGiven(this.templateStringValue("${index}given${random}", 15));
		createCard15.setWanted(this.templateStringValue("${index}wanted${random}", 15));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard15, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		com.anfelisa.card.data.CardCreationData createCard16 = new com.anfelisa.card.data.CardCreationData(randomUUID());
		createCard16.setCategoryId(this.templateStringValue("cat1", 16));
		createCard16.setGiven(this.templateStringValue("${index}given${random}", 16));
		createCard16.setWanted(this.templateStringValue("${index}wanted${random}", 16));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard16, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		com.anfelisa.card.data.CardCreationData createCard17 = new com.anfelisa.card.data.CardCreationData(randomUUID());
		createCard17.setCategoryId(this.templateStringValue("cat1", 17));
		createCard17.setGiven(this.templateStringValue("${index}given${random}", 17));
		createCard17.setWanted(this.templateStringValue("${index}wanted${random}", 17));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard17, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		com.anfelisa.card.data.CardCreationData createCard18 = new com.anfelisa.card.data.CardCreationData(randomUUID());
		createCard18.setCategoryId(this.templateStringValue("cat1", 18));
		createCard18.setGiven(this.templateStringValue("${index}given${random}", 18));
		createCard18.setWanted(this.templateStringValue("${index}wanted${random}", 18));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard18, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		com.anfelisa.card.data.CardCreationData createCard19 = new com.anfelisa.card.data.CardCreationData(randomUUID());
		createCard19.setCategoryId(this.templateStringValue("cat1", 19));
		createCard19.setGiven(this.templateStringValue("${index}given${random}", 19));
		createCard19.setWanted(this.templateStringValue("${index}wanted${random}", 19));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard19, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		com.anfelisa.card.data.CardCreationData createCard20 = new com.anfelisa.card.data.CardCreationData(randomUUID());
		createCard20.setCategoryId(this.templateStringValue("cat1", 20));
		createCard20.setGiven(this.templateStringValue("${index}given${random}", 20));
		createCard20.setWanted(this.templateStringValue("${index}wanted${random}", 20));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard20, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		com.anfelisa.card.data.CardCreationData createCard21 = new com.anfelisa.card.data.CardCreationData(randomUUID());
		createCard21.setCategoryId(this.templateStringValue("cat1", 21));
		createCard21.setGiven(this.templateStringValue("${index}given${random}", 21));
		createCard21.setWanted(this.templateStringValue("${index}wanted${random}", 21));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard21, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		com.anfelisa.card.data.CardCreationData createCard22 = new com.anfelisa.card.data.CardCreationData(randomUUID());
		createCard22.setCategoryId(this.templateStringValue("cat1", 22));
		createCard22.setGiven(this.templateStringValue("${index}given${random}", 22));
		createCard22.setWanted(this.templateStringValue("${index}wanted${random}", 22));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard22, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		com.anfelisa.card.data.CardCreationData createCard23 = new com.anfelisa.card.data.CardCreationData(randomUUID());
		createCard23.setCategoryId(this.templateStringValue("cat1", 23));
		createCard23.setGiven(this.templateStringValue("${index}given${random}", 23));
		createCard23.setWanted(this.templateStringValue("${index}wanted${random}", 23));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard23, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		com.anfelisa.card.data.CardCreationData createCard24 = new com.anfelisa.card.data.CardCreationData(randomUUID());
		createCard24.setCategoryId(this.templateStringValue("cat1", 24));
		createCard24.setGiven(this.templateStringValue("${index}given${random}", 24));
		createCard24.setWanted(this.templateStringValue("${index}wanted${random}", 24));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard24, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		com.anfelisa.card.data.CardCreationData createCard25 = new com.anfelisa.card.data.CardCreationData(randomUUID());
		createCard25.setCategoryId(this.templateStringValue("cat1", 25));
		createCard25.setGiven(this.templateStringValue("${index}given${random}", 25));
		createCard25.setWanted(this.templateStringValue("${index}wanted${random}", 25));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard25, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		com.anfelisa.card.data.CardCreationData createCard26 = new com.anfelisa.card.data.CardCreationData(randomUUID());
		createCard26.setCategoryId(this.templateStringValue("cat1", 26));
		createCard26.setGiven(this.templateStringValue("${index}given${random}", 26));
		createCard26.setWanted(this.templateStringValue("${index}wanted${random}", 26));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard26, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		com.anfelisa.card.data.CardCreationData createCard27 = new com.anfelisa.card.data.CardCreationData(randomUUID());
		createCard27.setCategoryId(this.templateStringValue("cat1", 27));
		createCard27.setGiven(this.templateStringValue("${index}given${random}", 27));
		createCard27.setWanted(this.templateStringValue("${index}wanted${random}", 27));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard27, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		com.anfelisa.card.data.CardCreationData createCard28 = new com.anfelisa.card.data.CardCreationData(randomUUID());
		createCard28.setCategoryId(this.templateStringValue("cat1", 28));
		createCard28.setGiven(this.templateStringValue("${index}given${random}", 28));
		createCard28.setWanted(this.templateStringValue("${index}wanted${random}", 28));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard28, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		com.anfelisa.card.data.CardCreationData createCard29 = new com.anfelisa.card.data.CardCreationData(randomUUID());
		createCard29.setCategoryId(this.templateStringValue("cat1", 29));
		createCard29.setGiven(this.templateStringValue("${index}given${random}", 29));
		createCard29.setWanted(this.templateStringValue("${index}wanted${random}", 29));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard29, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		com.anfelisa.card.data.CardCreationData createCard30 = new com.anfelisa.card.data.CardCreationData(randomUUID());
		createCard30.setCategoryId(this.templateStringValue("cat1", 30));
		createCard30.setGiven(this.templateStringValue("${index}given${random}", 30));
		createCard30.setWanted(this.templateStringValue("${index}wanted${random}", 30));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard30, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		com.anfelisa.card.data.CardCreationData createCard31 = new com.anfelisa.card.data.CardCreationData(randomUUID());
		createCard31.setCategoryId(this.templateStringValue("cat1", 31));
		createCard31.setGiven(this.templateStringValue("${index}given${random}", 31));
		createCard31.setWanted(this.templateStringValue("${index}wanted${random}", 31));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard31, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		
		com.anfelisa.card.data.CardCreationData createCard32 = new com.anfelisa.card.data.CardCreationData(randomUUID());
		createCard32.setCategoryId(this.templateStringValue("cat1", 32));
		createCard32.setGiven(this.templateStringValue("${index}given${random}", 32));
		createCard32.setWanted(this.templateStringValue("${index}wanted${random}", 32));
		
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard32, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		
		

	}
	
	private Response when() throws Exception {
		com.anfelisa.card.data.CardSearchData getDuplicates0 = new com.anfelisa.card.data.CardSearchData(randomUUID());
		getDuplicates0.setCategoryId(this.templateStringValue("boxId", 0));
		getDuplicates0.setGiven(this.templateStringValue("ive", 0));
		getDuplicates0.setWanted(this.templateStringValue("nted", 0));
		getDuplicates0.setNaturalInputOrder(new Boolean("true"));
		
		
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
			
			return actual;
				}
				
				@Test
				public void getDuplicatesLimit() throws Exception {
					given();
					
					Response response = when();
			
					com.anfelisa.card.data.GetDuplicatesResponse actualResponse = then(response);
					
					verifications(actualResponse);
			}
			
			protected abstract void verifications(com.anfelisa.card.data.GetDuplicatesResponse response);
			
			}
			
			
			
			
			/******* S.D.G. *******/
			
			
			

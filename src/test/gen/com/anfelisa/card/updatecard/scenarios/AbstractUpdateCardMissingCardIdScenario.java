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




package com.anfelisa.card.updatecard.scenarios;

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
public abstract class AbstractUpdateCardMissingCardIdScenario extends BaseScenario {

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

		com.anfelisa.card.data.CardCreationData createCard3 = new com.anfelisa.card.data.CardCreationData("c1");
		createCard3.setCategoryId(this.templateStringValue("cat1", null));
		createCard3.setGiven(this.templateStringValue("given", null));
		createCard3.setImage(this.templateStringValue("image", null));
		createCard3.setWanted(this.templateStringValue("wanted", null));
		
		com.anfelisa.card.ActionCalls.callCreateCard(createCard3, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

	}
	
	private Response when() throws Exception {
		com.anfelisa.card.data.CardUpdateData updateCard0 = new com.anfelisa.card.data.CardUpdateData(randomUUID());
		updateCard0.setGiven(this.templateStringValue("given", null));
		updateCard0.setImage(this.templateStringValue("image", null));
		updateCard0.setWanted(this.templateStringValue("wanted", null));
		
		return 
		com.anfelisa.card.ActionCalls.callUpdateCard(updateCard0, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
	}
	
	private void then(Response response) throws Exception {
		assertThat(response.getStatus(), 400);
		
			
				}
				
				@Test
				public void updateCardMissingCardId() throws Exception {
					given();
					
					Response response = when();
			
					then(response);
					
					verifications();
			}
			
			protected abstract void verifications();
			
			}
			
			
			
			
			/******* S.D.G. *******/
			
			
			

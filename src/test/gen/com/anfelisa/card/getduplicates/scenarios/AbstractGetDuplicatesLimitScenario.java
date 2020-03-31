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
		com.anfelisa.user.ActionCalls.callRegisterUser("uuid", this.templateStringValue("password", 0), this.templateStringValue("Annette", 0), this.templateStringValue("annette.pohl@anfelisa.de", 0), this.templateStringValue("de", 0), DROPWIZARD.getLocalPort());

		com.anfelisa.box.ActionCalls.callCreateBox("boxId", this.templateStringValue("cat", 1), new Boolean("false"), null, null, 10, null, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.category.ActionCalls.callCreateCategory("cat1", this.templateStringValue("level 1 #1", 2), this.templateStringValue("boxId", 2), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.card.ActionCalls.callCreateCard(randomUUID(), this.templateStringValue("${index}wanted${random}", 3), this.templateStringValue("${index}given${random}", 3), null, this.templateStringValue("cat1", 3), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		com.anfelisa.card.ActionCalls.callCreateCard(randomUUID(), this.templateStringValue("${index}wanted${random}", 4), this.templateStringValue("${index}given${random}", 4), null, this.templateStringValue("cat1", 4), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		com.anfelisa.card.ActionCalls.callCreateCard(randomUUID(), this.templateStringValue("${index}wanted${random}", 5), this.templateStringValue("${index}given${random}", 5), null, this.templateStringValue("cat1", 5), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		com.anfelisa.card.ActionCalls.callCreateCard(randomUUID(), this.templateStringValue("${index}wanted${random}", 6), this.templateStringValue("${index}given${random}", 6), null, this.templateStringValue("cat1", 6), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		com.anfelisa.card.ActionCalls.callCreateCard(randomUUID(), this.templateStringValue("${index}wanted${random}", 7), this.templateStringValue("${index}given${random}", 7), null, this.templateStringValue("cat1", 7), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		com.anfelisa.card.ActionCalls.callCreateCard(randomUUID(), this.templateStringValue("${index}wanted${random}", 8), this.templateStringValue("${index}given${random}", 8), null, this.templateStringValue("cat1", 8), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		com.anfelisa.card.ActionCalls.callCreateCard(randomUUID(), this.templateStringValue("${index}wanted${random}", 9), this.templateStringValue("${index}given${random}", 9), null, this.templateStringValue("cat1", 9), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		com.anfelisa.card.ActionCalls.callCreateCard(randomUUID(), this.templateStringValue("${index}wanted${random}", 10), this.templateStringValue("${index}given${random}", 10), null, this.templateStringValue("cat1", 10), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		com.anfelisa.card.ActionCalls.callCreateCard(randomUUID(), this.templateStringValue("${index}wanted${random}", 11), this.templateStringValue("${index}given${random}", 11), null, this.templateStringValue("cat1", 11), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		com.anfelisa.card.ActionCalls.callCreateCard(randomUUID(), this.templateStringValue("${index}wanted${random}", 12), this.templateStringValue("${index}given${random}", 12), null, this.templateStringValue("cat1", 12), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		com.anfelisa.card.ActionCalls.callCreateCard(randomUUID(), this.templateStringValue("${index}wanted${random}", 13), this.templateStringValue("${index}given${random}", 13), null, this.templateStringValue("cat1", 13), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		com.anfelisa.card.ActionCalls.callCreateCard(randomUUID(), this.templateStringValue("${index}wanted${random}", 14), this.templateStringValue("${index}given${random}", 14), null, this.templateStringValue("cat1", 14), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		com.anfelisa.card.ActionCalls.callCreateCard(randomUUID(), this.templateStringValue("${index}wanted${random}", 15), this.templateStringValue("${index}given${random}", 15), null, this.templateStringValue("cat1", 15), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		com.anfelisa.card.ActionCalls.callCreateCard(randomUUID(), this.templateStringValue("${index}wanted${random}", 16), this.templateStringValue("${index}given${random}", 16), null, this.templateStringValue("cat1", 16), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		com.anfelisa.card.ActionCalls.callCreateCard(randomUUID(), this.templateStringValue("${index}wanted${random}", 17), this.templateStringValue("${index}given${random}", 17), null, this.templateStringValue("cat1", 17), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		com.anfelisa.card.ActionCalls.callCreateCard(randomUUID(), this.templateStringValue("${index}wanted${random}", 18), this.templateStringValue("${index}given${random}", 18), null, this.templateStringValue("cat1", 18), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		com.anfelisa.card.ActionCalls.callCreateCard(randomUUID(), this.templateStringValue("${index}wanted${random}", 19), this.templateStringValue("${index}given${random}", 19), null, this.templateStringValue("cat1", 19), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		com.anfelisa.card.ActionCalls.callCreateCard(randomUUID(), this.templateStringValue("${index}wanted${random}", 20), this.templateStringValue("${index}given${random}", 20), null, this.templateStringValue("cat1", 20), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		com.anfelisa.card.ActionCalls.callCreateCard(randomUUID(), this.templateStringValue("${index}wanted${random}", 21), this.templateStringValue("${index}given${random}", 21), null, this.templateStringValue("cat1", 21), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		com.anfelisa.card.ActionCalls.callCreateCard(randomUUID(), this.templateStringValue("${index}wanted${random}", 22), this.templateStringValue("${index}given${random}", 22), null, this.templateStringValue("cat1", 22), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		com.anfelisa.card.ActionCalls.callCreateCard(randomUUID(), this.templateStringValue("${index}wanted${random}", 23), this.templateStringValue("${index}given${random}", 23), null, this.templateStringValue("cat1", 23), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		com.anfelisa.card.ActionCalls.callCreateCard(randomUUID(), this.templateStringValue("${index}wanted${random}", 24), this.templateStringValue("${index}given${random}", 24), null, this.templateStringValue("cat1", 24), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		com.anfelisa.card.ActionCalls.callCreateCard(randomUUID(), this.templateStringValue("${index}wanted${random}", 25), this.templateStringValue("${index}given${random}", 25), null, this.templateStringValue("cat1", 25), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		com.anfelisa.card.ActionCalls.callCreateCard(randomUUID(), this.templateStringValue("${index}wanted${random}", 26), this.templateStringValue("${index}given${random}", 26), null, this.templateStringValue("cat1", 26), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		com.anfelisa.card.ActionCalls.callCreateCard(randomUUID(), this.templateStringValue("${index}wanted${random}", 27), this.templateStringValue("${index}given${random}", 27), null, this.templateStringValue("cat1", 27), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		com.anfelisa.card.ActionCalls.callCreateCard(randomUUID(), this.templateStringValue("${index}wanted${random}", 28), this.templateStringValue("${index}given${random}", 28), null, this.templateStringValue("cat1", 28), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		com.anfelisa.card.ActionCalls.callCreateCard(randomUUID(), this.templateStringValue("${index}wanted${random}", 29), this.templateStringValue("${index}given${random}", 29), null, this.templateStringValue("cat1", 29), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		com.anfelisa.card.ActionCalls.callCreateCard(randomUUID(), this.templateStringValue("${index}wanted${random}", 30), this.templateStringValue("${index}given${random}", 30), null, this.templateStringValue("cat1", 30), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		com.anfelisa.card.ActionCalls.callCreateCard(randomUUID(), this.templateStringValue("${index}wanted${random}", 31), this.templateStringValue("${index}given${random}", 31), null, this.templateStringValue("cat1", 31), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		com.anfelisa.card.ActionCalls.callCreateCard(randomUUID(), this.templateStringValue("${index}wanted${random}", 32), this.templateStringValue("${index}given${random}", 32), null, this.templateStringValue("cat1", 32), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
		com.anfelisa.card.ActionCalls.callCreateCard(randomUUID(), this.templateStringValue("${index}wanted${random}", 33), this.templateStringValue("${index}given${random}", 33), null, this.templateStringValue("cat1", 33), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

	}
	
	private Response when() throws Exception {
		return com.anfelisa.card.ActionCalls.callGetDuplicates(randomUUID(), this.templateStringValue("ive", 0), this.templateStringValue("nted", 0), new Boolean("true"), this.templateStringValue("boxId", 0), DROPWIZARD.getLocalPort(), authorization("Annette", "password"));
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
			
			
			

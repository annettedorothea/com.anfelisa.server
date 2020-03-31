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
public abstract class AbstractGetDuplicatesNoAccessToCategoryScenario extends BaseScenario {

	private void given() throws Exception {
		NotReplayableDataProvider.put("token", "TOKEN");
		com.anfelisa.user.ActionCalls.callRegisterUser("uuid", "password", "Annette", "annette.pohl@anfelisa.de", "de", DROPWIZARD.getLocalPort());

		com.anfelisa.box.ActionCalls.callCreateBox("boxId", "cat", new Boolean("false"), null, null, 10, null, DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.category.ActionCalls.callCreateCategory("cat1", "level 1 #1", "boxId", DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.card.ActionCalls.callCreateCard("c1", "wanted", "given", "image", "cat1", DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.card.ActionCalls.callCreateCard("c2", "wanted2", "given2", "image2", "cat1", DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.card.ActionCalls.callCreateCard("c3", "3wanted", "3given", null, "cat1", DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.card.ActionCalls.callCreateCard("c4", "4wanted4", "4given4", null, "cat1", DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		com.anfelisa.card.ActionCalls.callCreateCard("c5", "different", "different", null, "cat1", DROPWIZARD.getLocalPort(), authorization("Annette", "password"));

		NotReplayableDataProvider.put("token", "ADMIN-TOKEN");
		com.anfelisa.user.ActionCalls.callRegisterUser("uuid-admin", "admin-password", "Admin", "annette.pohl@anfelisa.de", "de", DROPWIZARD.getLocalPort());

	}
	
	private Response when() throws Exception {
		return com.anfelisa.card.ActionCalls.callGetDuplicates(randomUUID(), "ive", "nted", new Boolean("true"), "boxId", DROPWIZARD.getLocalPort(), authorization("Admin", "admin-password"));
	}
	
	private com.anfelisa.card.data.GetDuplicatesResponse then(Response response) throws Exception {
		assertThat(response.getStatus(), 401);
		
		com.anfelisa.card.data.GetDuplicatesResponse actual = null;
		try {
			actual = response.readEntity(com.anfelisa.card.data.GetDuplicatesResponse.class);
		} catch (Exception x) {
		}
		
		return actual;
	}
	
	@Test
	public void getDuplicatesNoAccessToCategory() throws Exception {
		given();
		
		Response response = when();

		com.anfelisa.card.data.GetDuplicatesResponse actualResponse = then(response);
		
		verifications(actualResponse);
	}
	
	protected abstract void verifications(com.anfelisa.card.data.GetDuplicatesResponse response);

}




/******* S.D.G. *******/




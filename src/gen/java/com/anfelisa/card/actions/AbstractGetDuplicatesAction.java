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




package com.anfelisa.card.actions;

import javax.validation.constraints.NotNull;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.acegen.CustomAppConfiguration;
import de.acegen.E2E;
import de.acegen.IDaoProvider;
import de.acegen.IDataContainer;
import de.acegen.ViewProvider;
import de.acegen.PersistenceConnection;
import de.acegen.PersistenceHandle;
import de.acegen.ReadAction;
import de.acegen.ITimelineItem;

import de.acegen.auth.AuthUser;

import com.codahale.metrics.annotation.Timed;

import io.dropwizard.auth.Auth;

import com.fasterxml.jackson.core.JsonProcessingException;

import javax.ws.rs.GET;

import com.anfelisa.card.data.ICardSearchData;
import com.anfelisa.card.data.CardSearchData;

@Path("/cards/search")
@SuppressWarnings("unused")
public abstract class AbstractGetDuplicatesAction extends ReadAction<ICardSearchData> {

	static final Logger LOG = LoggerFactory.getLogger(AbstractGetDuplicatesAction.class);
	
	public AbstractGetDuplicatesAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
		super("com.anfelisa.card.actions.GetDuplicatesAction", persistenceConnection, appConfiguration, daoProvider,
						viewProvider, e2e);
	}

	public void setActionData(IDataContainer data) {
		this.actionData = (ICardSearchData)data;
	}

	protected abstract void loadDataForGetRequest(PersistenceHandle readonlyHandle);

	@Override
	protected ICardSearchData createAceData(ITimelineItem timelineItem) {
		IDataContainer originalData = AceDataFactory.createAceData(timelineItem.getName(), timelineItem.getData());
		ICardSearchData originalActionData = (ICardSearchData)originalData;
		this.actionData.setSystemTime(originalActionData.getSystemTime());
		return (ICardSearchData)originalData;
	}

	@GET
	@Timed
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getDuplicatesResource(
			@Auth AuthUser authUser, 
			@QueryParam("given") String given, 
			@QueryParam("wanted") String wanted, 
			@QueryParam("naturalInputOrder") Boolean naturalInputOrder, 
			@QueryParam("categoryId") String categoryId, 
			@NotNull @QueryParam("uuid") String uuid) 
			throws JsonProcessingException {
		this.actionData = new CardSearchData(uuid);
		try {
			this.actionData.setGiven(given);
		} catch (Exception x) {
			LOG.warn("failed to parse param {}", "given");
		}
		try {
			this.actionData.setWanted(wanted);
		} catch (Exception x) {
			LOG.warn("failed to parse param {}", "wanted");
		}
		try {
			this.actionData.setNaturalInputOrder(naturalInputOrder);
		} catch (Exception x) {
			LOG.warn("failed to parse param {}", "naturalInputOrder");
		}
		try {
			this.actionData.setCategoryId(categoryId);
		} catch (Exception x) {
			LOG.warn("failed to parse param {}", "categoryId");
		}
		try {
			this.actionData.setUserId(authUser.getUserId());
		} catch (Exception x) {
			LOG.warn("failed to parse param {}", "userId");
		}
		return this.apply();
	}

	protected Object createReponse() {
		return new com.anfelisa.card.data.GetDuplicatesResponse(this.actionData);
	}
	
}




/******* S.D.G. *******/




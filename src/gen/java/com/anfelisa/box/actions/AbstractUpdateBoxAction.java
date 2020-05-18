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




package com.anfelisa.box.actions;

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

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.acegen.CustomAppConfiguration;
import de.acegen.E2E;
import de.acegen.HttpMethod;
import de.acegen.ICommand;
import de.acegen.IDaoProvider;
import de.acegen.IDataContainer;
import de.acegen.ITimelineItem;
import de.acegen.ViewProvider;
import de.acegen.NotReplayableDataProvider;
import de.acegen.PersistenceConnection;
import de.acegen.WriteAction;

import de.acegen.auth.AuthUser;
import io.dropwizard.auth.Auth;

import com.codahale.metrics.annotation.Timed;

import com.fasterxml.jackson.core.JsonProcessingException;

import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;

import com.anfelisa.box.data.IBoxUpdateData;
import com.anfelisa.box.data.BoxUpdateData;
import com.anfelisa.box.commands.UpdateBoxCommand;

@Path("/box/update")
@SuppressWarnings("unused")
public abstract class AbstractUpdateBoxAction extends WriteAction<IBoxUpdateData> {

	static final Logger LOG = LoggerFactory.getLogger(AbstractUpdateBoxAction.class);
	
	private ObjectMapper objectMapper;

	public AbstractUpdateBoxAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
		super("com.anfelisa.box.actions.UpdateBoxAction", persistenceConnection, appConfiguration, daoProvider,
						viewProvider, e2e, HttpMethod.PUT);
		objectMapper = new ObjectMapper();
	}

	@Override
	public ICommand getCommand() {
		return new UpdateBoxCommand(this.actionData, daoProvider, viewProvider, this.appConfiguration);
	}
	
	@Override
	protected void initActionDataFrom(ITimelineItem timelineItem) {
		IDataContainer originalData = AceDataFactory.createAceData(timelineItem.getName(), timelineItem.getData());
		IBoxUpdateData originalActionData = (IBoxUpdateData)originalData;
		this.actionData.setSystemTime(originalActionData.getSystemTime());
	}


	@Override
	protected void initActionDataFromNotReplayableDataProvider() {
		DateTime systemTime = NotReplayableDataProvider.consumeSystemTime(this.actionData.getUuid());
		if (systemTime != null) {
			this.actionData.setSystemTime(systemTime);
		}
	}

	@PUT
	@Timed
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateBoxResource(
			@Auth AuthUser authUser, 
			IBoxUpdateData payload)
			throws JsonProcessingException {
		if (payload == null) {
			throwBadRequest("payload must not be null");
		}
		this.actionData = new BoxUpdateData(payload.getUuid());
		
		this.actionData.setMaxInterval(payload.getMaxInterval());
		
		if (payload.getMaxCardsPerDay() == null) {
			throwBadRequest("maxCardsPerDay is mandatory");
		}
		this.actionData.setMaxCardsPerDay(payload.getMaxCardsPerDay());
		
		if (StringUtils.isBlank(payload.getBoxId()) || "null".equals(payload.getBoxId())) {
			throwBadRequest("boxId is mandatory");
		}
		this.actionData.setBoxId(payload.getBoxId());
		
		if (StringUtils.isBlank(payload.getCategoryId()) || "null".equals(payload.getCategoryId())) {
			throwBadRequest("categoryId is mandatory");
		}
		this.actionData.setCategoryId(payload.getCategoryId());
		
		if (StringUtils.isBlank(payload.getCategoryName()) || "null".equals(payload.getCategoryName())) {
			throwBadRequest("categoryName is mandatory");
		}
		this.actionData.setCategoryName(payload.getCategoryName());
		
		this.actionData.setDictionaryLookup(payload.getDictionaryLookup());
		
		this.actionData.setGivenLanguage(payload.getGivenLanguage());
		
		this.actionData.setWantedLanguage(payload.getWantedLanguage());
		this.actionData.setUserId(authUser.getUserId());
		
		return this.apply();
	}


}




/******* S.D.G. *******/




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
import de.acegen.IDaoProvider;
import de.acegen.IDataContainer;
import de.acegen.ViewProvider;
import de.acegen.PersistenceConnection;
import de.acegen.PersistenceHandle;
import de.acegen.ReadAction;
import de.acegen.ITimelineItem;
import de.acegen.NotReplayableDataProvider;

import de.acegen.auth.AuthUser;
import io.dropwizard.auth.Auth;

import com.codahale.metrics.annotation.Timed;

import com.fasterxml.jackson.core.JsonProcessingException;

import javax.ws.rs.GET;

import com.anfelisa.box.data.IBoxListData;
import com.anfelisa.box.data.BoxListData;

@Path("/boxes/my/")
@SuppressWarnings("unused")
public abstract class AbstractGetBoxesAction extends ReadAction<IBoxListData> {

	static final Logger LOG = LoggerFactory.getLogger(AbstractGetBoxesAction.class);
	
	private ObjectMapper objectMapper;
	
	public AbstractGetBoxesAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
		super("com.anfelisa.box.actions.GetBoxesAction", persistenceConnection, appConfiguration, daoProvider,
						viewProvider, e2e);
		objectMapper = new ObjectMapper();
	}

	protected abstract void loadDataForGetRequest(PersistenceHandle readonlyHandle);

	@Override
	protected void initActionDataFrom(ITimelineItem timelineItem) {
		IDataContainer originalData = AceDataFactory.createAceData(timelineItem.getName(), timelineItem.getData());
		IBoxListData originalActionData = (IBoxListData)originalData;
		this.actionData.setSystemTime(originalActionData.getSystemTime());
	}
	
	@Override
	protected void initActionDataFromNotReplayableDataProvider() {
		DateTime systemTime = NotReplayableDataProvider.consumeSystemTime(this.actionData.getUuid());
		if (systemTime != null) {
			this.actionData.setSystemTime(systemTime);
		}
	}

	@GET
	@Timed
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getBoxesResource(
			@Auth AuthUser authUser, 
			@QueryParam("todayAtMidnightInUTC") String todayAtMidnightInUTC, 
			@QueryParam("uuid") String uuid) 
			throws JsonProcessingException {
		if (StringUtils.isBlank(uuid)) {
			throwBadRequest("uuid must not be blank or null");
		}
		this.actionData = new BoxListData(uuid);
		
		if (StringUtils.isBlank(todayAtMidnightInUTC) || "null".equals(todayAtMidnightInUTC)) {
			throwBadRequest("todayAtMidnightInUTC is mandatory");
		}
		if (StringUtils.isNotBlank(todayAtMidnightInUTC)) {
			try {
				this.actionData.setTodayAtMidnightInUTC(new DateTime(todayAtMidnightInUTC).withZone(DateTimeZone.UTC));
			} catch (Exception x) {
				LOG.warn("failed to parse dateTime todayAtMidnightInUTC - {}", todayAtMidnightInUTC);
			}
		}
		this.actionData.setUserId(authUser.getUserId());
		
		return this.apply();
	}

	protected Object createReponse() {
		return new com.anfelisa.box.data.GetBoxesResponse(this.actionData);
	}
	
}




/******* S.D.G. *******/




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




package com.anfelisa.user.actions;

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

import com.anfelisa.user.data.IUserData;
import com.anfelisa.user.data.UserData;

@Path("/user/get")
@SuppressWarnings("unused")
public abstract class AbstractGetUserProfileAction extends ReadAction<IUserData> {

	static final Logger LOG = LoggerFactory.getLogger(AbstractGetUserProfileAction.class);
	
	public AbstractGetUserProfileAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
		super("com.anfelisa.user.actions.GetUserProfileAction", persistenceConnection, appConfiguration, daoProvider,
						viewProvider, e2e);
	}

	public void setActionData(IDataContainer data) {
		this.actionData = (IUserData)data;
	}

	protected abstract void loadDataForGetRequest(PersistenceHandle readonlyHandle);

	@Override
	protected IUserData createAceData(ITimelineItem timelineItem) {
		IDataContainer originalData = AceDataFactory.createAceData(timelineItem.getName(), timelineItem.getData());
		IUserData originalActionData = (IUserData)originalData;
		this.actionData.setSystemTime(originalActionData.getSystemTime());
		return (IUserData)originalData;
	}

	@GET
	@Timed
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getUserProfileResource(
			@Auth AuthUser authUser, 
			@NotNull @QueryParam("uuid") String uuid) 
			throws JsonProcessingException {
		this.actionData = new UserData(uuid);
		try {
			this.actionData.setUserId(authUser.getUserId());
		} catch (Exception x) {
			LOG.warn("failed to parse param {}", "userId");
		}
		try {
			this.actionData.setUsername(authUser.getUsername());
		} catch (Exception x) {
			LOG.warn("failed to parse param {}", "username");
		}
		try {
			this.actionData.setPassword(authUser.getPassword());
		} catch (Exception x) {
			LOG.warn("failed to parse param {}", "password");
		}
		try {
			this.actionData.setRole(authUser.getRole());
		} catch (Exception x) {
			LOG.warn("failed to parse param {}", "role");
		}
		return this.apply();
	}

	protected Object createReponse() {
		return new com.anfelisa.user.data.GetUserProfileResponse(this.actionData);
	}
	
}




/******* S.D.G. *******/




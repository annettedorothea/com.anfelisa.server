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


import com.codahale.metrics.annotation.Timed;

import com.fasterxml.jackson.core.JsonProcessingException;

import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;

import com.anfelisa.user.data.IUserRegistrationData;
import com.anfelisa.user.data.UserRegistrationData;
import com.anfelisa.user.commands.RegisterUserCommand;

@Path("/users/register")
@SuppressWarnings("unused")
public abstract class AbstractRegisterUserAction extends WriteAction<IUserRegistrationData> {

	static final Logger LOG = LoggerFactory.getLogger(AbstractRegisterUserAction.class);
	
	public AbstractRegisterUserAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
		super("com.anfelisa.user.actions.RegisterUserAction", persistenceConnection, appConfiguration, daoProvider,
						viewProvider, e2e, HttpMethod.POST);
	}

	@Override
	public ICommand getCommand() {
		return new RegisterUserCommand(this.actionData, daoProvider, viewProvider, this.appConfiguration);
	}
	
	@Override
	protected void initActionDataFrom(ITimelineItem timelineItem) {
		IDataContainer originalData = AceDataFactory.createAceData(timelineItem.getName(), timelineItem.getData());
		IUserRegistrationData originalActionData = (IUserRegistrationData)originalData;
		this.actionData.setSystemTime(originalActionData.getSystemTime());
		this.actionData.setToken((originalActionData.getToken()));
	}


	@Override
	protected void initActionDataFromNotReplayableDataProvider() {
		if (NotReplayableDataProvider.getSystemTime() != null) {
			this.actionData.setSystemTime(NotReplayableDataProvider.getSystemTime());
		}
		if (NotReplayableDataProvider.get("token") != null) {
			this.actionData.setToken((String)NotReplayableDataProvider.get("token"));
		} else {
			LOG.warn("token is declared as not replayable but no value was found in NotReplayableDataProvider.");
		}
	}

	@POST
	@Timed
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registerUserResource(
			IUserRegistrationData payload)
			throws JsonProcessingException {
		if (payload == null) {
			throwBadRequest("payload must not be null");
		}
		this.actionData = new UserRegistrationData(payload.getUuid());
		
		if (StringUtils.isBlank(payload.getPassword()) || "null".equals(payload.getPassword())) {
			throwBadRequest("password is mandatory");
		}
		this.actionData.setPassword(payload.getPassword());
		
		if (StringUtils.isBlank(payload.getUsername()) || "null".equals(payload.getUsername())) {
			throwBadRequest("username is mandatory");
		}
		this.actionData.setUsername(payload.getUsername());
		
		if (StringUtils.isBlank(payload.getEmail()) || "null".equals(payload.getEmail())) {
			throwBadRequest("email is mandatory");
		}
		this.actionData.setEmail(payload.getEmail());
		
		if (StringUtils.isBlank(payload.getLanguage()) || "null".equals(payload.getLanguage())) {
			throwBadRequest("language is mandatory");
		}
		this.actionData.setLanguage(payload.getLanguage());
		
		return this.apply();
	}


}




/******* S.D.G. *******/




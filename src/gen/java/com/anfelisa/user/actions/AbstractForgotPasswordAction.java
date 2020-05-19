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


import com.codahale.metrics.annotation.Timed;

import com.fasterxml.jackson.core.JsonProcessingException;

import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;

import com.anfelisa.user.data.IForgotPasswordData;
import com.anfelisa.user.data.ForgotPasswordData;
import com.anfelisa.user.commands.ForgotPasswordCommand;

@Path("/users/forgot-password")
@SuppressWarnings("unused")
public abstract class AbstractForgotPasswordAction extends WriteAction<IForgotPasswordData> {

	static final Logger LOG = LoggerFactory.getLogger(AbstractForgotPasswordAction.class);
	
	private ObjectMapper objectMapper;

	public AbstractForgotPasswordAction(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
		super("com.anfelisa.user.actions.ForgotPasswordAction", persistenceConnection, appConfiguration, daoProvider,
						viewProvider, e2e, HttpMethod.POST);
		objectMapper = new ObjectMapper();
	}

	@Override
	public ICommand getCommand() {
		return new ForgotPasswordCommand(this.actionData, daoProvider, viewProvider, this.appConfiguration);
	}
	
	@Override
	protected void initActionDataFrom(ITimelineItem timelineItem) {
		IDataContainer originalData = AceDataFactory.createAceData(timelineItem.getName(), timelineItem.getData());
		IForgotPasswordData originalActionData = (IForgotPasswordData)originalData;
		this.actionData.setSystemTime(originalActionData.getSystemTime());
		this.actionData.setToken((originalActionData.getToken()));
	}


	@Override
	protected void initActionDataFromNotReplayableDataProvider() {
		DateTime systemTime = NotReplayableDataProvider.consumeSystemTime(this.actionData.getUuid());
		if (systemTime != null) {
			this.actionData.setSystemTime(systemTime);
		} else {
			this.actionData.setSystemTime(DateTime.now().withZone(DateTimeZone.UTC));
		}
		Object value = NotReplayableDataProvider.consumeValue(this.actionData.getUuid(), "token");
		if (value != null) {
			try {
				String token = (String)value;
				this.actionData.setToken(token);
			} catch (Exception x) {
				LOG.warn("token is declared as not replayable and failed to parse {} from NotReplayableDataProvider.", value);
			}
		} else {
			LOG.warn("token is declared as not replayable but no value was found in NotReplayableDataProvider.");
		}
	}

	@POST
	@Timed
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response forgotPasswordResource(
			IForgotPasswordData payload)
			throws JsonProcessingException {
		if (payload == null) {
			throwBadRequest("payload must not be null");
		}
		this.actionData = new ForgotPasswordData(payload.getUuid());
		
		if (StringUtils.isBlank(payload.getUsername()) || "null".equals(payload.getUsername())) {
			throwBadRequest("username is mandatory");
		}
		this.actionData.setUsername(payload.getUsername());
		
		if (StringUtils.isBlank(payload.getLanguage()) || "null".equals(payload.getLanguage())) {
			throwBadRequest("language is mandatory");
		}
		this.actionData.setLanguage(payload.getLanguage());
		
		LOG.info("execute ForgotPassword with uuid " + this.actionData.getUuid());
		
		return this.apply();
	}


}




/******* S.D.G. *******/




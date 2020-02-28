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
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import org.jdbi.v3.core.Jdbi;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.App;
import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.E2E;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.IDataContainer;
import com.anfelisa.ace.ITimelineItem;
import com.anfelisa.ace.JodaObjectMapper;
import com.anfelisa.ace.ServerConfiguration;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.auth.AuthUser;

import com.codahale.metrics.annotation.Timed;

import io.dropwizard.auth.Auth;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.jdbi.v3.core.Handle;


import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;

import com.anfelisa.user.data.IForgotPasswordData;
import com.anfelisa.user.data.ForgotPasswordData;
import com.anfelisa.user.commands.ForgotPasswordCommand;

@Path("/users/forgot-password")
@SuppressWarnings("unused")
public abstract class AbstractForgotPasswordAction extends Action<IForgotPasswordData> {

	static final Logger LOG = LoggerFactory.getLogger(AbstractForgotPasswordAction.class);
	
	private DatabaseHandle databaseHandle;
	private Jdbi jdbi;
	protected JodaObjectMapper mapper;
	protected CustomAppConfiguration appConfiguration;
	protected IDaoProvider daoProvider;
	private ViewProvider viewProvider;
	private E2E e2e;
	

	public AbstractForgotPasswordAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
		super("com.anfelisa.user.actions.ForgotPasswordAction", HttpMethod.POST);
		this.jdbi = jdbi;
		mapper = new JodaObjectMapper();
		this.appConfiguration = appConfiguration;
		this.daoProvider = daoProvider;
		this.viewProvider = viewProvider;
		this.e2e = e2e;
	}

	@Override
	public ICommand getCommand() {
		return new ForgotPasswordCommand(this.actionData, daoProvider, viewProvider, this.appConfiguration);
	}
	
	public void setActionData(IDataContainer data) {
		this.actionData = (IForgotPasswordData)data;
	}

	@POST
	@Timed
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response forgotPasswordResource(
			@NotNull IForgotPasswordData payload) 
			throws JsonProcessingException {
		this.actionData = new ForgotPasswordData(payload.getUuid());
		this.actionData.setUsername(payload.getUsername());
		this.actionData.setLanguage(payload.getLanguage());
		
		return this.apply();
	}
	
	public Response apply() {
		databaseHandle = new DatabaseHandle(jdbi);
		databaseHandle.beginTransaction();
		try {
			if (ServerConfiguration.DEV.equals(appConfiguration.getServerConfiguration().getMode())
					|| ServerConfiguration.LIVE.equals(appConfiguration.getServerConfiguration().getMode())) {
				if (daoProvider.getAceDao().contains(databaseHandle.getHandle(), this.actionData.getUuid())) {
					databaseHandle.commitTransaction();
					throwBadRequest("uuid already exists - please choose another one");
				}
				this.actionData.setSystemTime(new DateTime());
				this.initActionData();
			} else if (ServerConfiguration.REPLAY.equals(appConfiguration.getServerConfiguration().getMode())) {
				ITimelineItem timelineItem = e2e.selectAction(this.actionData.getUuid());
				IDataContainer originalData = AceDataFactory.createAceData(timelineItem.getName(), timelineItem.getData());
				this.actionData = (IForgotPasswordData)originalData;
				// TODO only not replayable
			} else if (ServerConfiguration.TEST.equals(appConfiguration.getServerConfiguration().getMode())) {
				// TODO
			}
			daoProvider.getAceDao().addActionToTimeline(this, this.databaseHandle.getTimelineHandle());
			ICommand command = this.getCommand();
			command.execute(this.databaseHandle.getReadonlyHandle(), this.databaseHandle.getTimelineHandle());
			command.publishEvents(this.databaseHandle.getHandle(), this.databaseHandle.getTimelineHandle());
			Response response = Response.ok(this.createReponse()).build();
			databaseHandle.commitTransaction();
			return response;
		} catch (WebApplicationException x) {
			LOG.error(actionName + " failed " + x.getMessage());
			try {
				databaseHandle.rollbackTransaction();
				daoProvider.getAceDao().addExceptionToTimeline(this.actionData.getUuid(), x, this.databaseHandle.getTimelineHandle());
				App.reportException(x);
			} catch (Exception ex) {
				LOG.error("failed to rollback or to save or report exception " + ex.getMessage());
			}
			return Response.status(x.getResponse().getStatusInfo()).entity(x.getMessage()).build();
		} catch (Exception x) {
			LOG.error(actionName + " failed " + x.getMessage());
			try {
				databaseHandle.rollbackTransaction();
				daoProvider.getAceDao().addExceptionToTimeline(this.actionData.getUuid(), x, this.databaseHandle.getTimelineHandle());
				App.reportException(x);
			} catch (Exception ex) {
				LOG.error("failed to rollback or to save or report exception " + ex.getMessage());
			}
			return Response.status(500).entity(x.getMessage()).build();
		} finally {
			databaseHandle.close();
		}
	}
	

}




/******* S.D.G. *******/




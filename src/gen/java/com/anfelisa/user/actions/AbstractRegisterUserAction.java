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

import java.util.UUID;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.QueryParam;
import javax.ws.rs.PathParam;
import io.dropwizard.auth.Auth;
import javax.ws.rs.HeaderParam;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.IDataContainer;
import com.anfelisa.ace.App;
import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.ServerConfiguration;
import com.anfelisa.ace.E2E;
import com.anfelisa.ace.ITimelineItem;
import com.anfelisa.ace.IAction;
import com.anfelisa.ace.SetSystemTimeResource;
import com.anfelisa.ace.JodaObjectMapper;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import javax.ws.rs.WebApplicationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.user.data.IUserRegistrationData;
import com.anfelisa.user.data.UserRegistrationData;
import com.anfelisa.user.commands.RegisterUserCommand;

@Path("/users/register")
@SuppressWarnings("unused")
public abstract class AbstractRegisterUserAction extends Action<IUserRegistrationData> {

	static final Logger LOG = LoggerFactory.getLogger(AbstractRegisterUserAction.class);

	private DatabaseHandle databaseHandle;
	private Jdbi jdbi;
	protected JodaObjectMapper mapper;
	protected CustomAppConfiguration appConfiguration;
	protected IDaoProvider daoProvider;
	private ViewProvider viewProvider;
	private E2E e2e;

	public AbstractRegisterUserAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
		super("com.anfelisa.user.actions.RegisterUserAction", HttpMethod.POST);
		this.jdbi = jdbi;
		mapper = new JodaObjectMapper();
		this.appConfiguration = appConfiguration;
		this.daoProvider = daoProvider;
		this.viewProvider = viewProvider;
		this.e2e = e2e;
	}

	@Override
	public ICommand getCommand() {
		return new RegisterUserCommand(this.actionData, daoProvider, viewProvider, this.appConfiguration);
	}
	
	public void setActionData(IDataContainer data) {
		this.actionData = (IUserRegistrationData)data;
	}

	@POST
	@Timed
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registerUserResource(
			@NotNull IUserRegistrationData payload) 
			throws JsonProcessingException {
		this.actionData = new UserRegistrationData(payload.getUuid());
		this.actionData.setPassword(payload.getPassword());
		this.actionData.setUsername(payload.getUsername());
		this.actionData.setEmail(payload.getEmail());
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
				this.actionData.addUuidForTriggeredAction("com.anfelisa.user.actions.SendRegistrationEmailAction", UUID.randomUUID().toString());
				this.initActionData();
			} else if (ServerConfiguration.REPLAY.equals(appConfiguration.getServerConfiguration().getMode())) {
				ITimelineItem timelineItem = e2e.selectAction(this.actionData.getUuid());
				IDataContainer originalData = AceDataFactory.createAceData(timelineItem.getName(), timelineItem.getData());
				this.actionData = (IUserRegistrationData)originalData;
			} else if (ServerConfiguration.TEST.equals(appConfiguration.getServerConfiguration().getMode())) {
				if (SetSystemTimeResource.systemTime != null) {
					this.actionData.setSystemTime(SetSystemTimeResource.systemTime);
				} else {
					this.actionData.setSystemTime(new DateTime());
				}
				this.actionData.addUuidForTriggeredAction("com.anfelisa.user.actions.SendRegistrationEmailAction", UUID.randomUUID().toString());
			}
			daoProvider.getAceDao().addActionToTimeline(this, this.databaseHandle.getTimelineHandle());
			ICommand command = this.getCommand();
			command.execute(this.databaseHandle.getReadonlyHandle(), this.databaseHandle.getTimelineHandle());
			command.publishEvents(this.databaseHandle.getHandle(), this.databaseHandle.getTimelineHandle());
			Response response = Response.ok(this.createReponse()).build();
			databaseHandle.commitTransaction();
			
			SendRegistrationEmailThread sendRegistrationEmailThread = new SendRegistrationEmailThread(
				jdbi, mapper, appConfiguration, daoProvider, viewProvider, e2e, command.getCommandData());
			e2e.addTriggeredThread(sendRegistrationEmailThread);
			sendRegistrationEmailThread.start();
			
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
	
	public class SendRegistrationEmailThread extends Thread {
		private Jdbi jdbi;
		private JodaObjectMapper mapper;
		private CustomAppConfiguration appConfiguration;
		private IDaoProvider daoProvider;
		private ViewProvider viewProvider;
		private IDataContainer commandData;
		private E2E e2e;

		public SendRegistrationEmailThread(Jdbi jdbi, JodaObjectMapper mapper, CustomAppConfiguration appConfiguration,
				IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e, IDataContainer commandData) {
		   this.jdbi = jdbi;
		   this.mapper = mapper;
		   this.appConfiguration = appConfiguration;
		   this.daoProvider = daoProvider;
		   this.viewProvider = viewProvider;
		   this.e2e = e2e;
		   this.commandData = commandData;
		   this.setName("SendRegistrationEmailThread");
		}
	
		public void run() {
			try {
				LOG.info("trigger SendRegistrationEmail");
				com.anfelisa.user.actions.SendRegistrationEmailAction sendRegistrationEmail 
					= new com.anfelisa.user.actions.SendRegistrationEmailAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e);
				IDataContainer data = AceDataFactory.createAceData("com.anfelisa.user.actions.SendRegistrationEmailAction", mapper.writeValueAsString(commandData));
				data.setUuid(commandData.getUuidForTriggeredAction("com.anfelisa.user.actions.SendRegistrationEmailAction"));
				sendRegistrationEmail.setActionData(data);
				sendRegistrationEmail.apply();
				LOG.info("trigger SendRegistrationEmail finished");
			} catch (Exception x) {
				LOG.error("failed to trigger SendRegistrationEmail " + x.getMessage());
			}
		}
	};
	
	


}




/******* S.D.G. *******/




package com.anfelisa.user.actions;

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

import com.anfelisa.user.data.IResetPasswordWithNewPasswordData;
import com.anfelisa.user.data.ResetPasswordWithNewPasswordData;
import com.anfelisa.user.commands.ResetPasswordCommand;

@Path("/users/resetpassword")
@SuppressWarnings("unused")
public abstract class AbstractResetPasswordAction extends Action<IResetPasswordWithNewPasswordData> {

	static final Logger LOG = LoggerFactory.getLogger(AbstractResetPasswordAction.class);

	private DatabaseHandle databaseHandle;
	private Jdbi jdbi;
	protected JodaObjectMapper mapper;
	protected CustomAppConfiguration appConfiguration;
	protected IDaoProvider daoProvider;
	private ViewProvider viewProvider;

	public AbstractResetPasswordAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.user.actions.ResetPasswordAction", HttpMethod.PUT);
		this.jdbi = jdbi;
		mapper = new JodaObjectMapper();
		this.appConfiguration = appConfiguration;
		this.daoProvider = daoProvider;
		this.viewProvider = viewProvider;
	}

	@Override
	public ICommand getCommand() {
		return new ResetPasswordCommand(this.actionData, daoProvider, viewProvider);
	}
	
	public void setActionData(IDataContainer data) {
		this.actionData = (IResetPasswordWithNewPasswordData)data;
	}


	@PUT
	@Timed
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response resetPasswordResource(
			@NotNull IResetPasswordWithNewPasswordData payload)
			throws JsonProcessingException {
		this.actionData = new ResetPasswordWithNewPasswordData(payload.getUuid());
		this.actionData.setPassword(payload.getPassword());
		this.actionData.setToken(payload.getToken());
		return this.apply();
	}

	public Response apply() {
		databaseHandle = new DatabaseHandle(jdbi);
		databaseHandle.beginTransaction();
		try {
			IDataContainer originalData = null;
			if (ServerConfiguration.DEV.equals(appConfiguration.getServerConfiguration().getMode())
					|| ServerConfiguration.LIVE.equals(appConfiguration.getServerConfiguration().getMode())) {
				if (daoProvider.getAceDao().contains(databaseHandle.getHandle(), this.actionData.getUuid())) {
					databaseHandle.commitTransaction();
					throwBadRequest("uuid already exists - please choose another one");
				}
				this.actionData.setSystemTime(new DateTime());
				this.initActionData();
			} else if (ServerConfiguration.REPLAY.equals(appConfiguration.getServerConfiguration().getMode())) {
				ITimelineItem timelineItem = E2E.selectAction(this.actionData.getUuid());
				if (timelineItem != null) {
					IAction action = ActionFactory.createAction(timelineItem.getName(), timelineItem.getData(), jdbi,
							appConfiguration, daoProvider, viewProvider);
					if (action != null) {
						originalData = action.getActionData();
						this.actionData = (IResetPasswordWithNewPasswordData)originalData;
					}
				} else {
					throw new WebApplicationException(
							"action for " + this.actionData.getUuid() + " not found in timeline");
				}
			} else if (ServerConfiguration.TEST.equals(appConfiguration.getServerConfiguration().getMode())) {
				if (SetSystemTimeResource.systemTime != null) {
					this.actionData.setSystemTime(SetSystemTimeResource.systemTime);
				} else {
					this.actionData.setSystemTime(new DateTime());
				}
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

/*       S.D.G.       */

package com.anfelisa.box.actions;

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

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.jdbi.v3.core.Jdbi;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import com.anfelisa.auth.AuthUser;

import com.anfelisa.box.data.BoxUpdateData;

import com.anfelisa.box.commands.UpdateBoxCommand;

@SuppressWarnings("unused")
@Path("/box/update")
public abstract class AbstractUpdateBoxAction extends Action<BoxUpdateData> {

	public AbstractUpdateBoxAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.box.actions.UpdateBoxAction", HttpMethod.PUT, jdbi, appConfiguration, daoProvider, viewProvider);
	}

	@Override
	public ICommand getCommand() {
		return new UpdateBoxCommand(this.actionData, databaseHandle, daoProvider, viewProvider);
	}

	protected final void loadDataForGetRequest() {
	}

	@PUT
	@Timed
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateBoxResource(
			@Auth AuthUser authUser, 
			@NotNull BoxUpdateData payload)
			throws JsonProcessingException {
		this.actionData = new BoxUpdateData(payload.getUuid());
		this.actionData.setMaxInterval(payload.getMaxInterval());
		this.actionData.setBoxId(payload.getBoxId());
		this.actionData.setUserId(authUser.getUserId());
		return this.apply();
	}

}

/*       S.D.G.       */

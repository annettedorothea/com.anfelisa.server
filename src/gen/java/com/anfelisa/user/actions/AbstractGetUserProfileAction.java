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

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.jdbi.v3.core.Jdbi;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import com.anfelisa.auth.AuthUser;

import com.anfelisa.user.data.UserData;


@SuppressWarnings("unused")
@Path("/user/get")
public abstract class AbstractGetUserProfileAction extends Action<UserData> {

	public AbstractGetUserProfileAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.user.actions.GetUserProfileAction", HttpMethod.GET, jdbi, appConfiguration, daoProvider, viewProvider);
	}

	@Override
	public ICommand getCommand() {
		return null;
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
		this.actionData.setUserId(authUser.getUserId());
		this.actionData.setUsername(authUser.getUsername());
		this.actionData.setPassword(authUser.getPassword());
		this.actionData.setRole(authUser.getRole());
		return this.apply();
	}

	protected Object createReponse() {
		return new com.anfelisa.user.data.GetUserProfileResponse(this.actionData);
	}
}

/*       S.D.G.       */

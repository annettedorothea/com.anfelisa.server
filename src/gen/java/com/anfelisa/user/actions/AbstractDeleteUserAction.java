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

import com.anfelisa.user.data.DeleteUserData;

import com.anfelisa.user.commands.DeleteUserCommand;

@SuppressWarnings("unused")
@Path("/user/delete")
public abstract class AbstractDeleteUserAction extends Action<DeleteUserData> {

	public AbstractDeleteUserAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.user.actions.DeleteUserAction", HttpMethod.DELETE, jdbi, appConfiguration, daoProvider, viewProvider);
	}

	@Override
	public ICommand getCommand() {
		return new DeleteUserCommand(this.actionData, databaseHandle, daoProvider, viewProvider);
	}

	protected final void loadDataForGetRequest() {
	}

	@DELETE
	@Timed
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteUserResource(
			@Auth AuthUser authUser, 
			@QueryParam("usernameToBeDeleted") String usernameToBeDeleted, 
			@NotNull @QueryParam("uuid") String uuid) 
			throws JsonProcessingException {
		this.actionData = new DeleteUserData(uuid);
		this.actionData.setUsernameToBeDeleted(usernameToBeDeleted);
		this.actionData.setUsername(authUser.getUsername());
		this.actionData.setRole(authUser.getRole());
		return this.apply();
	}

}

/*       S.D.G.       */

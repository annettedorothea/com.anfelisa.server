package com.anfelisa.user.actions;

import javax.annotation.security.PermitAll;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.user.data.UserData;
import com.anfelisa.user.models.IUserModel;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
	public class GetUserProfileAction extends AbstractGetUserProfileAction {

	static final Logger LOG = LoggerFactory.getLogger(GetUserProfileAction.class);

	public GetUserProfileAction(DBI jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(jdbi, appConfiguration, daoProvider, viewProvider);
	}

	@GET
	@Timed
	@Path("/get")
	@PermitAll
	public Response get(@Auth AuthUser principal, @NotNull @QueryParam("uuid") String uuid) throws JsonProcessingException {
		this.actionData = new UserData(uuid).withUsername(principal.getUsername());
		return this.apply();
	}

	protected final void loadDataForGetRequest() {
		IUserModel user = daoProvider.getUserDao().selectByUsername(getHandle(), actionData.getUsername());
		actionData.setEmail(user.getEmail());
		actionData.setEmailConfirmed(user.getEmailConfirmed());
		actionData.setRole(user.getRole());
		actionData.setUserId(user.getUserId());
	}

}

/*       S.D.G.       */

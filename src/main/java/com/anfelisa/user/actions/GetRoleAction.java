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

import com.anfelisa.ace.AppConfiguration;
import com.anfelisa.ace.DaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.user.data.RoleData;
import com.anfelisa.user.models.IUserModel;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GetRoleAction extends AbstractGetRoleAction {

	static final Logger LOG = LoggerFactory.getLogger(GetRoleAction.class);

	public GetRoleAction(DBI jdbi, AppConfiguration appConfiguration, DaoProvider daoProvider, ViewProvider viewProvider) {
		super(jdbi, appConfiguration, daoProvider, viewProvider);
	}

	@GET
	@Timed
	@Path("/role")
	@PermitAll
	public Response get(@Auth AuthUser principal, @NotNull @QueryParam("uuid") String uuid)
			throws JsonProcessingException {
		this.actionData = new RoleData(uuid).withCredentialsUsername(principal.getUsername());
		return this.apply();
	}

	protected final void loadDataForGetRequest() {
		IUserModel user = daoProvider.userDao.selectByUsername(getHandle(), actionData.getCredentialsUsername());
		if (user == null) {
			throwBadRequest("user " + actionData.getCredentialsUsername() + " not found");
		}
		actionData.setCredentialsRole(user.getRole());
	}

}

/* S.D.G. */

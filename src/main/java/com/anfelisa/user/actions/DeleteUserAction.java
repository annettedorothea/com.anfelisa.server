package com.anfelisa.user.actions;

import javax.annotation.security.PermitAll;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
import com.anfelisa.user.data.DeleteUserData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/user")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
public class DeleteUserAction extends AbstractDeleteUserAction {

	static final Logger LOG = LoggerFactory.getLogger(DeleteUserAction.class);

	public DeleteUserAction(DBI jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(jdbi, appConfiguration, daoProvider, viewProvider);
	}

	@DELETE
	@Timed
	@Path("/delete")
	@PermitAll
	public Response delete(@Auth AuthUser user, @NotNull @QueryParam("deletedUsername") String deletedUsername,
			@NotNull @QueryParam("uuid") String uuid) throws JsonProcessingException {
		this.actionData = new DeleteUserData(uuid).withAuthRole(user.getRole()).withAuthUsername(user.getUsername()).withDeletedUsername(deletedUsername);
		return this.apply();
	}

}

/* S.D.G. */

package com.anfelisa.user.actions;

import javax.annotation.security.RolesAllowed;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.auth.AuthUser;
import com.anfelisa.user.data.PasswordUpdateData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/user")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
	public class ResetPasswordAction extends AbstractResetPasswordAction {

	static final Logger LOG = LoggerFactory.getLogger(ResetPasswordAction.class);

	public ResetPasswordAction(DBI jdbi) {
		super(jdbi);
	}

	@PUT
	@Timed
	@Path("/password")
	@RolesAllowed({ AuthUser.ADMIN })
	public Response put(@Auth AuthUser user, @NotNull @QueryParam("username") String username,
			@NotNull @QueryParam("password") String password, @NotNull @QueryParam("uuid") String uuid)
			throws JsonProcessingException {
		this.actionData = new PasswordUpdateData(uuid).withPassword(password).withUsername(username);
		return this.apply();
	}


}

/*       S.D.G.       */

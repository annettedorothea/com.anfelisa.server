package com.anfelisa.user.actions;

import javax.annotation.security.PermitAll;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.auth.AuthUser;
import com.anfelisa.user.data.UserUpdateData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UpdateUserAction extends AbstractUpdateUserAction {

	static final Logger LOG = LoggerFactory.getLogger(UpdateUserAction.class);

	public UpdateUserAction(DBI jdbi) {
		super(jdbi);
	}

	@PUT
	@Timed
	@Path("/update")
	@PermitAll
	public Response put(@Auth AuthUser user, @NotNull UserUpdateData userUpdateData) throws JsonProcessingException {
		this.actionData = userUpdateData.withCredentialsRole(user.getRole())
				.withCredentialsUsername(user.getUsername());
		return this.apply();
	}

}

/* S.D.G. */

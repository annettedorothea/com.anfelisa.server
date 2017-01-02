package com.anfelisa.user.resources;

import javax.annotation.security.PermitAll;
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

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Resource;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.user.actions.ConfirmEmailAction;
import com.anfelisa.user.data.UsernameData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ConfirmEmailResource extends Resource {

	static final Logger LOG = LoggerFactory.getLogger(ConfirmEmailResource.class);

	public ConfirmEmailResource(DBI jdbi) {
		super(jdbi);
	}

	@PUT
	@Timed
	@Path("/confirm")
	@PermitAll
	public Response put(@Auth AuthUser user, @NotNull @QueryParam("uuid") String uuid,
			@NotNull @QueryParam("schema") String schema) throws JsonProcessingException {
		DatabaseHandle handle = this.createDatabaseHandle();
		UsernameData actionParam = new UsernameData(uuid, schema).withUsername(user.getUsername());
		return new ConfirmEmailAction(actionParam, handle).apply();
	}

}

/* S.D.G. */

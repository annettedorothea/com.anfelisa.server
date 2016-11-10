package com.anfelisa.user.resources;

import javax.annotation.security.PermitAll;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseService;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.user.actions.LoginAction;
import com.anfelisa.user.data.LoginData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoginResource {

	static final Logger LOG = LoggerFactory.getLogger(LoginResource.class);

	@POST
	@Timed
	@Path("/login")
	@PermitAll
	public Response post(@Auth AuthUser principal, @NotNull @QueryParam("uuid") String uuid, @NotNull @QueryParam("schema") String schema)
			throws JsonProcessingException {
		LoginData loginData = new LoginData(null, principal.getUsername(), null, principal.getRole(), uuid, schema);
		return new LoginAction(loginData, DatabaseService.getDatabaseHandle()).apply();
	}

}

/* S.D.G. */

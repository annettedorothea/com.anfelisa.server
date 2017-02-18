package com.anfelisa.user.actions;

import javax.annotation.security.PermitAll;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.joda.time.DateTime;
import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.auth.AuthUser;
import com.anfelisa.user.data.LoginData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/user")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
public class LoginAction extends AbstractLoginAction {

	static final Logger LOG = LoggerFactory.getLogger(LoginAction.class);

	public LoginAction(DBI jdbi) {
		super(jdbi);
	}

	@POST
	@Timed
	@Path("/login")
	@PermitAll
	public Response post(@Auth AuthUser principal, @NotNull @QueryParam("uuid") String uuid)
			throws JsonProcessingException {
		this.actionData = new LoginData(uuid).withUsername(principal.getUsername()).withDate(new DateTime());
		return this.apply();
	}

}

/* S.D.G. */

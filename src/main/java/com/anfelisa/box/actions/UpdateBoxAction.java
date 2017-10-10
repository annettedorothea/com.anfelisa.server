package com.anfelisa.box.actions;

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
import com.anfelisa.box.data.BoxCreationData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/boxes")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
public class UpdateBoxAction extends AbstractUpdateBoxAction {

	static final Logger LOG = LoggerFactory.getLogger(UpdateBoxAction.class);

	public UpdateBoxAction(DBI jdbi, DBI jdbiTimeline) {
		super(jdbi, jdbiTimeline);
	}

	@PUT
	@Timed
	@Path("/update")
	@PermitAll
	public Response put(@NotNull BoxCreationData actionParam, @Auth AuthUser user) throws JsonProcessingException {
		this.actionData = actionParam.withCredentialsUsername(user.getUsername()).withCredentialsRole(user.getRole());
		return this.apply();
	}

}

/* S.D.G. */

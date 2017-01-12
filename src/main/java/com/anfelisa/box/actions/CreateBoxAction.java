package com.anfelisa.box.actions;

import javax.annotation.security.PermitAll;
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

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.auth.AuthUser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

import org.skife.jdbi.v2.DBI;

import com.anfelisa.box.data.BoxCreationData;

@Path("/BoxCreation")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
public class CreateBoxAction extends AbstractCreateBoxAction {

	static final Logger LOG = LoggerFactory.getLogger(CreateBoxAction.class);

	public CreateBoxAction(DBI jdbi) {
		super(jdbi);
	}

	@POST
	@Timed
	@Path("/post")
	@PermitAll
	public Response post(@NotNull BoxCreationData actionParam, @Auth AuthUser user) throws JsonProcessingException {
		BoxCreationData actionData = null;
		return this.apply();
	}

}

/*       S.D.G.       */

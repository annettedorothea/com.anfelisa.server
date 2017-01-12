package com.anfelisa.box.actions;

import javax.annotation.security.PermitAll;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.auth.AuthUser;
import com.anfelisa.box.data.BoxToCourseAdditionData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/boxes")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
public class AddCourseToBoxAction extends AbstractAddCourseToBoxAction {

	static final Logger LOG = LoggerFactory.getLogger(AddCourseToBoxAction.class);

	public AddCourseToBoxAction(DBI jdbi) {
		super(jdbi);
	}

	@POST
	@Timed
	@Path("/addcourse")
	@PermitAll
	public Response post(@NotNull BoxToCourseAdditionData data, @Auth AuthUser user) throws JsonProcessingException {
		this.actionData = data;
		// set AuthUser in actionData
		return this.apply();
	}

}

/*       S.D.G.       */

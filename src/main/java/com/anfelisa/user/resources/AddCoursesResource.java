package com.anfelisa.user.resources;

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

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Resource;
import com.anfelisa.user.actions.AddCoursesAction;
import com.anfelisa.user.data.AddCoursesData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AddCoursesResource extends Resource {

	static final Logger LOG = LoggerFactory.getLogger(AddCoursesResource.class);

	public AddCoursesResource( DBI jdbi ) {
		super(jdbi);
	}

	@POST
	@Timed
	@Path("/courses")
	@PermitAll
	public Response post(@NotNull AddCoursesData addCoursesData) throws JsonProcessingException {
		DatabaseHandle handle = this.createDatabaseHandle();
		return new AddCoursesAction(addCoursesData, handle).apply();
	}

}

/*       S.D.G.       */

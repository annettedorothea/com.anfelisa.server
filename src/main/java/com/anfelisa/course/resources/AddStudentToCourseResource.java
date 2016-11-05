package com.anfelisa.course.resources;

import javax.annotation.security.PermitAll;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseService;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.course.actions.AddStudentToCourseAction;
import com.anfelisa.course.data.StudentToCourseAdditionData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/courses")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AddStudentToCourseResource {

	static final Logger LOG = LoggerFactory.getLogger(AddStudentToCourseResource.class);

	@POST
	@Timed
	@Path("/addstudent")
	@PermitAll
	public Response post(@NotNull StudentToCourseAdditionData actionParam, @Auth AuthUser user) throws JsonProcessingException {
		if (user.getRole().equals(AuthUser.STUDENT) && !actionParam.getUsername().equals(user.getUsername())) {
			throw new WebApplicationException(Response.Status.UNAUTHORIZED);
		}
		return new AddStudentToCourseAction(actionParam, DatabaseService.getDatabaseHandle()).apply();
	}

}

/*       S.D.G.       */

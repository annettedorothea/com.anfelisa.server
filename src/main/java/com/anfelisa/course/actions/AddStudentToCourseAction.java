package com.anfelisa.course.actions;

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
import com.anfelisa.course.data.StudentToCourseAdditionData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/courses")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
public class AddStudentToCourseAction extends AbstractAddStudentToCourseAction {

	static final Logger LOG = LoggerFactory.getLogger(AddStudentToCourseAction.class);

	public AddStudentToCourseAction(DBI jdbi, DBI jdbiTimeline) {
		super(jdbi, jdbiTimeline);
	}

	@POST
	@Timed
	@Path("/addstudent")
	@PermitAll
	public Response post(@NotNull StudentToCourseAdditionData actionParam, @Auth AuthUser user)
			throws JsonProcessingException {
		this.actionData = actionParam.withCredentialsRole(user.getRole()).withCredentialsUsername(user.getUsername());
		return this.apply();
	}

}

/* S.D.G. */

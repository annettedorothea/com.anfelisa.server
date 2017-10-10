package com.anfelisa.course.actions;

import javax.annotation.security.RolesAllowed;
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
import com.anfelisa.course.data.CourseData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/courses")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UpdateCourseAction extends AbstractUpdateCourseAction {

	static final Logger LOG = LoggerFactory.getLogger(UpdateCourseAction.class);

	public UpdateCourseAction(DBI jdbi, DBI jdbiTimeline) {
		super(jdbi, jdbiTimeline);
	}

	@PUT
	@Timed
	@Path("/update")
	@RolesAllowed({ AuthUser.AUTHOR, AuthUser.ADMIN })
	public Response put(@NotNull CourseData courseData) throws JsonProcessingException {
		this.actionData = courseData;
		return this.apply();
	}

}

/* S.D.G. */

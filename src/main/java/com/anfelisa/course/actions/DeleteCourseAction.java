package com.anfelisa.course.actions;

import javax.annotation.security.RolesAllowed;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.auth.AuthUser;
import com.anfelisa.course.data.CourseIdData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/courses")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
	public class DeleteCourseAction extends AbstractDeleteCourseAction {

	static final Logger LOG = LoggerFactory.getLogger(DeleteCourseAction.class);

	public DeleteCourseAction(DBI jdbi) {
		super(jdbi);
	}

	@DELETE
	@Timed
	@Path("/delete")
	@RolesAllowed({ AuthUser.AUTHOR, AuthUser.ADMIN })
	public Response delete(@NotNull @QueryParam("uuid") String uuid, @NotNull @QueryParam("courseId") Integer courseId) throws JsonProcessingException {
		this.actionData = new CourseIdData(uuid).withCourseId(courseId);
		return this.apply();
	}


}

/*       S.D.G.       */
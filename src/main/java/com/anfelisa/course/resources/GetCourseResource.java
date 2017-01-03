package com.anfelisa.course.resources;

import javax.annotation.security.RolesAllowed;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Resource;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.course.actions.GetCourseAction;
import com.anfelisa.course.data.CourseData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/courses")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GetCourseResource extends Resource {

	static final Logger LOG = LoggerFactory.getLogger(GetCourseResource.class);

	public GetCourseResource(DBI jdbi) {
		super(jdbi);
	}

	@GET
	@Timed
	@Path("/single")
	@RolesAllowed({ AuthUser.ADMIN, AuthUser.AUTHOR })
	public Response get(@NotNull @QueryParam("uuid") String uuid, @NotNull @QueryParam("schema") String schema,
			@NotNull @QueryParam("courseId") Integer courseId) throws JsonProcessingException {
		DatabaseHandle handle = this.createDatabaseHandle();
		CourseData actionParam = new CourseData(uuid, schema).withCourseId(courseId); // init
																						// actionParam
		return new GetCourseAction(actionParam, handle).apply();
	}

}

/* S.D.G. */

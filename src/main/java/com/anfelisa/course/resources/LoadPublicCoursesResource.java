package com.anfelisa.course.resources;

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

import com.anfelisa.ace.Resource;
import com.anfelisa.course.actions.LoadPublicCoursesAction;
import com.anfelisa.course.data.CourseListData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/courses")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoadPublicCoursesResource extends Resource {

	static final Logger LOG = LoggerFactory.getLogger(LoadPublicCoursesResource.class);

	public LoadPublicCoursesResource(DBI jdbi) {
		super(jdbi);
	}

	@GET
	@Timed
	@Path("/public")
	public Response get(@NotNull @QueryParam("uuid") String uuid, @NotNull @QueryParam("schema") String schema)
			throws JsonProcessingException {
		CourseListData actionParam = new CourseListData(uuid, schema);
		return new LoadPublicCoursesAction(actionParam, this.createDatabaseHandle()).apply();
	}

}

/* S.D.G. */

package com.anfelisa.lesson.resources;

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
import com.anfelisa.lesson.actions.LoadPublicLessonsAction;
import com.anfelisa.lesson.data.LessonListData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/lessons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoadPublicLessonsResource extends Resource {

	static final Logger LOG = LoggerFactory.getLogger(LoadPublicLessonsResource.class);

	public LoadPublicLessonsResource(DBI jdbi) {
		super(jdbi);
	}

	@GET
	@Timed
	@Path("/public")
	public Response get(@NotNull @QueryParam("uuid") String uuid, @NotNull @QueryParam("schema") String schema,
			@NotNull @QueryParam("courseId") Integer courseId) throws JsonProcessingException {
		LessonListData actionParam = new LessonListData(courseId, null, null, null, null, uuid, schema);
		return new LoadPublicLessonsAction(actionParam, this.createDatabaseHandle()).apply();
	}

}

/* S.D.G. */

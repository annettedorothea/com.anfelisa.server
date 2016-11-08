package com.anfelisa.lesson.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseService;
import com.anfelisa.lesson.actions.LoadPublicLessonsAction;
import com.anfelisa.lesson.data.LessonListData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/lessons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoadPublicLessonsResource {

	static final Logger LOG = LoggerFactory.getLogger(LoadPublicLessonsResource.class);

	@GET
	@Timed
	@Path("/public")
	public Response get(@QueryParam("uuid") String uuid, @QueryParam("schema") String schema, @QueryParam("courseid") Integer courseId) throws JsonProcessingException {
		LessonListData actionParam = new LessonListData(courseId, null, null, null, null, uuid, schema);
		return new LoadPublicLessonsAction(actionParam, DatabaseService.getDatabaseHandle()).apply();
	}

}

/*       S.D.G.       */

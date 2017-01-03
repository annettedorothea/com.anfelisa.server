package com.anfelisa.lesson.resources;

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
import com.anfelisa.lesson.actions.GetLessonAction;
import com.anfelisa.lesson.data.LessonData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/lessons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GetLessonResource extends Resource {

	static final Logger LOG = LoggerFactory.getLogger(GetLessonResource.class);

	public GetLessonResource( DBI jdbi ) {
		super(jdbi);
	}

	@GET
	@Timed
	@Path("/single")
	@RolesAllowed({AuthUser.ADMIN,AuthUser.AUTHOR})
	public Response get(@NotNull @QueryParam("uuid") String uuid, @NotNull @QueryParam("schema") String schema,
			@NotNull @QueryParam("lessonId") Integer lessonId) throws JsonProcessingException {
		DatabaseHandle handle = this.createDatabaseHandle();
		LessonData actionParam = new LessonData(uuid, schema).withLessonId(lessonId);  // init actionParam
		return new GetLessonAction(actionParam, handle).apply();
	}

}

/*       S.D.G.       */

package com.anfelisa.lesson.resources;

import javax.annotation.security.PermitAll;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Resource;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.course.models.CustomCourseDao;
import com.anfelisa.course.models.ICourseModel;
import com.anfelisa.lesson.actions.LoadPrivateLessonsAction;
import com.anfelisa.lesson.data.MyLessonListData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/lessons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoadPrivateLessonsResource extends Resource {

	static final Logger LOG = LoggerFactory.getLogger(LoadPrivateLessonsResource.class);

	public LoadPrivateLessonsResource(DBI jdbi) {
		super(jdbi);
	}

	@GET
	@Timed
	@Path("/private")
	@PermitAll
	public Response get(@Auth AuthUser user, @NotNull @QueryParam("uuid") String uuid,
			@NotNull @QueryParam("schema") String schema, @NotNull @QueryParam("courseId") Integer courseId)
			throws JsonProcessingException {
		DatabaseHandle handle = this.createDatabaseHandle();
		ICourseModel course = CustomCourseDao.selectByCourseIdAndUsername(handle.getHandle(), courseId,
				user.getUsername(), schema);
		if (course == null) {
			handle.close();
			throw new WebApplicationException(Response.Status.BAD_REQUEST);
		}
		MyLessonListData actionParam = new MyLessonListData(uuid, schema).withUsername(user.getUsername())
				.withCourseId(courseId);
		return new LoadPrivateLessonsAction(actionParam, handle).apply();
	}

}

/* S.D.G. */

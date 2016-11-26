package com.anfelisa.test.resources;

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
import com.anfelisa.lesson.models.CustomLessonDao;
import com.anfelisa.lesson.models.ILessonModel;
import com.anfelisa.test.actions.LoadPrivateTestsAction;
import com.anfelisa.test.data.MyTestListData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/tests")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoadPrivateTestsResource extends Resource {

	static final Logger LOG = LoggerFactory.getLogger(LoadPrivateTestsResource.class);

	public LoadPrivateTestsResource( DBI jdbi ) {
		super(jdbi);
	}

	@GET
	@Timed
	@Path("/private")
	@PermitAll
	public Response get(@Auth AuthUser user, @NotNull @QueryParam("uuid") String uuid,
			@NotNull @QueryParam("schema") String schema, @NotNull @QueryParam("lessonId") Integer lessonId) throws JsonProcessingException {
		DatabaseHandle handle = this.createDatabaseHandle();
		ILessonModel course = CustomLessonDao.selectByLessonIdAndUsername(handle.getHandle(), lessonId, user.getUsername(), schema);
		if (course == null) {
			handle.close();
			throw new WebApplicationException(Response.Status.BAD_REQUEST);
		}
		MyTestListData actionParam = new MyTestListData(lessonId, null, null, null, null, null, null, null, null, uuid, schema);
		return new LoadPrivateTestsAction(actionParam, handle).apply();
	}

}

/*       S.D.G.       */

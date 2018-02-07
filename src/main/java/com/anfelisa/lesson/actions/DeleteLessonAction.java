package com.anfelisa.lesson.actions;

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
import com.anfelisa.lesson.data.LessonIdData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/lessons")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
	public class DeleteLessonAction extends AbstractDeleteLessonAction {

	static final Logger LOG = LoggerFactory.getLogger(DeleteLessonAction.class);

	public DeleteLessonAction(DBI jdbi, DBI jdbiTimeline) {
		super(jdbi, jdbiTimeline);
	}

	@DELETE
	@Timed
	@Path("/delete")
	@RolesAllowed({ AuthUser.AUTHOR, AuthUser.ADMIN })
	public Response delete(@NotNull @QueryParam("uuid") String uuid, @NotNull @QueryParam("lessonId") Integer lessonId) throws JsonProcessingException {
		this.actionData = new LessonIdData(uuid).withLessonId(lessonId);
		return this.apply();
	}


}

/*       S.D.G.       */

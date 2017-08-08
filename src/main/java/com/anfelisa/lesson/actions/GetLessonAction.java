package com.anfelisa.lesson.actions;

import javax.annotation.security.RolesAllowed;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.process.internal.RequestScoped;
import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.auth.AuthUser;
import com.anfelisa.lesson.data.LessonData;
import com.anfelisa.lesson.models.ILessonModel;
import com.anfelisa.lesson.models.LessonDao;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/lessons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class GetLessonAction extends AbstractGetLessonAction {

	static final Logger LOG = LoggerFactory.getLogger(GetLessonAction.class);

	private LessonDao lessonDao = new LessonDao();

	public GetLessonAction(DBI jdbi, DBI jdbiTimeline) {
		super(jdbi, jdbiTimeline);
	}

	@GET
	@Timed
	@Path("/single")
	@RolesAllowed({ AuthUser.ADMIN, AuthUser.AUTHOR })
	public Response get(@NotNull @QueryParam("uuid") String uuid, @NotNull @QueryParam("lessonId") Integer lessonId)
			throws JsonProcessingException {
		this.actionData = new LessonData(uuid).withLessonId(lessonId);
		return this.apply();
	}

	protected final void loadDataForGetRequest() {
		ILessonModel lesson = lessonDao.selectByLessonId(this.getDatabaseHandle().getHandle(),
				this.actionData.getLessonId());
		if (lesson != null) {
			this.actionData.setAuthor(lesson.getAuthor());
			this.actionData.setCourseId(lesson.getCourseId());
			this.actionData.setDescription(lesson.getDescription());
			this.actionData.setName(lesson.getName());
			this.actionData.setSequence(lesson.getSequence());
		}
	}

}

/* S.D.G. */

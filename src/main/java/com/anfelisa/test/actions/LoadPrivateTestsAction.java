package com.anfelisa.test.actions;

import javax.annotation.security.PermitAll;
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

import com.anfelisa.auth.AuthUser;
import com.anfelisa.course.models.CustomCourseDao;
import com.anfelisa.course.models.ICourseModel;
import com.anfelisa.lesson.models.CustomLessonDao;
import com.anfelisa.lesson.models.ILessonModel;
import com.anfelisa.test.data.MyTestListData;
import com.anfelisa.test.models.CustomTestDao;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/tests")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoadPrivateTestsAction extends AbstractLoadPrivateTestsAction {

	static final Logger LOG = LoggerFactory.getLogger(LoadPrivateTestsAction.class);

	public LoadPrivateTestsAction(DBI jdbi) {
		super(jdbi);
	}

	@GET
	@Timed
	@Path("/private")
	@PermitAll
	public Response get(@Auth AuthUser user, @NotNull @QueryParam("uuid") String uuid,
			@NotNull @QueryParam("schema") String schema, @NotNull @QueryParam("lessonId") Integer lessonId)
			throws JsonProcessingException {
		this.actionData = new MyTestListData(uuid, schema).withLessonId(lessonId).withUsername(user.getUsername());
		return this.apply();
	}

	protected final void loadDataForGetRequest() {
		ILessonModel lesson = CustomLessonDao.selectByLessonIdAndUsername(this.getHandle(), actionData.getLessonId(),
				actionData.getUsername(), actionData.getSchema());
		if (lesson == null) {
			throwBadRequest();
		}
		this.actionData.setLessonDescription(lesson.getDescription());
		this.actionData.setLessonAuthor(lesson.getAuthor());
		this.actionData.setLessonName(lesson.getName());
		ICourseModel course = CustomCourseDao.selectByLessonId(this.getDatabaseHandle().getHandle(),
				this.actionData.getLessonId(), this.getActionData().getSchema());
		this.actionData.setCourseAuthor(course.getAuthor());
		this.actionData.setCourseDescription(course.getDescription());
		this.actionData.setCourseName(course.getName());
		this.actionData.setCourseId(course.getCourseId());
		this.actionData.setMyTestList(CustomTestDao.selectMyTests(this.getDatabaseHandle().getHandle(),
				this.getActionData().getSchema(), this.actionData.getLessonId(), this.actionData.getUsername()));

	}

}

/* S.D.G. */

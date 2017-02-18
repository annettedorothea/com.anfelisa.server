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
import com.anfelisa.test.data.MyTestData;
import com.anfelisa.test.models.CustomTestDao;
import com.anfelisa.test.models.ITestModel;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/tests")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoadPrivateTestAction extends AbstractLoadPrivateTestAction {

	static final Logger LOG = LoggerFactory.getLogger(LoadPrivateTestAction.class);

	private CustomLessonDao customLessonDao = new CustomLessonDao();

	private CustomCourseDao customCourseDao = new CustomCourseDao();

	private CustomTestDao customTestDao = new CustomTestDao();

	public LoadPrivateTestAction(DBI jdbi) {
		super(jdbi);
	}

	@GET
	@Timed
	@Path("/private/single")
	@PermitAll
	public Response get(@Auth AuthUser user, @NotNull @QueryParam("uuid") String uuid,
			@NotNull @QueryParam("testId") Integer testId) throws JsonProcessingException {
		this.actionData = new MyTestData(uuid).withTestId(testId).withUsername(user.getUsername());
		return this.apply();
	}

	protected final void loadDataForGetRequest() {
		ITestModel test = customTestDao.selectByTestIdAndUsername(this.getHandle(), actionData.getTestId(),
				actionData.getUsername());
		if (test == null) {
			throwBadRequest();
		}

		ILessonModel lesson = customLessonDao.selectByTestId(this.getDatabaseHandle().getHandle(),
				this.actionData.getTestId());
		this.actionData.setLessonDescription(lesson.getDescription());
		this.actionData.setLessonAuthor(lesson.getAuthor());
		this.actionData.setLessonName(lesson.getName());
		this.actionData.setLessonId(lesson.getLessonId());

		ICourseModel course = customCourseDao.selectByLessonId(this.getDatabaseHandle().getHandle(),
				lesson.getLessonId());
		this.actionData.setCourseAuthor(course.getAuthor());
		this.actionData.setCourseDescription(course.getDescription());
		this.actionData.setCourseName(course.getName());
		this.actionData.setCourseId(course.getCourseId());

		this.actionData.setAuthor(test.getAuthor());
		this.actionData.setHtml(test.getHtml());
		this.actionData.setName(test.getName());
		this.actionData.setMyTestList(customTestDao.selectMyTests(this.getDatabaseHandle().getHandle(),
				this.actionData.getLessonId(), this.actionData.getUsername()));
	}

}

/* S.D.G. */

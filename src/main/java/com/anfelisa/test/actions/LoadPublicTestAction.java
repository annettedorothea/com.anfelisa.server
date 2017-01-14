package com.anfelisa.test.actions;

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

import com.anfelisa.course.models.CustomCourseDao;
import com.anfelisa.course.models.ICourseModel;
import com.anfelisa.lesson.models.CustomLessonDao;
import com.anfelisa.lesson.models.ILessonModel;
import com.anfelisa.test.data.TestData;
import com.anfelisa.test.models.CustomTestDao;
import com.anfelisa.test.models.ITestModel;
import com.anfelisa.test.models.TestDao;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/tests")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoadPublicTestAction extends AbstractLoadPublicTestAction {

	static final Logger LOG = LoggerFactory.getLogger(LoadPublicTestAction.class);

	public LoadPublicTestAction(DBI jdbi) {
		super(jdbi);
	}

	@GET
	@Timed
	@Path("/public/single")
	public Response get(@NotNull @QueryParam("uuid") String uuid, @NotNull @QueryParam("schema") String schema,
			@NotNull @QueryParam("testId") Integer testId) throws JsonProcessingException {
		this.actionData = new TestData(uuid, schema).withTestId(testId);
		return this.apply();
	}

	protected final void loadDataForGetRequest() {
		ILessonModel lesson = CustomLessonDao.selectByTestId(this.getDatabaseHandle().getHandle(),
				this.actionData.getTestId(), this.getActionData().getSchema());
		if (lesson == null) {
			throwBadRequest();
		}
		this.actionData.setLessonDescription(lesson.getDescription());
		this.actionData.setLessonAuthor(lesson.getAuthor());
		this.actionData.setLessonName(lesson.getName());
		this.actionData.setLessonId(lesson.getLessonId());
		ICourseModel course = CustomCourseDao.selectByLessonId(this.getDatabaseHandle().getHandle(),
				lesson.getLessonId(), this.getActionData().getSchema());
		if (course == null) {
			throwBadRequest();
		}
		this.actionData.setCourseAuthor(course.getAuthor());
		this.actionData.setCourseDescription(course.getDescription());
		this.actionData.setCourseName(course.getName());
		this.actionData.setCourseId(course.getCourseId());
		ITestModel test = TestDao.selectByTestId(this.getDatabaseHandle().getHandle(), this.actionData.getTestId(),
				this.getActionData().getSchema());
		if (test == null) {
			throwBadRequest();
		}
		this.actionData.setAuthor(test.getAuthor());
		this.actionData.setHtml(test.getHtml());
		this.actionData.setName(test.getName());
		this.actionData.setTestList(CustomTestDao.selectTests(this.getDatabaseHandle().getHandle(),
				this.getActionData().getSchema(), this.actionData.getLessonId()));
	}

}

/* S.D.G. */

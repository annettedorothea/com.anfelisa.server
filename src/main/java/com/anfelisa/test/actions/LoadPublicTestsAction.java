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
import com.anfelisa.lesson.models.ILessonModel;
import com.anfelisa.lesson.models.LessonDao;
import com.anfelisa.test.data.TestListData;
import com.anfelisa.test.models.CustomTestDao;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/tests")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoadPublicTestsAction extends AbstractLoadPublicTestsAction {

	static final Logger LOG = LoggerFactory.getLogger(LoadPublicTestsAction.class);

	private CustomCourseDao customCourseDao = new CustomCourseDao();

	private LessonDao lessonDao = new LessonDao();

	private CustomTestDao customTestDao = new CustomTestDao();

	public LoadPublicTestsAction(DBI jdbi, DBI jdbiTimeline) {
		super(jdbi, jdbiTimeline);
	}

	@GET
	@Timed
	@Path("/public")
	public Response get(@NotNull @QueryParam("uuid") String uuid, @NotNull @QueryParam("lessonId") Integer lessonId)
			throws JsonProcessingException {
		this.actionData = new TestListData(uuid).withLessonId(lessonId);
		return this.apply();
	}

	protected final void loadDataForGetRequest() {
		ILessonModel lesson = lessonDao.selectByLessonId(this.getDatabaseHandle().getHandle(),
				this.actionData.getLessonId());
		if (lesson == null) {
			throwBadRequest();
		}
		this.actionData.setLessonDescription(lesson.getDescription());
		this.actionData.setLessonAuthor(lesson.getAuthor());
		this.actionData.setLessonName(lesson.getName());
		ICourseModel course = customCourseDao.selectByLessonId(this.getDatabaseHandle().getHandle(),
				this.actionData.getLessonId());
		if (course == null) {
			throwBadRequest();
		}
		this.actionData.setCourseAuthor(course.getAuthor());
		this.actionData.setCourseDescription(course.getDescription());
		this.actionData.setCourseName(course.getName());
		this.actionData.setCourseId(course.getCourseId());
		this.actionData.setTestList(
				customTestDao.selectTests(this.getDatabaseHandle().getHandle(), this.actionData.getLessonId()));
	}

}

/* S.D.G. */

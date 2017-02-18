package com.anfelisa.lesson.actions;

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

import com.anfelisa.course.models.CourseDao;
import com.anfelisa.course.models.ICourseModel;
import com.anfelisa.lesson.data.LessonListData;
import com.anfelisa.lesson.models.CustomLessonDao;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/lessons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class LoadPublicLessonsAction extends AbstractLoadPublicLessonsAction {

	static final Logger LOG = LoggerFactory.getLogger(LoadPublicLessonsAction.class);

	private CustomLessonDao customLessonDao = new CustomLessonDao();

	private CourseDao courseDao = new CourseDao();

	public LoadPublicLessonsAction(DBI jdbi) {
		super(jdbi);
	}

	@GET
	@Timed
	@Path("/public")
	public Response get(@NotNull @QueryParam("uuid") String uuid, @NotNull @QueryParam("courseId") Integer courseId)
			throws JsonProcessingException {
		this.actionData = new LessonListData(uuid).withCourseId(courseId);
		;
		return this.apply();
	}

	protected final void loadDataForGetRequest() {
		ICourseModel course = courseDao.selectByCourseId(this.getDatabaseHandle().getHandle(),
				this.actionData.getCourseId());
		if (course == null) {
			throwBadRequest();
		} else {
			this.actionData.setCourseDescription(course.getDescription());
			this.actionData.setCourseAuthor(course.getAuthor());
			this.actionData.setIsPublic(course.getIsPublic());
			this.actionData.setCourseName(course.getName());
			this.actionData.setLessonList(
					customLessonDao.selectLessons(this.getDatabaseHandle().getHandle(), this.actionData.getCourseId()));
		}
	}

}

/* S.D.G. */

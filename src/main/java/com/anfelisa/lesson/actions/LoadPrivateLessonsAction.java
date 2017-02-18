package com.anfelisa.lesson.actions;

import javax.annotation.security.PermitAll;
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
import com.anfelisa.course.models.CustomCourseDao;
import com.anfelisa.course.models.ICourseModel;
import com.anfelisa.lesson.data.MyLessonListData;
import com.anfelisa.lesson.models.CustomLessonDao;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/lessons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class LoadPrivateLessonsAction extends AbstractLoadPrivateLessonsAction {

	static final Logger LOG = LoggerFactory.getLogger(LoadPrivateLessonsAction.class);

	private CustomCourseDao customCourseDao = new CustomCourseDao();

	private CustomLessonDao customLessonDao = new CustomLessonDao();

	public LoadPrivateLessonsAction(DBI jdbi) {
		super(jdbi);
	}

	@GET
	@Timed
	@Path("/private")
	@PermitAll
	public Response get(@Auth AuthUser user, @NotNull @QueryParam("uuid") String uuid,
			@NotNull @QueryParam("courseId") Integer courseId) throws JsonProcessingException {
		this.actionData = new MyLessonListData(uuid).withCourseId(courseId).withUsername(user.getUsername());
		return this.apply();
	}

	protected final void loadDataForGetRequest() {
		ICourseModel course = customCourseDao.selectByCourseIdAndUsername(this.getHandle(),
				this.actionData.getCourseId(), this.actionData.getUsername());
		if (course == null) {
			throwBadRequest();
		} else {
			this.actionData.setCourseDescription(course.getDescription());
			this.actionData.setCourseAuthor(course.getAuthor());
			this.actionData.setIsPublic(course.getIsPublic());
			this.actionData.setCourseName(course.getName());
			this.actionData.setMyLessonList(customLessonDao.selectMyLessons(this.getDatabaseHandle().getHandle(),
					this.actionData.getCourseId(), this.actionData.getUsername()));
		}
	}

}

/* S.D.G. */

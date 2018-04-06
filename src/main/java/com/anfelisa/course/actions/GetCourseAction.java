package com.anfelisa.course.actions;

import javax.annotation.security.RolesAllowed;
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
import com.anfelisa.course.data.CourseData;
import com.anfelisa.course.models.CourseDao;
import com.anfelisa.course.models.ICourseModel;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/courses")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GetCourseAction extends AbstractGetCourseAction {

	static final Logger LOG = LoggerFactory.getLogger(GetCourseAction.class);

	private CourseDao courseDao = new CourseDao();

	public GetCourseAction(DBI jdbi) {
		super(jdbi);
	}

	@GET
	@Timed
	@Path("/single")
	@RolesAllowed({ AuthUser.ADMIN, AuthUser.AUTHOR })
	public Response get(@NotNull @QueryParam("uuid") String uuid, @NotNull @QueryParam("courseId") String courseId)
			throws JsonProcessingException {
		this.actionData = new CourseData(uuid).withCourseId(courseId);
		return this.apply();
	}

	protected final void loadDataForGetRequest() {
		ICourseModel course = courseDao.selectByCourseId(this.getDatabaseHandle().getHandle(),
				this.actionData.getCourseId());
		if (course != null) {
			this.actionData.setAuthor(course.getAuthor());
			this.actionData.setDescription(course.getDescription());
			this.actionData.setName(course.getName());
			this.actionData.setSequence(course.getSequence());
		}
	}

}

/* S.D.G. */

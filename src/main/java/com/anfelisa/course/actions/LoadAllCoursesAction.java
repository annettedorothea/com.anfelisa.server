package com.anfelisa.course.actions;

import java.util.List;

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
import com.anfelisa.course.data.CourseListData;
import com.anfelisa.course.models.CourseDao;
import com.anfelisa.course.models.ICourseModel;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/courses")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
	public class LoadAllCoursesAction extends AbstractLoadAllCoursesAction {

	static final Logger LOG = LoggerFactory.getLogger(LoadAllCoursesAction.class);

	private CourseDao courseDao = new CourseDao();
	
	public LoadAllCoursesAction(DBI jdbi) {
		super(jdbi);
	}

	@GET
	@Timed
	@Path("/all")
	@RolesAllowed({ AuthUser.AUTHOR, AuthUser.ADMIN })
	public Response get(@NotNull @QueryParam("uuid") String uuid) throws JsonProcessingException {
		this.actionData = new CourseListData(uuid);
		return this.apply();
	}

	protected final void loadDataForGetRequest() {
		List<ICourseModel> courses = courseDao.selectAll(getHandle());
		this.actionData.setCourseList(courses);
	}

}

/*       S.D.G.       */

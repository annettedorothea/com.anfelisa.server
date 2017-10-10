package com.anfelisa.course.actions;

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
import com.anfelisa.course.data.MyCourseListData;
import com.anfelisa.course.models.CustomCourseDao;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/courses")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoadPrivateCoursesAction extends AbstractLoadPrivateCoursesAction {

	static final Logger LOG = LoggerFactory.getLogger(LoadPrivateCoursesAction.class);

	private CustomCourseDao customCourseDao = new CustomCourseDao();

	public LoadPrivateCoursesAction(DBI jdbi, DBI jdbiTimeline) {
		super(jdbi, jdbiTimeline);
	}

	@GET
	@Timed
	@Path("/private")
	@PermitAll
	public Response get(@Auth AuthUser user, @NotNull @QueryParam("uuid") String uuid) throws JsonProcessingException {
		this.actionData = new MyCourseListData(uuid).withUsername(user.getUsername());
		return this.apply();
	}

	protected final void loadDataForGetRequest() {
		this.actionData.setMyCourseList(
				customCourseDao.selectMyCourses(this.getDatabaseHandle().getHandle(), this.actionData.getUsername()));
	}

}

/* S.D.G. */

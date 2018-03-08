package com.anfelisa.user.actions;

import java.util.List;

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
import com.anfelisa.user.data.CourseSelectionData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GetCourseSelectionAction extends AbstractGetCourseSelectionAction {

	static final Logger LOG = LoggerFactory.getLogger(GetCourseSelectionAction.class);

	private CustomCourseDao customCourseDao = new CustomCourseDao();

	public GetCourseSelectionAction(DBI jdbi) {
		super(jdbi);
	}

	@GET
	@Timed
	@Path("/courses")
	@PermitAll
	public Response get(@Auth AuthUser user, @NotNull @QueryParam("uuid") String uuid) throws JsonProcessingException {
		this.actionData = new CourseSelectionData(uuid).withCredentialsUsername(user.getUsername())
				.withCredentialsRole(user.getRole());
		return this.apply();
	}

	protected final void loadDataForGetRequest() {
		List<ICourseModel> courses;
		if (AuthUser.STUDENT.equals(this.actionData.getCredentialsRole())) {
			courses = customCourseDao.selectCourseSelection(this.getDatabaseHandle().getHandle(),
					this.actionData.getCredentialsUsername());
		} else {
			courses = customCourseDao.selectCourseSelectionPremium(this.getDatabaseHandle().getHandle(),
					this.actionData.getCredentialsUsername());
		}
		this.actionData.setCourseList(courses);
	}

}

/* S.D.G. */

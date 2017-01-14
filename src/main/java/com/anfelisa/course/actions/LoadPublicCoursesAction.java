package com.anfelisa.course.actions;

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

import com.anfelisa.course.data.CourseListData;
import com.anfelisa.course.models.CustomCourseDao;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/courses")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoadPublicCoursesAction extends AbstractLoadPublicCoursesAction {

	static final Logger LOG = LoggerFactory.getLogger(LoadPublicCoursesAction.class);

	public LoadPublicCoursesAction(DBI jdbi) {
		super(jdbi);
	}

	@GET
	@Timed
	@Path("/public")
	public Response get(@NotNull @QueryParam("uuid") String uuid, @NotNull @QueryParam("schema") String schema)
			throws JsonProcessingException {
		this.actionData = new CourseListData(uuid, schema);
		return this.apply();
	}

	protected final void loadDataForGetRequest() {
		this.actionData.setCourseList(
				CustomCourseDao.selectPublic(this.getDatabaseHandle().getHandle(), this.getActionData().getSchema()));
	}

}

/* S.D.G. */

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
import com.anfelisa.box.models.CustomBoxDao;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.course.models.CustomCourseDao;
import com.anfelisa.course.models.ICourseModel;
import com.anfelisa.user.data.UserInfoData;
import com.anfelisa.user.models.IUserModel;
import com.anfelisa.user.models.UserDao;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GetUserInfoAction extends AbstractGetUserInfoAction {

	static final Logger LOG = LoggerFactory.getLogger(GetUserInfoAction.class);

	private UserDao userDao = new UserDao();

	private CustomCourseDao customCourseDao = new CustomCourseDao();

	private CustomBoxDao customBoxDao = new CustomBoxDao();

	public GetUserInfoAction(DBI jdbi, DBI jdbiTimeline) {
		super(jdbi, jdbiTimeline);
	}

	@GET
	@Timed
	@Path("/info")
	@PermitAll
	public Response get(@Auth AuthUser user, @NotNull @QueryParam("uuid") String uuid) throws JsonProcessingException {
		this.actionData = new UserInfoData(uuid).withUsername(user.getUsername());
		return this.apply();
	}

	protected final void loadDataForGetRequest() {
		IUserModel user = userDao.selectByUsername(this.getDatabaseHandle().getHandle(), this.actionData.getUsername());
		this.actionData.setEmail(user.getEmail());
		this.actionData.setName(user.getName());
		this.actionData.setPrename(user.getPrename());

		List<ICourseModel> courseList = customCourseDao.selectCourses(this.getDatabaseHandle().getHandle(),
				this.actionData.getUsername());
		this.actionData.setCourseList(courseList);

		List<IBoxModel> boxList = customBoxDao.selectByUsername(this.getDatabaseHandle().getHandle(),
				this.actionData.getUsername());
		this.actionData.setBoxList(boxList);
	}

}

/* S.D.G. */

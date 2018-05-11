package com.anfelisa.user.actions;

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

import com.anfelisa.ace.AppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.user.data.UserListData;
import com.anfelisa.user.models.CustomUserDao;
import com.anfelisa.user.models.IUserModel;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GetAllUsersAction extends AbstractGetAllUsersAction {

	static final Logger LOG = LoggerFactory.getLogger(GetAllUsersAction.class);

	private CustomUserDao userDao = new CustomUserDao();

	public GetAllUsersAction(DBI jdbi, AppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(jdbi, appConfiguration, daoProvider, viewProvider);
	}

	@GET
	@Timed
	@Path("/all")
	@RolesAllowed({ AuthUser.ADMIN })
	public Response get(@NotNull @QueryParam("uuid") String uuid) throws JsonProcessingException {
		this.actionData = new UserListData(uuid);
		return this.apply();
	}

	protected final void loadDataForGetRequest() {
		List<IUserModel> users = userDao.selectAll(getHandle());
		this.actionData.setUserList(users);
	}

}

/* S.D.G. */

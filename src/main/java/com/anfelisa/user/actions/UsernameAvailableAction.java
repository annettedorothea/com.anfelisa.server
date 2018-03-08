package com.anfelisa.user.actions;

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

import com.anfelisa.user.data.UsernameAvailableData;
import com.anfelisa.user.models.UserDao;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsernameAvailableAction extends AbstractUsernameAvailableAction {

	static final Logger LOG = LoggerFactory.getLogger(UsernameAvailableAction.class);

	private UserDao userDao = new UserDao();

	public UsernameAvailableAction(DBI jdbi) {
		super(jdbi);
	}

	@GET
	@Timed
	@Path("/username")
	public Response get(@NotNull @QueryParam("uuid") String uuid, @NotNull @QueryParam("username") String username)
			throws JsonProcessingException {
		this.actionData = new UsernameAvailableData(uuid).withUsername(username);
		return this.apply();
	}

	protected final void loadDataForGetRequest() {
		if (userDao.selectByUsername(this.getDatabaseHandle().getHandle(), this.actionData.getUsername()) == null) {
			this.actionData.setAvailable(true);
		} else {
			this.actionData.setAvailable(false);
		}
	}

}

/* S.D.G. */

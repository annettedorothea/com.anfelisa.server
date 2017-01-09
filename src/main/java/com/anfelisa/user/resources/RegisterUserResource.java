package com.anfelisa.user.resources;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Resource;
import com.anfelisa.user.actions.RegisterUserAction;
import com.anfelisa.user.data.UserRegistrationData;
import com.anfelisa.user.models.IUserModel;
import com.anfelisa.user.models.UserDao;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/users")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
public class RegisterUserResource extends Resource {

	static final Logger LOG = LoggerFactory.getLogger(RegisterUserResource.class);

	public RegisterUserResource(DBI jdbi) {
		super(jdbi);
	}

	@POST
	@Timed
	@Path("/register")
	public Response post(@NotNull UserRegistrationData userCreationData) throws JsonProcessingException {
		DatabaseHandle handle = this.createDatabaseHandle();
		IUserModel user = UserDao.selectByUsername(handle.getHandle(), userCreationData.getUsername(), userCreationData.getSchema());
		if (user != null) {
			handle.close();
			throw new WebApplicationException(Response.Status.BAD_REQUEST);
		}
		return new RegisterUserAction(userCreationData, handle).apply();
	}

}

/* S.D.G. */

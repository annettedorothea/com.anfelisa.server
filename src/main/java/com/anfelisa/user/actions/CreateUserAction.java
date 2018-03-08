package com.anfelisa.user.actions;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.user.data.UserCreationData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/users")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
public class CreateUserAction extends AbstractCreateUserAction {

	static final Logger LOG = LoggerFactory.getLogger(CreateUserAction.class);

	public CreateUserAction(DBI jdbi) {
		super(jdbi);
	}

	@POST
	@Timed
	@Path("/create")
	public Response post(@NotNull UserCreationData userCreationData) throws JsonProcessingException {
		this.actionData = userCreationData;
		return this.apply();
	}

}

/* S.D.G. */

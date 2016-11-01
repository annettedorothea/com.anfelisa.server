package com.anfelisa.user.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseService;
import com.anfelisa.user.actions.CreateUserAction;
import com.anfelisa.user.data.UserCreationData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/{schema}/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CreateUserResource {

	static final Logger LOG = LoggerFactory.getLogger(CreateUserResource.class);

	@POST
	@Timed
	@Path("/create")
	public Response post(UserCreationData userCreationData) throws JsonProcessingException {
		return new CreateUserAction(userCreationData, DatabaseService.getDatabaseHandle()).apply();
	}

}

/*       S.D.G.       */

package com.anfelisa.user.resources;

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

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Resource;
import com.anfelisa.user.actions.UsernameAvailableAction;
import com.anfelisa.user.data.UsernameAvailableData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsernameAvailableResource extends Resource {

	static final Logger LOG = LoggerFactory.getLogger(UsernameAvailableResource.class);

	public UsernameAvailableResource(DBI jdbi) {
		super(jdbi);
	}

	@GET
	@Timed
	@Path("/username")
	public Response get(@NotNull @QueryParam("uuid") String uuid, @NotNull @QueryParam("schema") String schema,
			@NotNull @QueryParam("username") String username) throws JsonProcessingException {
		DatabaseHandle handle = this.createDatabaseHandle();
		UsernameAvailableData actionParam = new UsernameAvailableData(uuid, schema).withUsername(username); // init actionParam
		return new UsernameAvailableAction(actionParam, handle).apply();
	}

}

/* S.D.G. */

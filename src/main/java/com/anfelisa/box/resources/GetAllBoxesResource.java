package com.anfelisa.box.resources;

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

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Resource;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.box.actions.GetAllBoxesAction;
import com.anfelisa.box.data.AllBoxesData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/boxes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GetAllBoxesResource extends Resource {

	static final Logger LOG = LoggerFactory.getLogger(GetAllBoxesResource.class);

	public GetAllBoxesResource( DBI jdbi ) {
		super(jdbi);
	}

	@GET
	@Timed
	@Path("/all")
	@RolesAllowed({ AuthUser.AUTHOR, AuthUser.ADMIN })
	public Response get(@NotNull @QueryParam("uuid") String uuid, @NotNull @QueryParam("schema") String schema) throws JsonProcessingException {
		DatabaseHandle handle = this.createDatabaseHandle();
		AllBoxesData actionParam = new AllBoxesData(uuid, schema);
		return new GetAllBoxesAction(actionParam, handle).apply();
	}

}

/*       S.D.G.       */

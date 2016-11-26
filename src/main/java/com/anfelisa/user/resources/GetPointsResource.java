package com.anfelisa.user.resources;

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

import com.anfelisa.ace.Resource;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.user.actions.GetPointsAction;
import com.anfelisa.user.data.PointsData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GetPointsResource extends Resource {

	static final Logger LOG = LoggerFactory.getLogger(GetPointsResource.class);

	public GetPointsResource(DBI jdbi) {
		super(jdbi);
	}

	@GET
	@Timed
	@Path("/points")
	@PermitAll
	public Response get(@Auth AuthUser principal, @NotNull @QueryParam("uuid") String uuid, @NotNull @QueryParam("schema") String schema) throws JsonProcessingException {
		PointsData actionParam = new PointsData(null, principal.getUsername(), principal.getRole(), uuid, schema);
		return new GetPointsAction(actionParam, this.createDatabaseHandle()).apply();
	}

}

/*       S.D.G.       */

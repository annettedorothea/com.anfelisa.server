package com.anfelisa.result.resources;

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

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Resource;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.result.actions.LoadResultAction;
import com.anfelisa.result.data.MyResultData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/results")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoadResultResource extends Resource {

	static final Logger LOG = LoggerFactory.getLogger(LoadResultResource.class);

	public LoadResultResource( DBI jdbi ) {
		super(jdbi);
	}

	@GET
	@Timed
	@Path("/single")
	@PermitAll
	public Response get(@Auth AuthUser user, @NotNull @QueryParam("uuid") String uuid,
			@NotNull @QueryParam("schema") String schema, @NotNull @QueryParam("testId") Integer resultId) throws JsonProcessingException {
		DatabaseHandle handle = this.createDatabaseHandle();
		MyResultData actionParam = null;  // init actionParam
		return new LoadResultAction(actionParam, handle).apply();
	}

}

/*       S.D.G.       */

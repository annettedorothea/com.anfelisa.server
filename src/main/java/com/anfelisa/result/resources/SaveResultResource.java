package com.anfelisa.result.resources;

import javax.annotation.security.PermitAll;
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
import com.anfelisa.auth.AuthUser;
import com.anfelisa.result.actions.SaveResultAction;
import com.anfelisa.result.data.ResultSaveData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/results")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SaveResultResource extends Resource {

	static final Logger LOG = LoggerFactory.getLogger(SaveResultResource.class);

	public SaveResultResource( DBI jdbi ) {
		super(jdbi);
	}

	@POST
	@Timed
	@Path("/save")
	@PermitAll
	public Response post(@Auth AuthUser user, @NotNull ResultSaveData actionParam ) throws JsonProcessingException {
		DatabaseHandle handle = this.createDatabaseHandle();
		if (!actionParam.getUsername().equals(user.getUsername())) {
			handle.close();
			throw new WebApplicationException(Response.Status.BAD_REQUEST);
		}
		return new SaveResultAction(actionParam, handle).apply();
	}

}

/*       S.D.G.       */

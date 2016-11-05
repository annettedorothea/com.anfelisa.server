package com.anfelisa.result.resources;

import javax.annotation.security.PermitAll;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseService;
import com.anfelisa.result.actions.CreateResultAction;
import com.anfelisa.result.data.ResultCreationData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/results")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CreateResultResource {

	static final Logger LOG = LoggerFactory.getLogger(CreateResultResource.class);

	@POST
	@Timed
	@Path("/create")
	@PermitAll
	public Response post( @NotNull ResultCreationData actionParam) throws JsonProcessingException {
		return new CreateResultAction(actionParam, DatabaseService.getDatabaseHandle()).apply();
	}

}

/*       S.D.G.       */

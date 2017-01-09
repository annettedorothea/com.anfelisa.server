package com.anfelisa.result.resources;

import javax.annotation.security.PermitAll;
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

import com.anfelisa.ace.Resource;
import com.anfelisa.result.actions.CreateResultAction;
import com.anfelisa.result.data.ResultCreationData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/results")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
public class CreateResultResource extends Resource {

	static final Logger LOG = LoggerFactory.getLogger(CreateResultResource.class);

	public CreateResultResource(DBI jdbi) {
		super(jdbi);
		// TODO Auto-generated constructor stub
	}

	@POST
	@Timed
	@Path("/create")
	@PermitAll
	public Response post( @NotNull ResultCreationData actionParam) throws JsonProcessingException {
		return new CreateResultAction(actionParam, this.createDatabaseHandle()).apply();
	}

}

/*       S.D.G.       */

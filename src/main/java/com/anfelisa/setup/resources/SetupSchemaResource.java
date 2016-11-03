package com.anfelisa.setup.resources;

import javax.validation.Valid;
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
import com.anfelisa.setup.actions.SetupSchemaAction;
import com.anfelisa.setup.data.SetupSchemaData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/setup")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SetupSchemaResource {

	static final Logger LOG = LoggerFactory.getLogger(SetupSchemaResource.class);

	@POST
	@Timed
	@Path("/schema")
	public Response post(@Valid @NotNull SetupSchemaData setupSchemaData) throws JsonProcessingException {
		return new SetupSchemaAction(setupSchemaData, DatabaseService.getDatabaseHandle()).apply();
	}

}

/*       S.D.G.       */

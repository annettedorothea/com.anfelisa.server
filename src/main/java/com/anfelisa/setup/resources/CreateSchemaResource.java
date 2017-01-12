package com.anfelisa.setup.resources;

import javax.validation.Valid;
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

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Resource;
import com.anfelisa.setup.actions.CreateSchemaAction;
import com.anfelisa.setup.data.SchemaCreationData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/schema")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CreateSchemaResource extends Resource {

	static final Logger LOG = LoggerFactory.getLogger(CreateSchemaResource.class);

	public CreateSchemaResource(DBI jdbi) {
		super(jdbi);
	}

	@POST
	@Timed
	@Path("/create")
	public Response post(@Valid @NotNull SchemaCreationData actionParam) throws JsonProcessingException {
		DatabaseHandle handle = this.createDatabaseHandle();
		return new CreateSchemaAction(actionParam, handle).apply();
	}

}

/* S.D.G. */

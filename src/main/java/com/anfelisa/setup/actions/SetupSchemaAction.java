package com.anfelisa.setup.actions;

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

import com.anfelisa.setup.data.SetupSchemaData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/schema")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
	public class SetupSchemaAction extends AbstractSetupSchemaAction {

	static final Logger LOG = LoggerFactory.getLogger(SetupSchemaAction.class);

	public SetupSchemaAction(DBI jdbi) {
		super(jdbi);
	}

	@POST
	@Timed
	@Path("/setup")
	public Response post(@Valid @NotNull SetupSchemaData setupSchemaData) throws JsonProcessingException {
		this.actionData = setupSchemaData;
		return this.apply();
	}


}

/*       S.D.G.       */

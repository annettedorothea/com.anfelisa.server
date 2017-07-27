package com.anfelisa.result.actions;

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

import com.anfelisa.result.data.ResultCreationData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/results")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
	public class CreateResultAction extends AbstractCreateResultAction {

	static final Logger LOG = LoggerFactory.getLogger(CreateResultAction.class);

	public CreateResultAction(DBI jdbi, DBI jdbiTimeline) {
		super(jdbi, jdbiTimeline);
	}

	@POST
	@Timed
	@Path("/create")
	@PermitAll
	public Response post(@NotNull ResultCreationData actionParam) throws JsonProcessingException {
		this.actionData = actionParam;
		return this.apply();
	}


}

/*       S.D.G.       */

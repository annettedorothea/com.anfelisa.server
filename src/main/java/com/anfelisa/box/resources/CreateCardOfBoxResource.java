package com.anfelisa.box.resources;

import javax.annotation.security.PermitAll;
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
import com.anfelisa.box.actions.CreateCardOfBoxAction;
import com.anfelisa.box.data.CardOfBoxCreationData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/cardofbox")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
public class CreateCardOfBoxResource extends Resource {

	static final Logger LOG = LoggerFactory.getLogger(CreateCardOfBoxResource.class);

	public CreateCardOfBoxResource(DBI jdbi) {
		super(jdbi);
	}

	@POST
	@Timed
	@Path("/create")
	@PermitAll
	public Response post(CardOfBoxCreationData actionParam ) throws JsonProcessingException {
		return new CreateCardOfBoxAction(actionParam, this.createDatabaseHandle()).apply();
	}

}

/*       S.D.G.       */

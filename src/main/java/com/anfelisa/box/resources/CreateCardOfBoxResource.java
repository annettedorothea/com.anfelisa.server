package com.anfelisa.box.resources;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseService;
import com.anfelisa.box.actions.CreateCardOfBoxAction;
import com.anfelisa.box.data.CardOfBoxCreationData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/cardofbox")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CreateCardOfBoxResource {

	static final Logger LOG = LoggerFactory.getLogger(CreateCardOfBoxResource.class);

	@POST
	@Timed
	@Path("/create")
	@PermitAll
	public Response post(CardOfBoxCreationData actionParam ) throws JsonProcessingException {
		return new CreateCardOfBoxAction(actionParam, DatabaseService.getDatabaseHandle()).apply();
	}

}

/*       S.D.G.       */

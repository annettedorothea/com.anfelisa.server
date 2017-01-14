package com.anfelisa.box.actions;

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

import com.anfelisa.box.data.CardOfBoxCreationData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/cardofbox")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
public class CreateCardOfBoxAction extends AbstractCreateCardOfBoxAction {

	static final Logger LOG = LoggerFactory.getLogger(CreateCardOfBoxAction.class);

	public CreateCardOfBoxAction(DBI jdbi) {
		super(jdbi);
	}

	@POST
	@Timed
	@Path("/create")
	@PermitAll
	public Response post(CardOfBoxCreationData actionParam) throws JsonProcessingException {
		this.actionData = actionParam;
		return this.apply();
	}

}

/*       S.D.G.       */

package com.anfelisa.box.actions;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.skife.jdbi.v2.DBI;

import com.anfelisa.box.data.CardCreationData;

@Path("/CardCreation")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
public class CreateCardAction extends AbstractCreateCardAction {

	static final Logger LOG = LoggerFactory.getLogger(CreateCardAction.class);

	public CreateCardAction(DBI jdbi) {
		super(jdbi);
	}

	@POST
	@Timed
	@Path("/post")
	@PermitAll
	public Response post(/* params here */) throws JsonProcessingException {
		CardCreationData actionData = null;
		return this.apply();
	}

}

/*       S.D.G.       */

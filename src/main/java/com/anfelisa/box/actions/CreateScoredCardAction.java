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

import com.anfelisa.box.data.ScoredCardData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/scoredcards")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
	public class CreateScoredCardAction extends AbstractCreateScoredCardAction {

	static final Logger LOG = LoggerFactory.getLogger(CreateScoredCardAction.class);

	public CreateScoredCardAction(DBI jdbi, DBI jdbiTimeline) {
		super(jdbi, jdbiTimeline);
	}

	@POST
	@Timed
	@Path("/create")
	@PermitAll
	public Response post(ScoredCardData data) throws JsonProcessingException {
		this.actionData = data;
		return this.apply();
	}


}

/*       S.D.G.       */

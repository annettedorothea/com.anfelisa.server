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

import com.anfelisa.box.data.AllBoxesData;

@Path("/AllBoxes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GetAllBoxesAction extends AbstractGetAllBoxesAction {

	static final Logger LOG = LoggerFactory.getLogger(GetAllBoxesAction.class);

	public GetAllBoxesAction(DBI jdbi) {
		super(jdbi);
	}

	@GET
	@Timed
	@Path("/get")
	@PermitAll
	public Response get(/* params here */) throws JsonProcessingException {
		AllBoxesData actionData = null;
		return this.apply();
	}

}

/*       S.D.G.       */

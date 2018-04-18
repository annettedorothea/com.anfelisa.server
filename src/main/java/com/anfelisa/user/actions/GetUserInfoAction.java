package com.anfelisa.user.actions;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/UserInfo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
	public class GetUserInfoAction extends AbstractGetUserInfoAction {

	static final Logger LOG = LoggerFactory.getLogger(GetUserInfoAction.class);

	public GetUserInfoAction(DBI jdbi) {
		super(jdbi);
	}

	@GET
	@Timed
	@Path("/get")
	@PermitAll
	public Response get() throws JsonProcessingException {
		this.actionData = null;
		return this.apply();
	}

	protected final void loadDataForGetRequest() {
	}

}

/*       S.D.G.       */

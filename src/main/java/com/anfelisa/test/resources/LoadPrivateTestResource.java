package com.anfelisa.test.resources;

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

import com.anfelisa.ace.Resource;
import com.anfelisa.test.actions.LoadPrivateTestAction;
import com.anfelisa.test.data.TestData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/tests")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoadPrivateTestResource extends Resource {

	static final Logger LOG = LoggerFactory.getLogger(LoadPrivateTestResource.class);

	public LoadPrivateTestResource(DBI jdbi) {
		super(jdbi);
	}

	@GET
	@Timed
	@Path("/private/single")
	@PermitAll // set permission
	public Response get(/* params here */) throws JsonProcessingException {
		TestData actionParam = null;  // init actionParam
		return new LoadPrivateTestAction(actionParam, this.createDatabaseHandle()).apply();
	}

}

/*       S.D.G.       */

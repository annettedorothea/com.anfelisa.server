package com.anfelisa.test.resources;

import javax.annotation.security.RolesAllowed;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Resource;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.test.actions.GetCardsOfTestAction;
import com.anfelisa.test.data.CardContentHashListData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/tests")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GetCardsOfTestResource extends Resource {

	static final Logger LOG = LoggerFactory.getLogger(GetCardsOfTestResource.class);

	public GetCardsOfTestResource( DBI jdbi ) {
		super(jdbi);
	}

	@GET
	@Timed
	@Path("/cards")
	@RolesAllowed({ AuthUser.ADMIN, AuthUser.AUTHOR })
	public Response get(@NotNull @QueryParam("uuid") String uuid, @NotNull @QueryParam("schema") String schema,
			@NotNull @QueryParam("testId") Integer testId) throws JsonProcessingException {
		DatabaseHandle handle = this.createDatabaseHandle();
		CardContentHashListData actionParam = new CardContentHashListData(uuid, schema).withTestId(testId);
		return new GetCardsOfTestAction(actionParam, handle).apply();
	}

}

/*       S.D.G.       */

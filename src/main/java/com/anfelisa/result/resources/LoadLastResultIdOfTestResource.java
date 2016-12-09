package com.anfelisa.result.resources;

import javax.annotation.security.PermitAll;
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
import com.anfelisa.result.actions.LoadLastResultIdOfTestAction;
import com.anfelisa.result.data.LastResultIdData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/results")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoadLastResultIdOfTestResource extends Resource {

	static final Logger LOG = LoggerFactory.getLogger(LoadLastResultIdOfTestResource.class);

	public LoadLastResultIdOfTestResource(DBI jdbi) {
		super(jdbi);
	}

	@GET
	@Timed
	@Path("/last")
	@PermitAll
	public Response get(@Auth AuthUser user, @NotNull @QueryParam("uuid") String uuid,
			@NotNull @QueryParam("schema") String schema, @NotNull @QueryParam("testId") Integer testId)
			throws JsonProcessingException {
		DatabaseHandle handle = this.createDatabaseHandle();
		LastResultIdData actionParam = new LastResultIdData(uuid, schema).withTestId(testId)
				.withUsername(user.getUsername());
		return new LoadLastResultIdOfTestAction(actionParam, handle).apply();
	}

}

/* S.D.G. */

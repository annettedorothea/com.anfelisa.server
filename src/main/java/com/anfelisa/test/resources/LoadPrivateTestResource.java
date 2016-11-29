package com.anfelisa.test.resources;

import javax.annotation.security.PermitAll;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Resource;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.test.actions.LoadPrivateTestAction;
import com.anfelisa.test.data.MyTestData;
import com.anfelisa.test.models.CustomTestDao;
import com.anfelisa.test.models.ITestModel;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

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
	@PermitAll
	public Response get(@Auth AuthUser user, @NotNull @QueryParam("uuid") String uuid,
			@NotNull @QueryParam("schema") String schema, @NotNull @QueryParam("testId") Integer testId)
			throws JsonProcessingException {
		DatabaseHandle handle = this.createDatabaseHandle();
		ITestModel test = CustomTestDao.selectByTestIdAndUsername(handle.getHandle(), testId, user.getUsername(),
				schema);
		if (test == null) {
			handle.close();
			throw new WebApplicationException(Response.Status.BAD_REQUEST);
		}
		MyTestData actionParam = new MyTestData(testId, null, null, null, null, null, testId, user.getUsername(), null,
				null, null, null, null, null, null, null, uuid, schema);
		return new LoadPrivateTestAction(actionParam, this.createDatabaseHandle()).apply();
	}

}

/* S.D.G. */

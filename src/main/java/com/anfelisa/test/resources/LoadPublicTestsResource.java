package com.anfelisa.test.resources;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseService;
import com.anfelisa.test.actions.LoadPublicTestsAction;
import com.anfelisa.test.data.TestListData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/tests")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoadPublicTestsResource {

	static final Logger LOG = LoggerFactory.getLogger(LoadPublicTestsResource.class);

	@GET
	@Timed
	@Path("/public")
	public Response get(@NotNull @QueryParam("uuid") String uuid, @NotNull @QueryParam("schema") String schema,
			@NotNull @QueryParam("lessonId") Integer lessonId) throws JsonProcessingException {
		TestListData actionParam = new TestListData(lessonId, null, null, null, null, null, null, null, null, uuid,
				schema);
		return new LoadPublicTestsAction(actionParam, DatabaseService.getDatabaseHandle()).apply();
	}

}

/* S.D.G. */

package com.anfelisa.test.actions;

import javax.annotation.security.RolesAllowed;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.auth.AuthUser;
import com.anfelisa.test.data.TestIdData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/tests")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
	public class DeleteTestAction extends AbstractDeleteTestAction {

	static final Logger LOG = LoggerFactory.getLogger(DeleteTestAction.class);

	public DeleteTestAction(DBI jdbi) {
		super(jdbi);
	}

	@DELETE
	@Timed
	@Path("/delete")
	@RolesAllowed({ AuthUser.AUTHOR, AuthUser.ADMIN })
	public Response delete(@NotNull @QueryParam("uuid") String uuid, @NotNull @QueryParam("testId") Integer testId) throws JsonProcessingException {
		this.actionData = new TestIdData(uuid).withTestId(testId);
		return this.apply();
	}


}

/*       S.D.G.       */

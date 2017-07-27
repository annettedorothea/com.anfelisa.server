package com.anfelisa.test.actions;

import java.io.UnsupportedEncodingException;

import javax.annotation.security.RolesAllowed;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.auth.AuthUser;
import com.anfelisa.test.data.TestCreationData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/tests")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UpdateTestAction extends AbstractUpdateTestAction {

	static final Logger LOG = LoggerFactory.getLogger(UpdateTestAction.class);

	public UpdateTestAction(DBI jdbi, DBI jdbiTimeline) {
		super(jdbi, jdbiTimeline);
	}

	@PUT
	@Timed
	@Path("/update")
	@RolesAllowed({ AuthUser.AUTHOR, AuthUser.ADMIN })
	public Response put(@NotNull TestCreationData testData)
			throws JsonProcessingException, UnsupportedEncodingException {
		this.actionData = testData;
		return this.apply();
	}

}

/* S.D.G. */

package com.anfelisa.result.actions;

import javax.annotation.security.PermitAll;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.joda.time.DateTime;
import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.auth.AuthUser;
import com.anfelisa.result.data.ResultSaveData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/results")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
public class SaveResultAction extends AbstractSaveResultAction {

	static final Logger LOG = LoggerFactory.getLogger(SaveResultAction.class);

	public SaveResultAction(DBI jdbi) {
		super(jdbi);
	}

	@POST
	@Timed
	@Path("/save")
	@PermitAll
	public Response post(@Auth AuthUser user, @NotNull ResultSaveData actionParam) throws JsonProcessingException {
		this.actionData = actionParam.withCredentialsRole(user.getRole()).withCredentialsUsername(user.getUsername())
				.withDate(new DateTime());
		return this.apply();
	}

}

/* S.D.G. */

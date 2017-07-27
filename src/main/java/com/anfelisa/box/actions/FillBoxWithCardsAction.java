package com.anfelisa.box.actions;

import javax.annotation.security.PermitAll;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.joda.time.DateTime;
import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.auth.AuthUser;
import com.anfelisa.box.data.FillBoxData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/box")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
public class FillBoxWithCardsAction extends AbstractFillBoxWithCardsAction {

	static final Logger LOG = LoggerFactory.getLogger(FillBoxWithCardsAction.class);

	public FillBoxWithCardsAction(DBI jdbi, DBI jdbiTimeline) {
		super(jdbi, jdbiTimeline);
	}

	@POST
	@Timed
	@Path("/fill")
	@PermitAll
	public Response post(@NotNull @QueryParam("uuid") String uuid,
			@NotNull @QueryParam("boxId") Integer boxId, @Auth AuthUser user) throws JsonProcessingException {
		this.actionData = new FillBoxData(uuid).withBoxId(boxId).withCredentialsRole(user.getRole())
				.withCredentialsUsername(user.getUsername()).withNow(new DateTime());
		return this.apply();
	}

}

/* S.D.G. */

package com.anfelisa.box.actions;

import javax.annotation.security.PermitAll;
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
import com.anfelisa.box.data.RemoveCardFromBoxData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/cards")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RemoveCardFromBoxAction extends AbstractRemoveCardFromBoxAction {

	static final Logger LOG = LoggerFactory.getLogger(RemoveCardFromBoxAction.class);

	public RemoveCardFromBoxAction(DBI jdbi, DBI jdbiTimeline) {
		super(jdbi, jdbiTimeline);
	}

	@DELETE
	@Timed
	@Path("/removeFromBox")
	@PermitAll
	public Response delete(@Auth AuthUser user, @NotNull @QueryParam("uuid") String uuid,
			@NotNull @QueryParam("scheduledCardId") Integer scheduledCardId) throws JsonProcessingException {
		this.actionData = new RemoveCardFromBoxData(uuid).withScheduledCardId(scheduledCardId).withCredentialsUsername(user.getUsername());
		return this.apply();
	}

}

/* S.D.G. */
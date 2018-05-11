package com.anfelisa.box.actions;

import javax.annotation.security.PermitAll;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.AppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.box.data.RecalculateScheduledCardsData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/boxes")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
public class RecalculateScheduledCardsAction extends AbstractRecalculateScheduledCardsAction {

	static final Logger LOG = LoggerFactory.getLogger(RecalculateScheduledCardsAction.class);

	public RecalculateScheduledCardsAction(DBI jdbi, AppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(jdbi, appConfiguration, daoProvider, viewProvider);
	}

	@PUT
	@Timed
	@Path("/recalculate")
	@PermitAll
	public Response put(@Auth AuthUser user, @NotNull @QueryParam("uuid") String uuid,
			@NotNull @QueryParam("boxId") String boxId, @NotNull @QueryParam("daysBehind") Integer daysBehind)
			throws JsonProcessingException {
		this.actionData = new RecalculateScheduledCardsData(uuid).withBoxId(boxId).withDaysBehind(daysBehind)
				.withUsername(user.getUsername());
		return this.apply();
	}

}

/* S.D.G. */

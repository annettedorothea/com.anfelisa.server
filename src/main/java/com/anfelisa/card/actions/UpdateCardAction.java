package com.anfelisa.card.actions;

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

import com.anfelisa.ace.AppConfiguration;
import com.anfelisa.ace.DaoProvider;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.card.data.CardUpdateData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/card")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
	public class UpdateCardAction extends AbstractUpdateCardAction {

	static final Logger LOG = LoggerFactory.getLogger(UpdateCardAction.class);

	public UpdateCardAction(DBI jdbi, AppConfiguration appConfiguration, DaoProvider daoProvider) {
		super(jdbi, appConfiguration, daoProvider);
	}

	@PUT
	@Timed
	@Path("/update")
	@RolesAllowed({ AuthUser.AUTHOR })
	public Response put(@Auth AuthUser user, @NotNull CardUpdateData cardUpdateData) throws JsonProcessingException {
		this.actionData = cardUpdateData;
		return this.apply();
	}


}

/*       S.D.G.       */

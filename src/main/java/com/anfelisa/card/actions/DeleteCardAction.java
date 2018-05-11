package com.anfelisa.card.actions;

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

import com.anfelisa.ace.AppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.card.data.CardDeleteData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/card")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
public class DeleteCardAction extends AbstractDeleteCardAction {

	static final Logger LOG = LoggerFactory.getLogger(DeleteCardAction.class);

	public DeleteCardAction(DBI jdbi, AppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(jdbi, appConfiguration, daoProvider, viewProvider);
	}

	@DELETE
	@Timed
	@Path("/delete")
	@RolesAllowed({ AuthUser.ADMIN })
	public Response delete(@Auth AuthUser user, @NotNull @QueryParam("cardId") String cardId,
			@NotNull @QueryParam("uuid") String uuid) throws JsonProcessingException {
		this.actionData = new CardDeleteData(uuid).withCardId(cardId);
		return this.apply();
	}

}

/* S.D.G. */

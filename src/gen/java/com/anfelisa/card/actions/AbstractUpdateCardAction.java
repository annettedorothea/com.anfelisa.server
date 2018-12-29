package com.anfelisa.card.actions;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.QueryParam;
import javax.ws.rs.PathParam;
import io.dropwizard.auth.Auth;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.ace.IDaoProvider;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.jdbi.v3.core.Jdbi;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import com.anfelisa.auth.AuthUser;

import com.anfelisa.card.data.CardUpdateData;

import com.anfelisa.card.commands.UpdateCardCommand;

@SuppressWarnings("unused")
@Path("/card/update")
public abstract class AbstractUpdateCardAction extends Action<CardUpdateData> {

	public AbstractUpdateCardAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.card.actions.UpdateCardAction", HttpMethod.PUT, jdbi, appConfiguration, daoProvider, viewProvider);
	}

	@Override
	public ICommand getCommand() {
		return new UpdateCardCommand(this.actionData, databaseHandle, daoProvider, viewProvider);
	}

	protected final void loadDataForGetRequest() {
	}

	@PUT
	@Timed
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCardResource(
			@Auth AuthUser authUser, 
			@NotNull CardUpdateData payload)
			throws JsonProcessingException {
		this.actionData = new CardUpdateData(payload.getUuid());
		this.actionData.setCardId(payload.getCardId());
		this.actionData.setGiven(payload.getGiven());
		this.actionData.setImage(payload.getImage());
		this.actionData.setWanted(payload.getWanted());
		this.actionData.setUserId(authUser.getUserId());
		return this.apply();
	}

}

/*       S.D.G.       */

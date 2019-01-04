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

import com.anfelisa.card.data.CardCreationData;

import com.anfelisa.card.commands.CreateCardCommand;

@SuppressWarnings("unused")
@Path("/card/create")
public abstract class AbstractCreateCardAction extends Action<CardCreationData> {

	public AbstractCreateCardAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.card.actions.CreateCardAction", HttpMethod.POST, jdbi, appConfiguration, daoProvider, viewProvider);
	}

	@Override
	public ICommand getCommand() {
		return new CreateCardCommand(this.actionData, databaseHandle, daoProvider, viewProvider);
	}

	protected final void loadDataForGetRequest() {
	}

	@POST
	@Timed
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createCardResource(
			@Auth AuthUser authUser, 
			@NotNull CardCreationData payload)
			throws JsonProcessingException {
		this.actionData = new CardCreationData(payload.getUuid());
		this.actionData.setWanted(payload.getWanted());
		this.actionData.setGiven(payload.getGiven());
		this.actionData.setImage(payload.getImage());
		this.actionData.setCategoryId(payload.getCategoryId());
		this.actionData.setUserId(authUser.getUserId());
		this.actionData.setUsername(authUser.getUsername());
		return this.apply();
	}

}

/*       S.D.G.       */

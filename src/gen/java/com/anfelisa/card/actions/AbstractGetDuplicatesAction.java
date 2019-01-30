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
import com.anfelisa.ace.IDataContainer;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.jdbi.v3.core.Jdbi;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import com.anfelisa.auth.AuthUser;

import com.anfelisa.card.data.ICardSearchData;
import com.anfelisa.card.data.CardSearchData;


@SuppressWarnings("unused")
@Path("/cards/search")
public abstract class AbstractGetDuplicatesAction extends Action<ICardSearchData> {

	public AbstractGetDuplicatesAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.card.actions.GetDuplicatesAction", HttpMethod.GET, jdbi, appConfiguration, daoProvider, viewProvider);
	}

	@Override
	public ICommand getCommand() {
		return null;
	}
	
	public void setActionData(IDataContainer data) {
		this.actionData = (ICardSearchData)data;
	}


	@GET
	@Timed
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getDuplicatesResource(
			@Auth AuthUser authUser, 
			@QueryParam("given") String given, 
			@QueryParam("wanted") String wanted, 
			@QueryParam("naturalInputOrder") Boolean naturalInputOrder, 
			@QueryParam("categoryId") String categoryId, 
			@NotNull @QueryParam("uuid") String uuid) 
			throws JsonProcessingException {
		this.actionData = new CardSearchData(uuid);
		this.actionData.setGiven(given);
		this.actionData.setWanted(wanted);
		this.actionData.setNaturalInputOrder(naturalInputOrder);
		this.actionData.setCategoryId(categoryId);
		return this.apply();
	}

	protected Object createReponse() {
		return new com.anfelisa.card.data.GetDuplicatesResponse(this.actionData);
	}
}

/*       S.D.G.       */

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
import com.anfelisa.ace.DatabaseHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.Jdbi;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import com.anfelisa.auth.AuthUser;

import com.anfelisa.card.data.CardTranslationData;


@SuppressWarnings("unused")
@Path("/card/translation")
public abstract class AbstractGetTranslationAction extends Action<CardTranslationData> {

	public AbstractGetTranslationAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super("com.anfelisa.card.actions.GetTranslationAction", HttpMethod.GET, jdbi, appConfiguration, daoProvider, viewProvider);
	}

	@Override
	public ICommand getCommand() {
		return null;
	}


	public void initActionData(String json) {
		try {
			this.actionData = mapper.readValue(json, CardTranslationData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

	@GET
	@Timed
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getTranslationResource(
			@Auth AuthUser authUser, 
			@QueryParam("sourceValue") String sourceValue, 
			@QueryParam("sourceLanguage") String sourceLanguage, 
			@QueryParam("targetLanguage") String targetLanguage, 
			@NotNull @QueryParam("uuid") String uuid) 
			throws JsonProcessingException {
		this.actionData = new CardTranslationData(uuid);
		this.actionData.setSourceValue(sourceValue);
		this.actionData.setSourceLanguage(sourceLanguage);
		this.actionData.setTargetLanguage(targetLanguage);
		return this.apply();
	}

	protected Object createReponse() {
		return new com.anfelisa.card.data.GetTranslationResponse(this.actionData);
	}
}

/*       S.D.G.       */

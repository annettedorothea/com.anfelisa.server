/********************************************************************************
 * generated by de.acegen 0.9.13
 ********************************************************************************/




package com.anfelisa.card.resources;

import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.commons.lang3.StringUtils;

import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.IDataContainer;
import de.acegen.ViewProvider;
import de.acegen.PersistenceConnection;
import de.acegen.PersistenceHandle;
import de.acegen.ReadAction;
import de.acegen.ITimelineItem;
import de.acegen.NonDeterministicDataProvider;

import de.acegen.auth.AuthUser;
import io.dropwizard.auth.Auth;

import com.codahale.metrics.annotation.Timed;
import com.codahale.metrics.annotation.Metered;
import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.ResponseMetered;

import com.fasterxml.jackson.core.JsonProcessingException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;

import com.anfelisa.card.data.ICardTranslationData;
import com.anfelisa.card.data.CardTranslationData;

import de.acegen.Resource;

@Path("/card/translation")
@SuppressWarnings("unused")
public class GetTranslationResource extends Resource {

	static final Logger LOG = LoggerFactory.getLogger(GetTranslationResource.class);
	
	private PersistenceConnection persistenceConnection;
	private CustomAppConfiguration appConfiguration;
	private IDaoProvider daoProvider;
	private ViewProvider viewProvider;

	public GetTranslationResource(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
				IDaoProvider daoProvider, ViewProvider viewProvider) {
			this.persistenceConnection = persistenceConnection;
			this.appConfiguration = appConfiguration;
			this.daoProvider = daoProvider;
			this.viewProvider = viewProvider;
		}
	
	@GET
	@Timed(name = "GetTranslationActionTimed")
	@Metered(name = "GetTranslationActionMetered")
	@ExceptionMetered
	@ResponseMetered
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getTranslationResource(
			@Auth AuthUser authUser, 
			@QueryParam("sourceValue") String sourceValue, 
			@QueryParam("sourceLanguage") String sourceLanguage, 
			@QueryParam("targetLanguage") String targetLanguage, 
			@QueryParam("uuid") String uuid) 
			throws JsonProcessingException {
		if (StringUtils.isBlank(uuid)) {
			uuid = UUID.randomUUID().toString();
		}
		com.anfelisa.card.data.ICardTranslationData actionData = new CardTranslationData(uuid);
		
		if (StringUtils.isBlank(sourceValue) || "null".equals(sourceValue)) {
			return badRequest("sourceValue is mandatory");
		}
		actionData.setSourceValue(sourceValue);
		
		if (StringUtils.isBlank(sourceLanguage) || "null".equals(sourceLanguage)) {
			return badRequest("sourceLanguage is mandatory");
		}
		actionData.setSourceLanguage(sourceLanguage);
		
		if (StringUtils.isBlank(targetLanguage) || "null".equals(targetLanguage)) {
			return badRequest("targetLanguage is mandatory");
		}
		actionData.setTargetLanguage(targetLanguage);
		
		com.anfelisa.card.actions.GetTranslationAction action = new com.anfelisa.card.actions.GetTranslationAction(persistenceConnection, appConfiguration, daoProvider, viewProvider);
		action.setActionData(actionData);
		try {
			action.apply();
			return Response.ok(new com.anfelisa.card.data.GetTranslationResponse(action.getActionData())).build();
		} catch (IllegalArgumentException x) {
			LOG.error("bad request due to {} ", x.getMessage());
			return badRequest(x.getMessage());
		} catch (SecurityException x) {
			LOG.error("unauthorized due to {} ", x.getMessage());
			return unauthorized("authorization needed for /card/translation");
		} catch (Exception x) {
			LOG.error("internal server error due to {} ", x.getMessage());
			return internalServerError(x);
		}
	}
}




/******* S.D.G. *******/



/********************************************************************************
 * generated by de.acegen
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
import de.acegen.ViewProvider;
import de.acegen.PersistenceConnection;
import de.acegen.PersistenceHandle;
import de.acegen.ReadAction;
import de.acegen.ITimelineItem;
import de.acegen.SquishyDataProvider;
import de.acegen.Config;
import de.acegen.Data;

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

import com.anfelisa.card.models.CardTranslationModel;

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
		try {
			Data<com.anfelisa.card.models.CardTranslationModel> data = new Data<com.anfelisa.card.models.CardTranslationModel>(uuid);
			com.anfelisa.card.models.CardTranslationModel model = new com.anfelisa.card.models.CardTranslationModel();
			if (sourceValue == null || StringUtils.isBlank(sourceValue) || "null".equals(sourceValue)) {
				return badRequest("sourceValue is mandatory");
			}
			if (sourceValue != null) {
				model.setSourceValue(sourceValue);
			}
			if (sourceLanguage == null || StringUtils.isBlank(sourceLanguage) || "null".equals(sourceLanguage)) {
				return badRequest("sourceLanguage is mandatory");
			}
			if (sourceLanguage != null) {
				model.setSourceLanguage(sourceLanguage);
			}
			if (targetLanguage == null || StringUtils.isBlank(targetLanguage) || "null".equals(targetLanguage)) {
				return badRequest("targetLanguage is mandatory");
			}
			if (targetLanguage != null) {
				model.setTargetLanguage(targetLanguage);
			}
			
			data.setModel(model);
			com.anfelisa.card.actions.GetTranslationAction action = new com.anfelisa.card.actions.GetTranslationAction(persistenceConnection, appConfiguration, daoProvider, viewProvider);
			data = action.apply(data);
			return Response.ok(new com.anfelisa.card.data.GetTranslationResponse(data.getModel())).build();
		} catch (IllegalArgumentException x) {
			LOG.error("bad request due to {} ", x.getMessage());
			if (Config.DEV.equals(appConfiguration.getConfig().getMode())) {
				x.printStackTrace();
			}
			return badRequest(x.getMessage());
		} catch (SecurityException x) {
			LOG.error("unauthorized due to {} ", x.getMessage());
			if (Config.DEV.equals(appConfiguration.getConfig().getMode())) {
				x.printStackTrace();
			}
			return unauthorized("authorization needed for /card/translation");
		} catch (Exception x) {
			LOG.error("internal server error due to {} ", x.getMessage());
			if (Config.DEV.equals(appConfiguration.getConfig().getMode())) {
				x.printStackTrace();
			}
			return internalServerError(x);
		}
	}
}




/******* S.D.G. *******/



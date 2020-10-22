/********************************************************************************
 * generated by de.acegen 0.9.13
 ********************************************************************************/




package com.anfelisa.box.resources;

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

import com.anfelisa.box.data.IBoxCreationData;
import com.anfelisa.box.data.BoxCreationData;

import de.acegen.Resource;

@Path("/box/create")
@SuppressWarnings("unused")
public class CreateBoxResource extends Resource {

	static final Logger LOG = LoggerFactory.getLogger(CreateBoxResource.class);
	
	private PersistenceConnection persistenceConnection;
	private CustomAppConfiguration appConfiguration;
	private IDaoProvider daoProvider;
	private ViewProvider viewProvider;

	public CreateBoxResource(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
				IDaoProvider daoProvider, ViewProvider viewProvider) {
			this.persistenceConnection = persistenceConnection;
			this.appConfiguration = appConfiguration;
			this.daoProvider = daoProvider;
			this.viewProvider = viewProvider;
		}
	
	@POST
	@Timed(name = "CreateBoxActionTimed")
	@Metered(name = "CreateBoxActionMetered")
	@ExceptionMetered
	@ResponseMetered
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createBoxResource(
			@Auth AuthUser authUser, 
			@QueryParam("uuid") String uuid, 
			IBoxCreationData payload) 
			throws JsonProcessingException {
		if (payload == null) {
			return badRequest("payload must not be null");
		}
		if (StringUtils.isBlank(uuid)) {
			uuid = UUID.randomUUID().toString();
		}
		com.anfelisa.box.data.IBoxCreationData actionData = new BoxCreationData(uuid);
		
		if (StringUtils.isBlank(payload.getCategoryName()) || "null".equals(payload.getCategoryName())) {
			return badRequest("categoryName is mandatory");
		}
		actionData.setCategoryName(payload.getCategoryName());
		
		actionData.setDictionaryLookup(payload.getDictionaryLookup());
		
		actionData.setGivenLanguage(payload.getGivenLanguage());
		
		actionData.setWantedLanguage(payload.getWantedLanguage());
		
		if (payload.getMaxCardsPerDay() == null) {
			return badRequest("maxCardsPerDay is mandatory");
		}
		actionData.setMaxCardsPerDay(payload.getMaxCardsPerDay());
		
		actionData.setMaxInterval(payload.getMaxInterval());
		actionData.setUsername(authUser.getUsername());
		actionData.setUserId(authUser.getUserId());
		
		com.anfelisa.box.actions.CreateBoxAction action = new com.anfelisa.box.actions.CreateBoxAction(persistenceConnection, appConfiguration, daoProvider, viewProvider);
		action.setActionData(actionData);
		try {
			action.apply();
			return ok();
		} catch (IllegalArgumentException x) {
			LOG.error("bad request due to {} ", x.getMessage());
			return badRequest(x.getMessage());
		} catch (SecurityException x) {
			LOG.error("unauthorized due to {} ", x.getMessage());
			return unauthorized("authorization needed for /box/create");
		} catch (Exception x) {
			LOG.error("internal server error due to {} ", x.getMessage());
			return internalServerError(x);
		}
	}
}




/******* S.D.G. *******/



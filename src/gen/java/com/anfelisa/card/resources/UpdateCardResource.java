/********************************************************************************
 * generated by de.acegen 1.1.0
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

import com.anfelisa.card.data.ICardUpdateData;
import com.anfelisa.card.data.CardUpdateData;

import de.acegen.Resource;

@Path("/card/update")
@SuppressWarnings("unused")
public class UpdateCardResource extends Resource {

	static final Logger LOG = LoggerFactory.getLogger(UpdateCardResource.class);
	
	private PersistenceConnection persistenceConnection;
	private CustomAppConfiguration appConfiguration;
	private IDaoProvider daoProvider;
	private ViewProvider viewProvider;

	public UpdateCardResource(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
				IDaoProvider daoProvider, ViewProvider viewProvider) {
			this.persistenceConnection = persistenceConnection;
			this.appConfiguration = appConfiguration;
			this.daoProvider = daoProvider;
			this.viewProvider = viewProvider;
		}
	
	@PUT
	@Timed(name = "UpdateCardActionTimed")
	@Metered(name = "UpdateCardActionMetered")
	@ExceptionMetered
	@ResponseMetered
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCardResource(
			@Auth AuthUser authUser, 
			@QueryParam("uuid") String uuid, 
			ICardUpdateData payload) 
			throws JsonProcessingException {
		if (payload == null) {
			return badRequest("payload must not be null");
		}
		if (StringUtils.isBlank(uuid)) {
			uuid = UUID.randomUUID().toString();
		}
		try {
			com.anfelisa.card.data.ICardUpdateData actionData = new CardUpdateData(uuid);
			if (StringUtils.isBlank(payload.getCardId()) || "null".equals(payload.getCardId())) {
				return badRequest("cardId is mandatory");
			}
			actionData.setCardId(payload.getCardId());
			if (StringUtils.isBlank(payload.getGiven()) || "null".equals(payload.getGiven())) {
				return badRequest("given is mandatory");
			}
			actionData.setGiven(payload.getGiven());
			actionData.setImage(payload.getImage());
			if (StringUtils.isBlank(payload.getWanted()) || "null".equals(payload.getWanted())) {
				return badRequest("wanted is mandatory");
			}
			actionData.setWanted(payload.getWanted());
			actionData.setUserId(authUser.getUserId());
			
			com.anfelisa.card.actions.UpdateCardAction action = new com.anfelisa.card.actions.UpdateCardAction(persistenceConnection, appConfiguration, daoProvider, viewProvider);
			action.setActionData(actionData);
			action.apply();
			return ok();
		} catch (IllegalArgumentException x) {
			LOG.error("bad request due to {} ", x.getMessage());
			return badRequest(x.getMessage());
		} catch (SecurityException x) {
			LOG.error("unauthorized due to {} ", x.getMessage());
			return unauthorized("authorization needed for /card/update");
		} catch (Exception x) {
			LOG.error("internal server error due to {} ", x.getMessage());
			return internalServerError(x);
		}
	}
}




/******* S.D.G. *******/



/********************************************************************************
 * generated by de.acegen 1.3.0
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
import de.acegen.SquishyDataProvider;
import de.acegen.Config;

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

import com.anfelisa.card.data.ICardListData;
import com.anfelisa.card.data.CardListData;

import de.acegen.Resource;

@Path("/cards")
@SuppressWarnings("unused")
public class GetCardsResource extends Resource {

	static final Logger LOG = LoggerFactory.getLogger(GetCardsResource.class);
	
	private PersistenceConnection persistenceConnection;
	private CustomAppConfiguration appConfiguration;
	private IDaoProvider daoProvider;
	private ViewProvider viewProvider;

	public GetCardsResource(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
				IDaoProvider daoProvider, ViewProvider viewProvider) {
			this.persistenceConnection = persistenceConnection;
			this.appConfiguration = appConfiguration;
			this.daoProvider = daoProvider;
			this.viewProvider = viewProvider;
		}
	
	@GET
	@Timed(name = "GetCardsActionTimed")
	@Metered(name = "GetCardsActionMetered")
	@ExceptionMetered
	@ResponseMetered
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getCardsResource(
			@Auth AuthUser authUser, 
			@QueryParam("categoryId") String categoryId, 
			@QueryParam("filterNonScheduled") String filterNonScheduled, 
			@QueryParam("priority") String priority, 
			@QueryParam("reverse") String reverse, 
			@QueryParam("uuid") String uuid) 
			throws JsonProcessingException {
		if (StringUtils.isBlank(uuid)) {
			uuid = UUID.randomUUID().toString();
		}
		try {
			com.anfelisa.card.data.ICardListData data = new CardListData(uuid);
			if (StringUtils.isBlank(categoryId) || "null".equals(categoryId)) {
				return badRequest("categoryId is mandatory");
			}
			data.setCategoryId(categoryId);
			if (StringUtils.isBlank(filterNonScheduled) || "null".equals(filterNonScheduled)) {
				return badRequest("filterNonScheduled is mandatory");
			}
			data.setFilterNonScheduled("null".equals(filterNonScheduled) ? null : Boolean.parseBoolean(filterNonScheduled));
			data.setPriority("null".equals(priority) ? null : Integer.parseInt(priority));
			if (StringUtils.isBlank(reverse) || "null".equals(reverse)) {
				return badRequest("reverse is mandatory");
			}
			data.setReverse("null".equals(reverse) ? null : Boolean.parseBoolean(reverse));
			data.setUserId(authUser.getUserId());
			
			com.anfelisa.card.actions.GetCardsAction action = new com.anfelisa.card.actions.GetCardsAction(persistenceConnection, appConfiguration, daoProvider, viewProvider);
			data = action.apply(data);
			return Response.ok(new com.anfelisa.card.data.GetCardsResponse(data)).build();
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
			return unauthorized("authorization needed for /cards");
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



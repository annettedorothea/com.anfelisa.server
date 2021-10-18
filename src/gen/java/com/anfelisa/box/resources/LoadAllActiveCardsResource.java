/********************************************************************************
 * generated by de.acegen 1.6.4
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

import com.anfelisa.box.data.IActiveCardListData;
import com.anfelisa.box.data.ActiveCardListData;

import de.acegen.Resource;

@Path("/box/active-cards/{boxId}")
@SuppressWarnings("unused")
public class LoadAllActiveCardsResource extends Resource {

	static final Logger LOG = LoggerFactory.getLogger(LoadAllActiveCardsResource.class);
	
	private PersistenceConnection persistenceConnection;
	private CustomAppConfiguration appConfiguration;
	private IDaoProvider daoProvider;
	private ViewProvider viewProvider;

	public LoadAllActiveCardsResource(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
				IDaoProvider daoProvider, ViewProvider viewProvider) {
			this.persistenceConnection = persistenceConnection;
			this.appConfiguration = appConfiguration;
			this.daoProvider = daoProvider;
			this.viewProvider = viewProvider;
		}
	
	@GET
	@Timed(name = "LoadAllActiveCardsActionTimed")
	@Metered(name = "LoadAllActiveCardsActionMetered")
	@ExceptionMetered
	@ResponseMetered
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response loadAllActiveCardsResource(
			@Auth AuthUser authUser, 
			@PathParam("boxId") String boxId, 
			@QueryParam("uuid") String uuid) 
			throws JsonProcessingException {
		if (StringUtils.isBlank(uuid)) {
			uuid = UUID.randomUUID().toString();
		}
		try {
			com.anfelisa.box.data.IActiveCardListData data = new ActiveCardListData(uuid);
			if (StringUtils.isBlank(boxId) || "null".equals(boxId)) {
				return badRequest("boxId is mandatory");
			}
			data.setBoxId(boxId);
			data.setUserId(authUser.getUserId());
			
			com.anfelisa.box.actions.LoadAllActiveCardsAction action = new com.anfelisa.box.actions.LoadAllActiveCardsAction(persistenceConnection, appConfiguration, daoProvider, viewProvider);
			data = action.apply(data);
			return Response.ok(new com.anfelisa.box.data.LoadAllActiveCardsResponse(data)).build();
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
			return unauthorized("authorization needed for /box/active-cards/{boxId}");
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



/********************************************************************************
 * generated by de.acegen 1.5.6
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

import com.anfelisa.box.data.IBoxArchiveData;
import com.anfelisa.box.data.BoxArchiveData;

import de.acegen.Resource;

@Path("/box/archive")
@SuppressWarnings("unused")
public class ArchiveBoxResource extends Resource {

	static final Logger LOG = LoggerFactory.getLogger(ArchiveBoxResource.class);
	
	private PersistenceConnection persistenceConnection;
	private CustomAppConfiguration appConfiguration;
	private IDaoProvider daoProvider;
	private ViewProvider viewProvider;

	public ArchiveBoxResource(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
				IDaoProvider daoProvider, ViewProvider viewProvider) {
			this.persistenceConnection = persistenceConnection;
			this.appConfiguration = appConfiguration;
			this.daoProvider = daoProvider;
			this.viewProvider = viewProvider;
		}
	
	@PUT
	@Timed(name = "ArchiveBoxActionTimed")
	@Metered(name = "ArchiveBoxActionMetered")
	@ExceptionMetered
	@ResponseMetered
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response archiveBoxResource(
			@Auth AuthUser authUser, 
			@QueryParam("uuid") String uuid, 
			IBoxArchiveData payload) 
			throws JsonProcessingException {
		if (payload == null) {
			return badRequest("payload must not be null");
		}
		if (StringUtils.isBlank(uuid)) {
			uuid = UUID.randomUUID().toString();
		}
		try {
			com.anfelisa.box.data.IBoxArchiveData data = new BoxArchiveData(uuid);
			if (StringUtils.isBlank(payload.getBoxId()) || "null".equals(payload.getBoxId())) {
				return badRequest("boxId is mandatory");
			}
			data.setBoxId(payload.getBoxId());
			if (payload.getArchived() == null) {
				return badRequest("archived is mandatory");
			}
			data.setArchived(payload.getArchived());
			data.setUserId(authUser.getUserId());
			
			com.anfelisa.box.actions.ArchiveBoxAction action = new com.anfelisa.box.actions.ArchiveBoxAction(persistenceConnection, appConfiguration, daoProvider, viewProvider);
			data = action.apply(data);
			return ok();
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
			return unauthorized("authorization needed for /box/archive");
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



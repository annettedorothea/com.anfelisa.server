/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.user.resources;

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
import de.acegen.Config;
import de.acegen.Data;


import com.codahale.metrics.annotation.Timed;
import com.codahale.metrics.annotation.Metered;
import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.ResponseMetered;

import com.fasterxml.jackson.core.JsonProcessingException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;

import de.acegen.Resource;

@Path("/users/username")
@SuppressWarnings("unused")
public class UsernameAvailableResource extends Resource {

	static final Logger LOG = LoggerFactory.getLogger(UsernameAvailableResource.class);
	
	private PersistenceConnection persistenceConnection;
	private CustomAppConfiguration appConfiguration;
	private IDaoProvider daoProvider;
	private ViewProvider viewProvider;

	public UsernameAvailableResource(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
				IDaoProvider daoProvider, ViewProvider viewProvider) {
			this.persistenceConnection = persistenceConnection;
			this.appConfiguration = appConfiguration;
			this.daoProvider = daoProvider;
			this.viewProvider = viewProvider;
		}
	
	@GET
	@Timed(name = "UsernameAvailableActionTimed")
	@Metered(name = "UsernameAvailableActionMetered")
	@ExceptionMetered
	@ResponseMetered
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response usernameAvailableResource(
			@QueryParam("username") String username, 
			@QueryParam("uuid") String uuid) 
			throws JsonProcessingException {
		if (StringUtils.isBlank(uuid)) {
			uuid = UUID.randomUUID().toString();
		}
		try {
			Data<com.anfelisa.user.models.UsernameAvailableModel> data = new Data<com.anfelisa.user.models.UsernameAvailableModel>(uuid);
			com.anfelisa.user.models.UsernameAvailableModel model = new com.anfelisa.user.models.UsernameAvailableModel();
			if (username == null || StringUtils.isBlank(username) || "null".equals(username)) {
				return badRequest("username is mandatory");
			}
			if (username != null) {
				model.setUsername(username);
			}
			
			data.setModel(model);
			com.anfelisa.user.actions.UsernameAvailableAction action = new com.anfelisa.user.actions.UsernameAvailableAction(persistenceConnection, appConfiguration, daoProvider, viewProvider);
			data = action.apply(data);
			return Response.ok(new com.anfelisa.user.data.UsernameAvailableResponse(data.getModel())).build();
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
			return unauthorized("authorization needed for /users/username");
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



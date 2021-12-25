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
import de.acegen.IDataContainer;
import de.acegen.ViewProvider;
import de.acegen.PersistenceConnection;
import de.acegen.PersistenceHandle;
import de.acegen.ReadAction;
import de.acegen.ITimelineItem;
import de.acegen.SquishyDataProvider;
import de.acegen.Config;


import com.codahale.metrics.annotation.Timed;
import com.codahale.metrics.annotation.Metered;
import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.ResponseMetered;

import com.fasterxml.jackson.core.JsonProcessingException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;

import com.anfelisa.user.data.IUserRegistrationData;
import com.anfelisa.user.data.UserRegistrationData;

import de.acegen.Resource;

@Path("/users/register")
@SuppressWarnings("unused")
public class RegisterUserResource extends Resource {

	static final Logger LOG = LoggerFactory.getLogger(RegisterUserResource.class);
	
	private PersistenceConnection persistenceConnection;
	private CustomAppConfiguration appConfiguration;
	private IDaoProvider daoProvider;
	private ViewProvider viewProvider;

	public RegisterUserResource(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
				IDaoProvider daoProvider, ViewProvider viewProvider) {
			this.persistenceConnection = persistenceConnection;
			this.appConfiguration = appConfiguration;
			this.daoProvider = daoProvider;
			this.viewProvider = viewProvider;
		}
	
	@POST
	@Timed(name = "RegisterUserActionTimed")
	@Metered(name = "RegisterUserActionMetered")
	@ExceptionMetered
	@ResponseMetered
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registerUserResource(
			@QueryParam("uuid") String uuid, 
			IUserRegistrationData payload) 
			throws JsonProcessingException {
		if (payload == null) {
			return badRequest("payload must not be null");
		}
		if (StringUtils.isBlank(uuid)) {
			uuid = UUID.randomUUID().toString();
		}
		try {
			com.anfelisa.user.data.IUserRegistrationData data = new UserRegistrationData(uuid);
			if (StringUtils.isBlank(payload.getPassword()) || "null".equals(payload.getPassword())) {
				return badRequest("password is mandatory");
			}
			data.setPassword(payload.getPassword());
			if (StringUtils.isBlank(payload.getUsername()) || "null".equals(payload.getUsername())) {
				return badRequest("username is mandatory");
			}
			data.setUsername(payload.getUsername());
			if (StringUtils.isBlank(payload.getEmail()) || "null".equals(payload.getEmail())) {
				return badRequest("email is mandatory");
			}
			data.setEmail(payload.getEmail());
			if (StringUtils.isBlank(payload.getLanguage()) || "null".equals(payload.getLanguage())) {
				return badRequest("language is mandatory");
			}
			data.setLanguage(payload.getLanguage());
			
			com.anfelisa.user.actions.RegisterUserAction action = new com.anfelisa.user.actions.RegisterUserAction(persistenceConnection, appConfiguration, daoProvider, viewProvider);
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
			return unauthorized("authorization needed for /users/register");
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



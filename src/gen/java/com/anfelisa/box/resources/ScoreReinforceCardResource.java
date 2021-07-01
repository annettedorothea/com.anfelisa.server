/********************************************************************************
 * generated by de.acegen 1.2.1
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

import com.anfelisa.box.data.IScoreReinforceCardData;
import com.anfelisa.box.data.ScoreReinforceCardData;

import de.acegen.Resource;

@Path("/card/score-reinforce")
@SuppressWarnings("unused")
public class ScoreReinforceCardResource extends Resource {

	static final Logger LOG = LoggerFactory.getLogger(ScoreReinforceCardResource.class);
	
	private PersistenceConnection persistenceConnection;
	private CustomAppConfiguration appConfiguration;
	private IDaoProvider daoProvider;
	private ViewProvider viewProvider;

	public ScoreReinforceCardResource(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
				IDaoProvider daoProvider, ViewProvider viewProvider) {
			this.persistenceConnection = persistenceConnection;
			this.appConfiguration = appConfiguration;
			this.daoProvider = daoProvider;
			this.viewProvider = viewProvider;
		}
	
	@POST
	@Timed(name = "ScoreReinforceCardActionTimed")
	@Metered(name = "ScoreReinforceCardActionMetered")
	@ExceptionMetered
	@ResponseMetered
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response scoreReinforceCardResource(
			@Auth AuthUser authUser, 
			@QueryParam("uuid") String uuid, 
			IScoreReinforceCardData payload) 
			throws JsonProcessingException {
		if (payload == null) {
			return badRequest("payload must not be null");
		}
		if (StringUtils.isBlank(uuid)) {
			uuid = UUID.randomUUID().toString();
		}
		try {
			com.anfelisa.box.data.IScoreReinforceCardData data = new ScoreReinforceCardData(uuid);
			if (StringUtils.isBlank(payload.getReinforceCardId()) || "null".equals(payload.getReinforceCardId())) {
				return badRequest("reinforceCardId is mandatory");
			}
			data.setReinforceCardId(payload.getReinforceCardId());
			if (payload.getKeep() == null) {
				return badRequest("keep is mandatory");
			}
			data.setKeep(payload.getKeep());
			data.setUserId(authUser.getUserId());
			
			com.anfelisa.box.actions.ScoreReinforceCardAction action = new com.anfelisa.box.actions.ScoreReinforceCardAction(persistenceConnection, appConfiguration, daoProvider, viewProvider);
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
			return unauthorized("authorization needed for /card/score-reinforce");
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



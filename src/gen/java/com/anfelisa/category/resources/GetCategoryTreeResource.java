/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.category.resources;

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

import com.anfelisa.category.data.ICategoryTreeData;
import com.anfelisa.category.data.CategoryTreeData;

import de.acegen.Resource;

@Path("/category/tree")
@SuppressWarnings("unused")
public class GetCategoryTreeResource extends Resource {

	static final Logger LOG = LoggerFactory.getLogger(GetCategoryTreeResource.class);
	
	private PersistenceConnection persistenceConnection;
	private CustomAppConfiguration appConfiguration;
	private IDaoProvider daoProvider;
	private ViewProvider viewProvider;

	public GetCategoryTreeResource(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
				IDaoProvider daoProvider, ViewProvider viewProvider) {
			this.persistenceConnection = persistenceConnection;
			this.appConfiguration = appConfiguration;
			this.daoProvider = daoProvider;
			this.viewProvider = viewProvider;
		}
	
	@GET
	@Timed(name = "GetCategoryTreeActionTimed")
	@Metered(name = "GetCategoryTreeActionMetered")
	@ExceptionMetered
	@ResponseMetered
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getCategoryTreeResource(
			@Auth AuthUser authUser, 
			@QueryParam("rootCategoryId") String rootCategoryId, 
			@QueryParam("filterNonScheduled") String filterNonScheduled, 
			@QueryParam("priority") String priority, 
			@QueryParam("reverse") String reverse, 
			@QueryParam("uuid") String uuid) 
			throws JsonProcessingException {
		if (StringUtils.isBlank(uuid)) {
			uuid = UUID.randomUUID().toString();
		}
		try {
			com.anfelisa.category.data.ICategoryTreeData actionData = new CategoryTreeData(uuid);
			if (StringUtils.isBlank(rootCategoryId) || "null".equals(rootCategoryId)) {
				return badRequest("rootCategoryId is mandatory");
			}
			actionData.setRootCategoryId(rootCategoryId);
			if (StringUtils.isBlank(filterNonScheduled) || "null".equals(filterNonScheduled)) {
				return badRequest("filterNonScheduled is mandatory");
			}
			actionData.setFilterNonScheduled("null".equals(filterNonScheduled) ? null : Boolean.parseBoolean(filterNonScheduled));
			actionData.setPriority("null".equals(priority) ? null : Integer.parseInt(priority));
			if (StringUtils.isBlank(reverse) || "null".equals(reverse)) {
				return badRequest("reverse is mandatory");
			}
			actionData.setReverse("null".equals(reverse) ? null : Boolean.parseBoolean(reverse));
			actionData.setUserId(authUser.getUserId());
			
			com.anfelisa.category.actions.GetCategoryTreeAction action = new com.anfelisa.category.actions.GetCategoryTreeAction(persistenceConnection, appConfiguration, daoProvider, viewProvider);
			action.setActionData(actionData);
			action.apply();
			return Response.ok(new com.anfelisa.category.data.GetCategoryTreeResponse(action.getActionData())).build();
		} catch (IllegalArgumentException x) {
			LOG.error("bad request due to {} ", x.getMessage());
			return badRequest(x.getMessage());
		} catch (SecurityException x) {
			LOG.error("unauthorized due to {} ", x.getMessage());
			return unauthorized("authorization needed for /category/tree");
		} catch (Exception x) {
			LOG.error("internal server error due to {} ", x.getMessage());
			return internalServerError(x);
		}
	}
}




/******* S.D.G. *******/



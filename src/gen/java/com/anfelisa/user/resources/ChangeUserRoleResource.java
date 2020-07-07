	/* 
	 * Copyright (c) 2020, Annette Pohl, Koblenz, Germany
	 *
	 * Permission to use, copy, modify, and/or distribute this software for any
	 * purpose with or without fee is hereby granted, provided that the above
	 * copyright notice and this permission notice appear in all copies.
	
	 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
	 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
	 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
	 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
	 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
	 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
	 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
	 *
	 * generated with de.acegen 0.9.5
	 *
	 */
	
	
	
	
	package com.anfelisa.user.resources;
	
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
	import de.acegen.E2E;
	import de.acegen.IDaoProvider;
	import de.acegen.IDataContainer;
	import de.acegen.ViewProvider;
	import de.acegen.PersistenceConnection;
	import de.acegen.PersistenceHandle;
	import de.acegen.ReadAction;
	import de.acegen.ITimelineItem;
	import de.acegen.NotReplayableDataProvider;
	
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
	
	import com.anfelisa.user.data.IChangeUserRoleData;
	import com.anfelisa.user.data.ChangeUserRoleData;
	
	import de.acegen.Resource;
	
	@Path("/user/role")
	@SuppressWarnings("unused")
	public class ChangeUserRoleResource extends Resource {
	
		static final Logger LOG = LoggerFactory.getLogger(ChangeUserRoleResource.class);
		
		private PersistenceConnection persistenceConnection;
		private CustomAppConfiguration appConfiguration;
		private IDaoProvider daoProvider;
		private ViewProvider viewProvider;
		private E2E e2e;

	public ChangeUserRoleResource(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
				IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
			this.persistenceConnection = persistenceConnection;
			this.appConfiguration = appConfiguration;
			this.daoProvider = daoProvider;
			this.viewProvider = viewProvider;
			this.e2e = e2e;
		}
	
	@PUT
	@Timed(name = "ChangeUserRoleActionTimed")
	@Metered(name = "ChangeUserRoleActionMetered")
	@ExceptionMetered
	@ResponseMetered
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response changeUserRoleResource(
			@Auth AuthUser authUser, 
			IChangeUserRoleData payload)
			throws JsonProcessingException {
		if (payload == null) {
			return badRequest("payload must not be null");
		}
		com.anfelisa.user.data.IChangeUserRoleData actionData = new ChangeUserRoleData(payload.getUuid());
		
		if (StringUtils.isBlank(payload.getNewRole()) || "null".equals(payload.getNewRole())) {
			return badRequest("newRole is mandatory");
		}
		actionData.setNewRole(payload.getNewRole());
		
		if (StringUtils.isBlank(payload.getEditedUserId()) || "null".equals(payload.getEditedUserId())) {
			return badRequest("editedUserId is mandatory");
		}
		actionData.setEditedUserId(payload.getEditedUserId());
		actionData.setUserId(authUser.getUserId());
		actionData.setRole(authUser.getRole());
		
		com.anfelisa.user.actions.ChangeUserRoleAction action = new com.anfelisa.user.actions.ChangeUserRoleAction(persistenceConnection, appConfiguration, daoProvider, viewProvider, e2e);
		action.setActionData(actionData);
		try {
			action.apply();
			return ok();
		} catch (IllegalArgumentException x) {
			LOG.error("bad request due to {} ", x.getMessage());
			return badRequest(x.getMessage());
		} catch (SecurityException x) {
			LOG.error("unauthorized due to {} ", x.getMessage());
			return unauthorized();
		} catch (Exception x) {
			LOG.error("internal server error due to {} ", x.getMessage());
			return internalServerError(x);
		}
	}

}



/******* S.D.G. *******/




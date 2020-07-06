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
	 * generated with de.acegen 0.9.2
	 *
	 */
	
	
	
	
	package com.anfelisa.box.resources;
	
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
	
	import com.anfelisa.box.data.INextCardData;
	import com.anfelisa.box.data.NextCardData;
	
	import de.acegen.Resource;
	
	@Path("/box/next-card")
	@SuppressWarnings("unused")
	public class LoadNextCardResource extends Resource {
	
		static final Logger LOG = LoggerFactory.getLogger(LoadNextCardResource.class);
		
		private PersistenceConnection persistenceConnection;
		private CustomAppConfiguration appConfiguration;
		private IDaoProvider daoProvider;
		private ViewProvider viewProvider;
		private E2E e2e;

	public LoadNextCardResource(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
				IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
			this.persistenceConnection = persistenceConnection;
			this.appConfiguration = appConfiguration;
			this.daoProvider = daoProvider;
			this.viewProvider = viewProvider;
			this.e2e = e2e;
		}
	
	@GET
	@Timed(name = "LoadNextCardActionTimed")
	@Metered(name = "LoadNextCardActionMetered")
	@ExceptionMetered
	@ResponseMetered
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response loadNextCardResource(
			@Auth AuthUser authUser, 
			@QueryParam("boxId") String boxId, 
			@QueryParam("todayAtMidnightInUTC") String todayAtMidnightInUTC, 
			@QueryParam("uuid") String uuid) 
			throws JsonProcessingException {
		if (StringUtils.isBlank(uuid)) {
			return badRequest("uuid must not be blank or null");
		}
		com.anfelisa.box.data.INextCardData actionData = new NextCardData(uuid);
		
		if (StringUtils.isBlank(boxId) || "null".equals(boxId)) {
			return badRequest("boxId is mandatory");
		}
		actionData.setBoxId(boxId);
		
		if (StringUtils.isBlank(todayAtMidnightInUTC) || "null".equals(todayAtMidnightInUTC)) {
			return badRequest("todayAtMidnightInUTC is mandatory");
		}
		if (StringUtils.isNotBlank(todayAtMidnightInUTC)) {
			try {
				actionData.setTodayAtMidnightInUTC(LocalDateTime.parse(todayAtMidnightInUTC, DateTimeFormatter.ISO_DATE_TIME));
			} catch (Exception x) {
				LOG.warn("failed to parse dateTime todayAtMidnightInUTC - {}", todayAtMidnightInUTC);
			}
		}
		actionData.setUserId(authUser.getUserId());
		
		com.anfelisa.box.actions.LoadNextCardAction action = new com.anfelisa.box.actions.LoadNextCardAction(persistenceConnection, appConfiguration, daoProvider, viewProvider, e2e);
		action.setActionData(actionData);
		try {
			action.apply();
			return Response.ok(new com.anfelisa.box.data.LoadNextCardResponse(action.getActionData())).build();
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




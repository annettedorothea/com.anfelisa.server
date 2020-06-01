	/* 
	 * Copyright (c) 2019, Annette Pohl, Koblenz, Germany
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
	 */
	
	
	
	
	package com.anfelisa.card.resources;
	
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
	
	import com.anfelisa.card.data.ICardSearchData;
	import com.anfelisa.card.data.CardSearchData;
	
	import de.acegen.Resource;
	
	@Path("/cards/search")
	@SuppressWarnings("unused")
	public class GetDuplicatesResource extends Resource {
	
		static final Logger LOG = LoggerFactory.getLogger(GetDuplicatesResource.class);
		
		private PersistenceConnection persistenceConnection;
		private CustomAppConfiguration appConfiguration;
		private IDaoProvider daoProvider;
		private ViewProvider viewProvider;
		private E2E e2e;

	public GetDuplicatesResource(PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
				IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
			this.persistenceConnection = persistenceConnection;
			this.appConfiguration = appConfiguration;
			this.daoProvider = daoProvider;
			this.viewProvider = viewProvider;
			this.e2e = e2e;
		}
	
	@GET
	@Timed(name = "GetDuplicatesActionTimed")
	@Metered(name = "GetDuplicatesActionMetered")
	@ExceptionMetered
	@ResponseMetered
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getDuplicatesResource(
			@Auth AuthUser authUser, 
			@QueryParam("given") String given, 
			@QueryParam("wanted") String wanted, 
			@QueryParam("naturalInputOrder") Boolean naturalInputOrder, 
			@QueryParam("categoryId") String categoryId, 
			@QueryParam("uuid") String uuid) 
			throws JsonProcessingException {
		if (StringUtils.isBlank(uuid)) {
			return badRequest("uuid must not be blank or null");
		}
		com.anfelisa.card.data.ICardSearchData actionData = new CardSearchData(uuid);
		
		actionData.setGiven(given);
		
		actionData.setWanted(wanted);
		
		actionData.setNaturalInputOrder(naturalInputOrder);
		
		if (StringUtils.isBlank(categoryId) || "null".equals(categoryId)) {
			return badRequest("categoryId is mandatory");
		}
		actionData.setCategoryId(categoryId);
		actionData.setUserId(authUser.getUserId());
		
		com.anfelisa.card.actions.GetDuplicatesAction action = new com.anfelisa.card.actions.GetDuplicatesAction(persistenceConnection, appConfiguration, daoProvider, viewProvider, e2e);
		action.setActionData(actionData);
		try {
			action.apply();
			return Response.ok(new com.anfelisa.card.data.GetDuplicatesResponse(action.getActionData())).build();
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


	

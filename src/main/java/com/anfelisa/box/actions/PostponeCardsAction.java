package com.anfelisa.box.actions;

import javax.annotation.security.PermitAll;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.box.data.PostponeCardsData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/cards")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
	public class PostponeCardsAction extends AbstractPostponeCardsAction {

	static final Logger LOG = LoggerFactory.getLogger(PostponeCardsAction.class);

	public PostponeCardsAction(DBI jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(jdbi,appConfiguration, daoProvider, viewProvider);
	}

	@PUT
	@Timed
	@Path("/postpone")
	@PermitAll
	public Response put(@NotNull @QueryParam("boxId") String boxId, @Auth AuthUser user, @NotNull @QueryParam("uuid") String uuid) throws JsonProcessingException {
		this.actionData = new PostponeCardsData(uuid).withBoxId(boxId).withUserId(user.getUserId());
		return this.apply();
	}


}

/*       S.D.G.       */
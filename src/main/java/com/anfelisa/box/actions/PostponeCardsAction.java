package com.anfelisa.box.actions;

import javax.annotation.security.PermitAll;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
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

	public PostponeCardsAction(DBI jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider,
			ViewProvider viewProvider) {
		super(jdbi, appConfiguration, daoProvider, viewProvider);
	}

	@PUT
	@Timed
	@Path("/postpone")
	@PermitAll
	public Response put(@NotNull PostponeCardsData postponeCardsData, @Auth AuthUser user)
			throws JsonProcessingException {
		DateTime todayDate = new DateTime(postponeCardsData.getToday());
		todayDate = todayDate.withZone(DateTimeZone.UTC);
		this.actionData = postponeCardsData.withUserId(user.getUserId()).withToday(todayDate);
		return this.apply();
	}

}

/* S.D.G. */

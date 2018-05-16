package com.anfelisa.user.actions;

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
import com.anfelisa.user.data.EmailConfirmationData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/users")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
public class ConfirmEmailAction extends AbstractConfirmEmailAction {

	static final Logger LOG = LoggerFactory.getLogger(ConfirmEmailAction.class);

	public ConfirmEmailAction(DBI jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(jdbi, appConfiguration, daoProvider, viewProvider);
	}

	@PUT
	@Timed
	@Path("/confirm")
	public Response put(@NotNull @QueryParam("token") String token, @NotNull @QueryParam("uuid") String uuid) throws JsonProcessingException {
		this.actionData = new EmailConfirmationData(uuid).withToken(token);
		return this.apply();
	}

}

/* S.D.G. */

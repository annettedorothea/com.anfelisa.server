package com.anfelisa.box.actions;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/card")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
	public class RemoveCardFromBoxAction extends AbstractRemoveCardFromBoxAction {

	static final Logger LOG = LoggerFactory.getLogger(RemoveCardFromBoxAction.class);

	public RemoveCardFromBoxAction(DBI jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(jdbi,appConfiguration, daoProvider, viewProvider);
	}

	@DELETE
	@Timed
	@Path("/remove")
	@PermitAll
	public Response delete() throws JsonProcessingException {
		this.actionData = null;
		return this.apply();
	}


}

/*       S.D.G.       */

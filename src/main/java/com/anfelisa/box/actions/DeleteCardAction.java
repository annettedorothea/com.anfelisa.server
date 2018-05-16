package com.anfelisa.box.actions;

import javax.annotation.security.RolesAllowed;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
import com.anfelisa.box.data.CardIdData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/cards")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
public class DeleteCardAction extends AbstractDeleteCardAction {

	static final Logger LOG = LoggerFactory.getLogger(DeleteCardAction.class);

	public DeleteCardAction(DBI jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(jdbi, appConfiguration, daoProvider, viewProvider);
	}

	@DELETE
	@Timed
	@Path("/delete")
	@RolesAllowed({ AuthUser.ADMIN, AuthUser.AUTHOR })
	public Response delete(@NotNull @QueryParam("uuid") String uuid, @NotNull @QueryParam("testId") String testId,
			@NotNull @QueryParam("contentHash") String contentHash) throws JsonProcessingException {
		this.actionData = new CardIdData(uuid).withTestId(testId).withContentHash(contentHash);
		return this.apply();
	}

}

/* S.D.G. */

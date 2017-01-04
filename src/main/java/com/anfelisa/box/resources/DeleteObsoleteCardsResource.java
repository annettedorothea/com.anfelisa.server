package com.anfelisa.box.resources;

import javax.annotation.security.RolesAllowed;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Resource;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.box.actions.DeleteObsoleteCardsAction;
import com.anfelisa.box.data.ContentHashesOfCreatedCardsData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/cards")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DeleteObsoleteCardsResource extends Resource {

	static final Logger LOG = LoggerFactory.getLogger(DeleteObsoleteCardsResource.class);

	public DeleteObsoleteCardsResource( DBI jdbi ) {
		super(jdbi);
	}

	@DELETE
	@Timed
	@Path("/obsolete-hashes")
	@RolesAllowed({ AuthUser.AUTHOR, AuthUser.ADMIN })
	public Response delete(@NotNull ContentHashesOfCreatedCardsData actionParam) throws JsonProcessingException {
		DatabaseHandle handle = this.createDatabaseHandle();
		return new DeleteObsoleteCardsAction(actionParam, handle).apply();
	}

}

/*       S.D.G.       */

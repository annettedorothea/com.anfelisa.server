package com.anfelisa.box.resources;

import javax.annotation.security.PermitAll;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Resource;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.box.actions.UpdateBoxAction;
import com.anfelisa.box.data.BoxCreationData;
import com.anfelisa.box.models.BoxDao;
import com.anfelisa.box.models.IBoxModel;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/boxes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UpdateBoxResource extends Resource {

	static final Logger LOG = LoggerFactory.getLogger(UpdateBoxResource.class);

	public UpdateBoxResource( DBI jdbi ) {
		super(jdbi);
	}

	@PUT
	@Timed
	@Path("/update")
	@PermitAll
	public Response put(@NotNull BoxCreationData actionParam, @Auth AuthUser user) throws JsonProcessingException {
		DatabaseHandle handle = this.createDatabaseHandle();
		IBoxModel box = BoxDao.selectByBoxId(handle.getHandle(), actionParam.getBoxId(), actionParam.getSchema());
		if (!box.getUsername().equals(user.getUsername())) {
			handle.close();
			throw new WebApplicationException(Response.Status.UNAUTHORIZED);
		}
		return new UpdateBoxAction(actionParam, handle).apply();
	}

}

/*       S.D.G.       */

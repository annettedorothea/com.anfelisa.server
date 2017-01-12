package com.anfelisa.box.resources;

import javax.annotation.security.PermitAll;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Resource;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.box.actions_.FillBoxWithCardsAction;
import com.anfelisa.box.data.FillBoxData;
import com.anfelisa.box.models.BoxDao;
import com.anfelisa.box.models.IBoxModel;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/box")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
public class FillBoxWithCardsResource extends Resource {

	static final Logger LOG = LoggerFactory.getLogger(FillBoxWithCardsResource.class);

	public FillBoxWithCardsResource(DBI jdbi) {
		super(jdbi);
	}

	@POST
	@Timed
	@Path("/fill")
	@PermitAll
	public Response post(@NotNull @QueryParam("uuid") String uuid, @NotNull @QueryParam("schema") String schema,
			@NotNull @QueryParam("boxId") Integer boxId, @Auth AuthUser user) throws JsonProcessingException {
		DatabaseHandle handle = this.createDatabaseHandle();
		if (user.getRole().equals(AuthUser.STUDENT)) {
			IBoxModel box = BoxDao.selectByBoxId(handle.getHandle(), boxId, schema);
			if (!box.getUsername().equals(user.getUsername())) {
				handle.close();
				throw new WebApplicationException(Response.Status.UNAUTHORIZED);
			}
		}
		FillBoxData actionParam = new FillBoxData(uuid, schema).withBoxId(boxId).withUsername(user.getUsername());
		return new FillBoxWithCardsAction(actionParam , handle).apply();
	}

}

/* S.D.G. */

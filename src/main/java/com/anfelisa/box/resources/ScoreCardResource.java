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
import com.anfelisa.box.actions.ScoreCardAction;
import com.anfelisa.box.data.ScoreCardData;
import com.anfelisa.box.models.CustomBoxDao;
import com.anfelisa.box.models.IBoxModel;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/cards")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
public class ScoreCardResource extends Resource {

	static final Logger LOG = LoggerFactory.getLogger(ScoreCardResource.class);

	public ScoreCardResource( DBI jdbi ) {
		super(jdbi);
	}

	@POST
	@Timed
	@Path("/score")
	@PermitAll
	public Response post(@Auth AuthUser user, @NotNull @QueryParam("uuid") String uuid,
			@NotNull @QueryParam("schema") String schema, @NotNull @QueryParam("cardOfBoxId") Integer cardOfBoxId, @NotNull @QueryParam("quality") Integer quality) throws JsonProcessingException {
		DatabaseHandle handle = this.createDatabaseHandle();
		IBoxModel box = CustomBoxDao.selectByCardOfBoxId(handle.getHandle(), schema, cardOfBoxId);
		if (!box.getUsername().equals(user.getUsername())) {
			handle.close();
			throw new WebApplicationException(Response.Status.UNAUTHORIZED);
		}
		ScoreCardData actionParam = new ScoreCardData(uuid, schema).withCardOfBoxId(cardOfBoxId).withSubmittedQuality(quality);
		return new ScoreCardAction(actionParam , handle).apply();
	}

}

/*       S.D.G.       */

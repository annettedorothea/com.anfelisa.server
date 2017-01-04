package com.anfelisa.box.resources;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
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
import com.anfelisa.box.actions.FillBoxWithCardsAction;
import com.anfelisa.box.data.BoxIdListData;
import com.anfelisa.box.models.BoxDao;
import com.anfelisa.box.models.IBoxModel;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/box")
@Produces(MediaType.APPLICATION_JSON)
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
	public Response post(BoxIdListData actionParam, @Auth AuthUser user) throws JsonProcessingException {
		DatabaseHandle handle = this.createDatabaseHandle();
		if (user.getRole().equals(AuthUser.STUDENT)) {
			List<Integer> boxIds = actionParam.getBoxIds();
			for (Integer boxId : boxIds) {
				IBoxModel box = BoxDao.selectByBoxId(handle.getHandle(), boxId, actionParam.getSchema());
				if (!box.getUsername().equals(user.getUsername())) {
					handle.close();
					throw new WebApplicationException(Response.Status.UNAUTHORIZED);
				}
			}
		}
		return new FillBoxWithCardsAction(actionParam, handle).apply();
	}

}

/* S.D.G. */

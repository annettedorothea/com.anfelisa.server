package com.anfelisa.box.resources;

import javax.annotation.security.PermitAll;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseService;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.box.actions.AddCourseToBoxAction;
import com.anfelisa.box.data.BoxToCourseAdditionData;
import com.anfelisa.box.models.BoxDao;
import com.anfelisa.box.models.IBoxModel;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/boxes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AddCourseToBoxResource {

	static final Logger LOG = LoggerFactory.getLogger(AddCourseToBoxResource.class);

	@POST
	@Timed
	@Path("/addcourse")
	@PermitAll
	public Response post(@NotNull BoxToCourseAdditionData actionParam, @Auth AuthUser user) throws JsonProcessingException {
		IBoxModel box = BoxDao.selectById(DatabaseService.getDatabaseHandle().getHandle(), actionParam.getBoxId(), actionParam.getSchema());
		if (user.getRole().equals(AuthUser.STUDENT) && !box.getUsername().equals(user.getUsername())) {
			throw new WebApplicationException(Response.Status.UNAUTHORIZED);
		}
		return new AddCourseToBoxAction(actionParam, DatabaseService.getDatabaseHandle()).apply();
	}

}

/*       S.D.G.       */

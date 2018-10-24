package com.anfelisa.category.actions;

import javax.annotation.security.PermitAll;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.category.data.RevokeUserData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/category")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
	public class RevokeUserAccessAction extends AbstractRevokeUserAccessAction {

	static final Logger LOG = LoggerFactory.getLogger(RevokeUserAccessAction.class);

	public RevokeUserAccessAction(Jdbi jdbi, CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		super(jdbi,appConfiguration, daoProvider, viewProvider);
	}

	@DELETE
	@Timed
	@Path("/revoke")
	@PermitAll
	public Response delete(@Auth AuthUser user, @NotNull @QueryParam("uuid") String uuid,
			@NotNull @QueryParam("revokedUserId") String revokedUserId, @NotNull @QueryParam("categoryId") String categoryId) throws JsonProcessingException {
		this.actionData = new RevokeUserData(uuid).withRevokedUserId(revokedUserId).withCategoryId(categoryId).withUserId(user.getUserId());
		return this.apply();
	}


}

/*       S.D.G.       */

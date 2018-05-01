package com.anfelisa.category.actions;

import javax.annotation.security.RolesAllowed;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.auth.AuthUser;
import com.anfelisa.category.data.CategoryCreationData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/category")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
public class CreateCategoryAction extends AbstractCreateCategoryAction {

	static final Logger LOG = LoggerFactory.getLogger(CreateCategoryAction.class);

	public CreateCategoryAction(DBI jdbi) {
		super(jdbi);
	}

	@POST
	@Timed
	@Path("/create")
	@RolesAllowed({ AuthUser.AUTHOR })
	public Response post(@Auth AuthUser user, @NotNull CategoryCreationData categoryCreationData)
			throws JsonProcessingException {
		this.actionData = categoryCreationData.withCategoryAuthor(user.getUsername());
		return this.apply();
	}

}

/* S.D.G. */

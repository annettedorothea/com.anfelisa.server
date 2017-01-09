package com.anfelisa.user.resources;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.ace.Resource;
import com.anfelisa.user.actions.ForgotPasswordAction;
import com.anfelisa.user.data.ForgotPasswordData;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/users")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
public class ForgotPasswordResource extends Resource {

	static final Logger LOG = LoggerFactory.getLogger(ForgotPasswordResource.class);

	public ForgotPasswordResource( DBI jdbi ) {
		super(jdbi);
	}

	@POST
	@Timed
	@Path("/forgot-password")
	public Response post(@NotNull @QueryParam("uuid") String uuid, @NotNull @QueryParam("schema") String schema,
			@NotNull @QueryParam("username") String username, @NotNull @QueryParam("language") String language) throws JsonProcessingException {
		DatabaseHandle handle = this.createDatabaseHandle();
		ForgotPasswordData actionParam = new ForgotPasswordData(uuid, schema).withUsername(username).withLanguage(language);  // init actionParam
		return new ForgotPasswordAction(actionParam, handle).apply();
	}

}

/*       S.D.G.       */

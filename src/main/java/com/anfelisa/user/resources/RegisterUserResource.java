package com.anfelisa.user.resources;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseService;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.anfelisa.user.actions.RegisterUserAction;

import com.anfelisa.user.data.RegistrationData;

@Path("/path")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RegisterUserResource {

	static final Logger LOG = LoggerFactory.getLogger(RegisterUserResource.class);

	@POST
	@Timed
	@Path("/path")
	@PermitAll // set permission
	public Response post(/* params here */) throws JsonProcessingException {
		RegistrationData actionParam = null;  // init actionParam
		return new RegisterUserAction(actionParam, DatabaseService.getDatabaseHandle()).apply();
	}

}

/*       S.D.G.       */
